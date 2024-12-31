package com.sirius1b.auth;

import com.sirius1b.auth.models.Role;
import com.sirius1b.auth.models.User;
import com.sirius1b.auth.repos.RoleRepository;
import com.sirius1b.auth.repos.TokenRepository;
import com.sirius1b.auth.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

@SpringBootTest
class LldApplicationTests {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void addTestRole(){
		Role admin = new Role();
		admin.setValue("ADMIN");

		roleRepository.save(admin);

		Role user = new Role();
		user.setValue("USER");
		roleRepository.save(user);
	}

	@Test
	public void addTestUser(){
		Role admin =
		roleRepository.findByValue("ADMIN").orElse(null);

		User adminUser = new User();
		adminUser.setName("admin");
		adminUser.setEmail("admin@admin.com");
		adminUser.setHashedPassword(encoder.encode("password"));
		adminUser.setRoles(Collections.singletonList(admin));
		userRepository.save(adminUser);


	}
}
