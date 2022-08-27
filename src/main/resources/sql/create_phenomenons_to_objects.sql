DROP TABLE IF EXISTS phenomenons_to_objects CASCADE;

CREATE TABLE phenomenons_to_objects (
	object_id SERIAL references objects(id),
	phenomenon_id SERIAL references phenomenons(id)
);