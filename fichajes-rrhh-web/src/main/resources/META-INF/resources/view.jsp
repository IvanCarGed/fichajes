<%@ include file="/init.jsp" %>

<p class="d-flex justify-content-around">
	<h1 class="text-center">Busqueda de Fichajes</h1>
</p>
<div class="d-flex justify-content-around">
	<div class="col-6">
		<portlet:actionURL name="buscarUsuario" var="buscarUsuarioURL" />
		<aui:form action="${buscarUsuarioURL}">
			<aui:input name="nombreUsuario" type="text" label="Buscar Fichajes de un usuario" />
			<aui:button name="buscarUsuarioButton" type="submit" value="Buscar" cssClass="d-flex mx-auto btn-success"/>
		</aui:form>
	</div>
	<div class="col-6">
		<portlet:actionURL name="buscarMes" var="buscarMesURL" />
		<aui:form action="${buscarMesURL}">
			<aui:select name="mes" id="mes" label="Buscar fichajes de un mes:">
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
</div>
