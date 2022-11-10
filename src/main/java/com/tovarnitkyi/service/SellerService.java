package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.SellerDTO;
import com.tovarnitkyi.mapper.SellerMapper;
import com.tovarnitkyi.model.Seller;
import com.tovarnitkyi.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(Integer id) {
        return sellerRepository.findById(id).orElse(null);
    }

    public Seller createSeller(SellerDTO sellerDTO) {
        return sellerRepository.save(SellerMapper.mapDTOToSeller(sellerDTO));
    }

    public Seller updateSeller(SellerDTO sellerDTO) {
        if (getSellerById(sellerDTO.getId()) != null) {
            return sellerRepository.save(SellerMapper.mapDTOToSeller(sellerDTO));
        }
        return null;
    }

    public Seller deleteSellerById(Integer id) {
        Seller seller = getSellerById(id);
        if (seller != null) {
            sellerRepository.deleteById(id);
            return seller;
        }
        return null;
    }
}