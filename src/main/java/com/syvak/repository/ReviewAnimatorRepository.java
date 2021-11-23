
package com.syvak.repository;
import com.syvak.domain.ReviewAnimator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewAnimatorRepository extends JpaRepository<ReviewAnimator, Integer> {
}