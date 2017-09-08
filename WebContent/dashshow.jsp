<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix DashBoard</title>
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" />
</head>
<body>
<br />
<br />
<br />
<input type="button" value="Back" onclick="location.href='dash.jsp'">
<center><h3>Console</h3></center>
<div style="width:60%;margin:0 auto;border:1px solid;">
<div style="width:90%;margin:0 auto;margin-top:15px;margin-bottom:15px">
<%
	String user = (String)session.getAttribute("emp");
	if(user==null)
		response.sendRedirect("dashlog.jsp");	
	ArrayList arraylist = new ArrayList();
	try{			
		arraylist = (ArrayList)request.getAttribute("result");																							
	}catch(Exception e){
		e.printStackTrace();
	}
	for(int i = 0;i < arraylist.size();i++){
%>
		<p><%=(String)arraylist.get(i)%></p>
<%} %>
</div>
</div>
</body>
</html>