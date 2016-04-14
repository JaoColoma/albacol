<%@page import="Classes.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% ArrayList<Account> accountList = new ArrayList();
        accountList = (ArrayList<Account>) request.getAttribute("accountList");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Accounts Page</title>
    </head>
    <body>
        <h1>All Accounts</h1>
        <table><table style="width:100%">
                <% for (int i = 0; i < accountList.size(); i++) { %>
                <tr>
                    <td><%=accountList.get(i).getLastname()%></td>
                    <td><%=accountList.get(i).getFirstname()%></td>
                    <td><%=accountList.get(i).getMiddlename()%></td>
                    <td><%=accountList.get(i).getBirthday()%></td>
                    <td><%=accountList.get(i).getAddress()%></td>
                    <td><%=accountList.get(i).getNationality()%></td>
                    <td><%=accountList.get(i).getGender()%></td>
                    <td><%=accountList.get(i).getStatus()%></td>
                    <td><%=accountList.get(i).getNumber()%></td>
                </tr>
                <%}%>
				<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="CreateAccount.jsp">Create another account </a></td>
				</tr>
            </table>
    </body>
</html>
