package com.Reservation.evenements.controllers;

import com.Reservation.evenements.dto.EventDto;
import com.Reservation.evenements.dto.EventMapper;
import com.Reservation.evenements.entity.EventCategory;
import com.Reservation.evenements.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents()
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        Optional<EventDto> optional = eventService.getEventById(id)
                .map(eventMapper::toDto);

        return optional.orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto dto) {
        return eventMapper.toDto(eventService.saveEvent(eventMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/category/{category}")
    public List<EventDto> getByCategory(@PathVariable EventCategory category) {
        return eventService.getEventsByCategory(category)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/location/{location}")
    public List<EventDto> getByLocation(@PathVariable String location) {
        return eventService.getEventsByLocation(location)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/date/{date}")
    public List<EventDto> getByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return eventService.getEventsByDate(localDate)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }
}
