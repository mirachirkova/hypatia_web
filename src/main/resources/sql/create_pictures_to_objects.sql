DROP TABLE IF EXISTS pictures_to_objects CASCADE;

CREATE TABLE pictures_to_objects (
	id SERIAL PRIMARY KEY,
	object_id integer NOT NULL references objects(id) ON DELETE CASCADE,
	picture_id integer NOT NULL references pictures(id) ON DELETE CASCADE
);

COPY pictures_to_objects(id, object_id, picture_id) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\contetnt_pictures_to_objects.csv' WITH (FORMAT csv);
