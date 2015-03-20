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
	var uname=document.getElementById("username");
	var pwd=document.getElementById("password");
	if(uname.value.length!=0){
		if(pwd.value.length!=0){
			return true;
		        }
			else{
			    alert("Please Enter Password");
		  	    return false;
			}
	}
	else{
		alert("Please Enter UserName");
		return false;
		}
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
<c:url var="usercheck" value="details.html"/>
<form:form action="${usercheck}" method="post" modelAttribute="user" onsubmit="return validate()">
<table border=2 align="center" bgcolor="cyan">
<tr>
<td><form:label path="username">USER NAME</form:label></td>
<td><form:input  path="username"/></td>
</tr>
<tr>
<td><form:label path="password">Password</form:label></td>
<td><form:input type="password" path="password"/></td>
</tr>
<tr ><td align="center">
<input type="submit" name="submit"></td>
</tr>
</table>
</form:form>
</body>
</html>