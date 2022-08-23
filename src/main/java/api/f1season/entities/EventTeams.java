package api.f1season.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event_teams")
public class EventTeams {

	@Id
	@Column(name = "event_id")
	private Long eventId;
	
	@Column(name = "team_id")
	private Long teamId;

	@Column(name = "team_points")
	private Long teamPoints;
}
