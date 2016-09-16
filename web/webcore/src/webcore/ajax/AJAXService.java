package webcore.ajax;

import javax.servlet.http.HttpServletResponse;
import webcore.WebCoreService;

public interface AJAXService extends WebCoreService
{
    public void processAJAXCall(HttpServletResponse response, AJAXResponse aJAXResponse);
}