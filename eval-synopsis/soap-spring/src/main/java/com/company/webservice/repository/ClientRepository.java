package com.company.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.webservice.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
