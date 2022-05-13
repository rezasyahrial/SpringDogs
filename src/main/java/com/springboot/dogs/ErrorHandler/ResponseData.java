package com.springboot.dogs.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseData {

    public static ResponseEntity<Object> generateResponse(String pesan, Object responseObj, HttpStatus code){
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("pesan", pesan);
            map.put("data", responseObj);
            map.put("code", code.value());

            return new ResponseEntity<>(map, code);
    }

}
