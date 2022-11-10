package com.tovarnitkyi.repository;

import com.tovarnitkyi.model.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristics, Integer> {
}
