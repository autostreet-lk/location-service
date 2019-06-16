CREATE TABLE if not exists `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE districts(
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL UNIQUE,
  `represent` varchar(50) NOT NULL
);


CREATE TABLE cities(
  `id` bigint(20) NOT NULL,
  `district_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL UNIQUE,
  `represent` varchar(50) NOT NULL
);

