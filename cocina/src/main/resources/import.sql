INSERT INTO rol (rol_nombre) VALUES ('ROLE_ADMIN'), ('ROLE_SECRETARIA'), ('ROLE_USER');

INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('admin', 'a@a.a','admin' ,'admin' , '$2a$10$g1NiG2AiQpTxg/a8HkvB.ObqopcO1QCk76jywtelrv17BMpulR4F2', '123456');
INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('trabajador', 'u@u.u', 'trabajador', 'trabajador','$2a$10$3qeSO2i0Z4bcVM.ey0R1U.b9bqnoQys0VPJmGMRlA56FaMAjxIVXa', '98765432');	
INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('user', 's@s.s', 'user', 'user', '$2a$10$H7JVREJUNernaPQ7ruDbpeWjXqv.K2a0oninIjJJzAL3sFWfEGw3O', '1234569');
	

INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (1, 1);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (2, 2);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (3, 3);


INSERT INTO public.plato(calorias, nombrebodega,detalle, estado,foto,miseplace ,nombre, observaciones, preparacion, punto_critico)VALUES ( 120,'bodega1','ARROZ CON LECHE','activo','0dccfe2b-d443-422c-bd83-fdb0d566ccf5_arroz_con_leche_800x800.webp','Sanitizar empaque primario de arroz, leche, azúcar, canela y esencia.' ,'ARROZ CON LECHE','OBSERVACIONES', 'Poner en una olla 150 cc de agua y llevar a ebullición. Agregar el arroz con leche, dejar cocinar durante 20 a 25 minutos sin dejar de revolver, ya cocinado el arroz, apagar fuego y dejar que baje la temperatura.Una vez templado, porciona en pocillos desechables y agrega coco rallado en el centro. ', 'PUNTOS CRÍTICOS *Controlar tiempo de cocción de preparación.*Montar en porciones individuales, esperar reducción de temperatura y mover a equipo de frio. ');
INSERT INTO public.plato(calorias, nombrebodega,detalle, estado,foto,miseplace ,nombre, observaciones, preparacion, punto_critico)VALUES ( 450,'bodega2','BIFE DE VACUNO CON ENSALADA ','activo','e2b0d297-6bac-4cda-ae1e-19f5e54edb3d_bife-con-ensalada-riquisima-foto-principal.jpg','Sanitizar verduras y envases primarios.Cortar vegetales (betarraga,lechuga y repollo) en juliana y chiffonade. Retirar exceso de tallos en brócoli y coliflor. Cortar vacuno en porciones tipo bife.' ,'REGIMEN HIPOCALÓRICO ','En montaje de platos asegurar que verduras cocidas tengan una temperatura menor a 5°C.En el caso del bife, montaje rápido en contenedores isotérmicos para no perder temperatura, utilizar horno mantenedor en caso de ser necesario. (T°>65°C).', 'En una olla blanquear, con una pizca de sal, durante 5 minutos el brócoli, coliflor y mix primavera, luego de transcurrido el tiempo enfriar con agua corriendo. En un sartén con aceite se incorpora el corte de vacuno con condimentos y sellar 5 minutos por lado, verificar temperatura interna (>65°C). Montar contenedor con cama de lechuga y repollo, por un lado la betarraga, primavera y crucíferas. ', '*Cuidar cadenas de frio en proteínas, <5°c en proteína cruda. *Respetar tiempos de cocción de proteínas y controlar temperatura de cocción, >75°C en centro del alimento. *Contaminación cruzada en productos crudos/cocidos y vegetales/cárnicos, respetar colores de tablas de cortar.');
INSERT INTO public.plato(calorias,nombrebodega, detalle, estado,foto,miseplace ,nombre, observaciones, preparacion, punto_critico)VALUES ( 35,'bodega3','ENSALADA 3 COLORES N°1  ','activo','a6fb89ed-4f58-425b-b121-ff92b663d410_receta-de-vinagreta-ensalada-de-col-y-zanahoria.jpg','Sanitizar verduras y cortar en corte juliana (zanahoria y repollo) y rodajas (pepino). Refrigerar. ' ,'ENSALADA  ','Montaje debe ser rápido para no perder temperatura de verduras. ', 'Verificar que los cortes de las verduras cumplan con lo establecido, montar en contenedores isotérmicos y refrigerar inmediatamente.   ', '*Controlar tiempo de sanitizado según producto utilizado. *Utilizar tablas verdes para mise en place.  *Supervisar temperatura de área y de equipos de frio. ');
INSERT INTO public.plato(calorias,nombrebodega, detalle, estado,foto,miseplace ,nombre, observaciones, preparacion, punto_critico)VALUES ( 35,'bodega4','ENSALADA 3 COLORES N°1  ','activo','a6fb89ed-4f58-425b-b121-ff92b663d410_receta-de-vinagreta-ensalada-de-col-y-zanahoria.jpg','Sanitizar verduras y cortar en corte juliana (zanahoria y repollo) y rodajas (pepino). Refrigerar. ' ,'FAJITA  ','Montaje debe ser rápido para no perder temperatura de verduras. ', 'Verificar que los cortes de las verduras cumplan con lo establecido, montar en contenedores isotérmicos y refrigerar inmediatamente.   ', '*Controlar tiempo de sanitizado según producto utilizado. *Utilizar tablas verdes para mise en place.  *Supervisar temperatura de área y de equipos de frio. ');

INSERT INTO public.tipo(nombre)VALUES ('ACEITES DE OLIVA');
INSERT INTO public.tipo(nombre)VALUES ('ACEITES ESPECIALES');
INSERT INTO public.tipo(nombre)VALUES ('ACEITES VEGETALES');
INSERT INTO public.tipo(nombre)VALUES ('ACETOS BALSAMICOS');
INSERT INTO public.tipo(nombre)VALUES ('VINAGRES');
INSERT INTO public.tipo(nombre)VALUES ('ACEITUNAS');
INSERT INTO public.tipo(nombre)VALUES ('ENCURTIDOS');
INSERT INTO public.tipo(nombre)VALUES ('ARROZ');
INSERT INTO public.tipo(nombre)VALUES ('AZUCAR Y ENDULZANTES');
INSERT INTO public.tipo(nombre)VALUES ('CEREALES');
INSERT INTO public.tipo(nombre)VALUES ('DULCES Y CHOCOLATES');
INSERT INTO public.tipo(nombre)VALUES ('HUEVOS');
INSERT INTO public.tipo(nombre)VALUES ('LEGUMBRES');
INSERT INTO public.tipo(nombre)VALUES ('MERMELADAS Y DULCES');
INSERT INTO public.tipo(nombre)VALUES ('MINI PORCIONES');
INSERT INTO public.tipo(nombre)VALUES ('OTROS');
INSERT INTO public.tipo(nombre)VALUES ('PASTAS');
INSERT INTO public.tipo(nombre)VALUES ('SOPAS Y CREMAS');
INSERT INTO public.tipo(nombre)VALUES ('SAL ');
INSERT INTO public.tipo(nombre)VALUES ('HELADOS');
INSERT INTO public.tipo(nombre)VALUES ('TORTILLAS DE MAIZ');
INSERT INTO public.tipo(nombre)VALUES ('PAPAS BASTON');
INSERT INTO public.tipo(nombre)VALUES ('PASTAS');
INSERT INTO public.tipo(nombre)VALUES ('FRUTAS');
INSERT INTO public.tipo(nombre)VALUES ('GUARNICIONES LISTAS');
INSERT INTO public.tipo(nombre)VALUES ('JUGOS Y PULPAS');
INSERT INTO public.tipo(nombre)VALUES ('MEZCLAS ESPECIALES');
INSERT INTO public.tipo(nombre)VALUES ('VERDURAS');
INSERT INTO public.tipo(nombre)VALUES ('TOCINOS');
INSERT INTO public.tipo(nombre)VALUES ('FRUTAS');
INSERT INTO public.tipo(nombre)VALUES ('VERDURAS');
INSERT INTO public.tipo(nombre)VALUES ('	LOMO	');
INSERT INTO public.tipo(nombre)VALUES ('	PORCIONADOS	');
INSERT INTO public.tipo(nombre)VALUES ('	PULPAS	');
INSERT INTO public.tipo(nombre)VALUES ('	ELABORADOS CERDO	');
INSERT INTO public.tipo(nombre)VALUES ('	ELABORADOS POLLO	');
INSERT INTO public.tipo(nombre)VALUES ('	ELABORADOS VACUNO	');
INSERT INTO public.tipo(nombre)VALUES ('	HAMBURGUESAS CERTIFICADAS	');
INSERT INTO public.tipo(nombre)VALUES ('	HAMBURGUESAS PREMIUM	');
INSERT INTO public.tipo(nombre)VALUES ('	CARNES CERTIFICADAS	');
INSERT INTO public.tipo(nombre)VALUES ('	SUBPRODUCTOS	');
INSERT INTO public.tipo(nombre)VALUES ('	PECHUGAS PAVO	');
INSERT INTO public.tipo(nombre)VALUES ('	ENTERO	');
INSERT INTO public.tipo(nombre)VALUES ('	PECHUGAS POLLO	');
INSERT INTO public.tipo(nombre)VALUES ('	FILETILLOS	');
INSERT INTO public.tipo(nombre)VALUES ('	TRUTROS	');
INSERT INTO public.tipo(nombre)VALUES ('	CAMARONES	');
INSERT INTO public.tipo(nombre)VALUES ('	MARISCOS Y MOLUSCOS	');
INSERT INTO public.tipo(nombre)VALUES ('	PESCADOS	');
INSERT INTO public.tipo(nombre)VALUES ('	PESCADOS EN CONSERVA	');
INSERT INTO public.tipo(nombre)VALUES ('	BOLLERIA Y MASAS DULCES	');
INSERT INTO public.tipo(nombre)VALUES ('	CREMAS	');
INSERT INTO public.tipo(nombre)VALUES ('	HARINAS Y SEMOLA	');
INSERT INTO public.tipo(nombre)VALUES ('	HELADOS	');
INSERT INTO public.tipo(nombre)VALUES ('	INGREDIENTES REPOSTERIA	');
INSERT INTO public.tipo(nombre)VALUES ('	MERMELADAS Y DULCES	');
INSERT INTO public.tipo(nombre)VALUES ('	MANJAR Y DULCE DE LECHE	');
INSERT INTO public.tipo(nombre)VALUES ('	PANES PRE HORNEADOS	');
INSERT INTO public.tipo(nombre)VALUES ('	PANES LISTOS PARA COMER	');
INSERT INTO public.tipo(nombre)VALUES ('	POSTRES EN POLVO	');
INSERT INTO public.tipo(nombre)VALUES ('	SALSAS Y TOPPINGS	');
INSERT INTO public.tipo(nombre)VALUES ('	KETCHUP	');
INSERT INTO public.tipo(nombre)VALUES ('	MAYONESA	');
INSERT INTO public.tipo(nombre)VALUES ('	MINI PORCIONES	');
INSERT INTO public.tipo(nombre)VALUES ('	MOSTAZAS	');
INSERT INTO public.tipo(nombre)VALUES ('	SALSAS DE AJI	');
INSERT INTO public.tipo(nombre)VALUES ('	SALSAS DE SOYA	');
INSERT INTO public.tipo(nombre)VALUES ('	SALSAS DE TOMATE	');
INSERT INTO public.tipo(nombre)VALUES ('	SALSAS ESPECIALES	');
INSERT INTO public.tipo(nombre)VALUES ('	SUCEDANEOS DE LIMON	');
INSERT INTO public.tipo(nombre)VALUES ('	FRUTOS SECOS	');
INSERT INTO public.tipo(nombre)VALUES ('	DESECHABLES	');
INSERT INTO public.tipo(nombre)VALUES ('	PRODUCTOS TISSUE	');
INSERT INTO public.tipo(nombre)VALUES ('	CAFÉ GRANO ENTERO	');
INSERT INTO public.tipo(nombre)VALUES ('	CAFES SOLUBLES	');
INSERT INTO public.tipo(nombre)VALUES ('	TE Y OTRAS BEBIDAS CALIENTES	');
INSERT INTO public.tipo(nombre)VALUES ('	LECHES	');
INSERT INTO public.tipo(nombre)VALUES ('	AGUAS	');
INSERT INTO public.tipo(nombre)VALUES ('	BEBIDAS GASEOSAS	');
INSERT INTO public.tipo(nombre)VALUES ('	JUGOS	');
INSERT INTO public.tipo(nombre)VALUES ('	MAYONESAS	');
INSERT INTO public.tipo(nombre)VALUES ('	BEBIDAS VEGETALES	');
INSERT INTO public.tipo(nombre)VALUES ('	HAMBURGUESAS   	');
INSERT INTO public.tipo(nombre)VALUES ('	CARNES VEGETALES	');
INSERT INTO public.tipo(nombre)VALUES ('	QUESOS SEMI DUROS	');
INSERT INTO public.tipo(nombre)VALUES ('	HELADOS	');
INSERT INTO public.tipo(nombre)VALUES ('	MANJAR Y DULCE DE LECHE	');
INSERT INTO public.tipo(nombre)VALUES ('	ESPECIAS 	');
INSERT INTO public.tipo(nombre)VALUES ('	CALDOS	');
INSERT INTO public.tipo(nombre)VALUES ('	SEMILLAS	');
INSERT INTO public.tipo(nombre)VALUES ('	MANTEQUILLA Y MARGARINA	');
INSERT INTO public.tipo(nombre)VALUES ('	QUESOS SEMI DUROS	');

INSERT INTO public.bodega( nombre)	VALUES ( 'bodega1');
INSERT INTO public.bodega(nombre)	VALUES ( 'bodega2');
INSERT INTO public.bodega(nombre)	VALUES ( 'bodega3');
INSERT INTO public.bodega(nombre)	VALUES ( 'bodega4');
INSERT INTO public.bodega(nombre)	VALUES ( 'bodega5');
INSERT INTO public.bodega(nombre)	VALUES ( 'bodega6');

INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,2000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,2600,9);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,3);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,5000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,6000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,2000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,2600,9);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,3);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,5000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,6000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);
INSERT INTO public.stock(cantidad,stock_critico,stock_inicial)VALUES (10000,1000,8);

INSERT INTO public.movimiento_stock(factura ,entrada,fecha, salida,stock_id)VALUES(365898, 0,'05-03-2024',0,1);
INSERT INTO public.movimiento_stock(factura ,entrada,fecha, salida,stock_id)VALUES(325698, 0,'05-03-2024',0,2);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'06-03-2024',0,3);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'07-03-2024',0,4);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'08-03-2024',0,5);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'09-03-2024',0,6);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'03-03-2024',0,7);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'03-03-2024',0,8);
INSERT INTO public.movimiento_stock(factura ,entrada,fecha, salida,stock_id)VALUES(365898, 0,'05-03-2024',0,9);
INSERT INTO public.movimiento_stock(factura ,entrada,fecha, salida,stock_id)VALUES(325698, 0,'05-03-2024',0,10);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'06-03-2024',0,11);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'07-03-2024',0,12);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'08-03-2024',0,13);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'09-03-2024',0,14);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'03-03-2024',0,15);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'03-03-2024',0,16);
INSERT INTO public.movimiento_stock(factura, entrada,fecha, salida,stock_id)VALUES(325698, 0,'03-03-2024',0,17);

INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	150000855	','	1ACETO BALSAMICO EDRA 500 CC	','	Unidad	','	SECO	','45000',1,	4);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514810	','	1ACEITE MARAVILLA 5 L	','	Unidad	','	SECO	','45900',2,	3	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514820	','	1ACEITE OLIVA OLITALIA 5 L	','	Unidad	','	SECO	','45900',3,	1	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104521630	','	1ACEITE OLIVA 5 L	','	Unidad	','	SECO	','21000',4,	1);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104512230	','	1ACEITE OLIVA E/VIRGEN OLITALIA 5 L	','	Unidad	','	SECO	','50000',5,	1);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	150000845	','	1ACEITE OLIVA E/VIRGEN ZAYTA 5 L	','	Unidad	','	SECO	','45000',6,	1);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514880	','1ACEITE SESAMO MAYAMOTO 500 ML','	Unidad	','	SECO	','45900',7,	2	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514840	','	1ACEITE SPRAY 481 G','	Unidad	','	SECO	','45900',8,	2	);

INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	150000855	','	2ACETO BALSAMICO EDRA 500 CC	','	Unidad	','	SECO	','45000',9,	4);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514810	','	2ACEITE MARAVILLA 5 L	','	Unidad	','	SECO	','45900',10,	3	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514820	','	2ACEITE OLIVA OLITALIA 5 L	','	Unidad	','	SECO	','45900',11,	1	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104521630	','	2ACEITE OLIVA 5 L	','	Unidad	','	SECO	','21000',12,	1);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104512230	','	2ACEITE OLIVA E/VIRGEN OLITALIA 5 L	','	Unidad	','	SECO	','50000',13,	1);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	150000845	','	2ACEITE OLIVA E/VIRGEN ZAYTA 5 L	','	Unidad	','	SECO	','45000',14,	1);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514880	','2ACEITE SESAMO MAYAMOTO 500 ML','	Unidad	','	SECO	','45900',15,	2	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514840	','	2ACEITE SPRAY 481 G','	Unidad	','	SECO	','45900',16,	2	);
INSERT INTO public.insumo(codigo,descripcion,descripcion_umv,temperatura,precio_unidad,movimiento_stock_id,tipo_id)VALUES ('	104514840	','	2ACEITE SPRAY 481 G','	Unidad	','	SECO	','45900',16,	2	);

INSERT INTO public.preparacion(fecha,stock_necesario, tiempo_preparacion, insumo_id, plato_id, usuario_id)	VALUES ('2024-03-12',200, 20, 1, 1,1);
INSERT INTO public.preparacion(fecha,stock_necesario, tiempo_preparacion, insumo_id, plato_id, usuario_id)	VALUES ('2024-03-12',200, 10, 2, 1,1);

INSERT INTO public.preparacion(fecha,stock_necesario, tiempo_preparacion, insumo_id, plato_id, usuario_id)	VALUES ('2024-03-12',200, 10, 3, 2,1);
INSERT INTO public.preparacion(fecha,stock_necesario, tiempo_preparacion, insumo_id, plato_id, usuario_id)	VALUES ('2024-03-12',200, 10, 4, 2,1);
INSERT INTO public.preparacion(fecha,stock_necesario, tiempo_preparacion, insumo_id, plato_id, usuario_id)	VALUES ('2024-03-12',100, 10, 6, 4,1);
INSERT INTO public.preparacion(fecha,stock_necesario, tiempo_preparacion, insumo_id, plato_id, usuario_id)	VALUES ('2024-03-12',100, 10, 7, 4,1);

INSERT INTO public.usuario_bodega(usuario_id, bodiga_id)VALUES(1,1)
INSERT INTO public.usuario_bodega(usuario_id, bodiga_id)VALUES(2,2)
INSERT INTO public.usuario_bodega(usuario_id, bodiga_id)VALUES(3,3)
INSERT INTO public.usuario_bodega(usuario_id, bodiga_id)VALUES(1,4)

INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(1,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(2,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(3,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(4,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(5,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(6,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(7,1)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(8,1)

INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(9,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(10,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(11,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(12,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(13,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(14,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(15,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(16,4)
INSERT INTO public.insumo_bodega(insumo_id, bodiga_id)VALUES(17,2)
INSERT INTO public.minuta(bodega, cantidad_plato, fecha, nombre, plato_id)VALUES('bodega1',2,'2024-04-29','ARROZ CON LECHE',1);
INSERT INTO public.minuta(bodega, cantidad_plato, fecha, nombre, plato_id)VALUES('bodega1',3,'2024-04-30','ARROZ CON LECHE',1);
INSERT INTO public.minuta(bodega, cantidad_plato, fecha, nombre, plato_id)VALUES('bodega2',2,'2024-05-01','ARROZ CON LECHE',1);
INSERT INTO public.minuta(bodega, cantidad_plato, fecha, nombre, plato_id)VALUES('bodega3',4,'2024-05-01','ARROZ CON LECHE',1);
INSERT INTO public.minuta(bodega, cantidad_plato, fecha, nombre, plato_id)VALUES('bodega4',3,'2024-05-03','ARROZ CON LECHE',1);