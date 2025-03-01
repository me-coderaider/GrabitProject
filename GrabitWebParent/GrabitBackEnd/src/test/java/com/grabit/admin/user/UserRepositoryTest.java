package com.grabit.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.grabit.common.entity.Role;
import com.grabit.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	public UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Role roleAdmin=entityManager.find(Role.class , 1);
		User usertest=new User("test.user@testmail.com","test123","Test","User");
		usertest.addRole(roleAdmin);
		
		User savedUser=repo.save(usertest);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		User userJohn=new User("test.john@testemail.com","john123","Test","John");
		Role roleEditor=new Role(3);
		Role roleAssistant=new Role(5);
		userJohn.addRole(roleEditor);
		userJohn.addRole(roleAssistant);
		
		User savedUser=repo.save(userJohn);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers=repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
		
	}
	
	@Test
	public void testGetUserById() {
		User testUser=repo.findById(1).get();
		System.out.println(testUser);
		assertThat(testUser).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		User testUser=repo.findById(1).get();
		testUser.setEnabled(true);
		testUser.setEmail("newtestuser@email.com");
		repo.save(testUser);
	}
	
	@Test
	public void testUpdateUserRoles() {
		User johnUser=repo.findById(3).get();
		Role roleEditor=new Role(3);
		Role roleSalesperson=new Role(2);
		johnUser.getRoles().remove(roleEditor);
		johnUser.addRole(roleSalesperson);
		
		repo.save(johnUser);
		
		
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId=3;
		repo.deleteById(userId);
	}
	
}
