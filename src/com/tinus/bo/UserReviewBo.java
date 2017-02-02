package com.tinus.bo;

import java.util.List;

import com.tinus.service.UserReview;

public interface UserReviewBo {
	public void insert(UserReview userReview);

	public UserReview findUserReviewById(int id);

	public List<UserReview> getAllUserReviewList();

	public void update(UserReview userReview);

	public void deleteAll();

	public void delete(int id);
}
