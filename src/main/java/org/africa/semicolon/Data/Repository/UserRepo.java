package org.africa.semicolon.Data.Repository;

import org.africa.semicolon.Data.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    User findByUserName(String userName);

}

