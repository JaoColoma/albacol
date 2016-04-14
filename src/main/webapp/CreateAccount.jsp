<%@page import="java.beans.Beans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Online Voter's Registration Form</title>
     </head>
    <body>
	
		<form method='POST' action='SQLRegistration'>
            <b> Personal Information </b>
            <br><br>
            Last Name: <input type='text' name='lastname'><br>
            First Name: <input type='text' name='firstname'><br>
            Middle Name: <input type='text' name='middlename'><br>
            Birthday: <input type='date' name='birthday'><br>
            Residence/Address: <input type='text' name='address'><br>
            Nationality: <input type='text' name='nationality'><br>            
            <i>Gender</i>
            <input type='radio' name='gender' value='male'>Male
            <input type='radio' name='gender' value='female'>Female<br>
            <i>Civil Status</i>
            <input type='radio' name='status' value='single'>Single
            <input type='radio' name='status' value='married'>Married
            <input type='radio' name='status' value='widow'>Widow/er
            <input type='radio' name='status' value='separated'>Legally Separated
            
            <br>
            <br>
            Phone Number:<input type='text' name='phonenumber'>
            <br>
            <input type='submit' value='Submit'>
        </form>
    </body>
</html>
