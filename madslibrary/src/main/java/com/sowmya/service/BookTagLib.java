package com.sowmya.service;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class BookTagLib extends TagSupport{
	String name;
	public void setArray(String value) {
		name=value;
	}
	
	public int doStartTag() throws JspException {  
	    JspWriter out=pageContext.getOut(); 
	  
	    try{  
	        out.print(name); 
	        System.out.println("doStartTag");
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return SKIP_BODY;  
	}  

}
