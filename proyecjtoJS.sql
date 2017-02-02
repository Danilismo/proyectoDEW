CREATE DATABASE `proyectoJS`;

CREATE TABLE `proyectoJS`.`ciudad` (
    `id_ciudad` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    `pais` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_ciudad`),
    UNIQUE INDEX `unique_index` (`nombre` , `pais`)
);
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('La Laguna', 'España');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Madrid', 'España');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Londres', 'Reino Unido');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('París', 'Francia');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Berlín', 'Alemania');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Lisboa', 'Portugal');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Roma', 'Italia');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Moscú', 'Rusia');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Brasilia', 'Brasil');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Ottawa', 'Canadá');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Buenos Aires', 'Argentina');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Washington', 'Estados Unidos');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Ciudad de México', 'México');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Pekín', 'China');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Seúl', 'Corea del Sur');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Tokio', 'Japón');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Nueva Delhi', 'India');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('El Cairo', 'Egipto');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Canberra', 'Australia');
INSERT INTO `proyectoJS`.`ciudad` (`nombre`, `pais`) VALUES ('Wellington', 'Nueva Zelanda');


CREATE TABLE `proyectoJS`.`aeropuerto` (
    `id_aeropuerto` INT NOT NULL AUTO_INCREMENT,
    `id_ciudad` INT NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
    `categoria` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id_aeropuerto`),
    INDEX `fk_aeropuerto_ciudad_idx` (`id_ciudad` ASC),
    UNIQUE INDEX `unique_index` (`id_ciudad`, `nombre`),
    CONSTRAINT `fk_aeropuerto_ciudad` FOREIGN KEY (`id_ciudad`)
        REFERENCES `proyectoJS`.`ciudad` (`id_ciudad`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('1', 'Los Rodeos', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('2', 'Barajas', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('3', 'Heathrow', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('3', 'Gatwick', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('4', 'Charles de Gaulle', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('5', 'Tegel', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('6', 'Aeropuerto de Portela', '1');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('7', 'Leonardo da Vinci', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('8', 'Moscú-Sheremétievo', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('9', 'Presidente Juscelino Kubitschek', '1');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('10', 'McDonald-Cartier', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('11', 'Jorge Newbery', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('11', 'Ezeiza', '1');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('11', 'Mariano Moreno', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('12', 'Dulles', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('13', 'Benito Juárez', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('14', 'Aeropuerto Internacional de Pekín-Capital', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('15', 'Incheon', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('16', 'Haneda', '3');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('17', 'Indira Gandhi', '1');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('18', 'Aeropuerto Internacional de El Cairo', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('19', 'Aeropuerto Internacional de Canberra', '2');
INSERT INTO `proyectoJS`.`aeropuerto` (`id_ciudad`, `nombre`, `categoria`) VALUES ('20', 'Aeropuerto Internacional de Wellington', '1');


CREATE TABLE `proyectoJS`.`aerolinea` (
    `id_aerolinea` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_aerolinea`),
    UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC)
);
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('Turkish Airlines');
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('Lufthansa');
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('Air France');
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('British Airways');
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('Ryanair');
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('Emirates');
INSERT INTO `proyectoJS`.`aerolinea` (`nombre`) VALUES ('Iberia');


CREATE TABLE `proyectoJS`.`vueloGenerico` (
    `nVuelo` INT NOT NULL AUTO_INCREMENT,
    `id_aerolinea` INT NULL DEFAULT NULL,
    `id_aero_origen` INT NOT NULL,
    `horaSalida` TIME NULL DEFAULT '08:00:00',
    `id_aero_destino` INT NOT NULL,
    `horaLlegada` TIME NULL DEFAULT '15:00:00',
    `precio` DECIMAL NULL DEFAULT 100,
    `capacidad` TINYINT UNSIGNED NULL DEFAULT 30,
    PRIMARY KEY (`nVuelo`),
    UNIQUE INDEX `unique_index` (`id_aerolinea` , `id_aero_origen` , `horaSalida` , `id_aero_destino` , `horaLlegada`),
    CONSTRAINT `fk_vueloG_aeropS` FOREIGN KEY (`id_aero_origen`)
        REFERENCES `proyectoJS`.`aeropuerto` (`id_aeropuerto`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_vueloG_aeropL` FOREIGN KEY (`id_aero_destino`)
        REFERENCES `proyectoJS`.`aeropuerto` (`id_aeropuerto`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_vueloG_aerolinea` FOREIGN KEY (`id_aerolinea`)
        REFERENCES `proyectoJS`.`aerolinea` (`id_aerolinea`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('7', '1', '06:44:00', '2', '13:07:00', '76', '40');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('7', '2', '14:02:00', '1', '21:25:00', '104', '36');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('7', '2', '07:23:00', '3', '10:27:00', '54', '39');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '3', '03:23:00', '2', '05:43:00', '84', '39');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('7', '2', '23:54:00', '7', '00:53:00', '34', '30');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('5', '7', '14:53:00', '2', '15:50:00', '41', '34');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('3', '2', '21:43:00', '4', '23:15:00', '68', '30');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('3', '4', '00:33:00', '2', '02:32:00', '75', '36');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('5', '2', '051400', '8', '075400', '84', '15');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('5', '8', '091200', '2', '124200', '81', '37');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('2', '2', '182400', '15', '195200', '75', '13');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('2', '15', '202300', '2', '213500', '71', '16');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('1', '2', '010600', '18', '052100', '185', '31');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('1', '18', '060000', '2', '084300', '198', '26');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '3', '153200', '4', '160300', '31', '19');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '4', '164800', '3', '172100', '30', '21');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '4', '195400', '5', '210300', '47', '26');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '5', '213800', '4', '225900', '45', '24');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '4', '215100', '6', '023400', '59', '14');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('4', '6', '025700', '4', '045000', '51', '18');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('2', '4', '042300', '9', '062400', '61', '25');
INSERT INTO `proyectoJS`.`vueloGenerico` (`id_aerolinea`, `id_aero_origen`, `horaSalida`, `id_aero_destino`, `horaLlegada`, `precio`, `capacidad`) VALUES ('2', '9', '070300', '4', '095300', '65', '20');
-- Me cansé de añadir vuelos (tantos aeropuertos para nada...) xD

-- IMPORTANTÍSIMO. A la hora de insertar, se debe poner en estado_plazas un String para controlar los asientos libres y ocupados
-- Algo en plan 1111010101010101 (1 ocupado, 0 libre), que después será traducido en el svg
-- No se crearán datos de vuelo. Si el usuario selecciona un vuelo que aún no ha sido seleccionado, se tendrán que crear 4 días (incluyendo el actual)
-- desde Java con datos aleatorios de plazas_libres/estado_plazas 
-- Lo IDEAL sería crear un montón de datos aleatorios para la tabla reservas y en la misma indicar el asiento. Después para cada vuelo crear varias reservas aleatorias
-- Sería lo ideal, pero lo veo mucho jaleo tener que crear 4 días aleatorios con una media de 15 reservas inventadas para cada día. Una locura
CREATE TABLE `proyectoJS`.`vuelo` (
    `id_vuelo` INT NOT NULL AUTO_INCREMENT,
    `id_vueloGenerico` INT NOT NULL,
    `fecha` DATE NOT NULL,
    `plazas_libres` INT NULL DEFAULT NULL,
    `estado_plazas` BIGINT UNSIGNED NULL DEFAULT null,
    PRIMARY KEY (`id_vuelo`),
    UNIQUE INDEX `id_vueloGenerico_UNIQUE` (`id_vueloGenerico` ASC),
    UNIQUE INDEX `fecha_UNIQUE` (`fecha` ASC),
    CONSTRAINT `fk_vuelo_vueloGenerico` FOREIGN KEY (`id_vueloGenerico`)
        REFERENCES `proyectoJS`.`vueloGenerico` (`nVuelo`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `proyectoJS`.`reservas` (
    `n_reserva` INT NOT NULL AUTO_INCREMENT,
    `id_vuelo` INT NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
    `apellidos` VARCHAR(45) NOT NULL,
    `telf` INT(9) UNSIGNED NOT NULL,
    `tarjeta` BIGINT(16) UNSIGNED NOT NULL,
    `importe` DECIMAL NOT NULL,
    PRIMARY KEY (`n_reserva`),
    UNIQUE INDEX `id_vuelo_UNIQUE` (`id_vuelo` ASC),
    UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
    UNIQUE INDEX `apellidos_UNIQUE` (`apellidos` ASC),
    CONSTRAINT `fk_reservas_vuelo` FOREIGN KEY (`id_vuelo`)
        REFERENCES `proyectoJS`.`vuelo` (`id_vuelo`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Vista ya hecha para buscar vuelos:
-- Ejemplo select * from buscarVuelos where precio <= 75 AND horaSalida <= 060000 AND horaLlegada <= 190000 AND Aerolínea IN ('Air France', 'British Airways');
USE `proyectoJS`;

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `buscarVuelos` AS
    SELECT 
        `vg`.`nVuelo` AS `nVuelo`,
        `aeropO`.`nombre` AS `Aeropuerto de Origen`,
        `ciudadO`.`nombre` AS `Ciudad de Origen`,
        `ciudadO`.`pais` AS `País de Origen`,
        `vg`.`horaSalida` AS `horaSalida`,
        `aeropD`.`nombre` AS `Aeropuerto de Destino`,
        `ciudadD`.`nombre` AS `Ciudad de Destino`,
        `ciudadD`.`pais` AS `País de Destino`,
        `vg`.`horaLlegada` AS `horaLlegada`,
        `vg`.`precio` AS `precio`,
        `vg`.`capacidad` AS `capacidad`,
        `aerol`.`nombre` AS `Aerolínea`
    FROM
        (((((`vueloGenerico` `vg`
        JOIN `aeropuerto` `aeropO` ON ((`vg`.`id_aero_origen` = `aeropO`.`id_aeropuerto`)))
        JOIN `aeropuerto` `aeropD` ON ((`vg`.`id_aero_destino` = `aeropD`.`id_aeropuerto`)))
        JOIN `ciudad` `ciudadO` ON ((`aeropO`.`id_ciudad` = `ciudadO`.`id_ciudad`)))
        JOIN `ciudad` `ciudadD` ON ((`aeropD`.`id_ciudad` = `ciudadD`.`id_ciudad`)))
        JOIN `aerolinea` `aerol` ON ((`vg`.`id_aerolinea` = `aerol`.`id_aerolinea`)));

-- Sentencia SQL ya hecha (sugerencia, vaya) para insertar la reserva y actualizar los asientos y plazas libres
-- Además, la segunda consulta se puede usar tambien para crear los datos (replace funciona tanto como create como update si añades el where id_vueloGenerico = ?)
-- insert into reservas `proyectoJS`.`reservas` (id_vuelo, nombre, apellidos, telf, tarjeta, importe) values (?, ?, ?, ?, ?, ?);
-- replace into `proyectoJS`.`vuelo` set id_vueloGenerico = ?, fecha = ?, plazas_libres = ?, estado_plazas = ?;