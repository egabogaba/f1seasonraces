package api.f1season.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import api.f1season.entities.Events;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchEventsDto {
    private Long eventId;

    private String eventDescription;

    private String eventLocation;

    private Timestamp eventDate;
}
