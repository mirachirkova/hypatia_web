DROP TABLE IF EXISTS sattelites CASCADE;

CREATE TABLE sattelites (
	object_id SERIAL references objects(id) ON DELETE CASCADE,
	planet_id SERIAL references objects(id) ON DELETE CASCADE,
	mass,
	shape,
	mean_radius,
	semi_major_axis,
	eccentrisity
);