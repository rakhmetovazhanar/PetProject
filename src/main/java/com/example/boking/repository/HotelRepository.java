package com.example.boking.repository;

import com.example.boking.model.Hotel;
import com.example.boking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findAll();
    List<Hotel> findByCity(String city);
}
