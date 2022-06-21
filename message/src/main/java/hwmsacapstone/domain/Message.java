package hwmsacapstone.domain;

import hwmsacapstone.MessageApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Message_table")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long scheduleId;

    private String customerId;

    private Boolean bookmarkYn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getBookmarkYn() {
        return bookmarkYn;
    }

    public void setBookmarkYn(Boolean bookmarkYn) {
        this.bookmarkYn = bookmarkYn;
    }

    public static MessageRepository repository() {
        MessageRepository messageRepository = MessageApplication.applicationContext.getBean(
            MessageRepository.class
        );
        return messageRepository;
    }

    public static void sendRegisterBookmark(
        BookmarkRegistered bookmarkRegistered
    ) {
        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        */

        /** Example 2:  finding and process
        
        repository().findById(bookmarkRegistered.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);


         });
        */

    }

    public static void sendCancelBookmark(BookmarkCanceled bookmarkCanceled) {
        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        */

        /** Example 2:  finding and process
        
        repository().findById(bookmarkCanceled.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);


         });
        */

    }
}
