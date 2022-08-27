DROP TABLE IF EXISTS reactions CASCADE;
DROP TYPE IF EXISTS e_reaction CASCADE;

CREATE TYPE e_reaction AS ENUM ('like', 'distrust');
CREATE TABLE reactions (
	user_id SERIAL references users(id),
	picture_id SERIAL references pictures(id),
	reaction e_reaction NOT NULL
);