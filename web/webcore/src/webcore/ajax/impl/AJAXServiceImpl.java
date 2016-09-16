package webcore.ajax.impl;

import javax.servlet.http.HttpServletResponse;
import dependencyinjection.annotation.Injector;
import webcore.WebCoreServiceObject;
import webcore.ajax.AJAXResponse;
import webcore.ajax.AJAXService;
import webcore.ajax.impl.tasks.ProcessAJAXCallTask;

public class AJAXServiceImpl extends WebCoreServiceObject implements AJAXService
{
    @Injector
    private ProcessAJAXCallTask processAJAXCallTask;
    
    
    @Override
    public void processAJAXCall(HttpServletResponse response, AJAXResponse aJAXResponse)
    {
        processAJAXCallTask.run(response, aJAXResponse);
    }
}