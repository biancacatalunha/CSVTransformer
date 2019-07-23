package src.converters;

public class Converters {

    public String convertPeriodToMinutesToStart(String period) {
        switch (period) {
            case "4":
                return "240";
            case "10":
                return "600";
            case "12":
                return "720";
            case "24":
                return "1440";
            case "48":
                return "2880";
            case "72":
                return "4320";
        }
        System.out.println(period);
        return "NOT FOUND";
    }

    public String convertGradeToGroup(String grade) {
        switch (grade) {
            case "ATP":
                return "1";
            case "ITF":
                return "2";
            case "ENG":
                return "3";
            case "EURO":
                return "4";
            case "AA":
                return "5";
            case "A":
                return "6";
            case "B":
                return "7";
            case "C":
                return "8";
            case "D":
                return "9";
            case "E":
                return "10";
        }
        return grade;
    }

    public String convertHorseRacingToDMGroup(String group) {
        switch (group) {
            case "1":
                return "11";
            case "2":
                return "12";
            case "3":
                return "13";
            case "4":
                return "14";
            case "5":
                return "15";
            case "6":
                return "16";
            case "7":
                return "17";
            case "8":
                return "18";
        }
        System.out.println(group);
        return "NOT FOUND";
    }

    public String separatedUKIeliteEventTypes(String eventType, String group) {
        switch(eventType) {
            case "16171":
            case "16172":
            case "16185":
            case "16190":
            case "16202":
            case "16215":
            case "16224":
            case "16226":
            case "16231":
            case "16238":
            case "16259":
                return "43";
        }
        return group;
    }

    public int getSubclassIdForGroup(String group) {
        switch (group) {
            case "NORTHHEMA":
            case "SOUTHHEMA":
                return 27;
            case "RUsevensB":
            case "RUnorthA":
            case "RUsouthB":
            case "RUsevensA":
            case "RUsouthA":
            case "RUnorthC":
            case "RUnorthB":
            case "RUspecials":
            case "RUnorthAA":
            case "RUsouthC":
                return 12;
            case "CricketD":
            case "CricketB":
            case "CricketC":
            case "CricketA":
            case "CRImultiB":
            case "CRIoutrB":
            case "CRIoutrA":
            case "CRImultiA":
            case "CRImultiC":
            case "CRIspecial":
            case "CRIoutrC":
                return 31;
        }
        System.out.println(group);
        return 0;
    }

    public String convertSISToGroup(String grade) {
        switch (grade) {
            case "NORTHHEMA":
                return "19";
            case "SOUTHHEMA":
                return "20";
            case "RUsevensB":
                return "21";
            case "RUnorthA":
                return "22";
            case "RUsouthB":
                return "23";
            case "RUsevensA":
                return "24";
            case "RUsouthA":
                return "25";
            case "RUnorthC":
                return "26";
            case "RUnorthB":
                return "27";
            case "RUspecials":
                return "28";
            case "RUnorthAA":
                return "29";
            case "RUsouthC":
                return "30";
            case "CricketD":
                return "31";
            case "CricketB":
                return "32";
            case "CricketC":
                return "33";
            case "CricketA":
                return "34";
            case "CRImultiB":
                return "35";
            case "CRIoutrB":
                return "36";
            case "CRIoutrA":
                return "37";
            case "CRImultiA":
                return "38";
            case "CRImultiC":
                return "39";
            case "CRIspecial":
                return "40";
            case "CRIoutrC":
                return "41";
            case "F":
                return "42";
        }
        return "0";
    }
}
