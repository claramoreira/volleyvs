CREATE DATABASE VOLLEYVS;


CREATE TABLE VOLLEYVS.POSITIONS (
	`id` INT(1) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
    );


INSERT INTO VOLLEYVS.POSITIONS 
VALUES (1, 'LEVANTADORA');

INSERT INTO VOLLEYVS.POSITIONS 
VALUES (2, 'CENTRAL');

INSERT INTO VOLLEYVS.POSITIONS 
VALUES (3, 'PONTEIRA');

INSERT INTO VOLLEYVS.POSITIONS 
VALUES (4, 'OPOSTA');

INSERT INTO VOLLEYVS.POSITIONS 
VALUES (5, 'LIBERO');


CREATE TABLE VOLLEYVS.CONDITIONS (
	`id` INT(1) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
    );

INSERT INTO VOLLEYVS.CONDITIONS 
VALUES (1, 'PÉSSIMO');

INSERT INTO VOLLEYVS.CONDITIONS 
VALUES (2, 'RUIM');

INSERT INTO VOLLEYVS.CONDITIONS 
VALUES (3, 'REGULAR');

INSERT INTO VOLLEYVS.CONDITIONS 
VALUES (4, 'BOM');

INSERT INTO VOLLEYVS.CONDITIONS 
VALUES (5, 'EXCELENTE');

INSERT INTO VOLLEYVS.CONDITIONS 
VALUES (6, 'INDISPONÍVEL');


CREATE TABLE `volleyvs`.`players` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`overall` INT(3) NOT NULL,
	`condition` INT(1),
	`position` INT(1),
	`height` DOUBLE,
	`attackHeight` DOUBLE,
    `blockHeight` DOUBLE,
    `serverPower` DOUBLE,
    `attackPower` DOUBLE,
    `blockPower` DOUBLE,
    `receptionPower` DOUBLE,
    `avgServerPointsPerMatch` DOUBLE,
    `avgAttackPointsPerMatch` DOUBLE,
    `avgBlockPointsPerMatch` DOUBLE,
    `avgReceptionsPerMatch` DOUBLE,
    `teamId` INT,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`condition`) REFERENCES VOLLEYVS.CONDITIONS(ID),
    FOREIGN KEY (`position`) REFERENCES VOLLEYVS.POSITIONS(ID)
);

INSERT INTO VOLLEYVS.PLAYERS
VALUES (1, "Gabi", 95, 3, 3, 1.80, 3.05, 2.89, 1.80, 51.92, 13.1,
				10.9, 0.8, 17.4, 1.52, 14.32, 1);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (2, "Natalia", 80, 1, 3, 1.86, 3.11, 2.95, 3.2, 48.02, 14.9,
				3.40, 1.1, 14.11, 2.3, 9.0, 1);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (3, "Brait", 82, 3, 5, 1.70, 2.71, 2.56, 0.0, 0.02, 0.0,
				30.00, 0.0, 0.01, 0.0, 40.0, 1);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (4, "Macris", 84, 4, 1, 1.78, 2.92, 2.75, 1.11,
				34.62, 14.04, 6.4, 0.63, 0.60, 0.53, 7.0, 1);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (5, "Mara", 81, 1, 2, 1.90, 3.10, 2.97, 7.0, 41.20, 14.81,
				2.0, 0.2, 5.0, 2.01, 1.2, 1);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (6, "Gattaz", 88, 4, 2, 1.93, 3.15, 2.99, 4.58, 59.15,
				16.79, 10.0, 0.5, 1.0, 1.83, 5.0, 1);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (7, "Egonu", 93, 2, 4, 1.93, 3.47, 3.30, 11.50, 49.07, 25.00,
				10.00, 1.18, 16.73, 1.27, 2.5, 1);

INSERT INTO VOLLEYVS.PLAYERS
VALUES (8, "Daroit", 80, 4, 3, 1.84, 2.90, 2.80, 0.99, 42.82, 8.11,
				10.1, 0.75, 15.32, 1.01, 4.97, 2);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (9, "Bruna Honorio", 77, 4, 3, 1.81, 3.10, 2.92, 4.20, 39.93,
				9.1, 3.9, 3.8, 10.84, 1.12, 6.23, 2);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (10, "Suellen", 78, 5, 5, 1.66, 2.62, 2.38, 1.80, 0.0,
				0.01, 10.0, 0.0, 0.02, 0.0, 24.0, 2);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (11, "Claudinha", 83, 5, 1, 1.81, 2.90, 2.66, 1.80,
				10.92, 4.91, 8.44, 1.33, 1.4, 1.21, 13.32, 2);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (12, "Carolana", 90, 4, 2, 1.83, 3.16, 3.09, 3.22, 34.92,
				25.1, 6.9, 3.5, 4.7, 7.88, 2.21, 2);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (13, "Thaisa", 89, 2, 2, 1.96, 3.20, 3.15, 4.51, 48.31,
				20.74, 1.15, 1.95, 17.4, 4.95, 1.82, 2);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (14, "Kisy", 81, 3, 4, 1.91, 3.03, 2.90, 2.41, 41.32, 11.1,
				3.9, 2.3, 10.15, 0.92, 2.15, 2);

INSERT INTO VOLLEYVS.PLAYERS
VALUES (15, "Tiffany", 93, 2, 4, 1.93, 3.47, 3.30, 11.50, 49.07, 25.00,
				10.00, 1.18, 16.73, 1.27, 2.5, 1);

INSERT INTO VOLLEYVS.PLAYERS
VALUES (16, "Druscyla", 80, 4, 3, 1.84, 2.90, 2.80, 0.99, 42.82, 8.11,
				10.1, 0.75, 15.32, 1.01, 4.97, 3);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (17, "Glayce", 77, 4, 3, 1.81, 3.10, 2.92, 4.20, 39.93,
				9.1, 3.9, 3.8, 10.84, 1.12, 6.23, 3);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (18, "Key Alves", 78, 5, 5, 1.66, 2.62, 2.38, 1.80, 0.0,
				0.01, 10.0, 0.0, 0.02, 0.0, 24.0, 3);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (19, "Giovana", 83, 5, 1, 1.81, 2.90, 2.66, 1.80,
				10.92, 4.91, 8.44, 1.33, 1.4, 1.21, 13.32, 3);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (20, "Fabiana Claudino", 90, 4, 2, 1.83, 3.16, 3.09, 3.22, 34.92,
				25.1, 6.9, 3.5, 4.7, 7.88, 2.21, 3);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (21, "Adenizia Silva", 89, 2, 2, 1.96, 3.20, 3.15, 4.51, 48.31,
				20.74, 1.15, 1.95, 17.4, 4.95, 1.82, 3);
				
INSERT INTO VOLLEYVS.PLAYERS
VALUES (22, "Sabrina Machado", 93, 2, 4, 1.93, 3.47, 3.30, 11.50, 49.07, 25.00,
				10.00, 1.18, 16.73, 1.27, 2.5, 4);

INSERT INTO VOLLEYVS.PLAYERS
VALUES (23, "Michelle Pavão", 80, 4, 3, 1.84, 2.90, 2.80, 0.99, 42.82, 8.11,
				10.1, 0.75, 15.32, 1.01, 4.97, 4);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (24, "Roni", 77, 4, 3, 1.81, 3.10, 2.92, 4.20, 39.93,
				9.1, 3.9, 3.8, 10.84, 1.12, 6.23, 4);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (25, "Laís Vasques", 78, 5, 5, 1.66, 2.62, 2.38, 1.80, 0.0,
				0.01, 10.0, 0.0, 0.02, 0.0, 24.0, 4);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (26, "Brie King", 83, 5, 1, 1.81, 2.90, 2.66, 1.80,
				10.92, 4.91, 8.44, 1.33, 1.4, 1.21, 13.32, 4);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (27, "Juciely Barreto", 90, 4, 2, 1.83, 3.16, 3.09, 3.22, 34.92,
				25.1, 6.9, 3.5, 4.7, 7.88, 2.21, 4);
                
INSERT INTO VOLLEYVS.PLAYERS
VALUES (28, "Julliana Gandra", 89, 2, 2, 1.96, 3.20, 3.15, 4.51, 48.31,
				20.74, 1.15, 1.95, 17.4, 4.95, 1.82, 4);
                