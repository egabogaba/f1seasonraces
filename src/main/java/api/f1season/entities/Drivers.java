package api.f1season.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drivers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long driverId;
	
	@Column(name = "team_id")
	private int team;
	
	@Column(name ="driver_name")
	private String driverName;
	
	@Column(name = "driver_point")
	private Double driverPoint;
	
}
