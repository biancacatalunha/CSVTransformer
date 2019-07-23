package src.comparators;

import src.types.EventTypeGroup;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {

    public void DMToSISGroups(List<EventTypeGroup> SISList, List<EventTypeGroup> DMList) {

        List<EventTypeGroup> groupsInSISButNotInDM = SISList.stream().filter(obj -> !DMList.contains(obj)).collect(Collectors.toList());
        List<EventTypeGroup> groupsInDMbutNotInSIS = DMList.stream().filter(obj -> !SISList.contains(obj)).collect(Collectors.toList());

        System.out.println("SIS List Size: " + SISList.size() + " DM List Size: " + DMList.size());
        System.out.println("Number of groups in SIS but no in DM: " + groupsInSISButNotInDM.size());
        System.out.println("Number of groups in DM but no in SIS: " + groupsInDMbutNotInSIS.size());

        groupsInSISButNotInDM.forEach(n -> {
            System.out.println(n.toString());
        });
    }
}
