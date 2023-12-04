package com.example.boking.controller;

import com.example.boking.service.HotelService;
import com.example.boking.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    Logger logger = LoggerFactory.getLogger(RoomController.class);

    public RoomController(HotelService hotelService, RoomService roomService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Object> getRoomById(@PathVariable Long id) {
//        try {
//            logger.info("Trying to find room by ID: " + id);
//            Room roomById = roomService.findByHotelId(id);
//            logger.info("Found room: " + roomById);
//            return ResponseEntity.ok(roomById);
//        } catch (HotelNotFoundException ex) {
//            logger.error("Room not found: " + ex.getMessage(), ex);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//        } catch (Exception ex) {
//            logger.error("Internal server error: " + ex.getMessage(), ex);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
//        }
//    }

}
