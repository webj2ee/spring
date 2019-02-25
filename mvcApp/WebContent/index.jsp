<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> MVC App </title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<jsp:include page="header.jsp"/>
</div> <hr/>
<div class="row">
<h3>Existing user login</h3>
<jsp:include page="loginForm.jsp" />
<a href="regForm.spring">New User Signup</a>
</div> <hr/>
<div class="row">
<jsp:include page="footer.jsp"/>
</div> 
</div>
</body>
</html>


