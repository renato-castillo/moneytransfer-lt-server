use MONEYTRANSFER;

create table agencias(
                         agencia_id			integer			primary key			auto_increment,
                         agencia_latitud		double			not null,
                         agencia_longitud	double			not null,
                         agencia_titulo		varchar(50)		not null,
                         agencia_telefono	varchar(10)		not null,
                         agencia_direccion	varchar(200)	not null
);

insert into agencias(agencia_latitud, agencia_longitud, agencia_titulo, agencia_telefono, agencia_direccion)
VALUES(-12.0652008, -77.1562112, 'titulo 1', '96586586', 'san vicente');