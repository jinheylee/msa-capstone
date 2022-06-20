package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import hwmsacapstone.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class ReviewRegistered extends AbstractEvent {

    private Long id;
    private Long scheduleId;
    private String customerId;
    private String reviewComment;

    public ReviewRegistered(Review aggregate) {
        super(aggregate);
    }

    public ReviewRegistered() {
        super();
    }
    // keep

}
