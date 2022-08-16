package api.f1season.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.f1season.entities.Events;
import api.f1season.entities.Teams;
import api.f1season.services.TeamsService;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {
	
	@Autowired
	private TeamsService teamsService;
	
	@GetMapping
	public List<Teams> getTeam() {
		
		return teamsService.findAllTeam();
	}

	@GetMapping(params = "teamId")
	public Teams getTeam(@PathParam(value = "teamId") Long teamId) {
		
		return teamsService.findTeam(teamId);
	}

	@PostMapping
	public Teams postTeam(@RequestBody Teams team) {		
		
		return teamsService.saveTeam(team);		
	}
	
	@PutMapping
	public Teams putTeam(@PathParam(value = "teamId") Long teamId, @RequestBody Teams team) {
		
		return teamsService.updateEvent(teamId, team);		
	}
	
	@DeleteMapping
	public void deleteEvent(@PathParam(value = "teamId") Long teamId) {
		
		teamsService.deleteTeam(teamId);		
	}

}
