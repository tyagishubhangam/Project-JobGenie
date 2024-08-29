package com.jobgenie.myjobapp.reviews;

import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewsService {
    public List<Reviews> getAllReviews(Long companyId);
    public boolean addReview(Long companyId, Reviews reviews);
    public Reviews getReview(Long companyId, Long reviewId);
    public boolean updateReview(Long companyId, Long reviewId, Reviews reviews);
    public boolean deleteReview(Long companyId, Long reviewId);

}
