DROP TABLE IF EXISTS objects CASCADE;
DROP TYPE IF EXISTS e_object_class CASCADE;

CREATE TYPE e_object_class AS ENUM 
	('comet', 'star', 'planet', 'sattelite', 'other');
CREATE TABLE objects (
	id SERIAL PRIMARY KEY,
	name text NOT NULL,
	class e_object_class,
	discoverer text,
	discovery_date date,
	ncg_id text,
	messier_id text
);