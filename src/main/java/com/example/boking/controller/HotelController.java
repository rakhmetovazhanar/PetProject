package com.example.boking.controller;

import com.example.boking.model.Hotel;
import com.example.boking.model.Room;
import com.example.boking.service.HotelService;
import com.example.boking.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final RoomService roomService;

    public HotelController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping(value = "/allHotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        log.info("Trying to find all hotels");
        List<Hotel> hotels = hotelService.findAllHotel();
        log.info("Hotels before returning: {}", hotels);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping(value = "/byCity/{city}")
    public ResponseEntity<List<Hotel>> getHotelByCity(@PathVariable  String city) {
            log.info("Requested url: /hotels/byCity/{city}, city = {}, {}",
                    city, new Date());
            List<Hotel> hotelByCity = hotelService.findByCity(city);
            log.info("Found hotels: {}", hotelByCity);
            return ResponseEntity.ok(hotelByCity);
    }

    @GetMapping(value = "/{hotelId}/rooms")
    public ResponseEntity<List<Room>> getRoomsByHotelId(@PathVariable Long hotelId) {
            log.info("Trying to find rooms by hotelID: " + hotelId);
            List<Room> rooms = roomService.findByHotelId(hotelId);
            log.info("Found rooms: {}", rooms);
            return ResponseEntity.ok(rooms);
    }
}
