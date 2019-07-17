package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import entity.User;
import mapper.UserMapper;
import service.prototype.IUserService;

/**
 * 用户业务实现类
 * @author RanJi
 *
 */
@Service
public class UserServiceDaoImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;		//-- userDao
	
	@Override  //-- 业务方法
	@Transactional	//-- 加事务处理标注表示是告诉Spring框架该方法需要事务处理的
	public void testTransaction() {
		//-- Step 1
		User u = new User();
		u.setName("999");
		u.setEmail("123@qq.com");
		u.setUname("999");
		u.setPwd("123456");
		userMapper.save(u);
		
		//-- construtor exception
		int i=3/0;
		//-- throw new RuntimeException();
		
		//-- Step 2
		userMapper.deleteUser(10);
	}

	@Override
	public List<User> findUsers(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.findAll();
		return users;
	}

}
