package api.f1season.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.f1season.entities.EventDrivers;

public interface EventDriversRepostory extends JpaRepository<EventDrivers, Long>{
	
	List<EventDrivers> findByDriverId(Long driverId);
}
