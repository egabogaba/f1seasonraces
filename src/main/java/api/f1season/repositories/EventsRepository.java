package api.f1season.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.f1season.entities.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {

}
