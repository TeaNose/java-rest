package com.tinus.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.tinus.bo.UserReviewBo;
import com.tinus.service.UserReview;

@RestController
public class UserReviewController {
	@Autowired
	private UserReviewBo userReviewBo;

	private static final Logger logger = Logger.getLogger(UserReviewController.class);

	@RequestMapping(value = "/userReview", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserReview>> listAllUserReview() {
		logger.info("----- Get All User Reviews -----");
		List<UserReview> userReviewList = userReviewBo.getAllUserReviewList();
		if (userReviewList.isEmpty()) {
			return new ResponseEntity<List<UserReview>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserReview>>(userReviewList, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/userReview/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserReview> findUserReviewById(@PathVariable("id") int id) {
		logger.info("----- Find User Review By Id: " + id + " -----");
		UserReview userReview = userReviewBo.findUserReviewById(id);

		if (userReview == null) {
			logger.info("----- User Review By Id: " + id + " Is Not Found -----");
			return new ResponseEntity<UserReview>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserReview>(userReview, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/userReview", method = RequestMethod.POST)
	public ResponseEntity<Void> insertUserReview(@RequestBody UserReview userReview,
			UriComponentsBuilder uriComponentsBuilder) {
		logger.info("----- Create User Review " + userReview.getReview() + " -----");
		UserReview userRev = new UserReview(userReview.getId(), userReview.getOrderId(), userReview.getProductId(),
				userReview.getUserId(), userReview.getRating(), userReview.getReview(), userReview.getCreatedAt(),
				userReview.getUpdatedAt());

		try {
			userReviewBo.insert(userRev);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(
					uriComponentsBuilder.path("list-userReview/{id}").buildAndExpand(userRev.getId()).toUri());

			return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/userReview", method = RequestMethod.PUT)
	public ResponseEntity<UserReview> updateUserReview(@RequestBody UserReview userReview) {
		logger.info("----- Update User Review with Id: " + userReview.getId() + " -----");
		UserReview userRev = userReviewBo.findUserReviewById(userReview.getId());

		if (userRev == null) {
			logger.info("----- User Review with Id: " + userReview.getId() + " Is Not Found -----");
			return new ResponseEntity<UserReview>(HttpStatus.NOT_FOUND);
		}
		userReviewBo.update(userRev);
		return new ResponseEntity<UserReview>(userRev, HttpStatus.OK);
	}

	@RequestMapping(value = "/userReview", method = RequestMethod.DELETE)
	public ResponseEntity<UserReview> deleteAllUserReview() {
		logger.info("----- Delete All User Review -----");
		userReviewBo.deleteAll();
		return new ResponseEntity<UserReview>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/userReview/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserReview> deleteUserReviewById(@PathVariable("id") int id) {
		logger.info("----- Delete User Review with Id: " + id + " -----");
		UserReview userRev = userReviewBo.findUserReviewById(id);

		if (userRev == null) {
			logger.info("----- Cannot Delete User Review with Id: " + id + " Is Not Found -----");
			return new ResponseEntity<UserReview>(HttpStatus.NOT_FOUND);
		}
		userReviewBo.delete(id);
		return new ResponseEntity<UserReview>(HttpStatus.NO_CONTENT);
	}
}
