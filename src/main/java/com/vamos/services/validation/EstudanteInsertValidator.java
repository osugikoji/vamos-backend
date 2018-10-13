package com.vamos.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vamos.domain.Estudante;
import com.vamos.domain.Motorista;
import com.vamos.dto.EstudanteNewDTO;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.repositories.MotoristaRepository;
import com.vamos.resources.exception.FieldMessage;

public class EstudanteInsertValidator implements ConstraintValidator<EstudanteInsert, EstudanteNewDTO>  {

	@Autowired
	private EstudanteRepository repository;
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@Override
	public void initialize(EstudanteInsert ann) {
	}

	@Override
	public boolean isValid(EstudanteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Estudante aux = repository.findByEmail(objDto.getEmail());
		if(aux != null)
			list.add(new FieldMessage("email", "Email já existente"));
		
		Motorista aux2 = motoristaRepository.findByEmail(objDto.getEmail());
		if(aux2 != null)
			list.add(new FieldMessage("email", "Email já existente"));
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
