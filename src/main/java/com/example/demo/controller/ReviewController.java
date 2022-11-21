package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")//this is the base url for api.but if you don't want to use this kind of url you can avoid this line
//so this api will be accessible from http://localhost:8080/
public class ReviewController {

    @Autowired
    private ReviewServices services;

    @GetMapping("/reviews")//you can give this any name you want and after adding this string to the end of base url you can use this
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(services.getReviewList());
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.services.getReviewById(id));
    }

    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return ResponseEntity.ok(this.services.createReview(review));
    }

    @PostMapping("/addReviews")
    public ResponseEntity<List<Review>> addReviews(@RequestBody List<Review> list) {
        return ResponseEntity.ok(this.services.createReviewList(list));
    }

    @PutMapping("/updateReviews/")
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        return ResponseEntity.ok().body(this.services.updateReviewById(review));
    }

    @DeleteMapping("/deleteReviews/{id}")
    public HttpStatus deleteReview(@PathVariable int id) {
        this.services.deleteReviewById(id);
        return HttpStatus.OK;
    }
}
