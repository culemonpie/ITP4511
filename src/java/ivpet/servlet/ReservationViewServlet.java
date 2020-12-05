/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.servlet;

import ivpet.db.AssignmentDB;
import ivpet.bean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.time.LocalDate;
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
@WebServlet(name = "ReservationViewServlet", urlPatterns = {"/reservation/view"})
public class ReservationViewServlet extends AbstractServlet {

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
	    
	    

	    request.setAttribute("title", String.format("View reservation #%s", id));
	    request.setAttribute("id", id);
	    String url = "/reservation/view.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	    // todo later
	    if (id != null) {

	    } else {

	    }

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
	//todo: Samuel please work on the messages here
	String action = request.getParameter("action");
        AssignmentDB db = new AssignmentDB();
        
        if (action.equals("approve")){
            /*
            1. Edit reservation.approved_by = request.session.user
            2. Change all equipments of that reservation to be occupied (status 1)
            3. Create borrow record (status 0, checkout_date = today, returned_date = T+14
            4. Prompt message success
            
            
            with django.db.transaction.atomic():
                reservation = get_object_or_404(m.ReservationRequest, id)
                reservation.approved_by = request.user
                reservation.save()

                reservation.equipments_set().update(status = m.Equipments.OCCUPIED)
                #Auto saving

                borrow_record = m.BorrowRecord(status = m.BorrowRecord.PENDING)
                //checkout_date is added automatically
                borrow_record.returned_date = datetime.date.today() + datetime.timedelta(days = config.LOAN_PERIOD)
                borrow_record.save()

                alerts.append(m.Alert("Record has been added"))
            
            return HttpResponseRedirect(reverse("reservation_view", args=[reservation.id]))
            
            */
            
            //1
            String id = request.getParameter("id");
            ReservationRequestBean reservation = db.getReservationRequest(Integer.parseInt(id));
            //todo: Change action??
            
            //2
            for (EquipmentBean equipment: reservation.getEquipments()){
                equipment.setstatus(1);//occupied
                db.editEquipmentRecord(equipment);
            }
            
            //3
            //todo: obtain the instance of BorrowRecordBean
            LocalDate today =  LocalDate.now();
            LocalDate due_date = today.plusDays(14);
            db.addBorrowRecord(Integer.parseInt(id), 0, today.toString(), due_date.toString(), false, 0);
            BorrowRecordBean borrowRecord = null;
            
            //4
            request.setAttribute("message", "Success");
            
            
            
            
            
        } else if (action.equals("reject")){
            /*
            
            */
        } 
        
	request.setAttribute("message", action);
	
	
	//do not change
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
