import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateParticipant")
public class UpdateParticipant extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);
    String name = request.getParameter("pname");
    String mobile = request.getParameter("pmobile");
    String email = request.getParameter("pemail");
    String affiliation = request.getParameter("paffi");
    String occupation = request.getParameter("poccu");

    Participant p = new Participant();
    p.setId(id);
    p.setName(name);
    p.setMobile(mobile);
    p.setEmail(email);
    p.setOccupation(occupation);
    p.setAffiliation(affiliation);

    int status = Dao.update(p);

    String messageText = "This is some Error Message Text";
    Integer messageType = 2;
    String redirecPage = "registration.html";

    if (status > 0) {
      // successfuly inserted record
      messageText = "Record Successfully Updated";
      messageType = 2;
      redirecPage = "View";
    } else {
      // Error occured
      messageText = "Sorry ! Error in Registration Modification";
      messageType = 1;
      redirecPage = "View";
    }

    request
        .getRequestDispatcher(
            "Message?messageText=" + messageText + "&messageType=" + messageType + "&redirectPage=" + redirecPage)
        .forward(request, response);

  }

}