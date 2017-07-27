package mvc.mybatis.dao;

import java.util.List;
import java.util.Map;

import mvc.mybatis.pojo.User;


public interface UserDao {

	public List<User> getUserListByName(String username);
	
	public List<Map<String,String>> userlist();
	
	public void add(User user);
}
