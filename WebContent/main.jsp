<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fabflix - Watch your favorite movie</title>
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


<!-- this is the ads-->	
	<div class = "caroursel poster-main" style="margin:160px auto;margin-top:30px" data-setting = '{
	        "width":1400,
            "height":410,
	        "posterWidth":1000,
	        "posterHeight":520,
	        "scale":0.6,
	        "speed":"5000",
	        "dealy":"5000",
	        "algin":"middle"
	    }'>
	        <ul class = "poster-list">
	            <li class = "poster-item"><a href="ShowOneMovie?movieid=217020" style="width:100%;height:100%"><img src="images\Alex.jpg" width = "100%" height="100%"></a></li>
	            <li class = "poster-item"><a href="ShowOneMovie?movieid=658001" style="width:100%;height:100%"><img src="images\Titan.jpg" width = "100%" height="100%"></a></li>
                <li class = "poster-item"><a href="ShowOneMovie?movieid=755010" style="width:100%;height:100%"><img src="images\Termin.png" width = "100%" height="100%"></a></li>
                <li class = "poster-item"><a href="ShowOneMovie?movieid=788012" style="width:100%;height:100%"><img src="images\almost.jpg" width = "100%" height="100%"></a></li>
                <li class = "poster-item"><a href="ShowOneMovie?movieid=755009" style="width:100%;height:100%"><img src="images\shrek.jpg" width = "100%" height="100%"></a></li>
	        </ul>	        
            <div class = "poster-btn poster-prev-btn"></div>
	        <div class = "poster-btn poster-next-btn"></div>
	    </div>			
	<script src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="jQ\js\jquery.carousel.js"></script>
    <script>
        Caroursel.init($('.caroursel'))
    </script>
<!-- ads ends-->

<br />

<!-- this is select section -->
<!-- select section ends -->


<!-- this is tail -->
<jsp:include page="tail.jsp"></jsp:include>
<!-- tail ends -->

</body>
</html>