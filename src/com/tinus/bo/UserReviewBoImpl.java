package com.tinus.bo;

import java.util.List;

import com.tinus.dao.UserReviewDao;
import com.tinus.service.UserReview;

public class UserReviewBoImpl implements UserReviewBo {
	private UserReviewDao userReviewDao;

	public UserReviewDao getUserReviewDao() {
		return userReviewDao;
	}

	public void setUserReviewDao(UserReviewDao userReviewDao) {
		this.userReviewDao = userReviewDao;
	}

	@Override
	public void insert(UserReview userReview) {
		userReviewDao.insert(userReview);
	}

	@Override
	public UserReview findUserReviewById(int id) {
		return userReviewDao.findUserReviewById(id);
	}

	@Override
	public List<UserReview> getAllUserReviewList() {
		return userReviewDao.getAllUserReviewList();
	}

	@Override
	public void update(UserReview userReview) {
		userReviewDao.update(userReview);
	}

	@Override
	public void deleteAll() {
		userReviewDao.deleteAll();
	}

	@Override
	public void delete(int id) {
		userReviewDao.delete(id);
	}

}
