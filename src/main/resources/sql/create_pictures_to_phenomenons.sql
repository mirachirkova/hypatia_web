DROP TABLE IF EXISTS pictures_to_phenomenons CASCADE;

CREATE TABLE pictures_to_phenomenons (
	id SERIAL PRIMARY KEY,
	phenomenon_id SERIAL references phenomenons(id) ON DELETE CASCADE,
	picture_id SERIAL references pictures(id) ON DELETE CASCADE
);