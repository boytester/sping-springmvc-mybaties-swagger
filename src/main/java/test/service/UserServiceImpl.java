package test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import test.IDao.UserTMapper;
import test.domain.UserT;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserTMapper userTMapper;
	
	@Override
	public UserT getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userTMapper.selectByPrimaryKey(userId);
	}
}
 