/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author op7
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends AbstractServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    boolean doAuthenticate(HttpServletRequest request, String username, String password) {
	boolean password_match = false;
	if (username.equals("demo") && password.equals("demoPassword")) {
            HttpSession session = request.getSession();
	    session.setAttribute("username", username);
	    session.setAttribute("role", 1);
	    password_match = true;
	} else if (username.equals("admin") && password.equals("admin")) {
	    HttpSession session = request.getSession();
	    session.setAttribute("username", username);
	    session.setAttribute("role", 3);
	    password_match = true;
	} else {
	    password_match = false;
	}
	return password_match;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter()) {
	    /* TODO output your page here. You may use following sample code. */
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    Boolean is_valid = true;
	    String error_message = "";
	    if (username == null) {
		error_message = "Username is empty\n";
		is_valid = false;
	    }

	    if (password == null) {
		is_valid = false;

	    }

	    if (is_valid) {
		boolean password_match = doAuthenticate(request, username, password);
		if (!password_match) {
		    is_valid = false;
		    error_message = "Incorrect username / password";
		}
	    }

	    // If the username / password combination is valid, direct them to welcome page and save the username to session.
	    // Otherwise, prompt an error.
	    if (is_valid) {
		response.sendRedirect(request.getContextPath() + "/welcome.jsp");

	    } else {
		error_message = String.format("Password: %s<br>", password);
		request.setAttribute("message", error_message);
		String url = "/login.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	    }

//		out.println(String.format("Username: %s<br> Password:%s<br>", username, password));
//	    } else {
//		request.setAttribute("error_message", error_message);
//		String url = "/login.jsp";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//	    }
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
