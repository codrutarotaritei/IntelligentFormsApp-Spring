package com.cobraTeam.intelligentFormsApp.controller;

import com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult;
import com.cobraTeam.intelligentFormsApp.service.FormRecognizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins = "http://localhost:4200")
public class FormRecognitionController {

    @Autowired
    private FormRecognizerService formRecognizerService;

//    @GetMapping("/recognize-form")
//    public String recognizeForm(@RequestParam("documentUrl") String documentUrl, Model model) {
//        AnalyzeResult analyzeResult = formRecognizerService.readDocument(documentUrl);
//        model.addAttribute("documentFields", analyzeResult);
//        return "result";
//    }

    @PostMapping("/identity-documents")
    public ResponseEntity<AnalyzeResult> recognizeIdentityDocument(@RequestParam("documentUrl") String documentUrl) {
        AnalyzeResult documentFields = formRecognizerService.readDocument(documentUrl);
        return ResponseEntity.ok(documentFields);
    }
}