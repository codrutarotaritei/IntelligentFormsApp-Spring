package com.cobraTeam.intelligentFormsApp.controller;

import com.cobraTeam.intelligentFormsApp.entity.Form;
import com.cobraTeam.intelligentFormsApp.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/create-form")
    public Mono<ResponseEntity<Form>> saveForm(@RequestBody Form form) {
        return formService.saveForm(form)
                .map(savedForm -> ResponseEntity.ok().body(savedForm))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }
}
