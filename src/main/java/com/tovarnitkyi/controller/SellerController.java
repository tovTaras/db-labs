package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.SellerDTO;
import com.tovarnitkyi.mapper.SellerMapper;
import com.tovarnitkyi.model.Seller;
import com.tovarnitkyi.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/seller")
public class SellerController {
    private final SellerService sellerService;

    @GetMapping
    public List<SellerDTO> getAllSeller() {
        return sellerService.getAllSeller().stream().map(SellerMapper::mapSellerToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable("id") Integer id) {
        Seller seller = sellerService.getSellerById(id);
        if (seller == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                SellerMapper.mapSellerToDTO(seller), HttpStatus.OK);
    }

    @PostMapping
    public SellerDTO createSeller(@RequestBody SellerDTO sellerDTO) {
        return SellerMapper.mapSellerToDTO(sellerService.createSeller(sellerDTO));
    }

    @PutMapping
    public ResponseEntity<SellerDTO> updateSeller(@RequestBody SellerDTO sellerDTO) {
        Seller seller = sellerService.getSellerById(sellerDTO.getId());
        if (seller == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                SellerMapper.mapSellerToDTO(sellerService.updateSeller(sellerDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SellerDTO> deleteSeller(@PathVariable("id") Integer id) {
        Seller seller = sellerService.getSellerById(id);
        if (seller == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                SellerMapper.mapSellerToDTO(sellerService.deleteSellerById(id)), HttpStatus.OK
        );
    }

}
