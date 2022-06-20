package hwmsacapstone.domain;

import hwmsacapstone.ScheduleApplication;
import hwmsacapstone.domain.ScheduleDeleted;
import hwmsacapstone.domain.ScheduleModified;
import hwmsacapstone.domain.ScheduleRegistered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Schedule_table")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String uploader;

    private Integer commentCnt;

    private Long bookmarkCnt;

    private Integer likeCnt;

    private Integer review;

    @PostPersist
    public void onPostPersist() {
        ScheduleRegistered scheduleRegistered = new ScheduleRegistered(this);
        scheduleRegistered.publishAfterCommit();

        ScheduleModified scheduleModified = new ScheduleModified(this);
        scheduleModified.publishAfterCommit();

        ScheduleDeleted scheduleDeleted = new ScheduleDeleted(this);
        scheduleDeleted.publishAfterCommit();
    }

    public static ScheduleRepository repository() {
        ScheduleRepository scheduleRepository = ScheduleApplication.applicationContext.getBean(
            ScheduleRepository.class
        );
        return scheduleRepository;
    }

    public static void updateBookmarkCnt(
        BookmarkRegistered bookmarkRegistered
    ) {
        /** Example 1:  new item 
        Schedule schedule = new Schedule();
        repository().save(schedule);

        */

        /** Example 2:  finding and process
        
        repository().findById(bookmarkRegistered.get???()).ifPresent(schedule->{
            
            schedule // do something
            repository().save(schedule);


         });
        */

    }

    public static void updateBookmarkCnt(BookmarkCanceled bookmarkCanceled) {
        /** Example 1:  new item 
        Schedule schedule = new Schedule();
        repository().save(schedule);

        */

        /** Example 2:  finding and process
        
        repository().findById(bookmarkCanceled.get???()).ifPresent(schedule->{
            
            schedule // do something
            repository().save(schedule);


         });
        */

    }

    public static void updateCommentCnt(CommentRegistered commentRegistered) {
        /** Example 1:  new item 
        Schedule schedule = new Schedule();
        repository().save(schedule);

        */

        /** Example 2:  finding and process
        
        repository().findById(commentRegistered.get???()).ifPresent(schedule->{
            
            schedule // do something
            repository().save(schedule);


         });
        */

    }

    public static void updateCommentCnt(CommentDeleted commentDeleted) {
        /** Example 1:  new item 
        Schedule schedule = new Schedule();
        repository().save(schedule);

        */

        /** Example 2:  finding and process
        
        repository().findById(commentDeleted.get???()).ifPresent(schedule->{
            
            schedule // do something
            repository().save(schedule);


         });
        */

    }
}
