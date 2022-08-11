package api.f1season.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.f1season.entities.Events;
import api.f1season.repositories.EventsRepository;

@Service
public class EventsService {

	@Autowired
	private EventsRepository eventsRepository;
	
	public Events findEvent(Long eventId) {
		
		return eventsRepository
			.findById(eventId)
			.orElse(null);
	}
	
	public List<Events> findAllEvent() {
		
		return eventsRepository.findAll();
	}
	
	public Events saveEvent(Events event) {
		
		return eventsRepository.save(event);		
	}
	
	public Events updateEvent(Long eventId, Events event) {
		
		Events oldEvent = findEvent(eventId);
		
		if (oldEvent == null) {
			return new Events();
		}
		
		oldEvent.setEventLocation(event.getEventLocation());
		oldEvent.setEventDescription(event.getEventDescription());
		oldEvent.setEventDate(event.getEventDate());
		
		return eventsRepository.save(oldEvent);
	}

	public void deleteEvent(Long eventId) {
		Events oldEvent = findEvent(eventId);
		
		if (oldEvent != null) {
			eventsRepository.delete(oldEvent);
		}		
	}
}


