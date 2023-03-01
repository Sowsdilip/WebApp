package com.sowmya.service;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class UserTagLib extends TagSupport {
	String[] names;

	public void setArray(String[] users) {
		names = users;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		try {
			out.print(names);
			System.out.println("doStartTag");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
