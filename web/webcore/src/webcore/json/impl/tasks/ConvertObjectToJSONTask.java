package webcore.json.impl.tasks;

import com.google.gson.Gson;
import webcore.WebCoreObject;
import webcore.WebCoreTask;

public class ConvertObjectToJSONTask extends WebCoreObject implements WebCoreTask
{
    public static String run(Object objectToConvert)
    {
        Gson gson = new Gson();
        return gson.toJson(objectToConvert);
    }
}