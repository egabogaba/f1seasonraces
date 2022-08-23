package api.f1season.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventsDto {
    private Long eventId;

    @NotEmpty
    @Size(min = 8)
    private String eventDescription;

    @NotEmpty
    @Size(min = 2)
    private String eventLocation;

    @NotNull
    private Timestamp eventDate;
}
