package com.example.demo.services;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServices {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> createReviewList(List<Review> list) {
        return reviewRepository.saveAll(list);
    }

    public List<Review> getReviewList() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review updateReviewById(Review review) {
        Optional<Review> reviewFound = reviewRepository.findById(review.getId());

        if (reviewFound.isPresent()) {
            Review reviewUpdate = reviewFound.get();
            reviewUpdate.setReference(review.getReference());
            reviewUpdate.setPubdate(review.getPubdate());
            reviewUpdate.setPrice(review.getPrice());

            return reviewRepository.save(review);
        } else {
            return null;
        }
    }

    public String deleteReviewById(int id) {
        reviewRepository.deleteById(id);
        return "Review "+ id +" deleted";
    }
}
