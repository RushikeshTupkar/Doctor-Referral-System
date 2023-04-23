package com.example.demo.exceptionHandler;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodArgumentNotValidException(MethodArgumentNotValidException ex){
//        String message = ex.getMessage();
        BindingResult result = ex.getBindingResult();
        List<ObjectError> errors = result.getAllErrors();
        Map<String,String>erroersMap = new HashMap<>();
        erroersMap.put("Errors"," :- errors are as follows");
        for(ObjectError e1 : errors){
            String message1 = e1.getDefaultMessage();
            String field = ((FieldError) e1).getField();
            erroersMap.put(field,message1);
        }
        return erroersMap;
    }
    @ExceptionHandler(NotValid.class)
    public String notValid(NotValid ex){
        System.out.println(ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler(NullPointerException.class)
    public HashMap<String , String> nullPointerException(NullPointerException ex){
        HashMap<String,String>map = new HashMap();
        map.put(ex.getMessage(), "-:-");
        map.put("If your symptom is not present in this list. Please consider our apology. We don't have specialist to" +
                " serve you. We yet have to " +
                "expand our specialist Team", "");
        return  map;
    }


}

