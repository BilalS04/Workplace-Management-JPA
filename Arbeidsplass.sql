DROP SCHEMA IF EXISTS arbeidsplass CASCADE;

CREATE SCHEMA arbeidsplass;
SET search_path TO arbeidsplass;


CREATE TABLE avdeling
(
    avdeling_id SERIAL,
	navn VARCHAR(30) NOT NULL,
	CONSTRAINT avdelingPK PRIMARY KEY (avdeling_id)
);



CREATE TABLE ansatt
(
    ansatt_id SERIAL,
    brukernavn VARCHAR(4) NOT NULL UNIQUE,
    fornavn VARCHAR(30) NOT NULL,
    etternavn VARCHAR(30) NOT NULL,
    ansatt_dato DATE,
    stilling VARCHAR(30) NOT NULL,
    maanedslonn INTEGER NOT NULL,
    avdeling_id INTEGER NOT NULL,
    CONSTRAINT ansattPK PRIMARY KEY (ansatt_id),
    CONSTRAINT ansattFK FOREIGN KEY (avdeling_id) REFERENCES avdeling(avdeling_id)
);



CREATE TABLE prosjekt
(
    prosjekt_id SERIAL,
    prosjekt_navn VARCHAR(30) NOT NULL,
    beskrivelse VARCHAR(50) NOT NULL,
	CONSTRAINT prosjektPK PRIMARY KEY (prosjekt_id)
);



CREATE TABLE prosjektdeltagelse
(
	ansatt_id INTEGER NOT NULL,
	prosjekt_id INTEGER NOT NULL,
   	rolle VARCHAR(30) NOT NULL,
	arbeidstimer INTEGER,
	CONSTRAINT prosjektdeltagelsePK PRIMARY KEY (ansatt_id, prosjekt_id),
	CONSTRAINT prosjektdeltagelseFK FOREIGN KEY (ansatt_id)
	REFERENCES ansatt(ansatt_id),
	CONSTRAINT prosjektdeltagelseFK1 FOREIGN KEY (prosjekt_id)
	REFERENCES prosjekt(prosjekt_id)
);



INSERT INTO
  avdeling(navn)
VALUES
    ('Flesland'),
    ('HVL'),
    ('Godvik');
    


INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansatt_dato, stilling, maanedslonn, avdeling_id)
VALUES
    ('bsa', 'Bilal', 'Saher', '2018-04-14', 'IT - Konsulent', 68000, 1),
    ('hv', 'Hoang', 'Nguyen', '2022-01-29', 'Butikkmedarbeider', 15000, 2),
    ('veg', 'Vegard', 'Rose', '2018-03-23', 'PT', 45000, 1),
    ('peb', 'Pelle', 'Nielsen', '2020-01-13', 'Selger', 22000, 1),
    ('jes', 'Jens', 'Solheim', '2023-10-06', 'Lege', 60000, 1),
    ('nok', 'Noah', 'Klepsvik', '2020-06-09', 'Vlogger', 38000, 3),
    ('fda', 'Fredrik', 'Dahl', '2022-12-30', 'Fisker', 29000, 3),
    ('seb', 'Sebastian', 'Olsen', '2021-10-15', 'Artist', 55000, 2),
    ('dah', 'Daniel', 'Hedbom', '2019-04-11', 'Ingeniør', 48000, 3),
    ('sig', 'Sigurd', 'Kløgetvedt', '2019-11-09', 'Barnehage - Lærer', 32000, 1),
    ('aho', 'Agnes', 'Hol', '2022-01-30','Spiller', '34000', 3),
    ('omo', 'Olga', 'Mossige', '2018-02-03','Baker', '12000', 2),
    ('tle', 'Tommy', 'Lervik', '2022-12-08','Utforsker', '46000', 3),
    ('kkj', 'Ken', 'Kjelsberg', '2024-06-11','Kjører', '30000', 3);


    
INSERT INTO
  prosjekt(prosjekt_navn, beskrivelse)
VALUES
    ('Snapchat', 'Fikse bug i snapchat'),
    ('Playstation', 'Lage GTA 6'),
    ('CAT', 'Bygge ny bro på sotra');
    
  
  
    
INSERT INTO
  prosjektdeltagelse(ansatt_id, prosjekt_id, rolle, arbeidstimer)
VALUES
    (1, 1, 'Utvikler', 120),
    (10, 1, 'Bruker', 80),
    (4, 1, 'Invester', 40),
    (3, 2, 'Referant', 95),
    (2, 2, 'Planlegger', 100),
    (7, 2, 'Tester', 65),
    (6, 3, 'Filming', 55),
    (5, 3, 'Healer', 100),
    (8, 3, 'Transporterer', 90);



ALTER TABLE avdeling ADD COLUMN sjef_id INTEGER;
ALTER TABLE avdeling ADD CONSTRAINT avdelingFK FOREIGN KEY (sjef_id) REFERENCES ansatt(ansatt_id);



UPDATE Avdeling SET sjef_id = 1 WHERE avdeling_id = 1;
UPDATE Avdeling SET sjef_id = 8 WHERE avdeling_id = 2;
UPDATE Avdeling SET sjef_id = 9 WHERE avdeling_id = 3;



SELECT * FROM ansatt;
    
