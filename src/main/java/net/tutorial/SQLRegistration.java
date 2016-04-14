/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Classes.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SQLRegistration", urlPatterns = {"/SQLRegistration"})
public class SQLRegistration extends HttpServlet {

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

        
        PrintWriter writer = response.getWriter();
        writer.println("IBM SQL Database, Java Demo Application using DB2 drivers");
        writer.println("Servlet: " + this.getClass().getName());
        writer.println();
        writer.println("Host IP:" + InetAddress.getLocalHost().getHostAddress());
        DBHelper db;
        try {
            db = new DBHelper(writer);
            Account bean = new Account();
			bean.setLastname(request.getParameter("lastname"));
            bean.setFirstname(request.getParameter("firstname"));
            bean.setMiddlename(request.getParameter("middlename"));
            bean.setBirthday(Date.valueOf(request.getParameter("birthday")));
            bean.setAddress(request.getParameter("address"));
            bean.setNationality(request.getParameter("nationality"));
            bean.setGender(request.getParameter("gender"));
            bean.setStatus(request.getParameter("status"));
            
            bean.setNumber(request.getParameter("phonenumber"));
            
            db.insertInto(bean);
            request.setAttribute("accountList", db.getAllAccount());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("viewAccounts.jsp");
            if (db.getAllAccount() != null) {
                rd.forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(SQLRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
