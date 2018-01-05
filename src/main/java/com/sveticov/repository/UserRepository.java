package com.sveticov.repository;

import com.sveticov.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Sveticov on 1/5/2018.
 */
public interface UserRepository extends MongoRepository<User,Long> {
}
