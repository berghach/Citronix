package com.example.Citronix.controllers;

import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping
    public ResponseEntity<List<FarmResponseDTO>> getAllFarms(){
        List<FarmResponseDTO> farmResponseDTOS = farmService.getAll();
        return ResponseEntity.ok(farmResponseDTOS);
    }
}
