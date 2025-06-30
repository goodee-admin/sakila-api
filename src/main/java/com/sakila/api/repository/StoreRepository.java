package com.sakila.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakila.api.entity.StoreEntiy;

public interface StoreRepository extends JpaRepository<StoreEntiy, Integer> {

}
