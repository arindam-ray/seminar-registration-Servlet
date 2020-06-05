import java.util.*;
import java.sql.*;

public class Dao {
  
  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String jdbcUrl =   Credentials.jdbcUrl;
      String username =  Credentials.username;
      String password =  Credentials.password;

      con = DriverManager.getConnection(jdbcUrl, username, password);

    } catch (Exception e) {
      System.out.println(e);
     
    }
    return con;
  }

  // ----------------------------------------------------------

  public static int save(Participant p) {
    int status = -1;

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("insert into reg_master(name,mobile,email,occupation,affiliation) values (?,?,?,?,?)");
      ps.setString(1, p.getName());
      ps.setString(2, p.getMobile());
      ps.setString(3, p.getEmail());
      ps.setString(4, p.getOccupation());
      ps.setString(5, p.getAffiliation());

      status = ps.executeUpdate();
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return status;
  }

  // ---------------------------------------------------------

  public static int update(Participant p) {
    int status = -1;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("update reg_master set name=?,mobile=?,email=?,occupation=?,affiliation=? where reg_id=?");

      ps.setString(1, p.getName());
      ps.setString(2, p.getMobile());
      ps.setString(3, p.getEmail());
      ps.setString(4, p.getOccupation());
      ps.setString(5, p.getAffiliation());
      ps.setInt(6, p.getId());

      status = ps.executeUpdate();

      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return status;
  }

  // ----------------------------------------------------------

  public static int delete(int id) {
    int status = 0;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("delete from reg_master where reg_id=?");
      ps.setInt(1, id);
      status = ps.executeUpdate();

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return status;
  }

  // --------------------------------------------------------

  public static Participant getParticipantById(int id) {
    Participant p = new Participant();

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from reg_master where reg_id=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setMobile(rs.getString(3));
        p.setEmail(rs.getString(4));
        p.setAffiliation(rs.getString(5));
        p.setOccupation(rs.getString(6));
      }
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return p;
  }

  // -----------------------------------------------------------------

  public static List<Participant> getAllParticipants() {
    List<Participant> list = new ArrayList<Participant>();
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from reg_master");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Participant p = new Participant();

        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setMobile(rs.getString(3));
        p.setEmail(rs.getString(4));
        p.setAffiliation(rs.getString(5));
        p.setOccupation(rs.getString(6));
        
        list.add(p);
      }
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }
}

// -------------------------------------------------------------------