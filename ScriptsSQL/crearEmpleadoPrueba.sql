select * from empleados;

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
	   'Profesional'
);

SELECT empleadocodigo,
	empleadonombre,
	empleadodni,
	empleadodireccion,
	empleadotelefono,
	empleadofechanacimiento,
	empleadoestadocivil,
	empleadogradoacademico
FROM empleados
WHERE empleadodni = '74061892';