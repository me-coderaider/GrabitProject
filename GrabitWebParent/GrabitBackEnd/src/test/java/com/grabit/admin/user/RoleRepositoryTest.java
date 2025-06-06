package com.grabit.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.grabit.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository repo;

	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("admin", "manage everything");
		Role savedRole = repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateRestRoles() {
		Role roleSalesperson=new Role("Salesperson", "manage product prices, customers, shipping, orders and sales report");
		Role roleEditor=new Role("Editor", "manage cateogories, brands, products, articles and menus");
		Role roleShipper=new Role("Shipper", "view products, view orders and update order status");
		Role roleAssistant=new Role("Assistant", "manage questions and reviews");
		
		repo.saveAll(List.of(roleSalesperson, roleEditor,roleShipper,roleAssistant));
	}
}
