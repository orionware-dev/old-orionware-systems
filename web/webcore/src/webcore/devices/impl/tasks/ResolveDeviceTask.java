package webcore.devices.impl.tasks;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import webcore.WebCoreObject;
import webcore.WebCoreTask;
import webcore.devices.UserAgents;
import webcore.devices.UserDeviceTypes;

public class ResolveDeviceTask extends WebCoreObject implements WebCoreTask
{
    public int run(HttpServletRequest request)
    {
        String userAgent = request.getHeader("User-Agent");

        if(userAgent != null)
        {
            userAgent = userAgent.toLowerCase();

            if((userAgent.contains("android")) && (!(userAgent.contains("mobile"))))
            {
                return UserDeviceTypes.TABLET;
            }

            if((userAgent.contains("silk")) && (!(userAgent.contains("mobile"))))
            {
                return UserDeviceTypes.TABLET;
            }

            for(String keyword : UserAgents.tabletUserAgentKeywords)
            {
                if(userAgent.contains(keyword))
                {
                    return UserDeviceTypes.TABLET;
                }
            }
            
            if((request.getHeader("x-wap-profile") != null) || (request.getHeader("Profile") != null))
            {
                return UserDeviceTypes.MOBILE;
            }
            
            if(userAgent.length() >= 4)
            {
                String prefix = userAgent.substring(0, 4).toLowerCase();

                if(UserAgents.mobileUserAgentPrefixes.contains(prefix))
                {
                    return UserDeviceTypes.MOBILE;
                }
            }
            
            String accept = request.getHeader("Accept");

            if(accept.contains("wap"))
            {
                return UserDeviceTypes.MOBILE;
            }
            
            for(String keyword : UserAgents.mobileUserAgentKeywords)
            {
                if(userAgent.contains(keyword))
                {
                    return UserDeviceTypes.MOBILE;
                }
            }
            
            Enumeration<String> headers = request.getHeaderNames();

            while(headers.hasMoreElements())
            {
                String header = (String)headers.nextElement();

                if(header.contains("OperaMini"))
                {
                    return UserDeviceTypes.MOBILE;
                }
            }
        }

        return UserDeviceTypes.DESKTOP;
    }
}