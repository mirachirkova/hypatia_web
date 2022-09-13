DROP TABLE IF EXISTS users CASCADE;
DROP TYPE IF EXISTS e_gender CASCADE;

CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	nickname text NOT NULL,
	first_name text NOT NULL,
	last_name text,
	gender text NOT NULL,
	password_hash integer NOT NULL
);

COPY users(id, nickname, password_hash, first_name, last_name, gender) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_users.csv' WITH (FORMAT csv);