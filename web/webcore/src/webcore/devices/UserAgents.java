package webcore.devices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.abstraction.OrionConstants;
import webcore.WebCoreObject;

public class UserAgents extends WebCoreObject implements OrionConstants
{
    public static final List<String> mobileUserAgentPrefixes = new ArrayList<String>();
    public static final List<String> mobileUserAgentKeywords = new ArrayList<String>();
    public static final List<String> tabletUserAgentKeywords = new ArrayList<String>();
    public static final String[] KNOWN_MOBILE_USER_AGENT_PREFIXES = new String[] {"w3c ", "w3c-", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "htc_", "inno", "ipaq", "ipod", "jigs", "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "lg/u", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-", "moto", "mwbp", "nec-", "newt", "noki", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda ", "xda-"};
    public static final String[] KNOWN_MOBILE_USER_AGENT_KEYWORDS = new String[] {"blackberry", "webos", "ipod", "lge vx", "midp", "maemo", "mmp", "mobile", "netfront", "hiptop", "nintendo DS", "novarra", "openweb", "opera mobi", "opera mini", "palm", "psp", "phone", "smartphone", "symbian", "up.browser", "up.link", "wap", "windows ce"};
    public static final String[] KNOWN_TABLET_USER_AGENT_KEYWORDS = new String[] {"ipad", "playbook", "hp-tablet", "kindle"};
    
    
    static
    {
        mobileUserAgentPrefixes.addAll(Arrays.asList(KNOWN_MOBILE_USER_AGENT_PREFIXES));
        mobileUserAgentKeywords.addAll(Arrays.asList(KNOWN_MOBILE_USER_AGENT_KEYWORDS));
        tabletUserAgentKeywords.addAll(Arrays.asList(KNOWN_TABLET_USER_AGENT_KEYWORDS));
    }
}