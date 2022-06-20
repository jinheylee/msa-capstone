package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import hwmsacapstone.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class LikeCanceled extends AbstractEvent {

    private Long id;
    private Long scheduleId;
    private String customerId;
    private Boolean likeYn;
    // keep

}
