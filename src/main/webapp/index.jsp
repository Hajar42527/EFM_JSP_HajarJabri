<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${empty param.direct}">
		<c:redirect url="/do/All"></c:redirect>
	</c:when>

	<c:when test="${param.direct eq 'goAdd'}">
		<c:redirect url="/do/goAdd" />
	</c:when>
	<c:when test="${param.direct eq 'delete'}">
		<c:redirect url="/do/delete?id=${ param.id}" />
	</c:when>
</c:choose>