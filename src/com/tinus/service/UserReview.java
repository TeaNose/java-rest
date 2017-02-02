package com.tinus.service;

import java.io.Serializable;

public class UserReview implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8299742764639974281L;

	public UserReview(int id, int orderId, int productId, int userId, float rating, String review, String createdAt,
			String updatedAt) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserReview() {
		super();
	}

	private int id;

	private int orderId;

	private int productId;

	private int userId;

	private float rating;

	private String review;

	private String createdAt;

	private String updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}
