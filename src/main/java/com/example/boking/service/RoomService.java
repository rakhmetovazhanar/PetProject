package com.example.boking.service;

import com.example.boking.exception.RoomException;
import com.example.boking.model.Room;
import com.example.boking.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findByHotelId(Long hotelId) {
        try{
            log.info("Trying to find rooms by hotel id: {}", hotelId);
            return roomRepository.findByHotelId(hotelId);
        } catch (Exception ex) {
            log.error("Error with searching room");
            throw new RoomException("Rooms not found", ex);
        }
    }
}
