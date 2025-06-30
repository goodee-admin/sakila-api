package com.sakila.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakila.api.repository.StoreRepository;

@Service
@Transactional
public class StoreService {
	private StoreRepository storeRepository;
	
	public StoreService(StoreRepository storeRepository) {
		// 주입전에 선행작업 or 테스트, ....
		this.storeRepository = storeRepository;
	}
	
}
