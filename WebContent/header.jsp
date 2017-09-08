<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="headerdiv">
<!-- left part -->
	<div style="float:left;width:35%;height:100%;">
		<div style="float:left;width:35%">
		  	<a href="main.jsp"><img class="logostyle" src="images/fablog.gif" width="150" height="45"/></a>
		 </div>
		 <div style="margin-top:20px;float:left;width:65%;">
		  	<a style="color:#303030;margin-left:20px;" class="navcont" href="advance.jsp">Advanced</a>
			<a style="color:#303030" class="navcont" href="classified.jsp">Classified</a>
		 </div>
	</div>



<!-- right part -->
  <div style="float:left;width:65%;height:100%;">

  
	  <div style="float:right;width:10%;">
		  <a href="shopcart.jsp"><img class="cartlogostyle" src="images/cart11.png" width="30" height="30" /></a>
	  </div>
	  <div style="float:right;margin-right:2%">
			<%
				String user = (String)session.getAttribute("user");
				if(user == null){
			%>
				<a class="userstyle" href="login.jsp">Sign In</a>
			<%
				}else{
					%>
				<a class="userstyle" href="SignOut">Hi! <%=user%></a>
					<% 
				}
			%>
		</div>
			
		
	<div style="float:right;margin-right:5%;">
  		<div class="searchbarstyle">
			<form>
			<span><input id= "search" name="search" type="text" class="searchbox" onkeyup="searchsuggest();" autocomplete="off" value="Search the movie by any keyword" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}"></span>
			<span><input type="button" value="Go" class="searchbutt" onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';" onclick="return search1();"></span>
			</form>
		</div>
		<div class="suggestdiv">
			<div class="suggestboxshow" id="suggest" style="display:none"></div>
		</div>
	</div>
	
</div>	






<script language="javascript" type="text/javascript">

	var AjaxRequest;   
	function searchsuggest() {  
		AjaxRequest = getAjaxRequest();   
		AjaxRequest.onreadystatechange = processAjaxReuqest;  
		var str = document.getElementById("search").value;
		AjaxRequest.open("GET", "suggestservlet?key="+str, true);  
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
	
    function processAjaxReuqest() {
		if (AjaxRequest.readyState == 4 && AjaxRequest.status == 200) {  
			var show = document.getElementById("suggest");  
			show.innerHTML = "";  
			var str = AjaxRequest.responseText.split(",");  
			var suggest = "";  
			if (str.length > 0 && str[0].length > 0) { 
				for (i = 0; i < str.length; i++) {  
					suggest += "<div onclick='javascript:setsearch(this.innerHTML);' onmouseout='javascript:suggestout(this);' onmouseover='javascript:suggestover(this);' class='suggest_link'>";  
					suggest += str[i] + "</div>";  
				}  
				show.innerHTML = suggest;  
				document.getElementById("suggest").style.display = "block";  
			}  
			else {  
				document.getElementById("suggest").style.display = "none";  
			}  
		}  
	}
	
	
    function suggestover(label) {  
        label.className = "suggest_link_over";  
    } 

 
    function suggestout(label) {  
        label.className = "suggest_link";  
    }
   
	function setsearch(value) {  
		document.getElementById("search").value = value;  
		document.getElementById("suggest").innerHTML = "";  
		document.getElementById("suggest").style.display = "none";  
	} 
	
	function search1(){
		window.location.href="ClassifyMovies?keyword="+document.getElementById("search").value+"&model=13&pagesize=8&pagenow=1&aod=tasc";		
	}
</script>


</div>



