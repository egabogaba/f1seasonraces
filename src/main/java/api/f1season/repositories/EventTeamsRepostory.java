package api.f1season.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.f1season.entities.EventDrivers;
import api.f1season.entities.EventTeams;

public interface EventTeamsRepostory extends JpaRepository<EventTeams, Long>{

}
