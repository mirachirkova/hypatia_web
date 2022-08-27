DROP TABLE IF EXISTS pictures_to_phenomenons CASCADE;

CREATE TABLE pictures_to_phenomenons (
	phenomenon_id SERIAL references phenomenons(id),
	picture_id SERIAL references pictures(id)
);