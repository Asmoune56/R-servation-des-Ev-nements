package com.Reservation.evenements.service;


import com.Reservation.evenements.Mapper.EventMapper;
import com.Reservation.evenements.dto.EventDto;
import com.Reservation.evenements.entity.Evenement;
import com.Reservation.evenements.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    private final EventRepository eventRepository;
    private EventMapper eventMapper;


    @Transactional
    public EventDto AddEvent(EventDto eventDto) {
        return eventMapper.eventToDto(eventRepository.save(eventMapper.dtoToEvent(eventDto)));
    }

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event ->eventMapper.eventToDto(event))
                .toList();
    }

    public EventDto getEventById(Long id){
        return eventRepository.findById(id)
                .map(evenement -> eventMapper.eventToDto(evenement))
                .orElseThrow(()->new RuntimeException("event not found"));
    }

    public EventDto updateEvent(Long id , EventDto eventDto) {
        Evenement ev = eventRepository.findById(id).get();
        ev.setEventname(eventDto.getEventname());
        ev.setType(eventDto.getType());
        ev.setDescription(eventDto.getDescription());

        return eventMapper.eventToDto(eventRepository.save(eventMapper.dtoToEvent(eventDto)));

    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }




}
