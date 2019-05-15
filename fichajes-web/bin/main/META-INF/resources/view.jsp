<%@ include file="/init.jsp" %>

<c:choose>

	<c:when test="${rol}">
		<%@ include file="/fichajes.jsp" %>
	</c:when>
	<c:otherwise>
		<h3>No eres empleado, con lo cual no te dejaremos ver esto.</h3>
	</c:otherwise>
</c:choose>
