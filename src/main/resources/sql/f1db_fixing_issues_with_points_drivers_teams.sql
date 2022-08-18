ALTER TABLE f1db.drivers DROP COLUMN driver_point;

ALTER TABLE f1db.teams DROP COLUMN team_point;

ALTER TABLE f1db.event_drivers ADD driver_points BIGINT UNSIGNED DEFAULT 0 NOT NULL;

ALTER TABLE f1db.event_teams ADD team_points BIGINT UNSIGNED DEFAULT 0 NOT NULL;
