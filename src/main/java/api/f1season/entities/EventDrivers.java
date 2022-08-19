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
@Table(name = "event_drivers")
public class EventDrivers {

	@Id
	@Column(name = "event_id")
	private Long eventId;
	
	@Column(name = "driver_id")
	private Long driverId;

	@Column(name = "driver_points")
	private Long driverPoints;
}
