package com.training.RunningTracker.repository;

import com.training.RunningTracker.entity.User;
import org.springframework.stereotype.Repository;;


@Repository
public interface UserRepository extends org.springframework.data.repository.CrudRepository<User, Integer> {
}
