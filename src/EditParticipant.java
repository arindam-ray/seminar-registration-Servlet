import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditParticipant")
public class EditParticipant extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                response.setContentType("text/html");

                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
                Participant p = Dao.getParticipantById(id);

                String occuStatus1 = "";
                String occuStatus2 = "";
                String occuStatus3 = "";
                String occuStatus4 = "";
                String occuStatus5 = "";

                switch (p.getOccupation()) {
                        case "student":
                                occuStatus1 = "Selected";
                                break;
                        case "scholar":
                                occuStatus2 = "Selected";
                                break;
                        case "faculty":
                                occuStatus3 = "Selected";
                                break;
                        case "industry":
                                occuStatus4 = "Selected";
                                break;
                        case "others":
                                occuStatus5 = "Selected";
                }

                PrintWriter out = response.getWriter();
                out.print("<!DOCTYPE html><html lang='en'>");
                out.print("<head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.print("<title>Seminar Registration</title><link rel='icon' href='images/logo.png'><link rel='stylesheet' href='style.css'></head>");
                out.print("<body><center><img src='images/logo.png' width=75><h1>Registration Update</h1>");
                out.print("<form action='UpdateParticipant' method='POST'><table width='50%'' id='cus_table1'>");
                out.print("<input type='hidden' name='id' value='" + p.getId() + "' >");
                out.print("<tr><td>1. Participant Name *</td><td><input type='text' name='pname' value='" + p.getName()
                                + "' maxlength='80' size='50' placeholder='Participant Name' requrired></td>");
                out.print("</tr><tr><td>2. Mobile No. *</td><td><input type='text' name='pmobile' value='"
                                + p.getMobile()
                                + "' maxlength='10' size='20' pattern='[0-9]+'  placeholder='Mobile No ' required></td>");
                out.print("</tr><tr><td>3. Email *</td> <td><input type='email' name='pemail' value='" + p.getEmail()
                                + "' size='50' placeholder='Email for confirmation mail' required></td>");
                out.print("</tr><tr><td>4. Affiliation / Institution</td><td><input type='text' name='paffi'value='"
                                + p.getAffiliation()
                                + "' maxlength='90' placeholder='Institute / Company Name' size='50'></td>");
                out.print("</tr><tr><td>5. Occupation Type</td><td><select name='poccu' value='" + p.getOccupation()
                                + "'><option value='student'" + occuStatus1
                                + ">Student</option><option value='scholar'"+occuStatus2+">Research Scholar</option><option value='faculty' "+occuStatus3+">Faculty</option><option value='industry'"+occuStatus4+">Industry</option><option value='others'"+occuStatus5+">Others</option>");
                out.print("</select></td></tr><tr><td colspan=2 align='center'><input type='submit'> <input type='reset'></td></tr><tr><td colspan=2 align='center'> <a href='View'>List of Registered Participants</a> </td>");
                out.print("</tr></table></form> </center></body></html>");

                out.close();
        }
}