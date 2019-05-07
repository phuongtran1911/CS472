package net.mumde.cs545;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class Label extends SimpleTagSupport {
    String foreColor;
    String text;
    //This is called from JSP servlet to render custom tag
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (foreColor != null)
            out.write(String.format("<span style='color:%s'>%s</span>", foreColor, text));
        else
            out.write(String.format("<span>%s</span>", text));
    }
    //Need a setter for each attribute of custom tag
    public void setForeColor(String foreColor) {
        this.foreColor = foreColor;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}