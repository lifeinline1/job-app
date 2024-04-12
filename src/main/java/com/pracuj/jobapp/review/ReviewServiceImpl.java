package com.pracuj.jobapp.review;

import com.pracuj.jobapp.company.Company;
import com.pracuj.jobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReview(Long companyId, Long id) {
        return reviewRepository.findByCompanyIdAndId(companyId, id);
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public Review updateReview(Long companyId, Long id, Review review) {
        Review oldReview = getReview(companyId, id);
        if(oldReview != null){
            oldReview.setCompany(companyService.getCompanyById(companyId));
            oldReview.setAuthor(review.getAuthor());
            oldReview.setTitle(review.getTitle());
            oldReview.setContent(review.getContent());
            return reviewRepository.save(oldReview);
        }
        return null;
    }

    @Override
    public void deleteReview(Long companyId, Long id) {
        reviewRepository.deleteById(id);
    }
}
