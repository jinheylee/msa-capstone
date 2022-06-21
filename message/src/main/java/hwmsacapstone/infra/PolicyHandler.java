package hwmsacapstone.infra;

//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
import hwmsacapstone.config.kafka.KafkaProcessor;
import hwmsacapstone.domain.*;
//import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkRegistered_SendRegisterBookmark(@Payload BookmarkRegistered bookmarkRegistered) {

        if(bookmarkRegistered.validate()){

            /////////////////
            // 북마크 시 
            /////////////////
            System.out.println("##### listener SendConfirmMsg : " + bookmarkRegistered.toJson());

            // Schedule 정보 추출
            long scheduleId = bookmarkRegistered.getScheduleId(); // 북마크가 완료된 schedule
            String customerId = bookmarkRegistered.getCustomerId(); // 북마크가 완료된 Customer
            Boolean bookmarkYn = true;

            // 메시지 전송
            sendMsg(scheduleId, customerId, bookmarkYn);
        }

    }   

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkCanceled_SendCancelBookmark(@Payload BookmarkCanceled bookmarkCanceled) {
        if(bookmarkCanceled.validate()){

            /////////////////
            // 북마크 시 
            /////////////////
            System.out.println("##### listener SendCancelMsg : " + bookmarkCanceled.toJson());

            // Schedule 정보 추출
            long scheduleId = bookmarkCanceled.getScheduleId(); // 북마크가 완료된 schedule
            String customerId = bookmarkCanceled.getCustomerId(); // 북마크가 완료된 Customer
            Boolean bookmarkYn = false;

             // 메시지 전송
             sendMsg(scheduleId, customerId, bookmarkYn);

        }

    }    

    private void sendMsg(long scheduleId, String customerId, boolean bookmarkYn)     {

        //////////////////////////////////////////////
        // scheduleId 스케쥴에 대해 msgString으로 SMS를 쌓는다
        //////////////////////////////////////////////
        Message msg = new Message();
        msg.setScheduleId(scheduleId);
        msg.setCustomerId(customerId);
        msg.setBookmarkYn(bookmarkYn);

        // DB Insert
        messageRepository.save(msg);
    
    }    

/*
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkRegistered_SendRegisterBookmark(@Payload BookmarkRegistered bookmarkRegistered) {
             
        if (!bookmarkRegistered.validate()) return;
        BookmarkRegistered event = bookmarkRegistered;
        System.out.println(
            "\n\n##### listener SendRegisterBookmark : " +
            bookmarkRegistered.toJson() +
            "\n\n"
        );

        // Sample Logic //
        // Message.sendRegisterBookmark(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkCanceled_SendCancelBookmark(
        @Payload BookmarkCanceled bookmarkCanceled
    ) {
        if (!bookmarkCanceled.validate()) return;
        BookmarkCanceled event = bookmarkCanceled;
        System.out.println(
            "\n\n##### listener SendCancelBookmark : " +
            bookmarkCanceled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Message.sendCancelBookmark(event);
    }
    // keep
*/
}
