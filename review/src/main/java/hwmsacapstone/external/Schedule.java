package hwmsacapstone.external;

import java.util.Date;
import lombok.Data;

@Data
public class Schedule {

    private Long id;
    private String title;
    private String content;
    private String uploader;
    private Integer commentCnt;
    private Long bookmarkCnt;
    private Integer likeCnt;
    private Boolean reviewWriteYn;
    private Integer reviewCnt;
    // keep

}
