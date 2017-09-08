<%@ page language="java" import="java.util.*,com.proj2.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix - Movie</title>
<link type="text/css" rel="stylesheet" href="jQ\css\carousel.css">
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<!-- this is the header -->

<jsp:include page="header.jsp"></jsp:include>

<!-- header ends -->

<!-- this is one movie -->
<%
	ArrayList arraylist = new ArrayList();
	try{
		arraylist = (ArrayList)request.getAttribute("resultset");		

	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("main.jsp");
	}
	starsgenres sg = new starsgenres();
	movieData md = (movieData)arraylist.get(0);
	
	%>
	<div class="onemovie">
	<p style="color:black;font-size:22px;">Movie Details:</p>
		<div class="moviel"><img height="440px" width="280px" src="<%=md.getBanner_url()%>" alt="<%=md.getTitle()%> Banner">
		<center><br /><input type="button" value="Add to Cart" class="cart"  onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';" onclick="window.open('cart?id=<%=md.getMovieid()%>&title=<%=md.getTitle()%>');"></center></div>
		<div class="movier"><table style="color:black">
			<tr><td>Name:</td><td><%=md.getTitle() %></td></tr>
			<tr><td>ID:</td><td><%=md.getMovieid() %></td></tr>
			<tr><td>Year:</td><td><a href="ClassifyMovies?keyword=<%=md.getYear()%>&model=10&pagesize=8&pagenow=1&aod=tasc"><%=md.getYear() %></a></td></tr>
			<tr><td>Director:</td><td><a href="ClassifyMovies?keyword=<%=md.getDirector()%>&model=9&pagesize=8&pagenow=1&aod=tasc"><%=md.getDirector()%></a></td></tr>		
			<tr>
			<td>Genres:</td>
			<td>
			<%
				ArrayList al2 = sg.getGenres(md.getMovieid());
				for(int j = 0;j < al2.size();j++){
					genrename gn = (genrename)al2.get(j);
					%>
					<a href="ClassifyMovies?keyword=<%=gn.getGenre()%>&model=11&pagesize=8&pagenow=1&aod=tasc"><%=gn.getGenre()%></a>&nbsp
					<%
				}
			%>
			</td>
			</tr>
			<tr>
			<td>Trailer</td>
			<td><a href="<%=md.getTrailer_url()%>"><%=md.getTrailer_url() %></a></td>
			</tr>
						<tr>
			<td>Stars:</td>
			<td>
			<%
				ArrayList al1 = sg.getStars(md.getMovieid());
			%><div style="width:700px;height:300px"><%
				for(int j = 0;j < al1.size();j++){
					starname sn = (starname)al1.get(j);
					if(j%5==0&&j!=0){
						%>
						</div><div style="width:700px;height:280px">
						<%
					}
					%>
					<div style="width:20%;height:280px;float:left">
					<a href="ShowOneStar?starid=<%=sn.getStarid()%>"><img width="95%" src="<%=sn.getPhoto()%>"></a>
					<center><p style="font-size:12px;"><%=sn.getFirst()%>&nbsp<%=sn.getLast()%></p></center>
					</div>
					<%
				}
			%>
			</div>
			</td>
			</tr>
			
		</table></div>
	</div>
	<br /><br />
<!-- one movie ends -->

</body>
</html>