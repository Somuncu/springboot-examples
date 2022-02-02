package com.example.exceptionhandler.controller;

import com.example.exceptionhandler.entity.Bread;
import com.example.exceptionhandler.error.ErrorResponse;
import com.example.exceptionhandler.error.model.ErrorModel;
import com.example.exceptionhandler.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    @GetMapping("/getBread")
    public ResponseEntity<String> getBread(@Valid @RequestBody Bread bread){
        return new ResponseEntity<>(exceptionService.getMessage(bread), HttpStatus.OK);
    }

    @PostMapping("/setBread")
    public ResponseEntity<Bread> setBread(@Valid @RequestBody Bread bread){
        return new ResponseEntity<>(exceptionService.setBread(bread), HttpStatus.OK);
    }

    /**
     * Method that check against {@code @Valid} Objects passed to controller endpoints
     *
     * @param exception
     * @return a {@code ErrorResponse}
     * @see com.example.exceptionhandler.error.ErrorResponse
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {

        List<ErrorModel> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErrorModel(err.getField(), err.getRejectedValue(), err.getDefaultMessage()))
                .distinct()
                .collect(Collectors.toList());
        return ErrorResponse.builder().errorMessage(errorMessages).build();
    }

}
