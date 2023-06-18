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
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="newNinja" style="width:50%;">
			<form:select path="dojo">
				<c:forEach var="dojo" items="${ dojos }"> 			
					<form:option value="${ dojo.id }"><c:out value="${ dojo.name }"></c:out></form:option>
				</c:forEach>
			</form:select>
			<div class="my-3">
		        <form:label path="firstName" class="form-label">First Name</form:label><br/>
		        <form:errors path="firstName" style="color:red"/>
		        <form:input type="text" class="form-control" path="firstName"/>
		    </div>
			<div class="my-3">
		        <form:label path="lastName" class="form-label">Last Name</form:label><br/>
		        <form:errors path="lastName" style="color:red"/>
		        <form:input type="text" class="form-control" path="lastName"/>
		    </div>
			<div class="my-3">
		        <form:label path="age" class="form-label">Age</form:label><br/>
		        <form:errors path="age" style="color:red"/>
		        <form:input type="text" class="form-control" path="age"/>
		    </div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>