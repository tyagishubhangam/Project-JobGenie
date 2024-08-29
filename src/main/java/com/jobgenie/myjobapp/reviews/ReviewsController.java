package com.jobgenie.myjobapp.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewsService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@RequestBody Reviews reviews, @PathVariable Long companyId) {
       boolean isReviewAdded = reviewsService.addReview(companyId, reviews);
       if (isReviewAdded) {
           return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
       }
       return new ResponseEntity<>("Review not added", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
        Reviews review = reviewsService.getReview( companyId, reviewId);
        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Reviews reviews, @PathVariable Long companyId) {
        boolean isReviewUpdated = reviewsService.updateReview(companyId, reviewId, reviews);
        if (isReviewUpdated) {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not updated", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
        boolean isReviewDeleted = reviewsService.deleteReview(companyId, reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
    }

}
