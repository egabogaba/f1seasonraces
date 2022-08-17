package api.f1season.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.f1season.entities.Events;
import api.f1season.services.EventsService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

	@Autowired
	private EventsService eventsService;
	
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@GetMapping()
	public List<Events> getEvent(@RequestParam(value = "eventId", required = false) Long eventId) {
		if(eventId == null) {
			return eventsService.findAllEvent();
		}
		List<Events> eventos = new ArrayList<>();
		eventos.add(eventsService.findEvent(eventId));
		return eventos;
	}
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@PostMapping
	public Events postEvent(@RequestBody Events event) {		
		
		return eventsService.saveEvent(event);		
	}
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@PatchMapping
	public Events patchEvent(@PathParam(value = "eventId") Long eventId, @RequestBody Events event) {
		
		return eventsService.updateEvent(eventId, event);		
	}
	@ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "202", description = "Accepted"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "405", description = "Invalid Input"),
                    @ApiResponse(responseCode = "406", description = "Not Acceptable"),
                    @ApiResponse(responseCode = "408", description = "Request Timeout"),
                    @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
                    @ApiResponse(responseCode = "500", description = "Failure"),
                    @ApiResponse(responseCode = "501", description = "No Implemented")})
	@DeleteMapping
	public void deleteEvent(@PathParam(value = "eventId") Long eventId) {
		
		eventsService.deleteEvent(eventId);		
	}
}
