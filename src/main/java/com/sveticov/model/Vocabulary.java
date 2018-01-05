package com.sveticov.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by Sveticov on 1/5/2018.
 */
@Data
public class Vocabulary {

    private String RuVocabulary;
    private String EnVocabulary;

    public Vocabulary() {
    }

    public Vocabulary(String ruVocabulary, String enVocabulary) {
        RuVocabulary = ruVocabulary;
        EnVocabulary = enVocabulary;
    }
}
