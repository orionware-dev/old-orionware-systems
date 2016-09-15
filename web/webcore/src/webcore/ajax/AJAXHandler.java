package webcore.ajax;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import webcore.json.JSONUtilities;

public class AJAXHandler
{
    private final static Logger LOGGER = Logger.getLogger(AJAXHandler.class.getName());


    public static void processAjaxResponse(HttpServletResponse response, AJAXResponse aJAXResponse)
    {
        try
        {
            String JSONResponse = new JSONUtilities().convertObjectToJSON(aJAXResponse);
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
            LOGGER.info("AJAX Error = " + e1);
        }
    }
}