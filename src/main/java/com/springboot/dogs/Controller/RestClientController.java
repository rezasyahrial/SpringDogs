package com.springboot.dogs.Controller;

import com.springboot.dogs.ErrorHandler.ResponseData;
import com.springboot.dogs.ErrorHandler.ResponseDataMessage;
import com.springboot.dogs.ErrorHandler.ResponseHandler;
import com.springboot.dogs.Model.Dogs;
import com.springboot.dogs.Service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class RestClientController {

    @Autowired
    private RestClientService service;

    @GetMapping(value = "/breeds")
    public ResponseEntity<String> findAll(){
        return service.getBreedsAll();
    }

    @GetMapping(value = "/breeds/allbreeds")
    public ResponseEntity<?> findBreedsNotFound(){
        try {
            ResponseEntity<?> response = service.getBreedsNotFound();
            return ResponseHandler.generateResponse("success", "Breed Found!", HttpStatus.OK);
        } catch (Exception e){
            return ResponseHandler.generateResponse("error","Breeds not found (master breed does not exist)", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/breeds/random")
    public ResponseEntity<String> findRandomImageByBreeds(){
        return service.getRandomImageByBreeds();
    }

    @GetMapping(value = "breeds/sub")
    public ResponseEntity<String> findBySubBreeds(){
        return service.getBySubBreeds();
    }

    @GetMapping(value = "/breeds/status")
    public ResponseEntity<?> findAllDataWithStatus(){
        try {
            ResponseEntity<?> response = service.getBreedsAllWithStatus1();
            return ResponseData.generateResponse("success", response, HttpStatus.OK);
        } catch (Exception e){
            return ResponseData.generateResponse("error","Breeds not found (master breed does not exist)", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/breeds/object")
    public ResponseEntity<?> findAllDataWithObject(){
        try {
            Object dogs = service.getBreedsAllWithObject();
            return ResponseDataMessage.generateResponse("success", dogs, HttpStatus.OK);
        } catch (Exception e){
            return ResponseData.generateResponse("error","Breeds not found (master breed does not exist)", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/breeds/objectbreeds")
    public ResponseEntity<?> findAllDataWithObjectBreeds(){
        try {
            Object dogs = service.getBreedsAllWithObjectBreeds();
            return ResponseDataMessage.generateResponse("success", dogs, HttpStatus.OK);
        } catch (Exception e){
            return ResponseData.generateResponse("error","Breeds not found (master breed does not exist)", HttpStatus.NOT_FOUND);
        }
    }




}
