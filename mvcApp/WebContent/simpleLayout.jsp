<%@ taglib uri="http://tiles.apache.org/tags-tiles" 
prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> <tiles:getAsString name="title"/> </title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<tiles:insertAttribute name="header"/>
</div> <hr/>
<div class="row">
<tiles:insertAttribute name="contents"/>
</div> <hr/>
<div class="row">
<tiles:insertAttribute name="footer"/>
</div> 
</div>
</body>
</html>