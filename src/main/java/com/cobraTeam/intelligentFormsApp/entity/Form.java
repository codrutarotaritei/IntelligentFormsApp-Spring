package com.cobraTeam.intelligentFormsApp.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
@Container(containerName = "Form", ru = "400")
public class Form {

    @Id
    @GeneratedValue
    private String id;

    private String title;

    private List<DynamicFields> fields;


    @AllArgsConstructor
    @Setter
    @Getter
    public static class DynamicFields {
        private String label;

        private String placeholder;

        private boolean isMandatory;

        private FieldType fieldType;

    }

    public enum FieldType {
        text, singlechoice
    }
}
