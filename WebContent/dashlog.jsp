<%@ page language="java" import="com.proj2.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DashBoard</title>
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" />
<link rel="stylesheet" type="text/css" href="style.css">
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<br />
<br />
	<div class="logindiv">
 		<div class="loginform">
 		<br />
 			<% 
 				int errcode = 0;
 				try{
 					errcode = Integer.parseInt((String)request.getAttribute("err"));
 				}catch(Exception e){
 					e.printStackTrace();
 				}
 				if(errcode == 1){
 			%>
 			<br />
 			<div class="loginerr2">
				<div class="loginerrtext">
				<font size=3 face="arial" color="white">No such e-mail</font>
				</div>
			</div>
 			<%}else if(errcode == 2){%>
 			<br />
 			<div class="loginerr2">
				<div class="loginerrtext">
				<font size=3 face="arial" color="white">Wrong password</font>
				</div>
			</div>
 			<%}else if(errcode == 3){%>
 			<div class="loginerr2">
				<div class="loginerrtext">
				<font size=3 face="arial" color="white">reCaptcha Error</font>
				</div>
			</div>
			<%}else{	}%>
			<form name="form1" action="SignInEmployee" method="post">
				<p style="line-height:0px;"><font color="gray" face="arial">Email</font></p>
				<input type="text" name="user" id="user" class="textinput"/>
				<p style="line-height:2px;"><font color="gray" face="arial">Password</font></p>
				<input type="password" name="pswd" id="pswd" class="textinput"/>
				<br />
				<br />
				<input type="submit" value="Sign In" class="loginbutt" onclick="return check();" onmouseover="this.style.backgroundColor='red';" onmouseout="this.style.backgroundColor='';"/>
				<br />
				<br />
				<div class="g-recaptcha" data-sitekey="<%=MyConstants.SITE_KEY%>"></div>
				
			</form>
			<br /><br />
			<script language="javascript">
				function check(){
					if(form1.user.value==""){
						window.alert("Email cannot be empty");
						document.getElementById("user").className="textalert";
						document.getElementById("pswd").className="textinput";
						return false;
					}
					if(form1.pswd.value==""){
						window.alert("Password cannot be empty");
						document.getElementById("pswd").className="textalert";
						document.getElementById("user").className="textinput";
						return false;
					}
				}
			</script>
		</div>
	</div>
</body>
</html>