package webcore.json;

import java.util.Map;
import webcore.WebCoreService;

public interface JSONService extends WebCoreService
{
    public String convertObjectToJSON(Object objectToConvert);


    public Map<Object, Object> convertJSONToMap(String JSONData);
}