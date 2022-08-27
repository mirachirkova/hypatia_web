DROP TABLE IF EXISTS pictures_to_objects CASCADE;

CREATE TABLE pictures_to_objects (
	id SERIAL PRIMARY KEY,
	object_id SERIAL references objects(id) ON DELETE CASCADE,
	picture_id SERIAL references pictures(id) ON DELETE CASCADE
);