package webcore.json.impl;

import java.util.Map;
import webcore.WebCoreServiceObject;
import webcore.json.JSONService;
import webcore.json.impl.tasks.ConvertJSONToMapTask;
import webcore.json.impl.tasks.ConvertObjectToJSONTask;

public class JSONServiceImpl extends WebCoreServiceObject implements JSONService
{
    @Override
    public String convertObjectToJSON(Object objectToConvert)
    {
        return ConvertObjectToJSONTask.run(objectToConvert);
    }


    @Override
    public Map<Object, Object> convertJSONToMap(String JSONData)
    {
        return ConvertJSONToMapTask.run(JSONData);
    }
}