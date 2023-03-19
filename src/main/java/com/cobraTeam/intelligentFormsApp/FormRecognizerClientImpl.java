package com.cobraTeam.intelligentFormsApp;

import com.azure.ai.formrecognizer.FormRecognizerClient;
import com.azure.ai.formrecognizer.FormRecognizerClientBuilder;
import com.azure.ai.formrecognizer.documentanalysis.models.OperationResult;
import com.azure.ai.formrecognizer.models.FormRecognizerException;
import com.azure.ai.formrecognizer.models.FormRecognizerOperationResult;
import com.azure.ai.formrecognizer.models.RecognizeIdentityDocumentOptions;
import com.azure.ai.formrecognizer.models.RecognizedForm;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.ai.formrecognizer.FormRecognizerAsyncClient;
import com.cobraTeam.intelligentFormsApp.service.FormRecognizerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormRecognizerClientImpl {

    private final FormRecognizerClient formRecognizerClient;

    public FormRecognizerClientImpl() {
        formRecognizerClient = new FormRecognizerClientBuilder()
                .endpoint("https://intelligent-forms-app-recognizer.cognitiveservices.azure.com/")
                .credential(new AzureKeyCredential("90a341b6264a4d2ea042e108fe0af3c8"))
                .buildClient();
    }

//    public RecognizedForm recognizeIdentityDocumentFromUrl(String documentUrl) {
//
//        List<RecognizedForm> formList = formRecognizerClient.beginRecognizeContentFromUrl(documentUrl).getFinalResult();
//        return formList.get(0);
//
//    }


}

