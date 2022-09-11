DROP TABLE IF EXISTS pictures_to_phenomenons CASCADE;

CREATE TABLE pictures_to_phenomenons (
	id SERIAL PRIMARY KEY,
	phenomenon_id SERIAL references phenomenons(id) ON DELETE CASCADE,
	picture_id SERIAL references pictures(id) ON DELETE CASCADE
);

COPY pictures_to_phenomenons(id, phenomenon_id, picture_id) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_picrtures_to_phenomenons.csv' WITH (FORMAT csv);
