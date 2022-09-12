DROP TABLE IF EXISTS objects CASCADE;
DROP TYPE IF EXISTS e_object_class CASCADE;

CREATE TABLE objects (
	id SERIAL PRIMARY KEY,
	name text NOT NULL,
	object_class text,
	discoverer text,
	discovery_date date,
	info text
);
COPY objects(id, name, object_class, discoverer, discovery_date, info) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_objects.csv' WITH (FORMAT csv);