/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 10-Oct.-2019 13:43:12 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS Empleados CASCADE
;

/* Create Tables */

CREATE TABLE Empleados
(
	EmpleadoCodigo char(8) NOT NULL,
	EmpleadoNombre varchar(90) NOT NULL,
	EmpleadoDNI char(8) NOT NULL,
	EmpleadoDireccion varchar(150) NOT NULL,
	EmpleadoTelefono integer NOT NULL,
	EmpleadoFechaNacimiento date NOT NULL,
	EmpleadoEstadoCivil char(1) NOT NULL,
	EmpleadoGradoAcademico varchar(50) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE Empleados ADD CONSTRAINT EmpleadoCodigoPK
	PRIMARY KEY (EmpleadoCodigo)
;

ALTER TABLE Empleados ADD CONSTRAINT EmpleadoEstadoCivilCK CHECK (EmpleadoEstadoCivil = 'C' or EmpleadoEstadoCivil = 'S' OR EmpleadoEstadoCivil = 'D' OR EmpleadoEstadoCivil = 'V')
;

ALTER TABLE Empleados ADD CONSTRAINT EmpleadoCodigoCK CHECK (EmpleadoCodigo LIKE 'TR-[0-9][0-9][0-9][0-9][0-9]')
;
