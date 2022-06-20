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

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        hwmsacapstone.external.Schedule schedule = new hwmsacapstone.external.Schedule();
        // mappings goes here
        ReviewApplication.applicationContext
            .getBean(hwmsacapstone.external.ScheduleService.class)
            .checkWriteReview(schedule);

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
