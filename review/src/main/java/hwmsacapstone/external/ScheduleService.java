package hwmsacapstone.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "schedule", url = "${api.url.schedule}")
public interface ScheduleService {
    @RequestMapping(method = RequestMethod.POST, path = "/schedules")
    public void checkWriteReview(@RequestBody Schedule schedule);
    // keep

}
