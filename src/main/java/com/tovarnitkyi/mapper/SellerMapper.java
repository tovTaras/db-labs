package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.SellerDTO;
import com.tovarnitkyi.model.Seller;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SellerMapper {

    public static SellerDTO mapSellerToDTO(Seller seller) {
        return new SellerDTO(
                seller.getId(),
                seller.getFirst_name(),
                seller.getLast_name(),
                seller.getCell_phone(),
                seller.getEmail(),
                seller.getAdress()
        );
    }

    public static Seller mapDTOToSeller(SellerDTO sellerDTO) {
        return new Seller(
                sellerDTO.getId(),
                sellerDTO.getFirst_name(),
                sellerDTO.getLast_name(),
                sellerDTO.getCell_phone(),
                sellerDTO.getEmail(),
                sellerDTO.getAdress()
        );
    }
}