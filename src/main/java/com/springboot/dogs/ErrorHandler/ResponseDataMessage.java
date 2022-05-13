package com.springboot.dogs.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseDataMessage {

    public static ResponseEntity<Object> generateResponse(String message, Object responseObj, HttpStatus status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

}
