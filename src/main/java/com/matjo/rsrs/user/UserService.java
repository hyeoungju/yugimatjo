package com.matjo.rsrs.user;

public class UserService {
	private UserDao userDao;
	UserDao dao = new UserDao();
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public boolean isValidUser(String userId, String passwd) {
		return userDao.isValidUser(userId, passwd);
	}
	
	public boolean isUserPosition(String userId, String passwd) {
		return userDao.isUserPosition(userId, passwd);
	}
	
	public User getUserId(String grade) {
		return userDao.getUserId(grade);
	}
	
	public boolean isValidUser(String passwd) {
		return false;
	}
	
	public String getGrade(String grade){
	    return dao.findGradeByUserId(grade);
	}
	
}
