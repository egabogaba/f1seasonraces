package api.f1season.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.f1season.entities.Events;
import api.f1season.services.EventsService;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

	@Autowired
	private EventsService eventsService;

	@GetMapping
	public List<Events> getEvent() {
		
		return eventsService.findAllEvent();
	}

	@GetMapping(params = "eventId")
	public Events getEvent(@PathParam(value = "eventId") Long eventId) {
		
		return eventsService.findEvent(eventId);
	}

	@PostMapping
	public Events postEvent(@RequestBody Events event) {		
		
		return eventsService.saveEvent(event);		
	}
	
	@PatchMapping
	public Events patchEvent(@PathParam(value = "eventId") Long eventId, @RequestBody Events event) {
		
		return eventsService.updateEvent(eventId, event);		
	}
	
	@DeleteMapping
	public void deleteEvent(@PathParam(value = "eventId") Long eventId) {
		
		eventsService.deleteEvent(eventId);		
	}
}
