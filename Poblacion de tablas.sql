-- Contenido para la base de datos - poblando base de datos
-- Insertar Roles, no alcanzan los 5 ejemplos dado que solo nos piden 3 roles 
INSERT INTO ROL(NombreRol)
VALUES ('Cliente'),
('Pyme'),
('Admin');

--Insertar usuarios
INSERT INTO USUARIO(NombreUsuario,Correo,Contraseña,IdRol) 
VALUES ('Ricardo Flores', 'RFlores@gmail.com', '123RF', 1),
('Aurora Dominguez', 'Aurora.Dominguez@gmail.com', 'Auro2435Domi', 3),
('Leonardo Fuentes', 'LeoFuentes@gmail.com', 'FuentesL6752', 2),
('Manuel Toro', 'ToroM@gmail.com', 'ToroM1654', 1),
('Marco Solis', 'MSolis20@gmail.com', '123Marco567', 2),
('Nicolás Bustos', 'NicoB@gmail.com', 'Contraseña123', 2);

-- Insertar Permisos
INSERT INTO PERMISO(NombrePermiso, DescripcionPermiso)
VALUES ('Comprar','Permite al usuario poder comprar un producto en la plataforma web'),
('Publicar','Permite al usuario poder publicar un producto a la venta en la plataforma web'),
('Borrar Usuario','Permite eliminar un usuario de la plataforma web'),
('Actualizar Datos Usuario','Permite actualizar los datos de otro usuario'),
('Actualizar Datos Producto Propio','Permite actualizar la información de un producto publicado por este usuario'),
('Borrar Producto','Permite eliminar una producto publicado por un usuario PYME'),
('Borrar Producto Propio','Permite eliminar uno de los productos asignados a este usuario'),
('Agregar Categoria','Permite añadir una categoria de producto la cual puede ser asignada a un producto en venta'),
('Eliminar Categoria','Permite eliminar una categoria de product'),
('Leer Informacion Clientes','Permite acceder a informacion de clientes y PYMES normalmente oculta. Mas especificamente los carritos de compras, listas de deseos y boletas de compra'),
('Dejar Valoracion','Permite dejar una valoracion de un producto');

-- Insertar ROL_PERMISO (Tabla intermedia)
INSERT INTO ROL_PERMISO(IdRol, IdPermiso)
VALUES(3,3),
(3,4),
(3,6),
(3,8),
(3,9),
(3,10),
(2,2),
(2,5),
(2,7),
(1,1),
(1,11);

-- Insertar Ubicaciones
INSERT INTO UBICACION(Region, Comuna, Calle, Numero, IdUsuario)
VALUES('Metropolitana', 'Renca', 'Puente de Angamos', 1599, 1),
( 'Los Lagos', 'Frutillar', 'Las Chauras', 33, 2),
( 'Tarapacá', 'Iquique', 'José Joaquín Pérez',1044, 3),
( 'Valparaíso', 'Cartagena', 'Serrano', 416, 4),
( 'Maule', 'Curicó', 'Nicaragua', 1168, 5),
( 'Maule', 'Curicó', 'Sofía', 2849, 6);

-- Insertar Listas de Deseos
INSERT INTO LISTA_DESEOS(IdUsuario)
VALUES(1),
(2),
(3),
(4),
(5),
(6);

-- Insertar Productos
INSERT INTO PRODUCTO(NombreProducto, DescripcionProducto, TipoProducto, Stock, Precio, UrlProducto)
VALUES('Velador café', 'Mueble pequeño situado generalmente junto a la cama', 'Mueble', 23, 45000, 'http://veladorcafe'),
('Cuadro La Noche Estrellada', 'Pintura hecha al óleo por el pintor Van Gogh, marco de madera', 'Decoración', 10, 73990, 'http://cuadrolanocheestrellada'),
('Microondas 3000', 'Electrodoméstico diseñado para calentar y cocinar alimentos rápidamente', 'Producto electrónico', 122, 60000, 'http://microondas3000pro'),
('Poncho tejido', 'Prenda elaborada con lana de oveja hecha a mano', 'Vestimenta', 68, 35000, 'http://ponchotejidoamano'),
('Spray antipulgas', 'Producto químico diseñado para eliminar y prevenir la infestación de pulgas en animales domésticos', 'Producto cuidado de mascotas', 8, 20000, 'http://sprayantipulgas');
 
-- Insertar LISTA_DESEOS_PRODUCTO (Tabla intermedia)
INSERT INTO LISTA_DESEOS_PRODUCTO(IdListaDeseos, IdProducto)
VALUES(1,5),
(1,2),
(2,2),
(3,1),
(5,3),
(4,1),
(3,4);

-- Insertar Categorías de productos
INSERT INTO CATEGORIA_PRODUCTO(NombreCategoriaProducto, DescripcionCategoriaProducto)
VALUES('Hogar y Muebles', 'Productos para decorar el hogar'),
('Mueble', 'Artículo para decoración y guardar objetos portatil'),
('Decoración', 'Artículo enfocado en decorar el hogar'),
('Mascotas', 'Productos para mascotas'),
('Producto cuidado de mascotas', 'Artículo enfocado en el cuidado de salud, físico y/o estético de una mascota'),
('Accesorios para vehículos', 'Productos útiles para vehículos'),
('Moda','Productos relacionados con vestimenta'),
('Vestimenta','Artículo enfocado en cubrir el cuerpo'),
('Computadores y Electrónica', 'Productos electrónicos'),
('Producto electrónico','Artículo electrónico');

-- Insertar PRODUCTO_CATEGORIAPRODUCTO (Tabla intermedia)
INSERT INTO PRODUCTO_CATEGORIAPRODUCTO(IdProducto, IdCategoriaProducto)
VALUES(1,2),
(2,3),
(3,10),
(4,8),
(5,5);

-- Insertar Carros de compras
INSERT INTO CARRO_DE_COMPRAS(IdUsuario)
VALUES(1),
(2),
(3),
(4),
(5),
(6);

-- Insertar PRODUCTO_CARRODECOMPRAS (Tabla intermedia)
INSERT INTO PRODUCTO_CARRODECOMPRAS(IdProducto, IdCarro)
VALUES(1,3),
(5,5),
(1,4),
(4,2),
(3,1);

-- Insertar Medios de pago
INSERT INTO MEDIO_DE_PAGO(NombreMedioPago, DescripcionMedioPago)
VALUES('Débito', 'Tarjeta para realizar pagos dependiendo del saldo de la cuenta'),
('Crédito', 'Tarjeta para realizar pagos los cuales pueden realizarse en cuotas'),
('Transferencia', 'Mediante un rut asignado se realiza una transferencia de dinero a la cuenta de la página que se está comprando'),
('GiftCard', 'Tarjeta de regalo para cargar cierto saldo a tu cuenta de la pagina web'),
('Junaeb', 'Medio de pago por  el cual solo se pueden comprar alimentos');

-- Insertar Boletas de compra
INSERT INTO BOLETA_DE_COMPRA(FechaBoleta, MontoBoleta, IdCarro, IdMedioPago)
VALUES('2021-05-01', 45000, 3, 1),
('2024-07-22', 95000, 1, 2),
('2023-10-31', 20000, 5, 3),
('2020-03-02', 73990, 4, 1),
('2022-12-15', 233990, 2, 2);

--Insertar USUARIO_PUBLICA_PRODUCTO (Tabla intermedia)
INSERT INTO USUARIO_PUBLICA_PRODUCTO(IdProducto, IdUsuario)
VALUES(1,5),
(2,6),
(4,6),
(5,5),
(3,3);

-- Insertar USUARIO_VALORA_PRODUCTO (Tabla intermedia)
-- El atributo valoracion es un entero entre 1 y 10 
INSERT INTO USUARIO_VALORA_PRODUCTO(IdUsuario, IdProducto, Valoracion)
VALUES(1,4,5),
(3,2,3),
(4,5,10),
(5,1,7),
(2,3,1);