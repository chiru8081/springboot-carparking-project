package com.example.carparking.SpringBoot_Carparking_Project.controller;

import com.example.carparking.SpringBoot_Carparking_Project.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/{userId}")
    public String checkingAvailability(String userId){
        String slot = parkingService.checkAvailability(userId);
        return slot;
    }
}
