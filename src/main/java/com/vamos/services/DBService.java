package com.vamos.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.models.Motorista;
import com.vamos.repositories.MotoristaRepository;

@Service
public class DBService {
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public void instantiateDataBase() {
		
		Motorista motorista1 = new Motorista(null,"08/03/1997","koji097@gmail.com","123");
		motoristaRepository.saveAll(Arrays.asList(motorista1));
	}

}
