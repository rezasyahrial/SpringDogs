package com.springboot.dogs.Service;

import com.springboot.dogs.Model.Dogs;
import com.springboot.dogs.Model.SubBreeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {


    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getBreedsAll(){
        ResponseEntity <String> response = restTemplate.getForEntity("https://dog.ceo/api/breeds/list/all", String.class);
        return response;
    }

    public ResponseEntity<?> getBreedsNotFound(){
        ResponseEntity<?> response = restTemplate.getForEntity("https://dog.ceo/api/breeds/", String.class);
        return response;
    }

    public ResponseEntity<String> getRandomImageByBreeds(){
        ResponseEntity <String> response = restTemplate.getForEntity("https://dog.ceo/api/breed/hound/images", String.class);
        return response;
    }

    public ResponseEntity<String> getBySubBreeds(){
        ResponseEntity<String> response = restTemplate.getForEntity("https://dog.ceo/api/breed/hound/list", String.class);
        return response;
    }

    public ResponseEntity<SubBreeds> getBreedsAllWithStatus(){
        SubBreeds subBreeds = restTemplate.getForObject("https://dog.ceo/api/breeds/list/all", SubBreeds.class);
        return ResponseEntity.ok(subBreeds);
    }

    public ResponseEntity<?> getBreedsAllWithStatus1(){
        Object result = restTemplate.getForObject("https://dog.ceo/api/breeds/list/all", Object.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> getBreedsAllWithStatus3(ResponseEntity<?> object){
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public Object getBreedsAllWithObject(){
        Object result = restTemplate.getForObject("https://dog.ceo/api/breeds/list/all", Object.class);
        return result;
    }

    public Object getBreedsAllWithObjectBreeds(){
        Object result = restTemplate.getForObject("https://dog.ceo/api/breed/hound/list", Object.class);
        return result;
    }
}
