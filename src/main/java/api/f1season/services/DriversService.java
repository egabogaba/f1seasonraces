package api.f1season.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.f1season.entities.Drivers;
import api.f1season.repositories.DriversRepository;
@Service
public class DriversService {
	
	@Autowired
	private DriversRepository driversrepository;
	
	public Drivers findDriver(Long driverId) {
		
		return driversrepository
				.findById(driverId)
				.orElse(null);
	}
	
	public List<Drivers> findAllDriver(){
		
		return driversrepository.findAll();
	}
	
	public Drivers saveDriver(Drivers driver) {
		
		return driversrepository.save(driver); 
	}
	
	public Drivers updateDriver(Long driverId, Drivers driver) {
		
		Drivers oldDriver = findDriver(driverId);
		if(oldDriver == null) {
			return new Drivers();
		}
		oldDriver.setDriverName(driver.getDriverName());
		oldDriver.setDriverPoint(driver.getDriverPoint());
		oldDriver.setTeam(driver.getTeam());
		
		return driversrepository.save(oldDriver);
	}
	
	public void deleteDriver(Long driverId) {
		Drivers oldDriver = findDriver(driverId);
		if(oldDriver != null) {
			driversrepository.delete(oldDriver);
		}
	}
}
