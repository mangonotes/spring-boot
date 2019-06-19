<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/handlebars.runtime-v4.1.2.js"></script>
<script type="text/javascript" src="js/templates.js"></script>
<script type="text/javascript" src="js/system.js"></script>
</head>
<body>
<div id="content-placeholder"></div>
<script>
fetchData.call(context,  '/product/catalog',"catalogue", "content-placeholder");
</script>
</body>
</html>