/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 02-Nov.-2019 22:26:24 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Sequences for Autonumber Columns */

DROP SEQUENCE IF EXISTS afp_afpid_seq
;

DROP SEQUENCE IF EXISTS conceptos_conceptocodigo_seq
;

DROP SEQUENCE IF EXISTS contratos_contratocodigo_seq
;

/* Drop Tables */

DROP TABLE IF EXISTS AFP CASCADE
;

DROP TABLE IF EXISTS Conceptos CASCADE
;

DROP TABLE IF EXISTS Contratos CASCADE
;

DROP TABLE IF EXISTS Empleados CASCADE
;

DROP TABLE IF EXISTS Pagos CASCADE
;

DROP TABLE IF EXISTS Periodos CASCADE
;

/* Create Tables */

CREATE TABLE AFP
(
	AFPId integer NOT NULL   DEFAULT NEXTVAL(('"afp_afpid_seq"'::text)::regclass),
	AFPDescuento numeric NOT NULL,
	AFPNombre varchar(50) NOT NULL
)
;

CREATE TABLE Conceptos
(
	ConceptoCodigo integer NOT NULL   DEFAULT NEXTVAL(('"conceptos_conceptocodigo_seq"'::text)::regclass),
	montoHorasExtras numeric(10,2) NOT NULL,
	montoReintegros numeric(10,2) NOT NULL,
	montoOtrosIngresos numeric(10,2) NOT NULL,
	montoHorasAusentes numeric(10,2) NOT NULL,
	montoAdelantos numeric(10,2) NOT NULL,
	montoOtrosDescuentos numeric(10,2) NOT NULL,
	ContratoCodigo integer NULL,
	PeriodoCodigo char(8) NULL
)
;

CREATE TABLE Contratos
(
	ContratoCodigo integer NOT NULL DEFAULT NEXTVAL(('"contratos_contratocodigo_seq"'::text)::regclass),
	ContratoFechaInicio date NOT NULL,
	ContratoFechaFin date NOT NULL,
	ContratoAsignacionFamiliar char(1) NOT NULL,
	ContratoTotalHorasSemanal integer NOT NULL,
	ContratoValorHoras numeric(10,2) NOT NULL,
	ContratoCargo varchar(50) NOT NULL,
	AFPId integer NULL,
	EmpleadoCodigo char(8) NULL,
	ContratoTipo char(1) NOT NULL DEFAULT 'N'
)
;

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

CREATE TABLE Pagos
(
	PagoCodigo SERIAL NOT NULL,
	PagoAsignacionFamiliar numeric(10,2) NOT NULL,
	PagoFecha date NOT NULL,
	PagoPorcentajeAFP numeric(10,2) NOT NULL,
	PagoTotalHoras numeric(10,2) NOT NULL,
	PagoValorHoras numeric(10,2) NOT NULL,
	ContratoCodigo integer NULL,
	PeriodoCodigo char(8) NULL,
	ConceptoCodigo integer NULL
)
;

CREATE TABLE Periodos
(
	PeriodoCodigo char(8) NOT NULL,
	PeriodoFechaInicio date NOT NULL,
	PeriodoFechaFin date NOT NULL,
	PeriodoEstado char(1) NOT NULL DEFAULT 'E'
)
;


/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE AFP ADD CONSTRAINT AFPCodigoPK
	PRIMARY KEY (AFPId)
;

ALTER TABLE Conceptos ADD CONSTRAINT ConceptoCodigoPK
	PRIMARY KEY (ConceptoCodigo)
;

ALTER TABLE Contratos ADD CONSTRAINT ContratoCodigoPK
	PRIMARY KEY (ContratoCodigo)
;

ALTER TABLE Contratos ADD CONSTRAINT ContratoTipoCK CHECK (ContratoTipo = 'A' or ContratoTipo = 'N')
;

ALTER TABLE Empleados ADD CONSTRAINT EmpleadoCodigoPK
	PRIMARY KEY (EmpleadoCodigo)
;

ALTER TABLE Empleados ADD CONSTRAINT EmpleadoEstadoCivilCK CHECK (EmpleadoEstadoCivil = 'C' or EmpleadoEstadoCivil = 'S' OR EmpleadoEstadoCivil = 'D' OR EmpleadoEstadoCivil = 'V')
;

ALTER TABLE Pagos ADD CONSTRAINT PagoCodigoPK
	PRIMARY KEY (PagoCodigo)
;

ALTER TABLE Periodos ADD CONSTRAINT PeriodoCodigoPK
	PRIMARY KEY (PeriodoCodigo)
;

ALTER TABLE Periodos ADD CONSTRAINT PeriodoEstadoCK CHECK (PeriodoEstado = 'E' or PeriodoEstado = 'D')
;

/* Create Foreign Key Constraints */

ALTER TABLE Conceptos ADD CONSTRAINT ConceptoContratoCodigoFK
	FOREIGN KEY (ContratoCodigo) REFERENCES Contratos (ContratoCodigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Conceptos ADD CONSTRAINT ConceptoPeriodoCodigoFK
	FOREIGN KEY (PeriodoCodigo) REFERENCES Periodos (PeriodoCodigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Contratos ADD CONSTRAINT ContratoAFPIdFK
	FOREIGN KEY (AFPId) REFERENCES AFP (AFPId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Contratos ADD CONSTRAINT ContratoEmpleadoCodigoFK
	FOREIGN KEY (EmpleadoCodigo) REFERENCES Empleados (EmpleadoCodigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Pagos ADD CONSTRAINT PagoConceptoCodigoFK
	FOREIGN KEY (ConceptoCodigo) REFERENCES Conceptos (ConceptoCodigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Pagos ADD CONSTRAINT PagoContratoCodigoFK
	FOREIGN KEY (ContratoCodigo) REFERENCES Contratos (ContratoCodigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Pagos ADD CONSTRAINT PagoPeriodoCodigoFK
	FOREIGN KEY (PeriodoCodigo) REFERENCES Periodos (PeriodoCodigo) ON DELETE No Action ON UPDATE No Action
;

/* Create Table Comments, Sequences for Autonumber Columns */

CREATE SEQUENCE afp_afpid_seq INCREMENT 1 START 1
;

CREATE SEQUENCE conceptos_conceptocodigo_seq INCREMENT 1 START 1
;

CREATE SEQUENCE contratos_contratocodigo_seq INCREMENT 1 START 1
;

INSERT INTO 
afp
VALUES 
(1,11.44,'Capital'),
(2,11.44,'Cuprum'),
(3,11.27,'Habitat'),
(4,10.41,'PlanVital'),
(5,11.45,'ProVida'),
(6,10.77,'Modelo');

insert into empleados(
	empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico)
values('TR-00000',
	   'Kevin Piazzoli Felix Perez',
	   '74061892',
	   'Mz. 16 A. Lt. 03 Villa Rosa Porvenir',
	   '962823909',
	   '05/06/1999',
	   'S',
	   'PROFESIONAL'
);

insert into empleados(
	empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico)
values('TR-00001',
	   'Kayra Oriana Espinoza Garcia',
	   '73698921',
	   'Las Flores Mz. G Lt. 15',
	   '974287283',
	   '02/01/1998',
	   'S',
	   'BACHILLER'
);
insert into empleados(
	empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico)
values('TR-00002',
	   'Luis Felipe Cruz Isla',
	   '73451110',
	   'San Andreas 5ta Etapa c"26',
	   '986675458',
	   '24/06/1998',
	   'S',
	   'BACHILLER'
);
insert into empleados(
	empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico)
values('TR-00003',
	   'Ronald Segundo Alva Mariños',
	   '74972186',
	   'Cerro de Pasco 170 #6',
	   '949901612',
	   '09/03/1999',
	   'S',
	   'PROFESIONAL'
);
insert into empleados(
	empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico)
values('TR-00004',
	   'Jesus Femin De Paz Eras',
	   '12121212',
	   'Av 123i82 Prueba',
	   '949992122',
	   '09/08/1999',
	   'S',
	   'PROFESIONAL'
);

insert into empleados(
	empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico)
values('TR-00005',
	   'Elias Perez Kevin',
	   '12345678',
	   'Av. Larco Mz. 16 A LT 08',
	   '945352373',
	   '10/10/1990',
	   'C',
	   'DOCTOR'
);

SELECT empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico
FROM empleados;

INSERT INTO public.contratos(
	contratocodigo, 
	contratofechainicio, 
	contratofechafin, 
	contratoasignacionfamiliar, 
	contratototalhorassemanal, 
	contratovalorhoras, 
	contratocargo, 
	afpid, 
	empleadocodigo
)
VALUES (
	1, 
	'01/01/2019', 
	'01/12/2019', 
	'F', 
	40, 
	30, 
	'Administrador', 
	1, 
	'TR-00000'
);

INSERT INTO public.contratos(
	contratocodigo, 
	contratofechainicio, 
	contratofechafin, 
	contratoasignacionfamiliar, 
	contratototalhorassemanal, 
	contratovalorhoras, 
	contratocargo, 
	afpid, 
	empleadocodigo
)
VALUES (
	2, 
	'01/01/2019', 
	'01/12/2019', 
	'T', 
	8, 
	20, 
	'Gerente', 
	2, 
	'TR-00001'
);

INSERT INTO public.contratos(
	contratocodigo, 
	contratofechainicio, 
	contratofechafin, 
	contratoasignacionfamiliar, 
	contratototalhorassemanal, 
	contratovalorhoras, 
	contratocargo, 
	afpid, 
	empleadocodigo
)
VALUES (
	3, 
	'01/01/2019', 
	'01/12/2019', 
	'F', 
	40, 
	11, 
	'DBA', 
	3, 
	'TR-00002'
);

INSERT INTO public.contratos(
	contratocodigo, 
	contratofechainicio, 
	contratofechafin, 
	contratoasignacionfamiliar, 
	contratototalhorassemanal, 
	contratovalorhoras, 
	contratocargo, 
	afpid, 
	empleadocodigo
)
VALUES (
	4, 
	'01/01/2019', 
	'01/12/2019', 
	'T', 
	8, 
	21, 
	'Administrador de Redes', 
	4, 
	'TR-00003'
);

INSERT INTO public.contratos(
	contratocodigo, 
	contratofechainicio, 
	contratofechafin, 
	contratoasignacionfamiliar, 
	contratototalhorassemanal, 
	contratovalorhoras, 
	contratocargo, 
	afpid, 
	empleadocodigo
)
VALUES (
	5, 
	'01/01/2019', 
	'01/12/2019', 
	'F', 
	8, 
	40, 
	'Gerente de Software', 
	5, 
	'TR-00004'
);

select * from contratos;

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00001', 
		'2019-01-01', 
		'2019-01-31'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00002', 
		'2019-02-01', 
		'2019-02-28'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00003', 
		'2019-03-01', 
		'2019-03-31'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00004', 
		'2019-04-01', 
		'2019-04-30'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00005', 
		'2019-05-01', 
		'2019-05-31'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00006', 
		'2019-06-01', 
		'2019-06-30'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00007', 
		'2019-07-01', 
		'2019-07-31'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00008', 
		'2019-08-01', 
		'2019-08-31'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00009', 
		'2019-09-01', 
		'2019-09-30'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00010', 
		'2019-10-01', 
		'2019-10-31'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00011', 
		'2019-11-01', 
		'2019-11-30'
);

INSERT INTO public.periodos(
	periodocodigo, 
	periodofechainicio, 
	periodofechafin
)
VALUES (
		'PD-00012', 
		'2019-12-01', 
		'2019-12-31'
);

select * from periodos;

INSERT INTO public.conceptos(
	conceptocodigo, 
	montohorasextras, 
	montoreintegros, 
	montootrosingresos, 
	montohorasausentes, 
	montoadelantos, 
	montootrosdescuentos, 
	contratocodigo, 
	periodocodigo
)
VALUES (
	1, 
	10, 
	10, 
	15, 
	10, 
	15, 
	10, 
	1, 
	'PD-00001'
);

INSERT INTO public.conceptos(
	conceptocodigo, 
	montohorasextras, 
	montoreintegros, 
	montootrosingresos, 
	montohorasausentes, 
	montoadelantos, 
	montootrosdescuentos, 
	contratocodigo, 
	periodocodigo
)
VALUES (
	2, 
	10, 
	0, 
	15, 
	0, 
	15, 
	0, 
	2, 
	'PD-00001'
);

INSERT INTO public.conceptos(
	conceptocodigo, 
	montohorasextras, 
	montoreintegros, 
	montootrosingresos, 
	montohorasausentes, 
	montoadelantos, 
	montootrosdescuentos, 
	contratocodigo, 
	periodocodigo
)
VALUES (
	3, 
	10, 
	13, 
	15, 
	12, 
	15, 
	14, 
	3, 
	'PD-00001'
);

INSERT INTO public.conceptos(
	conceptocodigo, 
	montohorasextras, 
	montoreintegros, 
	montootrosingresos, 
	montohorasausentes, 
	montoadelantos, 
	montootrosdescuentos, 
	contratocodigo, 
	periodocodigo
)
VALUES (
	4, 
	8, 
	14, 
	15, 
	10, 
	15, 
	7, 
	4, 
	'PD-00001'
);

INSERT INTO public.conceptos(
	conceptocodigo, 
	montohorasextras, 
	montoreintegros, 
	montootrosingresos, 
	montohorasausentes, 
	montoadelantos, 
	montootrosdescuentos, 
	contratocodigo, 
	periodocodigo
)
VALUES (
	5, 
	0, 
	0, 
	20, 
	0, 
	0, 
	0, 
	5, 
	'PD-00001'
);

select * from conceptos;

select * from pagos;





