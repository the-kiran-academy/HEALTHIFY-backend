package com.healthify.api.serviceimpl;

import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.security.CustomUserDetail;
import com.healthify.api.service.UserService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao dao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired(required = false)
	private Date createdDate;
	
	@Value("${user.roles}")
	private String[] roles;

	@Override
	public boolean addUser(User user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user.setCreatedDate(createdDate);
		return dao.addUser(user);
		
	}

	@Override
	public User loginUser(User user) {

		return dao.loginUser(user);
	}

	@Override
	public CustomUserDetail loadUserByUserId(String userId) {
		return dao.loadUserByUserId(userId);
	}

	@Override
	public boolean deleteUserById(String id) {
		return false;
	}

	@Override
	public User getUserById(String id) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public Long getUsersTotalCounts() {
		return dao.getUsersTotalCounts();
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		return null;
	}

	@Override
	public Long getUserCountByDateAndType(Date registereddate, String type) {
		Long count = dao.getUserCountByDateAndType(registereddate, type);
		return count;
	}

	@Override
	public List<User> getUserByFirstName(String firstName) 
	{
		return dao.getUserByFirstName(firstName);	
		}

	@Override
	public Role addRole(Role role) {
		return role;

		

	}

	@Override
	public Role getRoleById(int roleId) {

		return null;
	}

	@Override
	public String generateReport() {
		return null;
	}

}
