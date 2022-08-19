package api.f1season.entities;

import java.sql.Timestamp;
import java.util.HashSet;
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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	
	@Column(name = "event_description")
	private String eventDescription;
	
	@Column(name = "event_location")
	private String eventLocation;
	
	@Column(name = "event_date")
	private Timestamp eventDate;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "event_drivers",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "driver_id")
	)
	private Set<Drivers> drivers;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "event_teams",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "team_id")
	)
	private Set<Teams> teams = new HashSet<>();
}
