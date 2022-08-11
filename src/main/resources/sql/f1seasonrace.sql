-- f1db.drivers definition

CREATE TABLE `drivers` (
  `driver_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `team_id` bigint(20) unsigned DEFAULT NULL,
  `driver_name` varchar(250) DEFAULT NULL,
  `driver_point` int(11) DEFAULT '0',
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- f1db.events definition

CREATE TABLE `events` (
  `event_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `event_description` varchar(250) NOT NULL,
  `event_location` varchar(250) NOT NULL,
  `event_date` timestamp NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- f1db.teams definition

CREATE TABLE `teams` (
  `team_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `team_name` varchar(250) DEFAULT NULL,
  `team_point` int(11) DEFAULT '0',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- f1db.event_drivers definition

CREATE TABLE `event_drivers` (
  `event_id` bigint(20) unsigned NOT NULL,
  `driver_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- f1db.event_teams definition

CREATE TABLE `event_teams` (
  `event_id` bigint(20) unsigned NOT NULL,
  `team_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;