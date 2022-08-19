package api.f1season.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.f1season.entities.Teams;
import api.f1season.repositories.TeamsRepository;

@Service
public class TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepository;
	
	public Teams findTeam(Long teamId) {
		
		return teamsRepository
			.findById(teamId)
			.orElse(null);
	}
	
	public List<Teams> findAllTeam() {
		
		return teamsRepository.findAll();
	}
	
	public Teams saveTeam(Teams team) {
		
		return teamsRepository.save(team);		
	}
	
	public Teams updateEvent(Long teamId, Teams team) {
		
		Teams oldTeam = findTeam(teamId);
		
		if (oldTeam == null) {
			return new Teams();
		}
		
		oldTeam.setTeamName(team.getTeamName());
		
		return teamsRepository.save(oldTeam);
	}

	public void deleteTeam(Long teamId) {
		Teams oldTeam = findTeam(teamId);
		
		if (oldTeam != null) {
			teamsRepository.delete(oldTeam);
		}		
	}

}
