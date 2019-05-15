<%@ include file="/init.jsp"%>

<p class="d-flex justify-content-center">
<h1 class="text-center">Fichaje</h1>
</p>

<c:choose>
	<c:when test="${empty activo }">
		<portlet:actionURL name="nuevoFichaje" var="nuevoFichajeURL" />
		<aui:form action="${nuevoFichajeURL}">
		<aui:input name="lat" id="lat" type="hidden"/>
		<aui:input name="long" id="long" type="hidden"/>
		<aui:input name="tareaId" type="hidden" value="${tareaId }" />
			<aui:select name="tipoTarea" id="tipoTarea" label="Tipo de tarea:">
				<aui:option selected="true" value="">Seleccione la Tarea</aui:option>
				<c:forEach items="${tiposTarea}" var="tarea">
		    		<aui:option value="${tarea.tipoTareaId}" label="${tarea.nombre}"></aui:option>
		  		</c:forEach>
		</aui:select>
			<div class="d-flex justify-content-around my-5">
				<aui:button name="nuevoFichajeButton" type="submit" value="Iniciar Tarea"  cssClass="btn-success col-4"/>
				<aui:button name="cerrarFichajeButton" type="button" value="Finalizar Tarea" cssClass="btn-danger col-4" disabled="true" />
			</div>
		</aui:form>
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="finalizarFichaje" var="finalizarFichajeURL" />
		<aui:form action="${finalizarFichajeURL}">
			<aui:input name="tareaId" type="hidden" value="${tareaId }" />
			<aui:input name="tarea" type="text" label="Tipo de tarea:" value="${tareaAbierta.nombre }" readonly="true"/>
			<div class="d-flex justify-content-around my-5">
				<aui:button name="nuevoFichajeButton" type="button" value="Iniciar Tarea" cssClass="btn-success col-4"  disabled="true"/>
				<aui:button name="cerrarFichajeButton" type="submit" value="Finalizar Tarea" cssClass="btn-danger col-4" />
			</div>
		</aui:form>
	</c:otherwise>
</c:choose>

<p class="d-flex justify-content-center my-5">
	<portlet:renderURL var="jspVerFichajesEmpleado">
		<portlet:param name="mvcRenderCommandName" value="/verFichajesEmpleado" />
	</portlet:renderURL>
	<a class="btn btn-primary text-center col-4" href="${jspVerFichajesEmpleado}">Ver mis fichajes</a>
</p>

<p id="lat"></p>


<script type="text/javascript">

navigator.geolocation.getCurrentPosition(showPosition);

function showPosition(position) {
	document.getElementById("<portlet:namespace />lat").value= position.coords.latitude;
	document.getElementById("<portlet:namespace />long").value = position.coords.longitude;
}
</script>