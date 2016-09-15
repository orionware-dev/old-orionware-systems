package webcore.devices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class DeviceService
{
    private final List<String> mobileUserAgentPrefixes = new ArrayList<String>();
    private final List<String> mobileUserAgentKeywords = new ArrayList<String>();
    private final List<String> tabletUserAgentKeywords = new ArrayList<String>();
    private final List<String> normalUserAgentKeywords = new ArrayList<String>();
    private static final String[] KNOWN_MOBILE_USER_AGENT_PREFIXES = {"w3c ", "w3c-", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "htc_", "inno", "ipaq", "ipod", "jigs", "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "lg/u", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-", "moto", "mwbp", "nec-", "newt", "noki", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda ", "xda-"};
    private static final String[] KNOWN_MOBILE_USER_AGENT_KEYWORDS = {"blackberry", "webos", "ipod", "lge vx", "midp", "maemo", "mmp", "mobile", "netfront", "hiptop", "nintendo DS", "novarra", "openweb", "opera mobi", "opera mini", "palm", "psp", "phone", "smartphone", "symbian", "up.browser", "up.link", "wap", "windows ce"};
    private static final String[] KNOWN_TABLET_USER_AGENT_KEYWORDS = {"ipad", "playbook", "hp-tablet", "kindle"};


    public DeviceService()
    {
        init();
    }


    public int resolveDevice(HttpServletRequest request)
    {
        String userAgent = request.getHeader("User-Agent");

        if(userAgent != null)
        {
            userAgent = userAgent.toLowerCase();

            for(String keyword : this.normalUserAgentKeywords)
            {
                if(userAgent.contains(keyword))
                {
                    return resolveFallback(request);
                }
            }
        }

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

            for(String keyword : this.tabletUserAgentKeywords)
            {
                if(userAgent.contains(keyword))
                {
                    return UserDeviceTypes.TABLET;
                }
            }
        }

        if((request.getHeader("x-wap-profile") != null) || (request.getHeader("Profile") != null))
        {
            return UserDeviceTypes.MOBILE;
        }

        if((userAgent != null) && (userAgent.length() >= 4))
        {
            String prefix = userAgent.substring(0, 4).toLowerCase();

            if(this.mobileUserAgentPrefixes.contains(prefix))
            {
                return UserDeviceTypes.MOBILE;
            }
        }

        String accept = request.getHeader("Accept");

        if((accept != null) && (accept.contains("wap")))
        {
            return UserDeviceTypes.MOBILE;
        }

        if(userAgent != null)
        {
            for(String keyword : this.mobileUserAgentKeywords)
            {
                if(userAgent.contains(keyword))
                {
                    return UserDeviceTypes.MOBILE;
                }
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

        return resolveFallback(request);
    }


    protected List<String> getMobileUserAgentPrefixes()
    {
        return this.mobileUserAgentPrefixes;
    }


    protected List<String> getMobileUserAgentKeywords()
    {
        return this.mobileUserAgentKeywords;
    }


    protected List<String> getTabletUserAgentKeywords()
    {
        return this.tabletUserAgentKeywords;
    }


    protected List<String> getNormalUserAgentKeywords()
    {
        return this.normalUserAgentKeywords;
    }


    protected void init()
    {
        getMobileUserAgentPrefixes().addAll(Arrays.asList(KNOWN_MOBILE_USER_AGENT_PREFIXES));
        getMobileUserAgentKeywords().addAll(Arrays.asList(KNOWN_MOBILE_USER_AGENT_KEYWORDS));
        getTabletUserAgentKeywords().addAll(Arrays.asList(KNOWN_TABLET_USER_AGENT_KEYWORDS));
    }


    protected int resolveFallback(HttpServletRequest request)
    {
        return UserDeviceTypes.DESKTOP;
    }
}