CREATE TABLE IF NOT EXISTS users (
   id binary(16) PRIMARY KEY,
   username VARCHAR(255) NOT NULL,
   email VARCHAR(255) NULL,
   password VARCHAR(255) NOT NULL,
   fullname VARCHAR(255) NULL,
   role VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS plants (
   id binary(16) PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   soaking_time INT NULL,
   start_harvest INT NULL,
   end_harvest INT NULL,
   shoots_appear INT NULL
);

CREATE TABLE IF NOT EXISTS locations (
   id binary(16) PRIMARY KEY,
   name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS plant_locations (
   plant_id binary(16) NOT NULL,
   location_id binary(16) NOT NULL
);

ALTER TABLE plant_locations ADD CONSTRAINT fk_plant_locations_on_plants FOREIGN KEY (plant_id) REFERENCES plants (id) ON DELETE CASCADE;
ALTER TABLE plant_locations ADD CONSTRAINT fk_plant_locations_on_locations FOREIGN KEY (location_id) REFERENCES locations (id) ON DELETE CASCADE;