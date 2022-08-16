package api.f1season.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import api.f1season.entities.Drivers;
import api.f1season.services.DriversService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("api/v1/drivers")
public class DriversController {
	@Autowired
	private DriversService driversService;
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@GetMapping
	public List<Drivers> getDrivers(@RequestParam(value = "driverId", required = false) Long driverId){
		if(driverId == null) {
			return driversService.findAllDriver();
		}
		List<Drivers> drivers = new ArrayList<>();
		drivers.add(driversService.findDriver(driverId));
		return drivers;
	}
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@PostMapping
	public Drivers postDriver(@RequestBody Drivers driver) {
		System.out.println(driver);
		return driversService.saveDriver(driver);
	}
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@PutMapping
	public Drivers putDrivers(@RequestParam(value = "driverId")Long driverId, @RequestBody Drivers driver) {
		
		return driversService.updateDriver(driverId, driver);
	}
	
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	
	@DeleteMapping
	public void deleteDriver(@RequestParam(value = "driverId") Long driverId) {
		driversService.deleteDriver(driverId);
	}
	
	
}
