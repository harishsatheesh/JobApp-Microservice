package com.harish.reviewms.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    boolean updateReview(Review updatedReview, Long reviewId);
    boolean deleteReviewById(Long reviewId);
    Review getReview(Long reviewId);

}

