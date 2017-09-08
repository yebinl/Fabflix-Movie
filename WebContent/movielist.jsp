<%@ page language="java" import="java.util.*,java.sql.*,com.proj2.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix - Movies</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="shortcut icon" type="image/x-icon" href="images\icon2.gif" media="screen" />
<link type="text/css" rel="stylesheet" href="jQ\css\carousel.css">
</head>

<body>

<!-- this is the header -->
<div>
<jsp:include page="header.jsp"></jsp:include>
</div>
<!-- header ends -->

<!-- this is movie list -->
<%
		int model = 1;
		String key="";
		int pagesize = 5;
		int pagenow = 1;
		int pagenum = 1;
		String aod = "tasc";
		ArrayList arraylist = new ArrayList();
		try{
			arraylist = (ArrayList)request.getAttribute("resultset");		
			model = Integer.parseInt((String)request.getAttribute("model"));
			key = (String)request.getAttribute("keyword");
			pagesize = Integer.parseInt((String)request.getAttribute("pagesize"));
			pagenow = Integer.parseInt((String)request.getAttribute("pagenow"));
			pagenum = Integer.parseInt((String)request.getAttribute("pagenum"));
			aod = (String)request.getAttribute("aod");
			if(pagenow<=0)
				pagenow=1;																					
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("main.jsp");
		}
		
		%>
		<div class="sorttool">
			<div style="float:right;margin-right:0px;">
			<br />
			<%if(aod.equals("asc")) {%>
				<a href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=asc">Year<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=desc">Year<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tasc">Title<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tdesc">Title<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<%}else if(aod.equals("desc")) {%>
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=asc">Year<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=desc">Year<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tasc">Title<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tdesc">Title<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<%}else if(aod.equals("tasc")) {%>
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=asc">Year<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=desc">Year<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp
				<a href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tasc">Title<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tdesc">Title<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<%}else if(aod.equals("tdesc")) {%>
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=asc">Year<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=desc">Year<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp
				<a style="color:black" href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tasc">Title<img width=15px height=15px  src="images\up.png"></a>&nbsp&nbsp&nbsp
				<a href="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=tdesc">Title<img width=15px height=15px  src="images\down.png"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<%} %>
			<br />
			</div>

		</div>	
		<br />			
		<div style="width:1200px;height:550px;margin:0 auto">
		<%		
		starsgenres sg = new starsgenres();		
		for(int i = 0;i < arraylist.size();i++){
			movieData md = (movieData)arraylist.get(i);
			if(i%4==0&&i!=0){
	%>
			</div><div style="width:1200px;height:600px;margin:0 auto">
	<%} %>
	
	
		<div id="<%=i%>" style="width:25%;float:left" ><a href="ShowOneMovie?movieid=<%=md.getMovieid()%>"><img width=280px src="<%=md.getBanner_url()%>" alt="<%=md.getTitle()%> Banner" onmouseover='javascript:pop("<%=md.getMovieid()%>","pop<%=i%>");' onmouseout='javascript:popout("pop<%=i%>");'></a>
		<div id="pop<%=i%>" class="pop"></div>
		<center>
		<p><%=md.getTitle()%>(<%=md.getYear()%>)</p>
		<input type="button" value="Add to Cart" class="cart"  onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';" onclick="window.open('cart?id=<%=md.getMovieid()%>&title=<%=md.getTitle()%>');">
		</center>
		</div>
	
	
	
	<%} %></div>
	<div class="pages">
	<p>There are <a href="ClassifyMovies?pagenow=<%=pagenum%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><%=pagenum %></a> pages</p>
	<%
	if(pagenow>1){
	%>
		<a href="ClassifyMovies?pagenow=<%=pagenow-1%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><img height="15px" width="15px" src="images\l.png"></a>
	<% 
	}
	if(pagenum<=7){
		for(int i=1;i<=pagenum;i++){
			if(i==pagenow){
				%>
				<a href="ClassifyMovies?pagenow=<%=i%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" style="background-color:#d00000" type="button" value="<%=i%>"></a>
				<%
			}else{
				%>
				<a href="ClassifyMovies?pagenow=<%=i%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" type="button" value="<%=i%>"></a>
				<%
			}
				
		}
	}else{
		if((pagenow-1)<3){
			for(int i=1;i<=7;i++){
				if(i==pagenow){
					%>
					<a href="ClassifyMovies?pagenow=<%=i%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" style="background-color:#d00000" type="button" value="<%=i%>"></a>
					<%
				}else{
					%>
					<a href="ClassifyMovies?pagenow=<%=i%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" type="button" value="<%=i%>"></a>
					<%
				}
			}
		}else if((pagenum-pagenow)<3){
			for(int i=7;i>=1;i--){
				if((pagenum-i+1)==pagenow){
				%>
				<a href="ClassifyMovies?pagenow=<%=pagenum-i+1%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" style="background-color:#d00000" type="button" value="<%=pagenum-i+1%>"></a>
				<%
				}else{
				%>
					<a href="ClassifyMovies?pagenow=<%=pagenum-i+1%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" type="button" value="<%=pagenum-i+1%>"></a>
				<%}
			}
		}else{
			for(int i=1;i<=7;i++){
				if((i+pagenow-4)==pagenow){
				%>
				<a href="ClassifyMovies?pagenow=<%=i+pagenow-4%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" style="background-color:#d00000" type="button" value="<%=i+pagenow-4%>"></a>
				<%}else{
					%>
					<a href="ClassifyMovies?pagenow=<%=i+pagenow-4%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><input class="pagenumbut" type="button" value="<%=i+pagenow-4%>"></a>
					<%
				}
			}
		}
	}
	if(pagenow<pagenum && pagenow>0){
	%>
		<a href="ClassifyMovies?pagenow=<%=pagenow+1%>&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><img height="15px" width="15px" src="images\r.png"></a>
	<% 
	}%>
	</div>
	<center >
		<font color="#303030">show
		<select name="pageselect" id="pageselect" onchange="window.location=this.value;">
			<option value="ClassifyMovies?pagenow=1&pagesize=<%=pagesize%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>" selected><%=pagesize %></option>
			<%
			for(int k=5;k<=30;k++){
			%> 
	  		<option value="ClassifyMovies?pagenow=1&pagesize=<%=k%>&model=<%=model%>&keyword=<%=key%>&aod=<%=aod%>"><%=k%></option>
	  		<%} %>
		</select>
		per page</font>
		</center>
	<input type="image" src="images\back.png" onClick="javascript:history.back(-1);" class="previousbutton">

<!-- movie list ends -->

<!-- this is tail -->
<jsp:include page="tail.jsp"></jsp:include>
<!-- tail ends -->

<script language="javascript" type="text/javascript">

	var AjaxRequest;   
	function pop(id,object) {  
		AjaxRequest = getAjaxRequest();   
		AjaxRequest.onreadystatechange =  function() {
			if (AjaxRequest.readyState == 4 && AjaxRequest.status == 200) {
				var show = document.getElementById(object);  
				show.innerHTML = "";  
				var str = AjaxRequest.responseText.split(",");  
				var poptext = "";  
				 
				poptext += "<div style='font-size:12px;line-height:14px;'><p>Title: "+str[1]+"</p>"+"<p>Year: "+str[2]+"  ID: "+str[0]+"</p>"+"<p>Director: "+str[3]+"</p>";  
				var genre = str[4].split("`");
				var star = str[5].split("`");
				poptext += "<p>Genres: ";
				for (i = 0; i < genre.length; i++) { 
					poptext += genre[i]+",";
				}
				poptext += "</p>";
				poptext += "<p>Stars: ";
				for (i = 0; i < star.length; i++) { 
					poptext += star[i]+",";
				}
				poptext += "</p></div>";
				
				show.innerHTML = poptext;   
			}  
		}  
		document.getElementById(object).style.display="block";
		AjaxRequest.open("GET", "moviepop?id="+id, true);  
		AjaxRequest.send(null);  
	}

    function getAjaxRequest() {
		var AjaxRequest = null;  
		try{
			AjaxRequest = new XMLHttpRequest();
		} catch (e){
			try{
				AjaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try{
					AjaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e){
					alert("Your browser broke!");
					return false;
				}
			}
		}
		return AjaxRequest;  
	}
	

	
	function popover(object){
		document.getElementById(object).style.display="block";
	}
	function popout(object){
		document.getElementById(object).style.display="none";
	}
</script>

</body>
</html>