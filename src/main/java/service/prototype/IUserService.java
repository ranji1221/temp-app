package service.prototype;

import java.util.List;

import entity.User;

/**
 * 用户业务接口
 * @author RanJi
 *
 */
public interface IUserService {
	void testTransaction();	//-- 演示事务的测试业务方法
	List<User> findUsers(int pageNum, int pageSize);
}
