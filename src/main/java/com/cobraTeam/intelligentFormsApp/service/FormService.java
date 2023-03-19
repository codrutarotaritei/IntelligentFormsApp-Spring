package com.cobraTeam.intelligentFormsApp.service;

import com.cobraTeam.intelligentFormsApp.entity.Form;
import com.cobraTeam.intelligentFormsApp.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public Mono<Form> saveForm(Form form) {
        return formRepository.save(form);
    }
}
