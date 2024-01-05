public class guests implements reservation {

    private String nationalid;
    private String name;
    private String lastname;
    private String email;
    private String password;

    public guests(String nationalid,String name,String lastname, String email,String password)
    {
        this.nationalid=nationalid;
        this.name=name;
        this.lastname=lastname;
        this.email=email;
        this.password=password;

    }

    public String getNationalid() {
        return nationalid;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String reserve() {
        return null;
    }

    @Override
    public String Return() {
        return null;
    }
}
