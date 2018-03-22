-- Inicializacion de datos para genero de productos de Blockbuster
INSERT INTO genders (idGender,gender,last_updated) values (1,'SUSPENSE',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (2,'TERROR',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (3,'DRAMA',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (4,'MANGA',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (5,'BELICA',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (6,'HISTORICA',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (7,'COMEDIA',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (8,'BOLLYWOOD',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (9,'GORE',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (10,'DOCUMENTAL',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (11,'ACCION',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (12,'FANTASIA',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (13,'DEPORTES',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (14,'AVENTURAS',CURRENT_TIMESTAMP());
INSERT INTO genders (idGender,gender,last_updated) values (15,'POLICIACA',CURRENT_TIMESTAMP());

-- Inicializacion de datos para estado de productos del Blockbuster
INSERT INTO status (idStatus,status_store,last_updated) values (1,'ALQUILADO',CURRENT_TIMESTAMP());
INSERT INTO status (idStatus,status_store,last_updated) values (2,'VENDIDO',CURRENT_TIMESTAMP());
INSERT INTO status (idStatus,status_store,last_updated) values (3,'RECLAMADO',CURRENT_TIMESTAMP()); -- Lo han alquilado y no lo han devuelto
INSERT INTO status (idStatus,status_store,last_updated) values (4,'DISPONIBLE',CURRENT_TIMESTAMP());
INSERT INTO status (idStatus,status_store,last_updated) values (5,'RESERVADO',CURRENT_TIMESTAMP()); -- Está en tienda pero no lo pueden coger

-- Inicializacion de peliculas
INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (1,'TITANIC',4,3,180,'James Cameron',5.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (2,'EL SEÑOR DE LOS ANILLOS',4,12,180,'Peter Jackson',3.4,29.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (3,'INDIANA JONES',4,14,78,'Steven Spielberg',4.4,12.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (4,'STAR WARS III',4,12,144,'George Lucas',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (5,'ALIEN',4,2,99,'James Cameron',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (6,'DEPREDADOR',4,11,97,'James Cameron',4.4,15.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (7,'CONAN',2,3,190,'Arnol Werger',3.4,12.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (8,'MARGIN CALL',4,3,180,'Kevin Spacy',3.3,27.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (9,'LA ULTIMA FORTALEZA',4,3,120,'Robert Redford',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (10,'ET',4,3,180,'Steven Spielberg',2.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (11,'EL VUELO DEL NAVEGANTE',4,12,97,'Orlando Blom',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (12,'ABYSS',1,3,180,'Ed Harris',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (13,'TIN CUP',2,3,68,'Kevin Costner',1.4,33.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (14,'TRANSPORTER',4,3,1012,'Jason Sttatham',3.4,55.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (15,'MERCENARIOS',1,3,88,'Sylvester Stallone',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (16,'ACORRALADO',4,3,90,'James Cameron',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (17,'CRIMEN FERPECTO',4,3,180,'James Cameron',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (18,'LOS PAJAROS',1,3,180,'Alfred Hitchcock',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (19,'TORRENTE',1,3,180,'Santiago Segura',3.8,36.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (20,'SPIDERMAN',1,3,130,'Bill Murray',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (21,'HULK',4,3,210,'Nick Notle',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (22,'SUPERMAN',2,3,143,'Kevin Montgomery',3.5,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (23,'BLANCANIEVES',4,3,111,'Lucas Cretch',3.4,27.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (24,'LOS PITUFOS',4,3,180,'luis Dominguez',3.9,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (25,'EL ULTIMO GRAN HEROE',4,3,180,'Michael Phoenix',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (26,'COMANDO',1,3,98,'Arnold Wayne',4.2,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (27,'SALVAR AL SOLDADO RYAN',4,5,180,'Steven Spielberg',5.4,54.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (28,'FURY',3,5,145,'Brad Pitt',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (29,'MONSTRUOS S.A',4,3,180,'Steve Jobs',3.4,11.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (30,'TOY STORY',1,3,125,'Steve Jobs',3.4,24.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (31,'SICARIO',3,15,165,'Guillermo del Toro',2.4,33.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (32,'LA BATALLA DE MIDWAY',4,5,115,'John Geldway',3.4,43.80,CURRENT_TIMESTAMP());

INSERT INTO films (idFilm,title,status_film,gender_film,duration,director,price_rent,price_sell,last_updated) 
values (33,'EL FUGITIVO',4,15,132,'Andy Murray',3.4,24.80,CURRENT_TIMESTAMP());

