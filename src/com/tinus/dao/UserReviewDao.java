package com.tinus.dao;

import java.util.List;

import com.tinus.service.UserReview;

public interface UserReviewDao {
	public void insert(UserReview userReview);

	public UserReview findUserReviewById(int id);

	public List<UserReview> getAllUserReviewList();

	public void update(UserReview userReview);

	public void deleteAll();

	public void delete(int id);
}
