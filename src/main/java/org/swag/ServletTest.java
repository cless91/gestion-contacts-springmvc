package org.swag;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/")
public class ServletTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1099528895661097360L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("coucouservlet");
	}
}
