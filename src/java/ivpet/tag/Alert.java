/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author op7
 */
public class Alert extends SimpleTagSupport {

    private String message;
    private String context = "danger";

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
	JspWriter out = getJspContext().getOut();

	try {
	    // TODO: insert code to write html before writing the body content.

	    if (message != null) {
		String message_html = String.format("<div class='alert alert-%s'>%s</div>", context, message);
		out.println(message_html);
	    }

	    JspFragment f = getJspBody();
	    if (f != null) {
		f.invoke(out);
	    }

	    // TODO: insert code to write html after writing the body content.
	    // e.g.:
	    //
	    // out.println("    </blockquote>");
	} catch (java.io.IOException ex) {
	    throw new JspException("Error in Alert tag", ex);
	}
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public void setContext(String context) {
	this.context = context;
    }

}
