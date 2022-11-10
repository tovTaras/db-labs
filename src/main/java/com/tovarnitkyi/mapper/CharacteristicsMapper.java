package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.CharacteristicsDTO;
import com.tovarnitkyi.model.Characteristics;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CharacteristicsMapper {

    public static CharacteristicsDTO mapCharacteristicsToDTO(Characteristics characteristics) {
        return new CharacteristicsDTO(
                characteristics.getId(),
                characteristics.getCar_id(),
                characteristics.getSerial_number(),
                characteristics.getIs_new(),
                characteristics.getEngine(),
                characteristics.getMilage(),
                characteristics.getTank_volume(),
                characteristics.getColor(),
                characteristics.getMaintenance()
        );
    }

    public static Characteristics mapDTOToCharacteristics(CharacteristicsDTO characteristicsDTO) {
        return new Characteristics(
                characteristicsDTO.getId(),
                characteristicsDTO.getCar_id(),
                characteristicsDTO.getSerial_number(),
                characteristicsDTO.getIs_new(),
                characteristicsDTO.getEngine(),
                characteristicsDTO.getMilage(),
                characteristicsDTO.getTank_volume(),
                characteristicsDTO.getColor(),
                characteristicsDTO.getMaintenance()
        );
    }
}