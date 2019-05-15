create table Fichajes_Tarea (
	tareaId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	horaInicio DATE null,
	horaFin DATE null,
	activa BOOLEAN,
	latitud DOUBLE,
	longitud DOUBLE,
	tipoTarea LONG
);

create table Fichajes_TipoTarea (
	tipoTareaId LONG not null primary key,
	nombre VARCHAR(75) null
);