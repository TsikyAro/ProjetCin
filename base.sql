-- POSTGRES --
CREATE USER cin SUPERUSER LOGIN PASSWORD 'cin'
CREATE DATABASE cin WITH OWNER cin;
Personne:
    CREATE TABLE COMMUNE(
        idCommune   VARCHAR(10) PRIMARY KEY,
        NomCommune  VARCHAR(25)
    );
    CREATE TABLE OLONA (
        idOlona     VARCHAR(10) PRIMARY KEY,
        Nom     VARCHAR(20),
        Prenom  VARCHAR(25),
        Dtn     DATE,
        Adresse    VARCHAR(25),
        idCommune   VARCHAR(10) REFERENCES COMMUNE (idCommune)
    );
    CREATE table CINs(
        CIN     VARCHAR(12) PRIMARY KEY,
        idOlona     VARCHAR(10) REFERENCES OLONA (idOlona),
        dateSortie   date     
    );
-- Insertion de données dans la table COMMUNE
INSERT INTO COMMUNE (idCommune, NomCommune)
VALUES
    ('CUM0000001', 'Paris'),
    ('CUM0000002', 'New York'),
    ('CUM0000003', 'Londres'),
    ('CUM0000004', 'Tokyo');

-- Insertion de données dans la table OLONA
INSERT INTO OLONA (idOlona, Nom, Prenom, Dtn, Adresse, idCommune)
VALUES
    ('OLN0000001', 'Dupont', 'Jean', '1980-05-15', '123 Rue de Paris', 'CUM0000001'),
    ('OLN0000002', 'Smith', 'John', '1975-08-20', '456 Elm Street', 'CUM0000002'),
    ('OLN0000003', 'Patel', 'Priya', '1990-03-10', '789 Baker Avenue', 'CUM0000003'),
    ('OLN0000004', 'Yamada', 'Satoshi', '1988-11-25', '101 Sakura Street', 'CUM0000004');

-- Insertion de données dans la table CINs
INSERT INTO CINs (CIN, idOlona, dateSortie)
VALUES
    ('101252123456', 'OLN0000001', '2022-02-15'),
    ('101257854212', 'OLN0000002', '2021-12-10'),
    ('101252863241', 'OLN0000003', '2023-03-05'),
    ('101252965245', 'OLN0000004', '2022-05-20');

Sante:
    CREATE TABLE Operation(
        idOperation     VARCHAR(10) PRIMARY KEY,
        NomOperation    VARCHAR(25)
    );
    CREATE TABLE Maladie(
        idMaladie   VARCHAR(10) PRIMARY KEY,
        NomMaladie  VARCHAR(25)
    );
    CREATE TABLE Information(
        idInformation   VARCHAR(10) PRIMARY KEY,
        CIN     VARCHAR(12) REFERENCES  CINS (CIN),
        idMaladie   VARCHAR(10) REFERENCES Maladie (idMaladie),
        idOperation     VARCHAR(10) REFERENCES Operation (idOperation)
    ); 
    CREATE TABLE Diagnostic(
        idDiagno    VARCHAR(10) PRIMARY KEY,
        CIN     VARCHAR(12) REFERENCES  CINS (CIN),
        idMaladie   VARCHAR(10) REFERENCES Maladie (idMaladie),
        idOperation     VARCHAR(10) REFERENCES Operation (idOperation),
        Datedetraitement DATE,
        Depense     DOUBLE PRECISION
    );
    -- Insertion de données dans la table Operation
INSERT INTO Operation (idOperation, NomOperation)
VALUES
    ('Op1', 'Appendicite'),
    ('Op2', 'Chirurgie cardiaque'),
    ('Op3', 'Hernie inguinale');

-- Insertion de données dans la table Maladie
INSERT INTO Maladie (idMaladie, NomMaladie)
VALUES
    ('M1', 'Diabète'),
    ('M2', 'Hypertension artérielle'),
    ('M3', 'Cancer');

-- Insertion de données dans la table Information
INSERT INTO Information (idInformation, CIN, idMaladie, idOperation)
VALUES
    ('Info1', '101252123456', 'M1', 'Op1'),
    ('Info2', '101257854212', 'M2', 'Op2'),
    ('Info3', '101252863241', 'M3', 'Op3');

-- Insertion de données dans la table Diagnostic
INSERT INTO Diagnostic (idDiagno, CIN, idMaladie, idOperation, Datedetraitement, Depense)
VALUES
    ('D1', '101252123456', 'M1', 'Op1', '2023-01-15', 500.00),
    ('D2', '101257854212', 'M2', 'Op2', '2023-02-20', 800.00),
    ('D3', '101252863241', 'M3', 'Op3', '2023-03-25', 1200.00);

-- View --
CREATE VIEW Sante as
 select d.CIN, o.nomoperation,m.nommaladie, d.datedetraitement,d.depense 
 from diagnostic d 
 join operation o 
 on d.idoperation = o.idoperation 
 join maladie m 
 on  m.idmaladie = d.idmaladie; 


-- MY SQL --
CREATE USER 'cin'@'localhost' IDENTIFIED BY 'cin';
CREATE DATABASE cin;
GRANT ALL PRIVILEGES ON cin.* TO 'cin'@'localhost';
FLUSH PRIVILEGES;
Foncier:
    CREATE TABLE Terrain(
        idTerrain    int AUTO_INCREMENT primary key,
        localisation    VARCHAR(25),
        superficie      DOUBLE PRECISION
    );
    CREATE TABLE ACTEVENTE(
        idActe   int AUTO_INCREMENT primary key,
        CIN     VARCHAR(12) REFERENCES  OLONA (CIN),
        idTerrain   int REFERENCES Terrain (idTerrain),
        idtypetany  int REFERENCES TypeTany(idtypetany),
        Datedetraitement DATE,
        prix    DOUBLE PRECISION
    );
    CREATE TABLE TypeTany(
        idType int AUTO_INCREMENT primary key,
        nomType     VARCHAR(25)
    );
    CREATE TABLE PROPRIETE(
        idPropriete     int AUTO_INCREMENT primary key,
        CIN         VARCHAR(12),
        longitude   double precision,
        latitude    double precision,
        idTerrain    int REFERENCES Terrain (idTerrain)
    );
INSERT INTO TypeTany (nomType) VALUES ('heritage'),('vente');
    -- Insertion de données dans la table Terrain avec des adresses fictives
INSERT INTO Terrain ( localisation, superficie)
VALUES
    ('123 Main Street,City', 1000.00),
    ('456 Elm Street,Town', 750.50),
    ('789 Oak Street,Village', 1200.25);

-- Insertion de données dans la table ACTEVENTE avec des adresses fictives
INSERT INTO ACTEVENTE (CIN, idTerrain,idtypetany, Datedetraitement, prix)
VALUES
    ( '101257854212', 1,1, '2023-01-15',0.0),
    ( '101252123456', 2,2,'2023-02-20',75000.0),
    ( '101252863241', 3,1,'2023-03-25',0.0);
    
CREATE view Foncier as
    select ac.cin,t.localisation,t.superficie,ac.datedetraitement,ac.prix,ac.idTerrain 
    from actevente ac 
    join terrain t 
    on t.idterrain=ac.idterrain;  
-- SQL SERVEUR --
CREATE DATABASE cin;
Banque:
    CREATE TABLE TRANSACTIONS(
        idTransaction  int IDENTITY(1,1) PRIMARY KEY,
        NomTransaction   VARCHAR(25)
    ); 
    CREATE TABLE Operation(
        idOperation  int IDENTITY(1,1) PRIMARY KEY,
        idTransaction  int REFERENCES TRANSACTIONS (idTransaction),
        montant         DOUBLE PRECISION,
        CINRecepteur             VARCHAR(12) REFERENCES  OLONA (CIN),
        CINEnvoyeur             VARCHAR(12) REFERENCES  OLONA (CIN),
        Dates           date
    );
INSERT INTO TRANSACTIONS(nomTransaction) VALUES ('Remboursement'),('Virement'),('Retrait')
INSERT INTO Operation (idTransaction, montant, CINRecepteur,CINEnvoyeur, Dates)
VALUES
    (1, 90000.00, '101252123456', '101257854212','2023-01-10 08:00:00'),
    (2, 0.00, '101257854212', '101252863241','2023-15-02 14:30:00'),
    
    (3, 300.00, '101252123456', '101252863241','2023-20-03 10:15:00'),
    (2, 1000.00, '101252863241','101252123456', '2023-04-25 16:45:00');
-- requete --
select t.nomTransaction,o.montant,o.cin,o.dates 
from operation o 
join TRANSACTIONS t 
on o.idTransaction = t.idTransaction;

CREATE table Devise(
    idDevise    serial PRIMARY key,
    nomDevise       VARCHAR(20)    
);
INSERT into Devise (nomDevise) values('Dollar'),('Euro')

CREATE table coursDevise(
    idCoursDevise   serial,
    idDevise        int REFERENCES devise (idDevise) ,
    DateCours       date,
    ValeurAriaryTV    double precision,
    ValeurEuroTV    double precision
); 
INSERT into coursDevise (idDevise,DateCours,ValeurAriaryTV,ValeurEuroTV) values (1,'2023-01-15',4930,4450),(2,'2023-05-24',5150,4890);
