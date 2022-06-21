package hwmsacapstone.domain;

import hwmsacapstone.CommunicationApplication;
import hwmsacapstone.domain.BookmarkCanceled;
import hwmsacapstone.domain.BookmarkRegistered;
import hwmsacapstone.domain.CommentDeleted;
import hwmsacapstone.domain.CommentModified;
import hwmsacapstone.domain.CommentRegistered;
import hwmsacapstone.domain.LikeCanceled;
import hwmsacapstone.domain.LikeRegister;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Communication_table")
@Data
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long scheduleId;

    private String customerId;

    private Boolean commentYn;

    private Boolean bookmarkYn;

    private Boolean likeYn;

    private String commentDesc;
    private String status;
    @PostPersist
    public void onPostPersist() {
        // CommentRegistered commentRegistered = new CommentRegistered(this);
        // commentRegistered.publishAfterCommit();

        // CommentModified commentModified = new CommentModified(this);
        // commentModified.publishAfterCommit();

        // CommentDeleted commentDeleted = new CommentDeleted(this);
        // commentDeleted.publishAfterCommit();

        

        // BookmarkCanceled bookmarkCanceled = new BookmarkCanceled(this);
        // bookmarkCanceled.publishAfterCommit();

        // LikeRegister likeRegister = new LikeRegister(this);
        // likeRegister.publishAfterCommit();

        // LikeCanceled likeCanceled = new LikeCanceled(this);
        // likeCanceled.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist(){
        System.out.println("PrePersist");
        if("bookmark".equals(this.getStatus())){
            BookmarkRegistered bookmarkRegistered = new BookmarkRegistered(this);
            bookmarkRegistered.publishAfterCommit();
        }
    }
    

    public static CommunicationRepository repository() {
        CommunicationRepository communicationRepository = CommunicationApplication.applicationContext.getBean(
            CommunicationRepository.class
        );
        return communicationRepository;
    }

    public String getStatus(){
        return this.status;
    }
}
