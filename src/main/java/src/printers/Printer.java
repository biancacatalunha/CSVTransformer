package src.printers;

import src.converters.Converters;
import src.types.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Printer {

    private Converters convert = new Converters();

    public void destinationGroupTimedRiskManagementInserts(List<DestinationGroupTimedRiskManagement> objList) {
        String tableName = "destination_group_timed_risk_management";

        for(DestinationGroupTimedRiskManagement obj: objList) {
                System.out.println(String.format("INSERT INTO %s VALUES('%s', %s, %s, %s, null, %s, %s, %s);",
                        tableName, obj.getDestination(), obj.getGroup(), obj.getMinutesToStart(), obj.getLTL(),
                        obj.getLL(), obj.getLMB(), obj.getMMB()));

        }
    }

    public void eventTypeGroupInserts(List<EventTypeGroup> objList) {
        String tableName = "event_type_group";
        int count = 0;
        for(EventTypeGroup eventTypeGroup: objList) {
//            if(!eventTypeGroup.getGroup().equals("43") && !eventTypeGroup.getGroup().equals("11")) {
                System.out.println("INSERT INTO " + tableName + " VALUES(" + eventTypeGroup.getEventTypeId() + "," + eventTypeGroup.getGroup() + ")");
                count ++;
//            }
        }
        System.out.println(count);
    }

    public void groupNameInserts(List<String> groupList) {
        for(String item: groupList) {
            System.out.println(String.format("INSERT INTO group_name VALUES('%s',%s);", item, convert.getSubclassIdForGroup(item)));
        }
    }

    public void groupWhitelistInserts(List<DestinationSubclass> objList) {
        for(DestinationSubclass obj: objList) {
            System.out.println(String.format("INSERT INTO group_feature_whitelist VALUES ('TIMED_BASED_RISK','%s', %s,);",
                    obj.getDestination(), obj.getSubclass()));
        }
    }

    public void eventTypeGroupMigration(List<DestinationEventTypeGroup> objList)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("event_type_group_inserts.txt"));
            for(DestinationEventTypeGroup obj: objList) {
                writer.write("INSERT INTO event_type_group VALUES (" + obj.getEventType() + "," + obj.getGroup() + ");");
                writer.newLine();
                System.out.println(String.format("INSERT INTO event_type_group VALUES (%s, %s);", obj.getEventType(), obj.getGroup()));
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("error writing to a file");
        }
    }
}
