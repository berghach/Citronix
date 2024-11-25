package com.example.Citronix.controllers;

import com.example.Citronix.dtos.request.FarmRequestDTO;
import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.dtos.response.FieldResponseDTO;
import com.example.Citronix.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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
    @GetMapping("/getFarmById")
    public ResponseEntity<FarmResponseDTO> getFarmById(@Param("farmId") UUID farmId){
        Optional<FarmResponseDTO> farmResponseDTO = farmService.get(farmId);
        return ResponseEntity.of(farmResponseDTO);
    }
    @GetMapping("/getFarm")
    public ResponseEntity<List<FarmResponseDTO>> getFarmByCriteria(@Param("name") String name,
                                                                   @Param("location") String location,
                                                                   @Param("date") LocalDate date)
    {
        System.out.println("get Farm ...");
        System.out.println("criteria prams controller: "+name+ ", "+location+", "+date);

        List<FarmResponseDTO> farmResponseDTOS = farmService.getByCriteria(name, location, date);
        return ResponseEntity.ok(farmResponseDTOS);
    }

    @PostMapping("/add")
    public ResponseEntity<FarmResponseDTO> addFarm(@RequestBody FarmRequestDTO farmRequestDTO){
        FarmResponseDTO farmResponseDTO = farmService.save(farmRequestDTO);
        return ResponseEntity.ok(farmResponseDTO);
    }
    @PutMapping("/edit")
    public ResponseEntity<FarmResponseDTO> editFarm(@Param("farmId") UUID farmId, @RequestBody FarmRequestDTO farmRequestDTO){
        FarmResponseDTO farmResponseDTO = farmService.update(farmRequestDTO, farmId);
        return ResponseEntity.ok(farmResponseDTO);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatusCode> deleteFarm(@Param("farmId") UUID farmId){
        boolean action = farmService.delete(farmId);
        if (action) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
