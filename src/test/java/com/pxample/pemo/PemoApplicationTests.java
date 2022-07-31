package com.pxample.pemo;

import com.pxample.pemo.controller.UserController;
import com.pxample.pemo.pojo.model.User;
import com.pxample.pemo.pojo.model.UserResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PemoApplicationTests {

	@Test
	public void testUserResponse() {

		UserController userController = new UserController();
		UserResponse userResponse = userController.getUser(new User("Elsa"));
		Assert.assertEquals(userResponse.getContent(), "Hello, Elsa");
	}

}
