package com.jobgenie.myjobapp.reviews.implementations;

import com.jobgenie.myjobapp.companies.Companies;
import com.jobgenie.myjobapp.companies.CompanyService;
import com.jobgenie.myjobapp.reviews.Reviews;
import com.jobgenie.myjobapp.reviews.ReviewsService;
import com.jobgenie.myjobapp.reviews.repositories.ReviewsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewsRepo reviewsRepo;
    private final CompanyService companyService;


    public ReviewsServiceImpl(ReviewsRepo reviewsRepo, CompanyService companyService) {
        this.reviewsRepo = reviewsRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        return reviewsRepo.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Reviews reviews) {
        Companies company = companyService.getCompanyById(companyId);
        if (company != null) {
            reviews.setCompany(company);
            reviewsRepo.save(reviews);
            return true;
        }
        return false;
    }

    @Override
    public Reviews getReview(Long companyId, Long reviewId) {
        List<Reviews> reviews = reviewsRepo.findByCompanyId(companyId);
        return reviews.stream().filter(r -> r.getId().equals(reviewId)).findFirst().orElse(null);

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedReview) {
        Companies company = companyService.getCompanyById(companyId);
        if (company != null) {
            if(getReview(companyId, reviewId) == null) {
                return false;
            }
            updatedReview.setCompany(company);
            updatedReview.setId(reviewId);
            reviewsRepo.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Companies company = companyService.getCompanyById(companyId);
        Reviews review = getReview(companyId, reviewId);
        if (company != null && review != null) {
            reviewsRepo.delete(review);
            return true;
        }
        return false;
    }
}
