package webcore.pages;

import webcore.WebCoreObject;
import webcore.WebCoreService;
import webcore.WebCoreServiceObject;

public interface PageInitialisationService extends WebCoreService
{
    /*public abstract void initialisePage(Model model, Map<String, Object> parameters);


    protected void initialisePageParameters(PageBean pageBean, Map<String, Object> parameters, HttpServletRequest request)
    {
        pageBean.setCurrentDate(new CalendarUtilities().getCurrentDate1());
        pageBean.setCurrentTime(new CalendarUtilities().getCurrentTime());
        pageBean.setAdministratorRole(getProperty("role.administrator"));
        pageBean.setUserRole(getProperty("role.user"));
        pageBean.setBusinessUserRole(getProperty("role.business"));
        pageBean.setAnonymousRole(getProperty("role.anonymous"));
        boolean isUserLoggedIn = new SessionUtilities().isCurrentUserLoggedIn(request);
        pageBean.setIsUserLoggedIn(Boolean.toString(new SessionUtilities().isCurrentUserLoggedIn(request)));

        if(isUserLoggedIn)
        {
            if((new SessionUtilities().getCurrentUserAuthority(request)).equals(getProperty("role.user")))
            {
                pageBean.setUserAuthority(getProperty("role.user"));
            }
            else if((new SessionUtilities().getCurrentUserAuthority(request)).equals(getProperty("role.business")))
            {
                pageBean.setUserAuthority(getProperty("role.business"));
            }
            else if((new SessionUtilities().getCurrentUserAuthority(request)).equals(getProperty("role.administrator")))
            {
                pageBean.setUserAuthority(getProperty("role.administrator"));
            }
        }
        else
        {
            pageBean.setUserAuthority(getProperty("role.anonymous"));
        }

        int currentUserDevice = new SessionUtilities().getCurrentUserDevice(request);

        if(currentUserDevice == UserDeviceTypes.MOBILE)
        {
            pageBean.setIsDesktop("false");
            pageBean.setIsMobile("true");
        }
        else
        {
            pageBean.setIsDesktop("true");
            pageBean.setIsMobile("false");
        }
    }*/
}