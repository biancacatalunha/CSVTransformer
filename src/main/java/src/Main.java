package src;

import src.comparators.Comparator;
import src.mappers.Transformer;
import src.readers.FileReader;
import src.printers.Printer;
import src.readers.JsonReader;
import src.types.DestinationEventTypeGroup;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        final FileReader file = new FileReader();
        final JsonReader json = new JsonReader();
        final Transformer transform = new Transformer();
        final Printer print =  new Printer();
        final Comparator comparator = new Comparator();

        final String timeBasedRiskValuesFile = "src/main/resources/time_based_risk_values_201811081120.csv";
        final String racingRiskValuesGroupFile = "src/main/resources/Racing Risk Values_groups (2).csv";
        final String sisGroupsJson = "src/main/resources/event_type_grades_sis.txt";
        final String dmEventTypeGroup = "src/main/resources/event_type_group_201810221536.csv";
        final String DGTRM = "src/main/resources/destination_group_timed_risk_management_201812211119.csv";
        final String groupName= "src/main/resources/group_name_201812211151.csv";
        final String destinationventTypGroup = "src/main/resources/destination_event_type_group_201902121427.csv";

//        print.destinationGroupTimedRiskManagementInserts(transform.processNewGroups(transform.DAtoDMTimedRiskValues(file.read(timeBasedRiskValuesFile))));

//        print.destinationGroupTimedRiskManagementInserts(list2);
//        print.eventTypeGroupInserts(transform.eventTypeGradeToGroup());
//        print.eventTypeGroupInserts(transform.eventTypeToDMGroup(file.read(racingRiskValuesGroupFile)));

//        Map<String, GroupNameSubclass> groupMap = transform.groupNameToObj(file.read(groupName));
//        print.groupWhitelistInserts(transform.timedRiskValuesToObj(file.read(DGTRM), groupMap));

        List<DestinationEventTypeGroup> objList = transform.destinationEventTypeGroupToObj(file.read(destinationventTypGroup));
        print.eventTypeGroupMigration(objList);
//
//        List<EventTypeGroup> SISFullList = transform.eventTypeGradeToEventTypeGroup(json.readToEventTypeGrade(sisGroupsJson));
//        List <String> groupsInSisButNotInDM = transform.filterUnknownGroups(SISFullList)
//               .stream()
//               .distinct()
//               .filter(d -> !d.equals("Null"))
//               .collect(Collectors.toList());
//       groupsInSisButNotInDM.stream().distinct().forEach(System.out::println);
//       print.groupNameInserts(groupsInSisButNotInDM);

//        print.eventTypeGroupInserts(transform.getNewEventTypeGroups(SISFullList));

//        List<EventTypeGroup> dmEventTypeGroupList = transform.stringToEventTypeGroup(file.read(dmEventTypeGroup));
//        comparator.DMToSISGroups(sisEventTypeGroupList, dmEventTypeGroupList);
    }
}

