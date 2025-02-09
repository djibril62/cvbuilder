package com.cvbuilder.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CV {

    @Id
    private String id;

    private String nom;
    private String email;
    private String telephone;

    private List<String> competences;
    private List<String> experiences;
    private List<String> formations;
}
