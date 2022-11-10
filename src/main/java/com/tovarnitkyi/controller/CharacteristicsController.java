package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.CharacteristicsDTO;
import com.tovarnitkyi.mapper.CharacteristicsMapper;
import com.tovarnitkyi.model.Characteristics;
import com.tovarnitkyi.service.CharacteristicsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/characteristics")
public class CharacteristicsController {
    private final CharacteristicsService characteristicsService;

    @GetMapping
    public List<CharacteristicsDTO> getAllCharacteristics() {
        return characteristicsService.getAllCharacteristics().stream().map(CharacteristicsMapper::mapCharacteristicsToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacteristicsDTO> getCharacteristicsById(@PathVariable("id") Integer id) {
        Characteristics characteristics = characteristicsService.getCharacteristicsById(id);
        if (characteristics == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CharacteristicsMapper.mapCharacteristicsToDTO(characteristics), HttpStatus.OK);
    }

    @PostMapping
    public CharacteristicsDTO createCharacteristics(@RequestBody CharacteristicsDTO characteristicsDTO) {
        return CharacteristicsMapper.mapCharacteristicsToDTO(characteristicsService.createCharacteristics(characteristicsDTO));
    }

    @PutMapping
    public ResponseEntity<CharacteristicsDTO> updateCharacteristics(@RequestBody CharacteristicsDTO characteristicsDTO) {
        Characteristics characteristics = characteristicsService.getCharacteristicsById(characteristicsDTO.getId());
        if (characteristics == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CharacteristicsMapper.mapCharacteristicsToDTO(characteristicsService.updateCharacteristics(characteristicsDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CharacteristicsDTO> deleteCharacteristics(@PathVariable("id") Integer id) {
        Characteristics characteristics = characteristicsService.getCharacteristicsById(id);
        if (characteristics == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CharacteristicsMapper.mapCharacteristicsToDTO(characteristicsService.deleteCharacteristicsById(id)), HttpStatus.OK
        );
    }

}
