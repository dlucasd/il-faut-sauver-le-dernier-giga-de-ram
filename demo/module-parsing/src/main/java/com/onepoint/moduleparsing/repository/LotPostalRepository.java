package com.onepoint.moduleparsing.repository;

import com.onepoint.moduleparsing.entity.LotPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotPostalRepository extends JpaRepository<LotPostal, Long> {

}
