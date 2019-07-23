package src.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import src.types.EventTypeGrade;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public EventTypeGrade[] readToEventTypeGrade(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        EventTypeGrade[] obj = new EventTypeGrade[21233];
        try {
            obj = mapper.readValue(new File(filename), EventTypeGrade[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
