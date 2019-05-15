<%@ include file="/init.jsp" %>

<div class="d-flex justify-content-center text-center">
	<div class="col-12">
		<c:choose>
			<c:when test="${!empty tarea}">
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th colspan="2"><h1>Detalle de la Tarea</h1></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Nombre de usuario</td>
							<td>${tarea.userName}</td>
						</tr>
						<tr>
							<td>Hora de inicio</td>
							<td>${tarea.horaInicio}</td>
						</tr>
						<tr>
							<td>Hora de finalización</td>
							<td>${tarea.horaFin}</td>
						</tr>
						<tr>
							<td>Latitud</td>
							<td>${tarea.latitud}</td>
						</tr>
						<tr>
							<td>Longitud</td>
							<td>${tarea.longitud}</td>
						</tr>
					</tbody>
				</table>
			</c:when>
		</c:choose>
		<div class="d-flex justify-content-center my-5">
			<portlet:renderURL var="jspVolver">
				<portlet:param name="mvcRenderCommandName" value="/volver" />				
			</portlet:renderURL>
			<a class="col-4 btn btn-success" href="${jspVolver}">Volver</a>
		</div>
	</div>
</div>