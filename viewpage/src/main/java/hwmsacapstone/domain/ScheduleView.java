package hwmsacapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ScheduleView_table")
@Data
public class ScheduleView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer commentCnt;
    private Integer bookmarkCnt;
    private Integer likeCnt;
    private Integer reviewCnt;
}
