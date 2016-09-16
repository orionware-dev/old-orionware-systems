package webcore.pages;

import javax.servlet.http.HttpServletResponse;
import webcore.WebCoreService;
import webcore.ajax.AJAXResponse;

public interface PageAJAXService extends WebCoreService
{
    public void processAJAXCallForPage(HttpServletResponse response, AJAXResponse aJAXResponse);
}