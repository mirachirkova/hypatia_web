DROP TABLE IF EXISTS comets CASCADE;
DROP TYPE IF EXISTS e_tail_type CASCADE;

CREATE TYPE e_tail_type AS ENUM 
	('?');
CREATE TABLE comets (
	object_id SERIAL references objects(id) ON DELETE CASCADE,
	aphelion,
	perihelion,
	tail_type e_tail_type,
	mass,
	previous_perihelion_time timestamp with time zone,
	next_perihelion_time timestamp with time zone
);