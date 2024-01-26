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

INSERT INTO public.insumo(codigo,descripcion,estado,fecha_vencimiento,nombre)VALUES (123456,'grado1','activo','12-08-2024','arroz');
INSERT INTO public.insumo(codigo,descripcion,,estado,fecha_vencimiento,nombre)VALUES (321456,'verdura','activo','12-08-2024','tomate');
INSERT INTO public.insumo(codigo,descripcion,estado,fecha_vencimiento,nombre)VALUES (258963,'pastas','activo','12-08-2024','tallarines');
INSERT INTO public.insumo(codigo,descripcion,estado,fecha_vencimiento,nombre)VALUES (78945,'blanco','activo','12-08-2024','pan');

INSERT INTO public.stock(cantidad,entrada,salida,stock_critico,stock_inicial,insumos_id)VALUES (1000,2,2,100,8,1);
INSERT INTO public.stock(cantidad,entrada,salida,stock_critico,stock_inicial,insumos_id)VALUES (2500,3,8,1200,9,2);
INSERT INTO public.stock(cantidad,entrada,salida,stock_critico,stock_inicial,insumos_id)VALUES (3000,6,2,1000,3,3);
INSERT INTO public.stock(cantidad,entrada,salida,stock_critico,stock_inicial,insumos_id)VALUES (50,6,8,10,8,4);

INSERT INTO public.preparacion(fecha,stock_necesario,tiempo_preparacion,plato_id,stock_id,usuario_id)VALUES ('12-03-2023',100,26,1,1,1);
INSERT INTO public.preparacion(fecha,stock_necesario,tiempo_preparacion,plato_id,stock_id,usuario_id)VALUES ('10-05-2024',100,47,1,1,1);
INSERT INTO public.preparacion(fecha,stock_necesario,tiempo_preparacion,plato_id,stock_id,usuario_id)VALUES ('01-01-2024',100,1,1,1,1);
INSERT INTO public.preparacion(fecha,stock_necesario,tiempo_preparacion,plato_id,stock_id,usuario_id)VALUES ('25-12-2024',100,39,1,1,1);