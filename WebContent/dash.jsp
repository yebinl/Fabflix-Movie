<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix DashBoard</title>
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" />
<link rel="stylesheet" type="text/css" href="style.css"> 
</head>

<body>
	<%
	String user = (String)session.getAttribute("emp");
	if(user==null)
		response.sendRedirect("dashlog.jsp");
	%>
	<br />
	<br />
	<div style="width:75%;height:500px;margin:0 auto">
	<div style="width:50%;height:500px;float:left">
	<center>
		<p><font face="arial" size="20px">Insert Movies</font><p>
		<form name="form2" action="DashInsert" method="post">
			<p style="line-height:0px;"><font color=black face="arial">Title</font></p>
			<input type="text" name="title" id="title" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">Year</font></p>
			<input type="text" name="year" id="year" class="dashinput"/>
			<p style="line-height:0px;"><font color=black face="arial">Director</font></p>
			<input type="text" name="dirc" id="dirc" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">BannerURL</font></p>
			<input type="text" name="banner" id="banner" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">TrailerURL</font></p>
			<input type="text" name="trailer" id="trailer" class="dashinput"/>			
			<p style="line-height:2px;"><font color=black face="arial">Star Firstname</font></p>
			<input type="text" name="fn" id="fn" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">Star Lastname</font></p>
			<input type="text" name="ln" id="ln" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">Genres</font></p>
			<input type="text" name="genres" id="genres" class="dashinput"/>
			<input type="text" name="mod" id="mod" style="display:none" value="2"/>
			<br />
			<br />
			<input type="submit" value="Insert" class="dashbutt" onclick="return check2();" onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';"/>
		</form>
	</center>
	</div>
	<div style="width:50%;height:500px;float:left">
	<center>
		<p><font face="arial" size="20px">Insert Stars</font><p>
		<form name="form1" action="DashInsert" method="post">
		<p style="line-height:0px;"><font color=black face="arial">Firstname</font></p>
			<input type="text" name="fn" id="fn" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">Lastname</font></p>
			<input type="text" name="ln" id="ln" class="dashinput"/>
			<p style="line-height:0px;"><font color=black face="arial">DoB</font></p>
			<input type="text" name="dob" id="dob" class="dashinput"/>
			<p style="line-height:2px;"><font color=black face="arial">PhotoURL</font></p>
			<input type="text" name="purl" id="purl" class="dashinput"/>
			<input type="text" name="mod" id="mod" style="display:none" value="1"/>
			<br />
			<br />
			<input type="submit" value="Insert" class="dashbutt" onclick="return check1();" onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';"/>
			<br /><br /><br /><br /><br /><br /><br />
			<input type="button" value="Metadata" class="metabutt" onclick="location.href='DashInsert?mod=3'" onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';"/>
		</form>
		</center>
	</div>
	</div>
	<script language="javascript">
				function check1(){
					if(form1.fn.value==""){
						window.alert("Firstname cannot be empty");
						return false;
					}
				}
				function check2(){
					if(form2.title.value==""){
						window.alert("Title of the movie cannot be empty");
						return false;
					}
					if(form2.year.value==""){
						window.alert("Year of the movie cannot be empty");
						return false;
					}
					if(form2.dirc.value==""){
						window.alert("Director of the movie cannot be empty");
						return false;
					}
					if(form2.fn.value==""){
						window.alert("Firstname of the star cannot be empty");
						return false;
					}
					if(form2.genres.value==""){
						window.alert("Genres of the movie cannot be empty");
						return false;
					}
				}
			</script>
</body>
</html>