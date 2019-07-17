package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.User;

/**
 * 和UserDao类似
 * @author RanJi
 *
 */
public interface UserMapper {
	//@Insert("insert into t_user(name,email,uname,pwd) values(#{name},#{email},#{uname},#{pwd})")
	void save(User user);
	void deleteUser(int id);
	@Select("select * from t_user where id=#{id}")
	User findUser(int id);
	
	@Select("select * from t_user")
	List<User> findAll(); 
}
