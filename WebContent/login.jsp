<%@ page language="java" import="com.proj2.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix - Sign In</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" /> 
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>

<body>

<!-- this is the logo -->
<center><a href="main.jsp"><img src="images\fablog.gif" alt="Fabfilx Log" width="300" height="100"  style="margin-left:-10px;margin-top:30px;margin-bottom:10px"/></a></center>
<!-- logo ends -->	
	
	
<!-- this is login form div -->
	<div class="logindiv">
 		<div class="loginform">
 		<br />
			<p><font face="arial" size="35px">Sign In</font><p>
 			<% 
 				int errcode = 0;
 				try{
 					errcode = Integer.parseInt((String)request.getAttribute("err"));
 				}catch(Exception e){
 					e.printStackTrace();
 				}
 				if(errcode == 1){
 			%>
 			<div class="loginerr">
 				<div class="loginerrtext">
 				<font size=3 face="arial" color="white">Sorry, you may enter a wrong password. Please try again or <a style="color:blue" href="forgot.jsp">find your password</a>.</font>
 				</div>
 			</div>
 			<%}else if(errcode == 2){%>
 			<div class="loginerr">
 				<div class="loginerrtext">
 				<font size=3 face="arial" color="white">Sorry, we can't find an account with this email address. Please try again or <a style="color:blue" href="signup.jsp">create a new account</a>.</font>
 				</div>
 			</div>
 			<%}else if(errcode == 3){%>
 			<div class="loginerr2">
				<div class="loginerrtext">
				<font size=3 face="arial" color="white">reCaptcha Error</font>
				</div>
			</div>
			<%}else{	}%>
			<form name="form1" action="SignInProcess" method="post">
				<p style="line-height:0px;"><font color="gray" face="arial">Email</font></p>
				<input type="text" name="user" id="user" class="textinput"/>
				<p style="line-height:2px;"><font color="gray" face="arial">Password</font></p>
				<input type="password" name="pswd" id="pswd" class="textinput"/>
				<br />
				<br />
				<a style="color:blue" href="forgot.jsp"><font size=3 face="arial">Forgot your email or password?</font></a>
				<br />
				<br />
				<input type="submit" value="Sign In" class="loginbutt" onclick="return check();" onmouseover="this.style.backgroundColor='red';" onmouseout="this.style.backgroundColor='';"/>
				<br />
				<br />
				<div class="g-recaptcha" data-sitekey="<%=MyConstants.SITE_KEY%>"></div>
				<br />
				<input type="checkbox" name="remember" style="width:30px;height:30px;vertical-align:middle"><font size=3 face="arial">  Remember me</font>
				<br />
				<hr>
				<br />
				<font size=4 face="arial">New to Fabfilx? <a style="color:blue" href="signup.jsp">Sign up now</a>!</font>
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
	<br />
<!-- login form ends -->


<!-- this is tail -->
<jsp:include page="tail.jsp"></jsp:include>
<!-- tail ends -->
	
</body>
</html>