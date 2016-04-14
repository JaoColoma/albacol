package Servlet;

import Classes.Account;
import Bean.TwilioConnect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


@WebServlet(name = "TwilioServlet", urlPatterns = {"/TwilioServlet"})
public class TwilioServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TwilioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TwilioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        PrintWriter out = response.getWriter();
        Sms msg = null;
        TwilioConnect connect = new TwilioConnect();
		
        String authToken = connect.getAuthToken();
        String accountSID = connect.getAcctSID();
        TwilioRestClient tw_client = new TwilioRestClient(accountSID, authToken);
        
        Map<String, String> params = new HashMap<String, String>();
        String[] senatorvalues = request.getParameterValues("senator");
        String s=Arrays.toString(senatorvalues).replaceAll("(\\[|\\]|| )", "");
        

        params.put("From", "+12016901187");
        params.put("Body", "President: " + request.getParameter("president") + ", Vice President: " + request.getParameter("vp") + ", Senators: " + s);
        params.put("To", request.getParameter("sendto"));
        
        SmsFactory msgFactory = tw_client.getAccount().getSmsFactory();
        try {
            msg = msgFactory.create(params);
        }
        catch (TwilioRestException e) {
            throw new ServletException(e);
	}
        out.println("Thank you for voting! Message sent! Your message ID is:" + msg.getSid());
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
