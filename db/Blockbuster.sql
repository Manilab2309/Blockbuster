-- Tabla de status de películas en el almacen
CREATE TABLE status(
	idStatus int 				NOT NULL,
	status_store VARCHAR(20)	NOT NULL,
	last_updated TIMESTAMP		NOT NULL,
	PRIMARY KEY (idStatus)
);

-- Tabla de géneros de películas
CREATE TABLE genders(
	idGender int  	NOT NULL,
	gender VARCHAR(40) 			NOT NULL,
	last_updated TIMESTAMP		NOT NULL,
	PRIMARY KEY (idGender)
);


CREATE TABLE films (
	idFilm int 					NOT NULL,
	title 		VARCHAR(100)	NOT NULL,
	status_film int				NOT NULL,
	gender_film int			 	NOT NULL,
	duration 	int,
	director 	VARCHAR(50),
	price_rent 	DECIMAL(5,2)	NOT NULL,
	price_sell 	DECIMAL(5,2)	NOT NULL,
	last_updated TIMESTAMP 		NOT NULL,
	PRIMARY KEY (idFilm, title, status_film),
	FOREIGN KEY (status_film) REFERENCES status(idStatus),
	FOREIGN KEY (gender_film) REFERENCES genders(idGender)
);



