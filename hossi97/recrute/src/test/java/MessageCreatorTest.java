import com.google.gson.Gson;
import com.hossi.recrute.common.service.anno.RCT;
import com.hossi.recrute.common.service.message.Message;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.service.message.ResponseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MessageCreatorTest {

    @Test @RCT(value = "001", description = "채용공고 상세 페이지 조회")
    public void testCreateMessageWithoutData() {
        // given

        // when
        Message<String> message = MessageCreator.create();
        String resMessage = new Gson().toJson(message);

        // then
        Assertions.assertEquals(resMessage,
            "{\"code\":\"RCT001\","
            + "\"description\":\"채용공고 상세 페이지 조회\","
            + "\"data\":\"\"}");
    }

    @Test @RCT(value = "002", description = "채용공고 지원")
    public void testCreateMessageWithData() {
        // given
        ResponseData responseData = new ResponseData.Builder().set("rctId", 1).build();

        // when
        Message<Map<String, Object>> message = MessageCreator.create(responseData);
        String resMessage = new Gson().toJson(message);

        // then
        Assertions.assertEquals(resMessage,
            "{\"code\":\"RCT002\","
            + "\"description\":\"채용공고 지원\","
            + "\"data\":{\"rctId\":1}}");
    }
}
