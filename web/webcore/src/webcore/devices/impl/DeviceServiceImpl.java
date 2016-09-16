package webcore.devices.impl;

import javax.servlet.http.HttpServletRequest;
import dependencyinjection.annotation.Injector;
import webcore.WebCoreServiceObject;
import webcore.devices.DeviceService;
import webcore.devices.impl.tasks.ResolveDeviceTask;

public class DeviceServiceImpl extends WebCoreServiceObject implements DeviceService
{
    @Injector
    private ResolveDeviceTask resolveDeviceTask;


    @Override
    public int resolveDevice(HttpServletRequest request)
    {
        return resolveDeviceTask.run(request);
    }
}