DROP TABLE IF EXISTS objects CASCADE;
DROP TYPE IF EXISTS e_object_class CASCADE;

CREATE TABLE objects (
                         id SERIAL PRIMARY KEY,
                         name text NOT NULL,
                         object_class text,
                         discoverer text,
                         discovery_date date,
                         info text
);
COPY objects(id, name, object_class, discoverer, discovery_date, info)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_objects.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS phenomenons CASCADE;
DROP TYPE IF EXISTS e_phenomenon_class CASCADE;

CREATE TABLE phenomenons (
                             id SERIAL PRIMARY KEY,
                             name text NOT NULL,
                             phenomenon_class text,
                             start_time timestamp with time zone,
                             finish_time timestamp with time zone
);
COPY phenomenons(id, name, phenomenon_class, start_time, finish_time)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_phenomenons.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS users CASCADE;
DROP TYPE IF EXISTS e_gender CASCADE;

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       nickname text NOT NULL,
                       first_name text NOT NULL,
                       last_name text,
                       gender text NOT NULL,
                       password_hash integer NOT NULL
);

COPY users(nickname, password_hash, first_name, last_name, gender)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_users.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS pictures CASCADE;
DROP TYPE IF EXISTS e_telesсope CASCADE;

CREATE TABLE pictures (
                          id SERIAL PRIMARY KEY,
                          link text NOT NULL,
                          author_id SERIAL references users(id) ON DELETE CASCADE,
                          telescope text
);
COPY pictures(link, author_id, telescope)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_pictures.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS phenomenons_to_objects CASCADE;

CREATE TABLE phenomenons_to_objects (
                                        id SERIAL PRIMARY KEY,
                                        object_id SERIAL references objects(id) ON DELETE CASCADE,
                                        phenomenon_id SERIAL references phenomenons(id)
);

COPY phenomenons_to_objects(id, object_id, phenomenon_id)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_phenomenons_to_objects.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS pictures_to_objects CASCADE;

CREATE TABLE pictures_to_objects (
                                     id SERIAL PRIMARY KEY,
                                     object_id integer NOT NULL references objects(id) ON DELETE CASCADE,
                                     picture_id integer NOT NULL references pictures(id) ON DELETE CASCADE
);

COPY pictures_to_objects(object_id, picture_id)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\contetnt_pictures_to_objects.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS pictures_to_phenomenons CASCADE;

CREATE TABLE pictures_to_phenomenons (
                                         id SERIAL PRIMARY KEY,
                                         phenomenon_id SERIAL references phenomenons(id) ON DELETE CASCADE,
                                         picture_id SERIAL references pictures(id) ON DELETE CASCADE
);

COPY pictures_to_phenomenons(id, phenomenon_id, picture_id)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_picrtures_to_phenomenons.csv' WITH (FORMAT csv);

DROP TABLE IF EXISTS reactions CASCADE;
DROP TYPE IF EXISTS e_reaction CASCADE;

CREATE TABLE reactions (
                           id SERIAL PRIMARY KEY,
                           user_id SERIAL references users(id) ON DELETE CASCADE,
                           picture_id SERIAL references pictures(id) ON DELETE CASCADE,
                           reaction text NOT NULL
);


COPY reactions(user_id, picture_id, reaction)
    FROM 'C:\Users\mir-u\Downloads\demo\demo\src\main\resources\sql\table_content\content_reactions.csv' WITH (FORMAT csv);
