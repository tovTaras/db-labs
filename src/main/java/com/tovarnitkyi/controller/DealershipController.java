package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.DealershipDTO;
import com.tovarnitkyi.mapper.DealershipMapper;
import com.tovarnitkyi.model.Dealership;
import com.tovarnitkyi.service.DealershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/dealership")
public class DealershipController {
    private final DealershipService dealershipService;

    @GetMapping
    public List<DealershipDTO> getAllDealership() {
        return dealershipService.getAllDealership().stream().map(DealershipMapper::mapDealershipToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<DealershipDTO> getDealershipById(@PathVariable("id") Integer id) {
        Dealership dealership = dealershipService.getDealershipById(id);
        if (dealership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DealershipMapper.mapDealershipToDTO(dealership), HttpStatus.OK);
    }

    @PostMapping
    public DealershipDTO createDealership(@RequestBody DealershipDTO dealershipDTO) {
        return DealershipMapper.mapDealershipToDTO(dealershipService.createDealership(dealershipDTO));
    }

    @PutMapping
    public ResponseEntity<DealershipDTO> updateDealership(@RequestBody DealershipDTO dealershipDTO) {
        Dealership dealership = dealershipService.getDealershipById(dealershipDTO.getId());
        if (dealership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DealershipMapper.mapDealershipToDTO(dealershipService.updateDealership(dealershipDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DealershipDTO> deleteDealership(@PathVariable("id") Integer id) {
        Dealership dealership = dealershipService.getDealershipById(id);
        if (dealership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DealershipMapper.mapDealershipToDTO(dealershipService.deleteDealershipById(id)), HttpStatus.OK
        );
    }

}
