DROP TABLE IF EXISTS phenomenons_to_objects CASCADE;

CREATE TABLE phenomenons_to_objects (
	id SERIAL PRIMARY KEY,
	object_id SERIAL references objects(id) ON DELETE CASCADE,
	phenomenon_id SERIAL references phenomenons(id)
);

COPY phenomenons_to_objects(id, object_id, phenomenon_id) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_phenomenons_to_objects.csv' WITH (FORMAT csv);