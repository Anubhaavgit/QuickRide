package com.comrade.QuickRide.dao;

import com.comrade.QuickRide.entities.CabDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<CabDriver, Integer> {
}
