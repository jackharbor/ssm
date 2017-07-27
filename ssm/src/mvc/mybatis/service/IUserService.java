package mvc.mybatis.service;

import java.util.List;
import java.util.Map;

import mvc.mybatis.pojo.User;

public interface IUserService {

	public List<User> getUserListByName(String username);
	
	public List<Map<String,String>> getUserList();
	
	public void addOneUser(User user);
}