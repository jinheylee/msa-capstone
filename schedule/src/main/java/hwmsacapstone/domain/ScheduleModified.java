package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import hwmsacapstone.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class ScheduleModified extends AbstractEvent {

    private Long id;
    private String title;
    private String content;
    private String uploader;
    private Integer commentCnt;
    private Integer bookmarkCnt;
    private Integer likeCnt;
    private Boolean reviewWriteYn;
    private Integer reviewCnt;

    public ScheduleModified(Schedule aggregate) {
        super(aggregate);
    }

    public ScheduleModified() {
        super();
    }
    // keep

}
