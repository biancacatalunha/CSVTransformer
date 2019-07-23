package src.types;

import lombok.Data;

@Data
public class EventTypeGroup {

    private String eventTypeId;
    private String group;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof EventTypeGroup)) {
            return false;
        }

        EventTypeGroup obj = (EventTypeGroup) o;

        return obj.getEventTypeId().equals(eventTypeId) &&
                obj.getGroup().equals(group);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + group.hashCode();
        result = 31 * result + eventTypeId.hashCode();
        return result;
    }
}
