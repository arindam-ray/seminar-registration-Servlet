import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveParticipant")
public class SaveParticipant extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String name = request.getParameter("pname");
    String mobile = request.getParameter("pmobile");
    String email = request.getParameter("pemail");
    String affiliation = request.getParameter("paffi");
    String occupation = request.getParameter("poccu");

    Participant p = new Participant();

    p.setName(name);
    p.setMobile(mobile);
    p.setEmail(email);
    p.setAffiliation(affiliation);
    p.setOccupation(occupation);

    // out.println(name+" "+mobile+" "+email+" "+affiliation+" "+occupation);

    int status = Dao.save(p);

    String messageText = "This is some Error Message Text";
    Integer messageType = 2;
    String redirecPage = "registration.html";

    if (status > 0) {
      // successfuly inserted record
      messageText = "Record Successfully Inserted";
      GlobalError.errorStrings.add(messageText);
      messageType = 2;
      redirecPage = "registration.html";
    } else {
      // Error occured
      messageText = "Sorry ! Some Error in Input";
      GlobalError.errorStrings.add(messageText);
      messageType = 1;
      redirecPage = "registration.html";
    }

    request
        .getRequestDispatcher(
            "Message?messageText=" + messageText + "&messageType=" + messageType + "&redirectPage=" + redirecPage)
        .forward(request, response);

    out.close();
  }

}