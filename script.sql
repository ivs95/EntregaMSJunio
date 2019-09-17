CREATE TABLE cliente(
ID int NOT NULL unique AUTO_INCREMENT ,
DNI varchar(9) unique ,
Nombre varchar(30),
Telefono integer(9),
Activo integer,
PRIMARY KEY (ID)
);


create table modelos(
ID int not null unique AUTO_INCREMENT,
Nombre varchar (100) unique,
precio float,
activo int,
tipo varchar (5),
extra int,
stock int,
PRIMARY KEY (ID)
);

create table ventas(
ID int NOT NULL UNIQUE AUTO_INCREMENT,
precioTotal float ,
fecha Date,
idCliente int,
activo int,
PRIMARY KEY (ID),
CONSTRAINT FOREIGN KEY (idCliente) REFERENCES cliente(id) ON DELETE CASCADE
);

create table lineaVenta(
idArticulo int,
idVenta int, 
cantidad int, 
precioTotal float,
constraint FOREIGN KEY (idArticulo) REFERENCES modelos(ID) ON DELETE CASCADE,
constraint FOREIGN KEY (idVenta) REFERENCES ventas(ID) ON DELETE CASCADE
);
