package com.springboot.dogs.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<?> generateResponse(String status, String message, HttpStatus code){
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", status);
            map.put("message", message);
            map.put("code", code.value());

            return new ResponseEntity<Object>(map, code);
    }

}
