package hwmsacapstone.domain;

import hwmsacapstone.ReviewApplication;
import hwmsacapstone.domain.ReviewDeleted;
import hwmsacapstone.domain.ReviewModified;
import hwmsacapstone.domain.ReviewRegistered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long scheduleId;

    private String customerId;

    private String reviewComment;

    @PostPersist
    public void onPostPersist() {
        ReviewRegistered reviewRegistered = new ReviewRegistered(this);
        reviewRegistered.publishAfterCommit();

        ReviewModified reviewModified = new ReviewModified(this);
        reviewModified.publishAfterCommit();

        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }
}
