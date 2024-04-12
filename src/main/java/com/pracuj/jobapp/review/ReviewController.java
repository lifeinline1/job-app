package com.pracuj.jobapp.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        if (reviewService.addReview(companyId, review) != null){
            return new ResponseEntity<>(review, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        if (reviewService.getReview(companyId, reviewId) != null){
            reviewService.deleteReview(companyId, reviewId);
            return new ResponseEntity<>("Review deleted succesfuly", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Review not found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        if (reviewService.updateReview(companyId, reviewId, review) != null){
            return new ResponseEntity<>("Review updated succesfuly", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found", HttpStatus.BAD_REQUEST);
    }
}
