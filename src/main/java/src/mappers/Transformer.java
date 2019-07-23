package src.mappers;

import lombok.extern.slf4j.Slf4j;
import src.converters.Converters;
import src.types.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Transformer {

    private final Converters converter = new Converters();

    public List<DestinationGroupTimedRiskManagement> DAtoDMTimedRiskValues(List<String> list) {
        return list.stream().map(e ->{
                String[] str = e.split(",");
                DestinationGroupTimedRiskManagement obj = new DestinationGroupTimedRiskManagement();

                obj.setGroup(converter.convertGradeToGroup(str[3]));
                obj.setDestination(str[1]);
                obj.setMinutesToStart(converter.convertPeriodToMinutesToStart(str[2]));
                obj.setLTL(str[4]);
                obj.setLL(str[5]);
                obj.setMMB(str[6]);
                obj.setLMB(str[7]);

                return obj;
        }).collect(Collectors.toList());
    }

    public List<DestinationSubclass> timedRiskValuesToObj(List<String> list, Map<String, GroupNameSubclass> groups) {
        return list.stream().map(e ->{
            String[] str = e.split(",", -1);
            DestinationSubclass obj = new DestinationSubclass();

            obj.setDestination(str[0]);
            obj.setSubclass(groups.get(str[1]).getSubclass());

            return obj;
        }).distinct().collect(Collectors.toList());
    }

    public Map<String, GroupNameSubclass> groupNameToObj(List<String> list) {
        Map<String, GroupNameSubclass> map = new HashMap<>();
        list.forEach(e ->{
            String[] str = e.split(",", -1);
            GroupNameSubclass obj = new GroupNameSubclass();
            obj.setName(str[1]);
            obj.setSubclass(str[2]);
            System.out.println(e);

            map.put(str[0], obj);
        });
        return map;
    }

    public List<EventTypeGroup> eventTypeGradeToEventTypeGroup(EventTypeGrade[] obj) {
        List<EventTypeGroup> eventTypeGroupList = new ArrayList<>();

        for (EventTypeGrade anObj : obj) {
            String group = converter.convertGradeToGroup(anObj.getGrade().trim());

            EventTypeGroup newObj = new EventTypeGroup();
            newObj.setGroup(group);
            newObj.setEventTypeId(anObj.getEventType().getId());

            eventTypeGroupList.add(newObj);
        }
        return eventTypeGroupList;
    }

    public List<String> filterUnknownGroups(List <EventTypeGroup> list) {
        List<String> unknownGroups = new ArrayList<>();
        for (EventTypeGroup obj: list) {
            try {
                Integer.parseInt(obj.getGroup());
            } catch (Exception ex) {
               unknownGroups.add(obj.getGroup());
            }
        }
        return unknownGroups;
    }

    public List<DestinationGroupTimedRiskManagement> processNewGroups(List<DestinationGroupTimedRiskManagement> list) {
        List<DestinationGroupTimedRiskManagement> fullList = new ArrayList<>();
        for (DestinationGroupTimedRiskManagement obj: list) {
            try {
                Integer.parseInt(obj.getGroup());
                fullList.add(obj);
            } catch (Exception ex) {
                String group = converter.convertSISToGroup(obj.getGroup());
                if(!group.equals("0")) {
                    obj.setGroup(group);
                    fullList.add(obj);
                }
            }
        }
        return fullList;
    }

    public List<EventTypeGroup> getNewEventTypeGroups(List <EventTypeGroup> list) {
        List<EventTypeGroup> newEventTypeGroupList = new ArrayList<>();
        for(EventTypeGroup obj: list) {
            String group = converter.convertSISToGroup(obj.getGroup());
            if(!group.equals("0")) {
                EventTypeGroup etg = new EventTypeGroup();
                etg.setGroup(group);
                etg.setEventTypeId(obj.getEventTypeId());
                newEventTypeGroupList.add(etg);
            }
        }
        return newEventTypeGroupList;
    }

    public List<EventTypeGroup> eventTypeToDMGroup(List<String> list) {
        return list.stream().map(e ->{
            String[] str = e.split(",");
            EventTypeGroup obj = new EventTypeGroup();

            obj.setEventTypeId(str[2]);
            obj.setGroup(converter.separatedUKIeliteEventTypes(str[2], converter.convertHorseRacingToDMGroup(str[5])));

            return obj;
        }).filter(d -> !d.getGroup().equals("NOT FOUND")).collect(Collectors.toList());
    }

    public List<EventTypeGroup> stringToEventTypeGroup(List<String> list) {
        return list.stream().map(e ->{
            String[] str = e.split(",");
            EventTypeGroup obj = new EventTypeGroup();
            obj.setGroup(str[1]);
            obj.setEventTypeId(str[0]);
            return obj;
        }).collect(Collectors.toList());
    }

    public List<DestinationEventTypeGroup> destinationEventTypeGroupToObj(List<String> list) {
        return list.stream()
                .map(e -> {
                    String[] str = e.split(",");

                        DestinationEventTypeGroup obj = new DestinationEventTypeGroup();
                        obj.setDestination(str[0]);
                        obj.setEventType(str[1]);
                        obj.setGroup(str[2]);
                        return obj;

                })
                .filter(obj -> (obj.getGroup().equals("2") || obj.getGroup().equals("1")) && obj.getDestination().equals("betfair"))
                .sorted(Comparator.comparing(DestinationEventTypeGroup::getEventType))
                .collect(Collectors.toList());
    }
}
