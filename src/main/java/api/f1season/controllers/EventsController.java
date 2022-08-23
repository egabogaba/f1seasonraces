package api.f1season.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.f1season.dto.EventListDto;
import api.f1season.dto.EventsDto;
import api.f1season.services.EventsService;
import api.f1season.utils.AppConstant;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Success"),
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
            @ApiResponse(responseCode = "501", description = "No Implemented") })
    @GetMapping()
    public EventListDto getListEvent(
        @RequestParam(value = "page", defaultValue = AppConstant.PAGE_DEFAULT_VALUE, required = false) Short page,
        @RequestParam(value = "limit", defaultValue = AppConstant.LIMIT_DEFAULT_VALUE, required = false) Byte limit,
        @RequestParam(value = "sortBy", defaultValue = "eventId", required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {

        return eventsService.findAllEvent(page, limit, sortBy, sortDir);
    }

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Success"),
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
            @ApiResponse(responseCode = "501", description = "No Implemented") })
    @GetMapping(params = "eventId")
    public ResponseEntity<EventsDto> getEvent(@PathParam(value = "eventId") Long eventId) {

        return new ResponseEntity<>(eventsService.findEvent(eventId), HttpStatus.OK);
    }

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Success"),
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
            @ApiResponse(responseCode = "501", description = "No Implemented") })
    @PostMapping
    public ResponseEntity<EventsDto> postEvent(@RequestBody EventsDto eventsDto) {

        return new ResponseEntity<>(eventsService.saveEvent(eventsDto), HttpStatus.CREATED);
    }

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Success"),
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
            @ApiResponse(responseCode = "501", description = "No Implemented") })
    @PutMapping
    public ResponseEntity<EventsDto> putEvent(
        @PathParam(value = "eventId") Long eventId,
        @RequestBody EventsDto event
    ) {

        return new ResponseEntity<>(eventsService.putEvent(eventId, event), HttpStatus.OK);
    }

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Success"),
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
            @ApiResponse(responseCode = "501", description = "No Implemented") })
    @PatchMapping
    public ResponseEntity<EventsDto> patchEvent(
        @PathParam(value = "eventId") Long eventId,
        @RequestBody EventsDto event
    ) {

        return new ResponseEntity<>(eventsService.patchEvent(eventId, event), HttpStatus.OK);
    }

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Success"),
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
            @ApiResponse(responseCode = "501", description = "No Implemented") })
    @DeleteMapping
    public ResponseEntity<String> deleteEvent(@PathParam(value = "eventId") Long eventId) {
        eventsService.deleteEvent(eventId);

        return new ResponseEntity<>("The operation was sucess", HttpStatus.NO_CONTENT);
    }
}
