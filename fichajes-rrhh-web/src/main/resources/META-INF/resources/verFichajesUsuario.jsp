<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="${!empty tareas}">
		<div class="d-flex justify-content-center text-center my-5 mx-auto col-8">
			<div class="col-12">
				<h1 class="text-center">Estos son los fichajes por usuario buscado</h1>
				<div class="col-6 mx-auto my-5">
					<portlet:actionURL name="buscarMesUsuario" var="buscarMesUsuarioURL" >
						<portlet:param name="userName" value="${usuario }" />
					</portlet:actionURL>
					<aui:form action="${buscarMesUsuarioURL}">
						<aui:select name="mes" id="mes" label="Filtrar por mes:">
							<aui:option selected="true" value="">Seleccione el mes</aui:option>
							<aui:option value="0">Enero</aui:option>
							<aui:option value="1">Febrero</aui:option>
							<aui:option value="2">Marzo</aui:option>
							<aui:option value="3">Abril</aui:option>
							<aui:option value="4">Mayo</aui:option>
							<aui:option value="5">Junio</aui:option>
							<aui:option value="6">Julio</aui:option>
							<aui:option value="7">Agosto</aui:option>
							<aui:option value="8">Septiembre</aui:option>
							<aui:option value="9">Octubre</aui:option>
							<aui:option value="10">Noviembre</aui:option>
							<aui:option value="11">Diciembre</aui:option>
						</aui:select>
					<aui:button name="buscarUsuarioButton" type="submit" value="Buscar" cssClass="d-flex mx-auto btn-success"/>
					</aui:form>
				</div>
				<table class="table table-hover text-center my-5">
					<thead>
						<tr>
							<th scope="col">Hora de Inicio</th>
							<th scope="col">Hora de Finalización</th>
							<th scope="col">Tipo de Tarea</th>
							<th scope="col">Usuario</th>
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
     							<td>
     								${tarea.userName }
     							</td>
								<td><portlet:renderURL var="jspVerDetalle">
										<portlet:param name="mvcRenderCommandName" value="/verDetalleTarea" />
										<portlet:param name="tareaId" value="${tarea.tareaId}" />
									</portlet:renderURL> <a class="col-4" href="${jspVerDetalle}">Detalles</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="d-flex justify-content-center text-center my-5 mx-auto col-8">
					<div class="col-12 d-flex flex-wrap">
						<h1 class="text-center col-12">Tiempo Total Trabajado</h1>
						<div class="col-6 my-3"><span class="font-weight-bold">Horas: </span>${horasTrabajadas }</div>
						<div class="col-6 my-3"><span class="font-weight-bold">Minutos: </span>${minutosTrabajados }</div>
					</div>
				</div>
				<c:choose>
					<c:when test="${!empty minutosExtra }">
						<div class="d-flex justify-content-center text-center my-5 mx-auto col-8">
							<div class="col-12 d-flex flex-wrap">
								<h1 class="text-center col-12">Estas son tus horas extra:</h1>
								<div class="col-6 my-3"><span class="font-weight-bold">Horas: </span>${horasExtra }</div>
								<div class="col-6 my-3"><span class="font-weight-bold">Minutos: </span>${minutosExtra }</div>
							</div>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</c:when>
</c:choose>