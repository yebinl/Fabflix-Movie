<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabfilx - AdvanceSearch</title>
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

<!-- this is advance form -->
<div class="logindiv">
<div class="loginform">
<br />
	<form action="ClassifyMovies?model=15&pagesize=8&pagenow=1&aod=tasc&keyword=search" method="post" name=form1>
	<p><font face="arial" style="line-height:-5px;" size=6>Adcance Search</font><p>
		<p style="line-height:0px;"><font color="gray" face="arial">Title</font></p>
		<input type="text" class="textinput" name="title" id="title"/>
		<p style="line-height:0px;"><font color="gray" face="arial">Year</font></p>
		<input type="text" class="textinput" name="year" id="year"/>
		<p style="line-height:0px;"><font color="gray" face="arial">Director</font></p>
		<input type="text" class="textinput" name="director" id="director"/>
		<p style="line-height:0px;"><font color="gray" face="arial">Star name</font></p>
		<input type="text" class="textinput" name="starname" id="starname"/>
		<br />
		<br />
		<br />
		<input type="submit" value="Go!" class="loginbutt" onclick="" onmouseover="this.style.backgroundColor='red';" onmouseout="this.style.backgroundColor='';"/>
		<br />
		<br />
		<br />
		<br />
	</form>
</div>
</div>
<!-- advance form ends-->

<!-- this is tail -->
<jsp:include page="tail.jsp"></jsp:include>
<!-- tail ends -->

</body>
</html>