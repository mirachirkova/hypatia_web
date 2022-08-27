DROP TABLE IF EXISTS stars CASCADE;

CREATE TABLE stars (
	object_id SERIAL references objects(id) ON DELETE CASCADE,
	mass double precision,
	radius double precision,
	distance double precision,
	luminosity double precision,
	spectral_classification text,
	apparent_magnitude double precision
);