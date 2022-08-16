package api.f1season.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.f1season.entities.Drivers;

public interface DriversRepository extends JpaRepository<Drivers, Long>{
	
}
