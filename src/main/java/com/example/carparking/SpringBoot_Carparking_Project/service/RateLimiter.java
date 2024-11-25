package com.example.carparking.SpringBoot_Carparking_Project.service;

import com.example.carparking.SpringBoot_Carparking_Project.model.UserRequestInfo;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private final int maxRequestPerMinute;
    private final Map<String, UserRequestInfo> userRequestInfoMap;

    public RateLimiter(int maxRequestPerMinute, Map<String, UserRequestInfo> userRequestInfoMap) {
        this.maxRequestPerMinute = maxRequestPerMinute;
        this.userRequestInfoMap = userRequestInfoMap;
    }

    public boolean isRequestAllowed(String userId){

        long currenTime = System.currentTimeMillis();

        UserRequestInfo userRequestInfo = userRequestInfoMap
                .putIfAbsent(userId, new UserRequestInfo(0, currenTime));

        UserRequestInfo userRequestInfoDetails = userRequestInfoMap.get(userId);

        if(currenTime - userRequestInfoDetails.getTimeStamp() > TimeUnit.MINUTES.toMillis(1)){

            userRequestInfo.setRequestCount(0);
            userRequestInfo.setTimeStamp(currenTime);
        }

        if(userRequestInfoDetails.getRequestCount() < maxRequestPerMinute){
           userRequestInfoDetails.setRequestCount(userRequestInfoDetails.getRequestCount()+1);
           return true;
        }
        return false;
    }
}
