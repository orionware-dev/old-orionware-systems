package webcore.devices;

import webcore.ajax.AJAXResponse;

public class UserDeviceType extends AJAXResponse
{
    private Integer userDeviceType;


    public Integer getUserDeviceType()
    {
        return userDeviceType;
    }


    public void setUserDeviceType(Integer userDeviceType)
    {
        this.userDeviceType = userDeviceType;
    }
}