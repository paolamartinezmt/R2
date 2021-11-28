package com.cacharrero.repository.crud;
import com.cacharrero.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @ autor Paola Martinez
 *
 **/
public interface UserRepository extends MongoRepository<User, Integer> {



}
