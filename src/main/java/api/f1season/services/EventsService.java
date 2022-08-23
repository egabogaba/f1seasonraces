package api.f1season.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import api.f1season.dto.EventListDto;
import api.f1season.dto.EventsDto;
import api.f1season.eceptions.ResourceNotFoundException;
import api.f1season.entities.Events;
import api.f1season.repositories.EventsRepository;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public EventsDto findEvent(Long eventId) {

        Events event = eventsRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Events", "eventId", eventId));

        return mapToEventsDto(event);
    }

    public EventListDto findAllEvent(Short page, Byte limit, String sortBy, String sortDir) {

        Sort sort = Sort.by(sortBy);
        sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(page, limit, sort);

        Page<Events> events = eventsRepository.findAll(pageable);

        List<Events> eventList = events.getContent();
        List<EventsDto> content = eventList.stream().map(x -> mapToEventsDto(x)).toList();

        EventListDto result = new EventListDto();
        result.setContent(content);
        result.setPage((short) events.getNumber());
        result.setLimit((byte) events.getSize());
        result.setTotalItems((short) events.getTotalElements());
        result.setTotalPages((short) events.getTotalPages());
        result.setLast(events.isLast());

        return result;
    }

    public EventsDto saveEvent(EventsDto eventsDto) {
        Events event = eventsRepository.save(mapToEvents(eventsDto));

        return mapToEventsDto(event);
    }

    public EventsDto putEvent(Long eventId, EventsDto eventsDto) {
        Events event = eventsRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Events", "eventId", eventId));

        event = eventsRepository.save(mapToEvents(eventsDto));

        return mapToEventsDto(event);
    }

    public EventsDto patchEvent(Long eventId, EventsDto eventsDto) {
        Events event = eventsRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Events", "eventId", eventId));

        if (eventsDto.getEventDescription() != null && !eventsDto.getEventDescription().isBlank()) {
            event.setEventDescription(eventsDto.getEventDescription());
        }

        if (eventsDto.getEventLocation() != null && !eventsDto.getEventLocation().isBlank()) {
            event.setEventLocation(eventsDto.getEventLocation());
        }

        if (eventsDto.getEventDate() != null) {
            event.setEventDate(eventsDto.getEventDate());
        }

        return mapToEventsDto(eventsRepository.save(event));
    }

    public void deleteEvent(Long eventId) {
        Events event = eventsRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Events", "eventId", eventId));

        eventsRepository.delete(event);
    }

    // Map from entitiy to DTO
    private EventsDto mapToEventsDto(Events event) {
        EventsDto eventsDto = new EventsDto();

        eventsDto.setEventId(event.getEventId());
        eventsDto.setEventDescription(event.getEventDescription());
        eventsDto.setEventLocation(event.getEventLocation());
        eventsDto.setEventDate(event.getEventDate());

        return eventsDto;
    }

    // Map from DTO to Entity
    private Events mapToEvents(EventsDto eventsDto) {

        Events event = new Events();
        event.setEventId(eventsDto.getEventId());
        event.setEventDescription(eventsDto.getEventDescription());
        event.setEventLocation(eventsDto.getEventLocation());
        event.setEventDate(eventsDto.getEventDate());

        return event;
    }
}
