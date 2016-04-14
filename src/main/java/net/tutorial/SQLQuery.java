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

@WebServlet(name = "SQLQuery", urlPatterns = {"/SQLQuery"})
public class SQLQuery extends HttpServlet {

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
            String votersID = request.getParameter("votersid");
            Account user = new Account();
            
            user = db.selectUser(votersID);
            request.setAttribute("accountList", user);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("viewAccount.jsp");
            if (db.getAllAccount() != null) {
                rd.forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(SQLRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
