package com.revature._611.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private String requestHelper;
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHelper = new RequestHelper().process(request, response);
		response.getWriter().write(requestHelper);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHelper = new RequestHelper().process(request, response);
		response.getWriter().write(requestHelper);
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 949b4135701f1a92b73a375dfde983a32e2d003e
