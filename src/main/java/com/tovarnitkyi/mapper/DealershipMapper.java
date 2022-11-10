package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.DealershipDTO;
import com.tovarnitkyi.model.Dealership;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DealershipMapper {

    public static DealershipDTO mapDealershipToDTO(Dealership dealership) {
        return new DealershipDTO(
                dealership.getId(),
                dealership.getAdress()
        );
    }

    public static Dealership mapDTOToDealership(DealershipDTO dealershipDTO) {
        return new Dealership(
                dealershipDTO.getId(),
                dealershipDTO.getAdress()
        );
    }
}