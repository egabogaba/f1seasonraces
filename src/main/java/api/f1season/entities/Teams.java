package api.f1season.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
public class Teams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;

	@Column(name = "team_name")
	private String teamName;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Set<EventTeams> eventTeams;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "team_drivers",
		joinColumns = @JoinColumn(name = "driver_id"),
		inverseJoinColumns = @JoinColumn(name = "team_id")
	)
	private Set<Drivers> drivers;
}
