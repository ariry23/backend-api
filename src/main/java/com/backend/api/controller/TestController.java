/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pcg29
 */
@RequestMapping("test")
@RestController
public class TestController {
    @GetMapping("/divide")
    public ResponseEntity<?> divide()
    {
        int x = 100 / 0 ; 
        return new ResponseEntity(x , HttpStatus.OK) ; 
    }
}
