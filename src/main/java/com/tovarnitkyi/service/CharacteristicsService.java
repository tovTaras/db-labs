package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.CharacteristicsDTO;
import com.tovarnitkyi.mapper.CharacteristicsMapper;
import com.tovarnitkyi.model.Characteristics;
import com.tovarnitkyi.repository.CharacteristicsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CharacteristicsService {

    private final CharacteristicsRepository characteristicsRepository;

    public List<Characteristics> getAllCharacteristics() {
        return characteristicsRepository.findAll();
    }

    public Characteristics getCharacteristicsById(Integer id) {
        return characteristicsRepository.findById(id).orElse(null);
    }

    public Characteristics createCharacteristics(CharacteristicsDTO characteristicsDTO) {
        return characteristicsRepository.save(CharacteristicsMapper.mapDTOToCharacteristics(characteristicsDTO));
    }

    public Characteristics updateCharacteristics(CharacteristicsDTO characteristicsDTO) {
        if (getCharacteristicsById(characteristicsDTO.getId()) != null) {
            return characteristicsRepository.save(CharacteristicsMapper.mapDTOToCharacteristics(characteristicsDTO));
        }
        return null;
    }

    public Characteristics deleteCharacteristicsById(Integer id) {
        Characteristics characteristics = getCharacteristicsById(id);
        if (characteristics != null) {
            characteristicsRepository.deleteById(id);
            return characteristics;
        }
        return null;
    }
}
