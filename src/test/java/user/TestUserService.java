package user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;

import config.TestConfig;
import entity.User;
import service.prototype.IUserService;

/**
 * UserService测试
 * @author RanJi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestUserService {
	@Autowired
	private IUserService userService;
	
	@Test
	public void testTransaction(){
		userService.testTransaction();
	}
	
	@Test
	public void testFindPage(){
		List<User> users = userService.findUsers(12432, 5);
		for (User user : users) {
			System.out.println(user);
		}
		//-- 总页数
		int totalPages = ((Page<User>)users).getPages();
		System.out.println(totalPages);
		long totalItems = ((Page<User>)users).getTotal();
		System.out.println(totalItems);
	}
}
