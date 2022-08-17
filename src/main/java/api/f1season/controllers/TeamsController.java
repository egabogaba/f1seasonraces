package api.f1season.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.f1season.entities.Teams;
import api.f1season.services.TeamsService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {
	
	@Autowired
	private TeamsService teamsService;
	
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
	
	@GetMapping(params = "teamId")
	public Object getTeam(@PathParam(value = "teamId") Long teamId) {
		
		if (teamId == null) {
			return teamsService.findAllTeam();
		}
		
		return teamsService.findTeam(teamId);
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
	public Teams postTeam(@RequestBody Teams team) {		
		
		return teamsService.saveTeam(team);		
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
	public Teams putTeam(@PathParam(value = "teamId") Long teamId, @RequestBody Teams team) {
		
		return teamsService.updateEvent(teamId, team);		
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
	public void deleteEvent(@PathParam(value = "teamId") Long teamId) {
		
		teamsService.deleteTeam(teamId);		
	}

}
