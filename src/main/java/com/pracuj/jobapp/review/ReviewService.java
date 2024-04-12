package com.pracuj.jobapp.review;

import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {

    List<Review> getReviews(Long companyId);
    Review getReview(Long companyId, Long id);
    Review addReview(Long companyId, Review review);
    Review updateReview(Long companyId, Long id, Review review);
    void deleteReview(Long companyId, Long id);

}
