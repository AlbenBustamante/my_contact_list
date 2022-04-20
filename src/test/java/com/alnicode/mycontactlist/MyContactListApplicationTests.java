package com.alnicode.mycontactlist;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.alnicode.mycontactlist.entity.User;
import com.alnicode.mycontactlist.repository.IUserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MyContactListApplicationTests {
	@Autowired
	private IUserRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	@Test
	void contextLoads() {
		var user = new User();
		user.setUsername("my_admin");
		user.setPassword(this.encoder.encode("adminroot123"));
		user.setRole("USER");
		assertNotNull(this.repository.save(user));
	}

}
