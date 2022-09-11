DROP TABLE IF EXISTS pictures CASCADE;
DROP TYPE IF EXISTS e_telesсope CASCADE;

CREATE TYPE e_telesсope AS ENUM ('SKYLINE', 'SVD1300', 'GHM03');
CREATE TABLE pictures (
	id SERIAL PRIMARY KEY,
	link text NOT NULL,
	author_id SERIAL references users(id) ON DELETE CASCADE,
	telescope e_telesсope
);
COPY pictures(id, link, author_id, telescope) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_pictures.csv' WITH (FORMAT csv);