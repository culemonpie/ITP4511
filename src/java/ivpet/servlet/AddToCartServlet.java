/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.servlet;

import ivpet.bean.EquipmentBean;
import ivpet.db.AssignmentDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AddToCertServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends AbstractServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /**
             * get the id of the item append that to session.setAttribute(cart)
             * add message saying success redirect user to the original page
             */

            AssignmentDB db = new AssignmentDB();

            /*
            If that equipment exists.
                If so, check if it's in cart
                    Prompt user that it's already in cart
                Else
                    Add item to cart
            Else
                Prompt that it doesn't exist
             */
            String action = request.getParameter("action");
            if (action == null){
                action = "add"; //to be fixed from upstream
            }

            ArrayList<Integer> cart = null;
            HttpSession session = request.getSession();

            if (action.equals("clear")) {
                cart = (ArrayList) session.getAttribute("cart");
                cart.clear();
                session.setAttribute("cart", cart);
                request.setAttribute("message", "Cart cleared");
                out.println("120");
            } else if (action.equals("submit")) {
                //submit cart
            } else if (action.equals("add")){
                out.println(3);
                String id = request.getParameter("id");
                Integer id_int = Integer.parseInt(id);
                EquipmentBean equipment = db.getEquipment(Integer.parseInt(id));
                if (equipment != null) {
                    if (session.getAttribute("cart") != null) {
                        cart = (ArrayList) session.getAttribute("cart");
                        if (!cart.contains(id_int)) {
                            cart.add(id_int);
                            request.setAttribute("message", String.format("Added %s to cart", equipment.getname()));
                        } else {
                            request.setAttribute("message", "Item is already in cart");
                        }
                    } else {
                        cart = new ArrayList();
                        cart.add(Integer.parseInt(id));
                        request.setAttribute("message", String.format("Added %s to cart", equipment.getname()));
                    }
                    session.setAttribute("cart", cart);
                } else {
                    request.setAttribute("message", "Equipment does not exist");
                }
            }
            String url = "/cart.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
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
