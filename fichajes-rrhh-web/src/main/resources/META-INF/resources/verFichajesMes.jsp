<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="${!empty tareas}">
		<div class="d-flex justify-content-center text-center my-5 mx-auto col-8">
			<div class="col-12">
				<h1 class="text-center">Estos son los fichajes del mes</h1>
				<table class="table table-hover text-center my-5">
					<thead>
						<tr>
							<th scope="col">Hora de Inicio</th>
							<th scope="col">Hora de Finalización</th>
							<th scope="col">Tipo de Tarea</th>
							<th scope="col">Empleado</th>
							<th scope="col">Ver Detalles</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tarea" items="${tareas}">
							<tr>
								<td>
									<c:choose>
										<c:when test="${tarea.horaInicio.minutes lt 10 }">
											<c:choose>
												<c:when test="${tarea.horaInicio.hours lt 10 }">
													0${tarea.horaInicio.hours} : 0${tarea.horaInicio.minutes} - ${tarea.horaInicio.date}/${tarea.horaInicio.month}
												</c:when>
												<c:otherwise>
													${tarea.horaInicio.hours} : 0${tarea.horaInicio.minutes} - ${tarea.horaInicio.date}/${tarea.horaInicio.month}
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											${tarea.horaInicio.hours} : ${tarea.horaInicio.minutes} - ${tarea.horaInicio.date}/${tarea.horaInicio.month}
										</c:otherwise>
									</c:choose>	 
								</td>
										
								<td>
									<c:choose>
										<c:when test="${tarea.horaFin.minutes lt 10 }">
											<c:choose>
												<c:when test="${tarea.horaFin.hours lt 10 }">
													0${tarea.horaFin.hours} : 0${tarea.horaFin.minutes} - ${tarea.horaFin.date}/${tarea.horaFin.month}
												</c:when>
												<c:otherwise>
													${tarea.horaFin.hours} : 0${tarea.horaFin.minutes} - ${tarea.horaFin.date}/${tarea.horaFin.month}
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											${tarea.horaFin.hours} : ${tarea.horaFin.minutes} - ${tarea.horaFin.date}/${tarea.horaFin.month}
										</c:otherwise>
									</c:choose>	 
								</td>
								<td>
									<c:forEach var = "tipo" items="${tiposTarea}">
        								 <c:if test = "${tarea.tipoTarea == tipo.tipoTareaId}">
         									${tipo.nombre }
      									</c:if>
     							 	</c:forEach>
     							</td>
     							<td>${tarea.userName }</td>
								<td><portlet:renderURL var="jspVerDetalle">
										<portlet:param name="mvcRenderCommandName" value="/verDetalleTarea" />
										<portlet:param name="tareaId" value="${tarea.tareaId}" />
									</portlet:renderURL> <a class="col-4" href="${jspVerDetalle}">Detalles</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:when>
</c:choose>
		