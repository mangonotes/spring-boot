<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/handlebars.runtime-v4.1.2.js"></script>
<script type="text/javascript" src="js/templates.js"></script>
</head>
<body>
<div id="content-placeholder"></div>
<script>
var template = Handlebars.templates['address-template'];
var context = ${data_json};

console.log(context);
var theCompiledHtml = template(context);
console.log(theCompiledHtml);
  // Add the compiled html to the page
document.getElementById("content-placeholder").innerHTML+= theCompiledHtml;
</script>
</body>
</html>