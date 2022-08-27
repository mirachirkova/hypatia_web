DROP TABLE IF EXISTS phenomenons_to_objects CASCADE;

CREATE TABLE phenomenons_to_objects (
	id SERIAL PRIMARY KEY,
	object_id SERIAL references objects(id) ON DELETE CASCADE,
	phenomenon_id SERIAL references phenomenons(id)
);