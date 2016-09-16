package webcore.pages.components;

import javax.servlet.http.HttpServletResponse;
import webcore.WebCoreService;
import webcore.ajax.AJAXResponse;

public interface PageComponentAJAXService extends WebCoreService
{
    public void processAJAXCallForPage(HttpServletResponse response, AJAXResponse aJAXResponse);
}