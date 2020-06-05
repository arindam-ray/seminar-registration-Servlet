import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteParticipant")  
public class DeleteParticipant extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        int status = Dao.delete(id);

        String messageText = "This is some Error Message Text";
        Integer messageType = 2;
        String redirecPage = "View";
    
        if (status > 0) {
          // successfuly inserted record
          messageText = "Record Successfully Deleted";
          GlobalError.errorStrings.add(messageText);
          messageType = 2;
          redirecPage = "View";
        } else {
          // Error occured
          messageText = "Sorry ! Error in Deletion Process";
          GlobalError.errorStrings.add(messageText);
          messageType = 1;
          redirecPage = "View";
        }
        
        request
            .getRequestDispatcher(
                "Message?messageText=" + messageText + "&messageType=" + messageType + "&redirectPage=" + redirecPage)
            .forward(request, response);

    }  
}