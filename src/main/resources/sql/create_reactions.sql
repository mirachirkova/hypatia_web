DROP TABLE IF EXISTS reactions CASCADE;
DROP TYPE IF EXISTS e_reaction CASCADE;

CREATE TYPE e_reaction AS ENUM ('like', 'distrust');
CREATE TABLE reactions (
	id SERIAL PRIMARY KEY,
	user_id SERIAL references users(id) ON DELETE CASCADE,
	picture_id SERIAL references pictures(id) ON DELETE CASCADE,
	reaction e_reaction NOT NULL
);