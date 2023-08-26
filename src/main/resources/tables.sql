use MONEYTRANSFER;

CREATE TABLE agencias (
                          agencia_id			INTEGER			PRIMARY KEY			AUTO_INCREMENT,
                          agencia_latitud		DECIMAL(65,30)	NOT NULL,
                          agencia_longitud	DECIMAL(65,30)	NOT NULL,
                          agencia_titulo		VARCHAR(50)		NOT NULL,
                          agencia_telefono	VARCHAR(10)		NULL,
                          agencia_direccion	VARCHAR(200)	NOT NULL
);

create table monedas(
                        moneda_id			integer			primary key			auto_increment,
                        moneda_nombre		varchar(50)		not null,
                        moneda_simbolo		varchar(10)		not null
);

create table paises(
                       pais_id				integer			primary key			auto_increment,
                       pais_nombre			varchar(100)	not null,
                       pais_moneda_id		integer			not null			references monedas(moneda_id),
                       pais_imagen			varchar(250)	null
);

create table pais_monedas(
                             paismoneda_id			integer			primary key			auto_increment,
                             paismoneda_pais_id		integer			not null			references paises(pais_id),
                             paismoneda_moneda_id	integer			not null			references monedas(moneda_id)
);

create table tipo_cambios(
                             tipocambio_id					integer				primary key			auto_increment,
                             tipocambio_moneda_id			integer				not null			references paises(pais_id),
                             tipocambio_moneda_destino_id	integer				not null			references paises(pais_id),
                             tipocambio_cambio				decimal(65,30)		not null
);

insert into agencias(agencia_latitud, agencia_longitud, agencia_titulo, agencia_telefono, agencia_direccion)
VALUES(-12.0652008, -0.390801517, 'titulo 1', '96586586', 'san vicente');

insert into monedas(moneda_nombre, moneda_simbolo) VALUES('Euro', '€');
insert into monedas(moneda_nombre, moneda_simbolo) VALUES('Peso Colombiano', 'COP');

insert into paises(pais_nombre, pais_moneda_id) VALUES('España', 1);
insert into paises(pais_nombre, pais_moneda_id) VALUES('Colombia', 2);


insert into tipo_cambios(tipocambio_moneda_id, tipocambio_moneda_destino_id, tipocambio_cambio)
VALUES(1, 2, 4455.03399)

    insert into tipo_cambios(tipocambio_moneda_id, tipocambio_moneda_destino_id, tipocambio_cambio)
VALUES(2, 1, 0.00022)