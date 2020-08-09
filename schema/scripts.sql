DROP DATABASE hotel;
CREATE DATABASE hotel;
USE hotel;

SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';


/* TABLES */
CREATE TABLE `users` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    `dni` VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `is_active` BOOLEAN DEFAULT TRUE,
    CONSTRAINT `Pk_users` PRIMARY KEY (`id`)    
);


CREATE TABLE `user_roles` (
	`id` INT AUTO_INCREMENT NOT NULL,
    `role` VARCHAR(255) NOT NULL,    
    CONSTRAINT `Pk_user_roles` PRIMARY KEY (`id`)
);


CREATE TABLE `users_x_user_roles` (
	`id_user` INT NOT NULL,
    `id_user_role` INT NOT NULL,
    CONSTRAINT `Pk_users_x_user_roles` PRIMARY KEY (`id_user`, `id_user_role`),
    CONSTRAINT `Fk_users_x_user_roles__user` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`),
    CONSTRAINT `Fk_users_x_user_roles__user_rol` FOREIGN KEY(`id_user_role`) REFERENCES `user_roles`(`id`)
);


CREATE TABLE `observations` (
	`id` INT AUTO_INCREMENT NOT NULL,
    `description` TEXT NOT NULL,
    `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `id_user` INT NOT NULL,
    CONSTRAINT `Pk_observations` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_observations_users` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`)    
);


CREATE TABLE `room_types` (
	`id` INT AUTO_INCREMENT NOT NULL,
    `type` VARCHAR(255) NOT NULL,    
    CONSTRAINT `Pk_room_types` PRIMARY KEY (`id`)    
);


CREATE TABLE `room_floors` (
	`id` INT AUTO_INCREMENT NOT NULL,    
    `floor` VARCHAR(255) NOT NULL,
    CONSTRAINT `Pk_room_floor` PRIMARY KEY (`id`)
);


CREATE TABLE `rooms` (
	`id` INT AUTO_INCREMENT NOT NULL,    
    `number` VARCHAR(255) NOT NULL,
    `status` ENUM('ENABLED', 'DISABLED', 'BUSY', 'REPAIR', 'CLEANING') NOT NULL,
    `id_room_floor` INT NOT NULL,    	    
    `id_room_type` INT NOT NULL,    	    
    CONSTRAINT `Pk_rooms` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_rooms_room_floor` FOREIGN KEY(`id_room_floor`) REFERENCES `room_floors`(`id`),    
    CONSTRAINT `Fk_rooms_room_type` FOREIGN KEY(`id_room_type`) REFERENCES `room_types`(`id`)    
);


CREATE TABLE `reservations` (
	`id` INT AUTO_INCREMENT NOT NULL,
    `from` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    
    `to` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    
    `total_quantity` INT NOT NULL,    
    `total_adults` INT NOT NULL,    
    `total_children` INT NOT NULL,    
    `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `id_user` INT NOT NULL,  
    `id_room` INT NOT NULL,
	CONSTRAINT `Pk_reservations` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_reservations_user` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`),
    CONSTRAINT `Fk_reservations_room` FOREIGN KEY(`id_room`) REFERENCES `rooms`(`id`)    
);


