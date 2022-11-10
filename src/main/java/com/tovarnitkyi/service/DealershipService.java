package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.DealershipDTO;
import com.tovarnitkyi.mapper.DealershipMapper;
import com.tovarnitkyi.model.Dealership;
import com.tovarnitkyi.repository.DealershipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DealershipService {

    private final DealershipRepository dealershipRepository;

    public List<Dealership> getAllDealership() {
        return dealershipRepository.findAll();
    }

    public Dealership getDealershipById(Integer id) {
        return dealershipRepository.findById(id).orElse(null);
    }

    public Dealership createDealership(DealershipDTO dealershipDTO) {
        return dealershipRepository.save(DealershipMapper.mapDTOToDealership(dealershipDTO));
    }

    public Dealership updateDealership(DealershipDTO dealershipDTO) {
        if (getDealershipById(dealershipDTO.getId()) != null) {
            return dealershipRepository.save(DealershipMapper.mapDTOToDealership(dealershipDTO));
        }
        return null;
    }

    public Dealership deleteDealershipById(Integer id) {
        Dealership dealership = getDealershipById(id);
        if (dealership != null) {
            dealershipRepository.deleteById(id);
            return dealership;
        }
        return null;
    }
}