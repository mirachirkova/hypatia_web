DROP TABLE IF EXISTS phenomenons CASCADE;
DROP TYPE IF EXISTS e_phenomenon_class CASCADE;

CREATE TYPE e_phenomenon_class AS ENUM 
	('flare', 'eclipse', 'parade');
CREATE TABLE phenomenons (
	id SERIAL PRIMARY KEY,
	name text NOT NULL,
	class e_phenomenon_class,
	start_time timestamp with time zone,
	finish_time timestamp with time zone
);