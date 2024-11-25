package com.example.carparking.SpringBoot_Carparking_Project.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ParkingService {

    private final RateLimiter rateLimiter;

    public ParkingService() {
       this.rateLimiter = new RateLimiter(5, new HashMap<>());
    }

    public String checkAvailability(String userId){
        if(rateLimiter.isRequestAllowed(userId)){
            return "Parking spot Avaliable";
        }else{
            return "Rate limiter exceeded...Please try again later";
        }
    }
}
