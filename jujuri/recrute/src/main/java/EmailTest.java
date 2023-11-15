import com.juju.util.EmailManager;

public class EmailTest {
  public static void main(String[] args) {

    EmailManager.mailSend("naver", "0612000ljy@naver.com", "시험 응시하기",
        "<a href='http://localhost:8080/recrute/exam/1/auth'>여기를 클릭하시면 시험페이지로 이동합니다.</a>");



    long beforeTime = System.currentTimeMillis();
    /*
     * for (int i = 0; i < 100000; i++) {
     * 
     * EmailManager.mailSend("naver", "0612000ljy@naver.com", "동기식 이메일 전송법 테스트입니다:3",
     * "당연히 비동기식이 빠르겠죠?");
     * 
     * 
     * CompletableFuture.runAsync(() -> { EmailManager.mailSend("naver", "0612000ljy@naver.com",
     * "동기식 이메일 전송법 테스트입니다:3", "당연히 비동기식이 빠르겠죠?"); });
     * 
     * }
     */

    long afterTime = System.currentTimeMillis();
    long runTime = afterTime - beforeTime;
    System.out.println(beforeTime);
    System.out.println(afterTime);
    System.out.println(runTime);
  }
}
