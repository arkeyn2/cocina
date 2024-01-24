INSERT INTO rol (rol_nombre) VALUES ('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_SECRETARIA');

INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('admin', 'a@a.a','admin' ,'admin' , '$2a$10$g1NiG2AiQpTxg/a8HkvB.ObqopcO1QCk76jywtelrv17BMpulR4F2', '123456');
	
INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('secretaria', 's@s.s', 'secretaria', 'secretaria', '$2a$10$uNq0xm359UvjKgS4L0Ad5umETvBYtCNFysqokAkisxOCUGC7XsDri', '1234569');
	
INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('trabajador', 'u@u.u', 'trabajador', 'trabajador','$2a$10$GrxgW1ydycwaoNGdMWrykulnU8w90ay2oS/p4G60mkMx3hbJRlNfC', '98765432');

INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (1, 1);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (2, 3);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (3, 2);

INSERT INTO public.plato(detalle,estado,nombre)VALUES ('vejetariana','activo','Fajita');
INSERT INTO public.plato(detalle,estado,nombre)VALUES ('blanco','activo','Arroz');
INSERT INTO public.plato(detalle,estado,nombre)VALUES ('con carne','activo','Fetuchini');
INSERT INTO public.plato(detalle,estado,nombre)VALUES ('asado','activo','Pollo');
INSERT INTO public.plato(detalle,estado,nombre)VALUES ('al plato','activo','Humita');
INSERT INTO public.plato(detalle,estado,nombre)VALUES ('al horno','activo','Pastel de papa');