package com.grabit.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grabit.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	// for 'Role' as Role is there in 'Common' and we're using it inside 'backend' which is child of 'parentweb' so we'll update parent's pom
	
	
}
