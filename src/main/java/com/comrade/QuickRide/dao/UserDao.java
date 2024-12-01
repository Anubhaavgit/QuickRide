package com.comrade.QuickRide.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comrade.QuickRide.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
