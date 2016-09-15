package webcore.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MessageTag extends SimpleTagSupport
{
    private String key;


    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        //out.println(PollPlug.getProperty(getKey()));
    }


    public String getKey()
    {
        return key;
    }


    public void setKey(String key)
    {
        this.key = key;
    }
}