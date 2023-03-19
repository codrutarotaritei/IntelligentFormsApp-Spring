package com.cobraTeam.intelligentFormsApp;

import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClient;
import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClientBuilder;
import com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult;
import com.azure.ai.formrecognizer.documentanalysis.models.OperationResult;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.polling.SyncPoller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@CrossOrigin(origins = "*")
public class IntelligentFormsAppApplication {

//	//use your `key` and `endpoint` environment variables
//	private static final String key = "90a341b6264a4d2ea042e108fe0af3c8";
//	private static final String endpoint = "https://intelligent-forms-app-recognizer.cognitiveservices.azure.com/";

	public static void main(String[] args) {
		SpringApplication.run(IntelligentFormsAppApplication.class, args);

//		// create your `DocumentAnalysisClient` instance and `AzureKeyCredential` variable
//		DocumentAnalysisClient client = new DocumentAnalysisClientBuilder()
//				.credential(new AzureKeyCredential(key))
//				.endpoint(endpoint)
//				.buildClient();
//
//		//sample document
//		String generalDocumentUrl = "https://www.shtiu.ro/wp-content/uploads/2023/01/63653f0f3c33d_bradd-pitt.jpg";
//		String modelId = "prebuilt-document";
//		SyncPoller<OperationResult, AnalyzeResult> analyzeDocumentPoller =
//				client.beginAnalyzeDocumentFromUrl(modelId, generalDocumentUrl);
//
//		AnalyzeResult analyzeResult = analyzeDocumentPoller.getFinalResult();
//
//		// pages
//		analyzeResult.getPages().forEach(documentPage -> {
//			System.out.printf("Page has width: %.2f and height: %.2f, measured with unit: %s%n",
//					documentPage.getWidth(),
//					documentPage.getHeight(),
//					documentPage.getUnit());
//
//			// lines
//			documentPage.getLines().forEach(documentLine ->
//					System.out.printf("Line %s is within a bounding polygon %s.%n",
//							documentLine.getContent(),
//							documentLine.getBoundingPolygon().toString()));
//
//			// words
//			documentPage.getWords().forEach(documentWord ->
//					System.out.printf("Word %s has a confidence score of %.2f%n.",
//							documentWord.getContent(),
//							documentWord.getConfidence()));
//		});
//
//// tables
////        List < DocumentTable > tab_les = analyzeResult.getTables();
////        for (int i = 0; i < tab_les.size(); i++) {
////            DocumentTable documentTable = tab_les.get(i);
////            System.out.printf("Table %d has %d rows and %d columns.%n", i, documentTable.getRowCount(),
////                    documentTable.getColumnCount());
////            documentTable.getCells().forEach(documentTableCell -> {
////                System.out.printf("Cell '%s', has row index %d and column index %d.%n",
////                        documentTableCell.getContent(),
////                        documentTableCell.getRowIndex(), documentTableCell.getColumnIndex());
////            });
////            System.out.println();
////        }
//
//// Key-value pairs
//		analyzeResult.getKeyValuePairs().forEach(documentKeyValuePair -> {
//			System.out.printf("Key content: %s%n", documentKeyValuePair.getKey().getContent());
//			System.out.printf("Key content bounding region: %s%n",
//					documentKeyValuePair.getKey().getBoundingRegions().toString());
//
//			if (documentKeyValuePair.getValue() != null) {
//				System.out.printf("Value content: %s%n", documentKeyValuePair.getValue().getContent());
//				System.out.printf("Value content bounding region: %s%n", documentKeyValuePair.getValue().getBoundingRegions().toString());
//			}
//		});
	}
}