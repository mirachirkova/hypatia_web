DROP TABLE IF EXISTS reactions CASCADE;
DROP TYPE IF EXISTS e_reaction CASCADE;

CREATE TABLE reactions (
	id SERIAL PRIMARY KEY,
	user_id SERIAL references users(id) ON DELETE CASCADE,
	picture_id SERIAL references pictures(id) ON DELETE CASCADE,
	reaction text NOT NULL
);


COPY reactions(id, user_id, picture_id, reaction) 
	FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_reactions.csv' WITH (FORMAT csv);
