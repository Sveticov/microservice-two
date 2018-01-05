package com.sveticov.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Sveticov on 1/5/2018.
 */
@Data
public class User {
    @Id
    private long idUser;
    private String nameUser;
    private String lastNameUser;
    private String hashPasswordUser;
    private List<ThemaEnglish> themaEnglishList;

    public User() {
    }


    public User(long idUser, String nameUser, String lastNameUser, String hashPasswordUser, List<ThemaEnglish> themaEnglishList) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.hashPasswordUser = hashPasswordUser;
        this.themaEnglishList = themaEnglishList;
    }
}
