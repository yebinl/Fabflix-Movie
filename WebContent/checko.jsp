<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix - CheckOut</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link type="text/css" rel="stylesheet" href="jQ\css\carousel.css">
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" />
</head>
<body>
<!-- this is the header -->
<div>
<jsp:include page="header.jsp"></jsp:include>
</div>
<!-- header ends -->

	<%
	String user = (String)session.getAttribute("user");
	if(user==null)
		response.sendRedirect("login.jsp");
	
			%>
	<div class="logindiv">
	<div class="loginform">
		 	<br />
			<p><font face="arial" size="35px">Check Out</font><p>
		<%
		try{
			int err = Integer.parseInt((String)request.getAttribute("err"));
			if(err==1){
				%>
			<div class="loginerr2">
 				<div class="loginerrtext">
 				<font size=3 face="arial" color="white">Wrong Credit Card Information</font>
 				</div>
 			</div>
				<%
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		%>
		<form action="CheckOut" method="post">
		<p><font color="gray" face="arial">Credit Card Number:</font></p>
		<input class="textinput" type="text" name="ccid">
		<p><font color="gray" face="arial">Expire Date:</font></p>
		<input class="textinput" type="text" name="exp">
		<p><font color="gray" face="arial">Card Holder First Name:</font></p>
		<input class="textinput" type="text" name="first">
		<p><font color="gray" face="arial">Card Holder Last Name:</font></p>
		<input class="textinput" type="text" name="last">
		<br /><br /><br />
		<input class="loginbutt" type="submit" value="CheckOut"  onmouseover="this.style.backgroundColor='red';" onmouseout="this.style.backgroundColor='';">
		</form>
		<br /><br /><br />
		</div>
	</div>
</body>
</html>