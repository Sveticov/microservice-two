package com.sveticov.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Sveticov on 1/5/2018.
 */
@Document(collection = "thema")
@Data
public class ThemaEnglish {
    @Id
private long idThem;
    private String nameThemaEnglish;
    private List<Vocabulary> vocabularies;

    public ThemaEnglish() {
    }


    public ThemaEnglish(String nameThemaEnglish, List<Vocabulary> vocabularies) {

        this.nameThemaEnglish = nameThemaEnglish;
        this.vocabularies = vocabularies;
    }
}
