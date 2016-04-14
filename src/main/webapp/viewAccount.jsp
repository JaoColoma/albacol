<%@page import="Classes.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Account accountList = (Account) request.getAttribute("accountList");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Account Page</title>
        
                <script type="text/javascript">

function checkboxlimit(checkgroup, limit){
	var checkgroup=checkgroup
	var limit=limit
	for (var i=0; i<checkgroup.length; i++){
		checkgroup[i].onclick=function(){
		var checkedcount=0
		for (var i=0; i<checkgroup.length; i++)
			checkedcount+=(checkgroup[i].checked)? 1 : 0
		if (checkedcount>limit){
			alert("You can only select a maximum of "+limit+" checkboxes")
			this.checked=false
			}
		}
	}
}

</script>
        
    </head>
    <body>
        <h1>Your Account Information</h1>
		<form method="POST" action="TwilioServlet" id="senate" name="senate">

        <table><table style="width:100%">
                <tr>
                    <td><%=accountList.getLastname()%></td>
                    <td><%=accountList.getFirstname()%></td>
                    <td><%=accountList.getMiddlename()%></td>
                    <td><%=accountList.getBirthday()%></td>
                    <td><%=accountList.getAddress()%></td>
                    <td><%=accountList.getNationality()%></td>
                    <td><%=accountList.getGender()%></td>
                    <td><%=accountList.getStatus()%></td>
                    <td><%=accountList.getNumber()%></td>
                </tr>
             </table>
             
             </br>
             </br>
             
			<p>
            </p>
            <h5>Please Choose President:</h5>
        
            <input type="radio" name="president" value="Binay" checked> Binay, Jejomar<br>
            <input type="radio" name="president" value="Duterte"> Duterte, Rodrigo<br>
            <input type="radio" name="president" value="Poe"> Poe, Mary Grace<br>
            <input type="radio" name="president" value="Roxas"> Roxas, Manuel<br>
            <input type="radio" name="president" value="Santiago"> Santiago, Miriam<br>
       
        </br>
        </br>
        <h5>Please Choose President:</h5>
      
            <input type="radio" name="vp" value="Cayetano" checked> Cayetano, Alan Peter<br>
            <input type="radio" name="vp" value="Escudero"> Escudero, Francis<br>
            <input type="radio" name="vp" value="Honasan"> Honasan, Gregorio<br>
            <input type="radio" name="vp" value="Marcos"> Marcos, Ferdinand Jr.<br>
            <input type="radio" name="vp" value="Robredo"> Robredo, Leni<br>
            <input type="radio" name="vp" value="Trillianes"> Trillianes, Antonio<br>
                
        </br>
        </br>  
        <h5>Please Choose Senators:</h5>
        
            <input type="checkbox" name="senator" value="1" /> 1. Ambolodto, Ina<br />
            <input type="checkbox" name="senator" value="2"/> 2. Colmenares, Neri<br />
            <input type="checkbox" name="senator" value="3"/> 3. De Lima, Leila<br />
            <input type="checkbox" name="senator" value="4"/> 4. Drilon, Franklin<br />
            <input type="checkbox" name="senator" value="5"/> 5. Gatchalian, Sherwin<br />
            <input type="checkbox" name="senator" value="6"/> 6. Gordon, Richard<br />
            <input type="checkbox" name="senator" value="7"/> 7. Guingona, TG<br />
            <input type="checkbox" name="senator" value="8"/> 8. Hontiveros, Risa<br />
            <input type="checkbox" name="senator" value="9"/> 9. Kapunan, Lorna<br />
            <input type="checkbox" name="senator" value="10"/> 10. Kiram, Princess Jacel<br />
            <input type="checkbox" name="senator" value="11"/> 11. Lacson, Panfilo<br />
            <input type="checkbox" name="senator" value="12"/> 12. Langit, Rey<br />
            <input type="checkbox" name="senator" value="13"/> 13. Lapid, Mark<br />
            <input type="checkbox" name="senator" value="14"/> 14. Manzano, Edu<br />
            <input type="checkbox" name="senator" value="15"/> 15. Montano, Allan<br />
            <input type="checkbox" name="senator" value="16"/> 16. Moreno, Alma<br />
            <input type="checkbox" name="senator" value="17"/> 17. Moreno, Isko<br />
            <input type="checkbox" name="senator" value="18"/> 18. Napeñas, Getulio<br />
            <input type="checkbox" name="senator" value="19"/> 19. Ople, Susan<br />
            <input type="checkbox" name="senator" value="20"/> 20. Pacquiao, Manny<br />
            <input type="checkbox" name="senator" value="21"/> 21. Paez, Cresente<br />
            <input type="checkbox" name="senator" value="22"/> 22. Pagdilao, Samuel<br />
            <input type="checkbox" name="senator" value="23"/> 23. Pangilinan, Francis<br />
            <input type="checkbox" name="senator" value="24"/> 24. Petilla, Jericho<br />
            <input type="checkbox" name="senator" value="25"/> 25. Recto, Ralph<br />
            <input type="checkbox" name="senator" value="26"/> 26. Romualdez, Martin<br />
            <input type="checkbox" name="senator" value="27"/> 27. Romulo, Roman<br />
            <input type="checkbox" name="senator" value="28"/> 28. Santiago, Dionisio<br />
            <input type="checkbox" name="senator" value="29"/> 29. Sotto, Tito<br />
            <input type="checkbox" name="senator" value="30"/> 30. Tolentino, Francis<br />
            <input type="checkbox" name="senator" value="31"/> 31. Villanueva, Joel<br />
            <input type="checkbox" name="senator" value="32"/> 32. Zubiri, Juan Miguel<br />
        
			<input type='hidden' name='sendto' value='<%=accountList.getNumber()%>'>
			
            <input type="submit" value="Vote!">
        </form>
        
        <script type="text/javascript">

			//Syntax: checkboxlimit(checkbox_reference, limit)
			checkboxlimit(document.forms.senate.senator, 12)

		</script>

    </body>
</html>
