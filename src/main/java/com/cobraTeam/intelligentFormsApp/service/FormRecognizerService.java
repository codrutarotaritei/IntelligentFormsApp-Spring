package com.cobraTeam.intelligentFormsApp.service;

import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClient;
import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClientBuilder;
import com.azure.ai.formrecognizer.documentanalysis.models.DocumentKeyValuePair;
import com.azure.ai.formrecognizer.documentanalysis.models.OperationResult;
import com.azure.ai.formrecognizer.implementation.models.AnalyzeResult;
import com.azure.ai.formrecognizer.implementation.models.FieldValue;
import com.azure.ai.formrecognizer.models.FormField;
import com.azure.ai.formrecognizer.models.RecognizedForm;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.polling.SyncPoller;
import com.cobraTeam.intelligentFormsApp.FormRecognizerClientImpl;
import com.cobraTeam.intelligentFormsApp.model.DocumentFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FormRecognizerService {

    private static final String key = "90a341b6264a4d2ea042e108fe0af3c8";
    private static final String endpoint = "https://intelligent-forms-app-recognizer.cognitiveservices.azure.com/";

    @Autowired
    private FormRecognizerClientImpl formRecognizerClientImpl;

    public com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult readDocument(String documentUrl) {

        // create your `DocumentAnalysisClient` instance and `AzureKeyCredential` variable
        DocumentAnalysisClient client = new DocumentAnalysisClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();

        //sample document
        String generalDocumentUrl = documentUrl;
        String modelId = "prebuilt-document";
        SyncPoller<OperationResult, com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult> analyzeDocumentPoller =
                client.beginAnalyzeDocumentFromUrl(modelId, generalDocumentUrl);

        com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult analyzeResult = analyzeDocumentPoller.getFinalResult();

        // pages
        analyzeResult.getPages().forEach(documentPage -> {
            System.out.printf("Page has width: %.2f and height: %.2f, measured with unit: %s%n",
                    documentPage.getWidth(),
                    documentPage.getHeight(),
                    documentPage.getUnit());

            // lines
            documentPage.getLines().forEach(documentLine ->
                    System.out.printf("Line %s is within a bounding polygon %s.%n",
                            documentLine.getContent(),
                            documentLine.getBoundingPolygon().toString()));

            // words
            documentPage.getWords().forEach(documentWord ->
                    System.out.printf("Word %s has a confidence score of %.2f%n.",
                            documentWord.getContent(),
                            documentWord.getConfidence()));
        });

// tables
//        List < DocumentTable > tab_les = analyzeResult.getTables();
//        for (int i = 0; i < tab_les.size(); i++) {
//            DocumentTable documentTable = tab_les.get(i);
//            System.out.printf("Table %d has %d rows and %d columns.%n", i, documentTable.getRowCount(),
//                    documentTable.getColumnCount());
//            documentTable.getCells().forEach(documentTableCell -> {
//                System.out.printf("Cell '%s', has row index %d and column index %d.%n",
//                        documentTableCell.getContent(),
//                        documentTableCell.getRowIndex(), documentTableCell.getColumnIndex());
//            });
//            System.out.println();
//        }

// Key-value pairs
        analyzeResult.getKeyValuePairs().forEach(documentKeyValuePair -> {
            System.out.printf("Key content: %s%n", documentKeyValuePair.getKey().getContent());
            System.out.printf("Key content bounding region: %s%n",
                    documentKeyValuePair.getKey().getBoundingRegions().toString());

            if (documentKeyValuePair.getValue() != null) {
                System.out.printf("Value content: %s%n", documentKeyValuePair.getValue().getContent());
                System.out.printf("Value content bounding region: %s%n", documentKeyValuePair.getValue().getBoundingRegions().toString());
            }
        });
        return analyzeResult;
    }

    private DocumentFields mapAnalyzeResultToFormFields(AnalyzeResult analyzeResult) {
        DocumentFields documentFields = new DocumentFields();
        Map<String, FieldValue> fields = analyzeResult.getDocumentResults().get(0).getFields();
        documentFields.setFirstName(fields.get("First name").getValueString());
        documentFields.setLastName(fields.get("Last name").getValueString());
        documentFields.setAddress(fields.get("Address").getValueString());
        documentFields.setSex(fields.get("Sex").getValueString());
        return documentFields;
    }


//    public DocumentFields recognizeDocument(String documentUrl) {
//        RecognizedForm recognizedForm = formRecognizerClientImpl.recognizeIdentityDocumentFromUrl(documentUrl);
//        DocumentFields documentFields = new DocumentFields();
//        documentFields.setFirstName(recognizedForm.getFields().get("First name").getValue().asString());
//        documentFields.setLastName(recognizedForm.getFields().get("Last name").getValue().asString());
//        documentFields.setSex(recognizedForm.getFields().get("Sex").getValue().asString());
//        documentFields.setAddress(recognizedForm.getFields().get("Address").getValue().asString());
//        return documentFields;
//    }
}