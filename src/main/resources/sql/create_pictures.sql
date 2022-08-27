DROP TABLE IF EXISTS pictures CASCADE;
DROP TYPE IF EXISTS e_telecsope CASCADE;

CREATE TYPE e_telecsope AS ENUM ('SKYLINE', 'SVD1300', 'GHM03');
CREATE TABLE pictures (
	id SERIAL PRIMARY KEY,
	link text NOT NULL,
	author_id SERIAL references users(id), 
	telescope e_telecsope
);