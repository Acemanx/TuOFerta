package com.accenture.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.accenture.model.RegistrarRequest;

@EnableScan
public interface OfertaRepository extends CrudRepository<RegistrarRequest, String> {
	public List<RegistrarRequest> findByFechaFinal(String fechaFinal);
	public List<RegistrarRequest> findByIdnegocio(String idnegocio);
	public RegistrarRequest findById(String id);
}
