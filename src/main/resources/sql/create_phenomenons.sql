DROP TABLE IF EXISTS phenomenons CASCADE;
DROP TYPE IF EXISTS e_phenomenon_class CASCADE;

CREATE TABLE phenomenons (
	id SERIAL PRIMARY KEY,
	name text NOT NULL,
	phenomenon_class text,
	start_time timestamp with time zone,
	finish_time timestamp with time zone
);
COPY phenomenons(id, name, phenomenon_class, start_time, finish_time) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_phenomenons.csv' WITH (FORMAT csv);