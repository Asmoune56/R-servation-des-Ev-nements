package com.Reservation.evenements.controllers;


import com.Reservation.evenements.dto.EventDto;
import com.Reservation.evenements.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public EventService eventService;

    @PostMapping("/addEvent")
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        return eventService.AddEvent(eventDto);
    }
    @GetMapping("/allEvents")
    public List<EventDto> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/event/{id}")
    public EventDto getEventById(@PathVariable Long id ) {
        return  eventService.getEventById(id);
    }
    @PutMapping("/event/{id}")
    public EventDto updatEvent(@PathVariable Long id ,@RequestBody EventDto eventDto) {
        return eventService.updateEvent(id,eventDto);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable Long id ) {
        eventService.deleteEvent(id);
    }




}


