package com.geeks4geeks.spring.mongo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iUserRepo extends MongoRepository<User,Object> {
//	         Paging and Sorting Repo requires a primary key. in order to have compatibility to properly extend the repo, give an arbitrary

	@Query("{ age : {$gt : ?0, $lt : ?1}")
//	mongo query : age that is greater than the 0th parameter, and less than the 1st parameter, found in the method signature below.
	List<User> getUsersByAge(int min, int max);

}
