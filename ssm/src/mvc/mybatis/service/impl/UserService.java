package mvc.mybatis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mvc.mybatis.dao.UserDao;
import mvc.mybatis.pojo.User;
import mvc.mybatis.service.IUserService;


@Service(value="a123456")
public class UserService implements IUserService {

	@Autowired
	private UserDao dao;
	
	@Override
	@Cacheable
	public List<User> getUserListByName(String username) {
		return dao.getUserListByName(username);
	}

	@Override
	public void addOneUser(User user) {
		dao.add(user);
	}

	@Override
	public List<Map<String, String>> getUserList() {
		
		return dao.userlist();
	}

}
