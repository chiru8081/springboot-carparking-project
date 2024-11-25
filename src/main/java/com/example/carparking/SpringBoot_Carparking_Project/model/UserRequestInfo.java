package com.example.carparking.SpringBoot_Carparking_Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestInfo {

    int requestCount;
    long timeStamp;

}
