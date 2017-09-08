<%@ page language="java" import="java.util.*,com.proj2.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabfilx - Cart</title>
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

<!-- this is cart -->
<div class="cartdiv">
	<center><h3>Shopping Cart</h3></center>
	<%
	ArrayList al = new ArrayList();
	al=(ArrayList)session.getAttribute("cart");
	double totalvalue = 0.00;
	if(al==null){
		%><center><p>No Record</p></center><%
	}else{
		%>
		<center><table style="color:black;text-align:left;">
		<tr><td>MovieID</td><td>Movie Title</td><td>Qty</td><td>Price</td><td></td><td></td></tr>
		<%
		for(int i=0;i<al.size();i++){
			cartData cd = new cartData();
			cd=(cartData)al.get(i);
		%>
			<tr><td><a style="color:black" href="ShowOneMovie?movieid=<%=cd.getMovieid()%>"><%=cd.getMovieid()%>&nbsp&nbsp</a></td>
			<td><a style="color:black" href="ShowOneMovie?movieid=<%=cd.getMovieid()%>"><%=cd.getMovie()%>&nbsp&nbsp</a></td>
			<td><input style="width:35px" type="text" id="num<%=i%>" value=<%=cd.getNumber()%>>&nbsp&nbsp</td>
			<td>$<%=9.99*cd.getNumber()%>&nbsp&nbsp</td>
			<td><input type="button" value="update" onclick="return checkup(<%=cd.getMovieid()%>,<%=i%>);"></td>
			<td><input type="button" value="remove" onclick="window.location.href='CartChange?cod=d&id=<%=cd.getMovieid()%>'"></td></tr>
			<%
			totalvalue = totalvalue + 9.99*cd.getNumber();
		}
		%></table></center><%
	}
	%><br /><br /><center><h5>Total price is: </h5><h3>$<%=totalvalue%></h3></center>
	<%
	al=(ArrayList)session.getAttribute("cart");
	if(al!=null){%>
	<center>
	<input type="button" value="Check Out" class="checkoutbut" onclick="window.location.href='checko.jsp'" onmouseover="this.style.backgroundColor='#4a4a4a';" onmouseout="this.style.backgroundColor='';"/>
	</center>
	<%}%>
	</div>
	<script language="javascript">
		function checkup(id,i){
			if(document.getElementById("num"+i).value==""){
				window.alert("Quantity cannot be empty");
				return false;
			}else if(isNaN(document.getElementById("num"+i).value)){
				window.alert("Quantity can only be numbers");
				return false;
			}else{
				window.location.href="CartChange?cod=c&num="+document.getElementById("num"+i).value+"&id="+id;
			}		
		}
	</script>
<!-- cart ends -->

</body>
</html>