package hwmsacapstone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hwmsacapstone.config.kafka.KafkaProcessor;
import hwmsacapstone.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ScheduleRepository scheduleRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkRegistered_UpdateBookmarkCnt(
        @Payload BookmarkRegistered bookmarkRegistered
    ) {
        if (!bookmarkRegistered.validate()) return;
        BookmarkRegistered event = bookmarkRegistered;
        System.out.println(
            "\n\n##### listener UpdateBookmarkCnt : " +
            bookmarkRegistered.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Schedule.updateBookmarkCnt(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkCanceled_UpdateBookmarkCnt(
        @Payload BookmarkCanceled bookmarkCanceled
    ) {
        if (!bookmarkCanceled.validate()) return;
        BookmarkCanceled event = bookmarkCanceled;
        System.out.println(
            "\n\n##### listener UpdateBookmarkCnt : " +
            bookmarkCanceled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Schedule.updateBookmarkCnt(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverLikeRegister_UpdateLikeCnt(
        @Payload LikeRegister likeRegister
    ) {
        if (!likeRegister.validate()) return;
        LikeRegister event = likeRegister;
        System.out.println(
            "\n\n##### listener UpdateLikeCnt : " +
            likeRegister.toJson() +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverLikeCanceled_UpdateLikeCnt(
        @Payload LikeCanceled likeCanceled
    ) {
        if (!likeCanceled.validate()) return;
        LikeCanceled event = likeCanceled;
        System.out.println(
            "\n\n##### listener UpdateLikeCnt : " +
            likeCanceled.toJson() +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewRegistered_UpdateReviewCnt(
        @Payload ReviewRegistered reviewRegistered
    ) {
        if (!reviewRegistered.validate()) return;
        ReviewRegistered event = reviewRegistered;
        System.out.println(
            "\n\n##### listener UpdateReviewCnt : " +
            reviewRegistered.toJson() +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewDeleted_UpdateReviewCnt(
        @Payload ReviewDeleted reviewDeleted
    ) {
        if (!reviewDeleted.validate()) return;
        ReviewDeleted event = reviewDeleted;
        System.out.println(
            "\n\n##### listener UpdateReviewCnt : " +
            reviewDeleted.toJson() +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCommentRegistered_UpdateCommentCnt(
        @Payload CommentRegistered commentRegistered
    ) {
        if (!commentRegistered.validate()) return;
        CommentRegistered event = commentRegistered;
        System.out.println(
            "\n\n##### listener UpdateCommentCnt : " +
            commentRegistered.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Schedule.updateCommentCnt(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCommentDeleted_UpdateCommentCnt(
        @Payload CommentDeleted commentDeleted
    ) {
        if (!commentDeleted.validate()) return;
        CommentDeleted event = commentDeleted;
        System.out.println(
            "\n\n##### listener UpdateCommentCnt : " +
            commentDeleted.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Schedule.updateCommentCnt(event);
    }
    // keep

}
