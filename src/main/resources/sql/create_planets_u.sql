DROP TABLE IF EXISTS planets CASCADE;

CREATE TABLE planets (
	object_id SERIAL references objects(id),
	star_id SERIAL references objects(id),
	mass,
	mean_density,
	surface_temperature integer,
	radius,
	aphelion,
	perihelion,
	orbital_period
);