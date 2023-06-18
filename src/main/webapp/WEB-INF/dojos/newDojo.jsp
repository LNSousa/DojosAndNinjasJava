<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">		
		<h1>New Dojo</h1>
		<form:form action="/dojos/new" method="post" modelAttribute="newDojo" style="width:50%;">
			<div class="my-3">
		        <form:label path="name" class="form-label">Name</form:label><br/>
		        <form:errors path="name" style="color:red"/>
		        <form:input type="text" class="form-control" path="name"/>
		    </div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>