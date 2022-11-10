package com.tovarnitkyi.repository;

import com.tovarnitkyi.model.Car_has_dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Car_has_dealershipRepository extends JpaRepository<Car_has_dealership, Integer> {
}
