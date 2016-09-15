package webcore.json;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class JSONUtilities
{
    public String convertObjectToJSON(Object objectToConvert)
    {
        Gson gson = new Gson();
        String JSONResponse = gson.toJson(objectToConvert);

        return JSONResponse;
    }


    @SuppressWarnings("unchecked")
    public Map<Object, Object> convertJSONToMap(String JSONData)
    {
        Gson gson = new Gson();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map = (Map<Object, Object>)gson.fromJson(JSONData, map.getClass());

        return map;
    }
}