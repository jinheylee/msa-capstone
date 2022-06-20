package hwmsacapstone.infra;

import hwmsacapstone.domain.*;
import hwmsacapstone.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleViewViewHandler {


    @Autowired
    private ScheduleViewRepository scheduleViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenScheduleRegistered_then_CREATE_1 (@Payload ScheduleRegistered scheduleRegistered) {
        try {

            if (!scheduleRegistered.validate()) return;

            // view 객체 생성
            ScheduleView scheduleView = new ScheduleView();
            // view 객체에 이벤트의 Value 를 set 함
            scheduleView.setId(scheduleRegistered.getId());
            // view 레파지 토리에 save
            scheduleViewRepository.save(scheduleView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회
            Optional<ScheduleView> scheduleViewOptional = scheduleViewRepository.findById(.getId());

            if( scheduleViewOptional.isPresent()) {
                 ScheduleView scheduleView = scheduleViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                scheduleView.setCommentCnt();    
                // view 레파지 토리에 save
                 scheduleViewRepository.save(scheduleView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // keep

}

