package src.types;

import lombok.Data;

@Data
public class DestinationGroupTimedRiskManagement {

    private String destination;
    private String LTL;
    private String LL;
    private String MMB;
    private String LMB;
    private String group;
    private String minutesToStart;
}
