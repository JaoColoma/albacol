<%@page import="java.beans.Beans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Philippine Elections</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
     </head>
    <body>
	    <img src="http://www.attorneysinbelize.com/images/FILIPINO-FLAG.jpg" width="1260" height="142">
        <h1>Welcome Voter!</h1>
        </br>
		<form method='POST' action='SQLQuery'>
            Please Enter your voter's ID: </br>
            <input type="text" name="votersid">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
