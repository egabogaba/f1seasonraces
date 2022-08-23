package api.f1season.dto;

import java.util.List;

import lombok.Data;

@Data
public class EventListDto {

    private List<EventsDto> content;

    private Short page;

    private Byte limit;

    private Short totalItems;

    private Short totalPages;

    private Boolean last;
}
