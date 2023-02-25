
package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Otp;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.security.CustomUserDetail;

@Repository
public class UserDaoImpl implements UserDao {
	private static Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	public boolean addUser(User user) {
		Session session = sf.getCurrentSession();
		boolean isAdded=false;
		
		try {
		User usr=session.get(User.class,user.getUsername());
		if (usr==null) {
			session.save(user);
			isAdded=true;
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public User loginUser(User user) {
		Session session = sf.getCurrentSession();
		User usr = null;
		try {
			usr = session.get(User.class, user.getUsername());
			boolean matches = passwordEncoder.matches(user.getPassword(), usr.getPassword());
			if (matches) {
				return usr;
			} else {
				usr = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usr;
	}

	@Override
	public CustomUserDetail loadUserByUserId(String userId) {
		Session session = sf.getCurrentSession();
		CustomUserDetail user = new CustomUserDetail();
		User usr = null;
		try {
			usr = session.get(User.class, userId);
			if (usr != null) {
				user.setUserid(usr.getUsername());
				user.setPassword(usr.getPassword());
				user.setRoles(usr.getRoles());
			}
			System.out.println("dao ..." + user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean deleteUserById(String id) {
		return false;
	}

	@Override
	public User getUserById(String id) {
		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> getAllUsers() {
		List<User> list=null;
		try {
			Session session=sf.getCurrentSession();
			Criteria criteria=session.createCriteria(User.class);
			list=criteria.list();
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public Long getUsersTotalCounts() {
		Session session = sf.getCurrentSession();
		long count=0;
		try {
			Criteria criteria = session.createCriteria(User.class);
			List<User>list=criteria.list();
			count=list.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		return null;
	}

	@Override
	public Long getUserCountByDateAndType(Date registeredDate, String type) {
		Session session = sf.getCurrentSession();
		long count=0;
		
		try {

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery query = criteriaBuilder.createQuery();
			Root<User> root = query.from(User.class);
			query.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("type"), type),
					criteriaBuilder.equal(root.get("createdDate"), registeredDate)));
			
			Query<Object> createQuery = session.createQuery(query);
			List<Object> resultList = createQuery.getResultList();
			count=resultList.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<User> getUserByFirstName(String firstname) {
		Session session=sf.getCurrentSession();
		List<User> list=null;
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
			Root<User> root=query.from(User.class);
			query.select(root).where(criteriaBuilder.equal(root.get("firstname"),firstname));
			list=session.createQuery(query).getResultList();
			} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	@Override
	public boolean saveOtp(Otp otp) {
		return false;
	}

	@Override
	public Otp getOtpByUser(String userId) {
		return null;
	}

	@Override
	public Role addRole(Role role) {
		return null;
	}

	@Override
	public Role getRoleById(int roleId) {
		return null;
	}

}