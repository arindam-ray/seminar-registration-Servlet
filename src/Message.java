import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Message")
public class Message extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String messageText = request.getParameter("messageText");
        int messageType = Integer.parseInt(request.getParameter("messageType"));
        String redirectPage = request.getParameter("redirectPage");

        messageText = GlobalError.errStr;
        
        String color = "black";

        if (messageType == 1)
            color = "red";
        if (messageType == 2)
            color = "green";
        if (messageType == 3)
            color = "yellow";

        out.print("<!DOCTYPE html><html lang='en'>");
        out.print("<head><meta charset='UTF-8'>");
        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("<title>Seminar Registration</title>");
        out.print("<link rel='icon' href='images/logo.png'>");
        out.print("<link rel='stylesheet' href='style.css'></head>");
        out.print(
                "<body><center><img src='images/logo.png' width='75'><h1>Display Message</h1><table width='50%' id='cus_table1'>");
        out.print("<tr><td align='center' style='color:" + color + "'>");
        out.print("<h2>" + messageText + "</h2> </td></tr>");
        out.print("<tr><td align='center'> <a href=" + redirectPage
                + "><button id='cus_btn'>OK</button></a> </td></tr></table></form></center></body></html>");
    }
}