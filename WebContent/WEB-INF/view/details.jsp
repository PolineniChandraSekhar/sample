<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validate(){
	var mail= document.getElementById("email");
	var addr=document.getElementById("address");
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if(email.value.match(emailExp)){
		if(address.value.length!=0){
			return true;
		}
		else{
			alert("Please Enter Your Address");
			return false;
		}
	}
	else{
		alert("Please Enter a valid email id");
		return false;
	}
}
</script>
<title>Insert title here</title>
</head>
<body>
<c:url var="storevalue" value="detailsSaved.html"/>
<form:form action="${storevalue}" methodParam="post" modelAttribute="userDetails" onsubmit="return validate()">
<table border=2>
<tr><td align="center">${uname}</td></tr>
<tr><td align="center">${password}</td></tr>
<tr><td><form:label path="email">Email Id</form:label></td>
<td><form:input  path="email"/></td>
</tr>
<tr><td><form:label path="address">Address</form:label></td>
<td><form:input  path="address"/></td>
</tr>
<tr><td><input type="submit" name="Save"></td></tr>
</table>
</form:form>
</body>
</html>