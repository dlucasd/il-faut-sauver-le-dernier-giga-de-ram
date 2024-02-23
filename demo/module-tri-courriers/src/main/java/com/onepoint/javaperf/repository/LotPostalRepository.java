package com.onepoint.javaperf.repository;

import com.onepoint.javaperf.entity.LotPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotPostalRepository extends JpaRepository<LotPostal, Long> {

}
