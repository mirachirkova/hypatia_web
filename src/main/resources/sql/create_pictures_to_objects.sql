DROP TABLE IF EXISTS pictures_to_objects CASCADE;

CREATE TABLE pictures_to_objects (
	object_id SERIAL references objects(id),
	picture_id SERIAL references pictures(id)
);