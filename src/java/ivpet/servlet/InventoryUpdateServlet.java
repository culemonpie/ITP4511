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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author op7
 */
@WebServlet(name = "InventoryUpdateServlet", urlPatterns = {"/inventory/update"})
/**
 * Code: 3.3 Who can access: Technicians Description: Technicians updating
 */

public class InventoryUpdateServlet extends AbstractServlet {

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
            /* TODO output your page here. You may use following sample code. */

            //Obtain the id
            String id = request.getParameter("id");

            request.setAttribute("title", String.format("Update inventory #%s", id));
            request.setAttribute("id", id);
            String url = "/inventory/update.jsp";
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

        int id = Integer.parseInt(request.getParameter("id"));

        AssignmentDB db = new AssignmentDB();
        EquipmentBean equipment = db.getEquipment(id);

        String name = request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("status"));
        String description = request.getParameter("description");
        String tag = request.getParameter("tags");
        boolean is_listed = request.getParameter("is_listed") != null;

        equipment.setname(name);
        equipment.setstatus(status);
        equipment.setDescription(description);
        equipment.setTag(tag);
        equipment.setis_listed(is_listed);

        db.editEquipmentRecord(equipment);

        String message_text = "Success";
        request.setAttribute("message", message_text);
        request.setAttribute("id", id);
        String url = "/inventory/view.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

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
