package com.cobraTeam.intelligentFormsApp.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.cobraTeam.intelligentFormsApp.entity.Form;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends ReactiveCosmosRepository<Form, String> {
}
