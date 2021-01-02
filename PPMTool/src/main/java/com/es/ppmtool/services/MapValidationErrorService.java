package com.es.ppmtool.services;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    //returns a Response Entity of type map , description : cannot be empty(error.getField(), error.getDefaultMessage()) , if there is
    //an error , if not it returns null .
    public ResponseEntity<?> MapValidationService (BindingResult result){
        if(result.hasErrors()){

            Map<String, String> errorMap = new HashMap<>();
            //intiate Map

            for(FieldError error: result.getFieldErrors()){
                //for loop that goes through the error field
                errorMap.put(error.getField() , error.getDefaultMessage());
                //if there is an error puts the field on one side and the message on the other ,
                //(descritpion: cannot be empty )
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
            //returns the errorMap with all the errorFields and descriptions if any and an HttpStatus.BAD_REQUEST.
        }
        return null ;
    }
}
