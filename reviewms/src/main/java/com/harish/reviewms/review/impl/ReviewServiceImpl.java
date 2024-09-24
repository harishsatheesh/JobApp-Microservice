package com.harish.reviewms.review.impl;

import com.harish.reviewms.review.Review;
import com.harish.reviewms.review.ReviewRepository;
import com.harish.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if (companyId!=null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Review updatedReview,Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review!=null){
            updatedReview.setCompanyId(updatedReview.getCompanyId());
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        if (reviewRepository.existsById(reviewId)){
//            Review review = reviewRepository.findById(reviewId).orElse(null);
//            review.setCompanyId(null);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
}
