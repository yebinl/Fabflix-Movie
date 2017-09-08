<%@ page language="java" import="java.util.*,com.proj2.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix - Star</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link type="text/css" rel="stylesheet" href="jQ\css\carousel.css">
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" />
</head>
<body>
<!-- this is the header -->

<jsp:include page="header.jsp"></jsp:include>

<!-- header ends -->

<!-- this is one star -->
<%
	ArrayList arraylist = new ArrayList();
	try{
		arraylist = (ArrayList)request.getAttribute("resultset");	

	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("main.jsp");
	}
	starsmovie ssm = new starsmovie();
	starData sd = (starData)arraylist.get(0);
	
	%>
	<div class="onemovie">
	<p style="color:black;font-size:22px;">Star Details:</p>
		<div class="moviel"><img width="280px" src="<%=sd.getPhotourl()%>" alt="<%=sd.getFirstname()%> <%=sd.getLastname()%> photo"></div>
		<div class="movier"><table style="color:black">
			<tr><td>Name:</td><td><%=sd.getFirstname()%>&nbsp<%=sd.getLastname()%></td></tr>
			<tr><td>ID:</td><td><%=sd.getStarid() %></td></tr>
			<tr><td>Birthday:</td><td><%=sd.getDob()%></td></tr>	
			<tr>
			<td>Starred In:</td>
			<td>
			<%
				ArrayList al1 = ssm.getStarsmoive(sd.getStarid());
			%><div style="width:700px;height:300px"><%
				for(int j = 0;j < al1.size();j++){
					moviety mty = (moviety)al1.get(j);
					if(j%4==0&&j!=0){
						%>
						</div><div style="width:700px;height:280px">
						<%
					}
					%>
					<div style="width:25%;height:300px;float:left">
					<a href="ShowOneMovie?movieid=<%=mty.getMovieid()%>"><img width="95%" src="<%=mty.getBanner()%>"></a>
					<center><p style="font-size:12px;"><%= mty.getMovietitle() %>(<%=mty.getMovieyear()%>)</p></center>
					</div>
					<%
				}
			%>
			</div>
			</td>
			</tr>
			
		</table></div>
	</div>
	<!-- one star ends -->
</body>
</html>