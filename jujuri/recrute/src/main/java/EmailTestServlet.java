

import java.io.IOException;
import com.juju.util.EmailManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmailTestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public EmailTestServlet() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    EmailManager.mailSend("naver", "0612000ljy@naver.com", "이메일 텍스트",
        "<a href='/recrute/exam/1/auth'>여기를 클릭하시면 시험페이지로 이동합니다.</a>");
  }


}
