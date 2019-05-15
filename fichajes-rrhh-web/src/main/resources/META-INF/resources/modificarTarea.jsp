<%@ include file="/init.jsp" %>

<p class="d-flex justify-content-around">
	<h1 class="text-center">Modificar Tarea</h1>
</p>


<portlet:actionURL name="modificarTarea" var="modificarTareaURL" />

<aui:form action="${modificarTareaURL}">
	<aui:input name="tareaId" type="hidden" value="${tarea.tareaId }"/>
	<aui:select name="userId" id="userId" label="Usuario:">
		<c:forEach var="usuario" items="${usuarios}">
			<c:choose>
				<c:when test = "${usuario.userId == tarea.userId}">
        			<aui:option value="${tarea.userId }" selected="true">${tarea.userName }</aui:option>
         		</c:when>
         		<c:otherwise>
         			<aui:option value="${usuario.userId }">${usuario.firstName }</aui:option>
         		</c:otherwise>
         	</c:choose>
         </c:forEach>
    </aui:select>
    
    <aui:select name="tipoTareaId" id="tipoTareaId" label="Tipo de Tarea:">
		<c:forEach var="tipoTarea" items="${tiposTarea}">
			<c:choose>
				<c:when test = "${tipoTarea.tipoTareaId == tarea.tareaId}">
        			<aui:option value="${tarea.tipoTarea }" selected="true">${tipoTarea.nombre }</aui:option>
         		</c:when>
         		<c:otherwise>
         			<aui:option value="${tarea.tipoTarea }">${tipoTarea.nombre }</aui:option>
         		</c:otherwise>
         	</c:choose>
         </c:forEach>
    </aui:select>

	<aui:input name="fechaInicio" type="date" label="Fecha de Inicio:" value="${fechaInicio }" />
	<aui:input name="horaInicio" type="text" label="Hora de Inicio:" value="${horaInicio }" />
	<aui:input name="fechaFin" type="date" label="Fecha de Finalización:" value="${fechaFin }" />
	<aui:input name="horaFin" type="text" label="Hora de Finalización:" value="${horaFin }" />
	<aui:input name="latitdud" type="number" label="Latitud:" value="${tarea.latitud }" />
	<aui:input name="longitud" type="number" label="Longitud:" value="${tarea.longitud }" />
	
	<aui:button name="modificarTareaButton" type="submit" value="Enviar" cssClass="d-flex mx-auto btn-success"/>
</aui:form>
