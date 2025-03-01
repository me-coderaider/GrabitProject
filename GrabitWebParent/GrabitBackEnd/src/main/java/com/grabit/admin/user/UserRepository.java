package com.grabit.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grabit.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
