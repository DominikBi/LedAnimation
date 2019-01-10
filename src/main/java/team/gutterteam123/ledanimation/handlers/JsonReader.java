package team.gutterteam123.ledanimation.handlers;

import java.io.IOException;
import java.io.Reader;
import org.json.JSONObject;

public class JsonReader {
    public static String ReadAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while((cp = reader.read()) != -1){
            stringBuilder.append((char) cp);
        }
        return stringBuilder.toString();
    }
}
