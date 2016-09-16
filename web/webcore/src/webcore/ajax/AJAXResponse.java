package webcore.ajax;

import webcore.WebCoreObject;

public class AJAXResponse extends WebCoreObject
{
    private Boolean error = Boolean.FALSE;


    public Boolean getError()
    {
        return error;
    }


    public void setError(Boolean error)
    {
        this.error = error;
    }
}