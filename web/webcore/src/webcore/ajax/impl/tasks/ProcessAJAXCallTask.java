package webcore.ajax.impl.tasks;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import dependencyinjection.annotation.InjectorImpl;
import webcore.WebCoreObject;
import webcore.WebCoreTask;
import webcore.ajax.AJAXResponse;
import webcore.json.JSONService;

public class ProcessAJAXCallTask extends WebCoreObject implements WebCoreTask
{
    @InjectorImpl
    private JSONService aJSONService;
    
    
    public void run(HttpServletResponse response, AJAXResponse aJAXResponse)
    {
        try
        {
            String JSONResponse = aJSONService.convertObjectToJSON(aJAXResponse);
            response.setContentType("application/json");
            response.setHeader("Allow", "GET, POST");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            ServletOutputStream out = response.getOutputStream();
            out.print(JSONResponse);
            out.flush();
            out.close();
        }
        catch(IOException e1)
        {
            
        }
    }
}