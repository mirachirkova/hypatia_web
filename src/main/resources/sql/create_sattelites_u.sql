DROP TABLE IF EXISTS sattelites CASCADE;

CREATE TABLE sattelites (
	object_id SERIAL references objects(id),
	planet_id SERIAL references objects(id),
	mass,
	shape,
	mean_radius,
	semi_major_axis,
	eccentrisity
);