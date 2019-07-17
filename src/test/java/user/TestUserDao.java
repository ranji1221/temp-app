package user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;

import config.TestConfig;
import entity.User;
import mapper.UserMapper;
/**
 * 测试用户Dao
 * @author RanJi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestUserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testAdd(){
		User u = new User();
		u.setName("swwww");
		u.setEmail("123@qq.com");
		u.setUname("swwww");
		u.setPwd("123456");
		userMapper.save(u);
	}
	
	@Test
	public void testDelete(){
		userMapper.deleteUser(6);
	}
	
	@Test
	public void testFind(){
		User u = userMapper.findUser(10);
		System.out.println(u);
	}
	
	@Test
	public void testFindAll(){
		PageHelper.startPage(1, 3);
		List<User> users = userMapper.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
