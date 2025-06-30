package com.sakila.api.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakila.api.dto.CityDto;
import com.sakila.api.entity.CityEntity;
import com.sakila.api.service.CityService;

@RestController
public class CityController {
	private CityService cityService;
	
	// 생성자로 주입
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	// 한 행 조회
	@GetMapping("/cityOne/{cityId}")
	public ResponseEntity<CityEntity> cityOne(@PathVariable int cityId){
		return new ResponseEntity<CityEntity>(cityService.findById(cityId),HttpStatus.OK);
	}
	
	// 조회
	@GetMapping("/city")
	public ResponseEntity<List<CityEntity>> city(){
		return new ResponseEntity<List<CityEntity>>(cityService.findAll(), HttpStatus.OK);
	}
	
	// 입력
	@PostMapping("/city")
	public ResponseEntity<String> city(@RequestBody CityDto cityDto){
		
		cityService.save(cityDto);
		return new ResponseEntity<String>("입력성공",HttpStatus.OK);
	}
	
	// 수정
	@PatchMapping("/city")
	public ResponseEntity<String> updateCity(@RequestBody CityDto cityDto){
		cityService.update(cityDto);
		
		return new ResponseEntity<String>("수정성공",HttpStatus.OK);
	}
	
	// 삭제
	@DeleteMapping("/city/{cityId}")
	public ResponseEntity<String> deleteCity(@PathVariable int cityId){
		if(cityService.delete(cityId)) {
			return new ResponseEntity<String>("삭제성공",HttpStatus.OK);
		}
		return new ResponseEntity<String>("삭제실패",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}