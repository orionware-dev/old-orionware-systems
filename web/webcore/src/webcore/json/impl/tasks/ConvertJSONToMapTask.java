package webcore.json.impl.tasks;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import webcore.WebCoreObject;
import webcore.WebCoreTask;

public class ConvertJSONToMapTask extends WebCoreObject implements WebCoreTask
{
    @SuppressWarnings("unchecked")
    public static Map<Object, Object> run(String JSONData)
    {
        Gson gson = new Gson();
        Map<Object, Object> map = new HashMap<Object, Object>();
        return (Map<Object, Object>)gson.fromJson(JSONData, map.getClass());
    }
}