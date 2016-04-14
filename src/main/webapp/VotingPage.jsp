<%-- 
    Document   : index
    Created on : Mar 6, 2016, 8:06:25 PM
    Author     : yla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <form method="POST" action="TwilioServlet" id="senate" name="senate">
			<p>
            <p>
            <input name="sendto" id="sendto" type="text" value="" placeholder="Enter phone number here">
            </p>
            <p>
            <textarea id="smsmsg" name="smsmsg" placeholder="Enter message here"></textarea>
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
        
            <input type="checkbox" name="senator" value="1" /> Ambolodto, Ina<br />
            <input type="checkbox" name="senator" value="2"/> Colmenares, Neri<br />
            <input type="checkbox" name="senator" value="3"/> De Lima, Leila<br />
            <input type="checkbox" name="senator" value="4"/> Drilon, Franklin<br />
            <input type="checkbox" name="senator" value="5"/> Gatchalian, Sherwin<br />
            <input type="checkbox" name="senator" value="6"/> Gordon, Richard<br />
            <input type="checkbox" name="senator" value="7"/> Guingona, TG<br />
            <input type="checkbox" name="senator" value="8"/> Hontiveros, Risa<br />
            <input type="checkbox" name="senator" value="9"/> Kapunan, Lorna<br />
            <input type="checkbox" name="senator" value="10"/> Kiram, Princess Jacel<br />
            <input type="checkbox" name="senator" value="11"/> Lacson, Panfilo<br />
            <input type="checkbox" name="senator" value="12"/> Langit, Rey<br />
            <input type="checkbox" name="senator" value="13"/> Lapid, Mark<br />
            <input type="checkbox" name="senator" value="14"/> Manzano, Edu<br />
            <input type="checkbox" name="senator" value="15"/> Montano, Allan<br />
            <input type="checkbox" name="senator" value="16"/> Moreno, Alma<br />
            <input type="checkbox" name="senator" value="17"/> Moreno, Isko<br />
            <input type="checkbox" name="senator" value="18"/> Napeñas, Getulio<br />
            <input type="checkbox" name="senator" value="19"/> Ople, Susan<br />
            <input type="checkbox" name="senator" value="20"/> Pacquiao, Manny<br />
            <input type="checkbox" name="senator" value="21"/> Paez, Cresente<br />
            <input type="checkbox" name="senator" value="22"/> Pagdilao, Samuel<br />
            <input type="checkbox" name="senator" value="23"/> Pangilinan, Francis<br />
            <input type="checkbox" name="senator" value="24"/> Petilla, Jericho<br />
            <input type="checkbox" name="senator" value="25"/> Recto, Ralph<br />
            <input type="checkbox" name="senator" value="26"/> Romualdez, Martin<br />
            <input type="checkbox" name="senator" value="27"/> Romulo, Roman<br />
            <input type="checkbox" name="senator" value="28"/> Santiago, Dionisio<br />
            <input type="checkbox" name="senator" value="29"/> Sotto, Tito<br />
            <input type="checkbox" name="senator" value="30"/> Tolentino, Francis<br />
            <input type="checkbox" name="senator" value="31"/> Villanueva, Joel<br />
            <input type="checkbox" name="senator" value="32"/> Zubiri, Juan Miguel<br />
        
            <input type="submit" value="Send!">
        </form>
        
        <script type="text/javascript">

			//Syntax: checkboxlimit(checkbox_reference, limit)
			checkboxlimit(document.forms.senate.senator, 12)

		</script>
        
    </body>
</html>
