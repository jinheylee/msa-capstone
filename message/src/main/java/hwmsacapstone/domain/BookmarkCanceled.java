package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import hwmsacapstone.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class BookmarkCanceled extends AbstractEvent {

    private Long id;
    private Long scheduleId;
    private String customerId;
    private Boolean bookmarkYn;
    
    // keep
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
    

}
