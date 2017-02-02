package com.tinus.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tinus.service.UserReview;

public class UserReviewDaoImpl implements UserReviewDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(UserReview userReview) {
		this.sessionFactory.getCurrentSession().save(userReview);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserReview findUserReviewById(int id) {
		List<UserReview> userReviewList = this.sessionFactory.getCurrentSession()
				.createQuery("FROM UserReview WHERE id = :id").setParameter("id", id).list();
		if (userReviewList.isEmpty()) {
			return null;
		} else {
			return userReviewList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserReview> getAllUserReviewList() {
		List<UserReview> userReviewList = this.sessionFactory.getCurrentSession().createQuery("FROM UserReview").list();
		return userReviewList;
	}

	@Override
	public void update(UserReview userReview) {
		this.sessionFactory.getCurrentSession().update(userReview);
	}

	@Override
	public void deleteAll() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("DELETE FROM UserReview");
		query.executeUpdate();
	}

	@Override
	public void delete(int id) {
		UserReview userReview = findUserReviewById(id);
		if (userReview != null) {
			this.sessionFactory.getCurrentSession().delete(userReview);
		}

	}

}
