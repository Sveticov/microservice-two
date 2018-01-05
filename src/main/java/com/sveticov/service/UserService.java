package com.sveticov.service;

import com.sveticov.model.ThemaEnglish;
import com.sveticov.model.Vocabulary;
import com.sveticov.repository.UserRepository;
import com.sveticov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Sveticov on 1/5/2018.
 */
@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public void test(){
//        Vocabulary vocabulary=new Vocabulary("ru1","en1");
//        ThemaEnglish themaEnglish=new ThemaEnglish("t1",vocabulary);
    //    User user=new User(19,"n1","l1","pas1",themaEnglish);
       // repository.save(user);
    }
}
