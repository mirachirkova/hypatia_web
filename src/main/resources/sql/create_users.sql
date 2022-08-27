DROP TABLE IF EXISTS users CASCADE;
DROP TYPE IF EXISTS e_gender CASCADE;

CREATE TYPE e_gender AS ENUM ('female', 'male', 'unspecified', 'other');
CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	nickname text NOT NULL,
	first_name text NOT NULL,
	last_name text,
	gender e_gender NOT NULL,
	password_hash integer NOT NULL
);