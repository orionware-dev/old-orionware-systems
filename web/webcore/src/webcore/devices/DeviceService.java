package webcore.devices;

import javax.servlet.http.HttpServletRequest;
import webcore.WebCoreService;

public interface DeviceService extends WebCoreService
{
    public int resolveDevice(HttpServletRequest request);
}