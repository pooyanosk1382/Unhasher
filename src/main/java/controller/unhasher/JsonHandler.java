package controller.unhasher;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonHandler {
    static public String sayHello() throws JSONException {
        return String.valueOf(new JSONObject().put("Request", "sayHello"));
    }
}
