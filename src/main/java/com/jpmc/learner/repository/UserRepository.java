package com.jpmc.learner.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpmc.learner.models.User;

/**
 * @author cmankala
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 User findByUsername(String userName);
}
