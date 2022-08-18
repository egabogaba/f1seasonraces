ALTER TABLE f1db.drivers DROP COLUMN team_id;

ALTER TABLE f1db.event_drivers ADD CONSTRAINT event_drivers_FK FOREIGN KEY (driver_id) REFERENCES f1db.drivers(driver_id) ON DELETE CASCADE;
ALTER TABLE f1db.event_drivers ADD CONSTRAINT event_drivers_FK_1 FOREIGN KEY (event_id) REFERENCES f1db.events(event_id) ON DELETE CASCADE;

ALTER TABLE f1db.event_teams ADD CONSTRAINT event_teams_FK FOREIGN KEY (team_id) REFERENCES f1db.teams(team_id) ON DELETE CASCADE;
ALTER TABLE f1db.event_teams ADD CONSTRAINT event_teams_FK_1 FOREIGN KEY (event_id) REFERENCES f1db.events(event_id) ON DELETE CASCADE;

CREATE TABLE f1db.team_drivers (
    team_id BIGINT unsigned NOT NULL,
    driver_id BIGINT unsigned NOT NULL,
    CONSTRAINT team_drivers_pk PRIMARY KEY (driver_id,team_id),
    CONSTRAINT team_drivers_FK FOREIGN KEY (driver_id) REFERENCES f1db.drivers(driver_id) ON DELETE CASCADE,
    CONSTRAINT team_drivers_FK_1 FOREIGN KEY (team_id) REFERENCES f1db.teams(team_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
