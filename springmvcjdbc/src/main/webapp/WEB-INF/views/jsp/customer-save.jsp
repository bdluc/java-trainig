<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<title>Helo Spring MVC + JDBC</title>
</head>
<body>
  <a href="<c:url value="/customer-list" />" >List Customer</a><br />
  <h1>Add new Customer:</h1>
  <c:url value="/saveCustomer" var="saveCustomer"/>
  <form:form action="${saveCustomer}" method="POST"
    modelAttribute="customer">
      Name: <form:input path="name" /> <br/> <br/>
      Address: <form:input path="address" /> <br/> <br/>
    <button type="submit">Submit</button>
  </form:form>
</body>
