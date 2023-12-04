package com.example.boking.service;

import com.example.boking.exception.HotelException;
import com.example.boking.model.Hotel;
import com.example.boking.repository.HotelRepository;
import com.example.boking.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;}

    public List<Hotel> findAllHotel() {
        return hotelRepository.findAll();
    }
    public List<Hotel> findByCity(String city) {
        try {
            log.info("Trying to find hotel by city: {}", city);
            return hotelRepository.findByCity(city);
        } catch (Exception ex) {
            log.error("Error with searching hotel");
            throw new HotelException("Hotel not found", ex);
        }
    }
}
