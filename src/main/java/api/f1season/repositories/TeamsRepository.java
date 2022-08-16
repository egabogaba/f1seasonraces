package api.f1season.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.f1season.entities.Teams;

public interface TeamsRepository extends JpaRepository<Teams, Long> {

}
