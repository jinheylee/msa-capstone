package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import hwmsacapstone.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class CommentModified extends AbstractEvent {

    private Long id;
    private Long scheduleId;
    private String customerId;
    private Boolean commentYn;
    private Long commentDesc;

    public CommentModified(Communication aggregate) {
        super(aggregate);
    }

    public CommentModified() {
        super();
    }
    // keep

}
