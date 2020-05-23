public class Participant {
    private int id;
    private String name,mobile,email,affiliation,occupation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name enter <b>users</b> name here
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;        
    }  
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    
    public String getAffiliation() {
        return affiliation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
 
}