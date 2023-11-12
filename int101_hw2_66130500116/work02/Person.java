package work02;


    import work01.Utilitor;
public class Person {
    private static int nextid = 1;
    private final int id;
    private String firstname;
    private String lastname;
   
    public  Person(String firstname, String lastname) {
        
        this.firstname = Utilitor.testString(firstname);
        this.lastname = Utilitor.testString(lastname);
        this.id = nextid;
        nextid++;
        
    }

    

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
            this.firstname = Utilitor.testString(firstname);
       
        
    }

    public void setLastname(String lastname) {
       
            this.lastname =Utilitor.testString(lastname) ;
       
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person {");
        sb.append("id = ").append(this.id);
        sb.append(", fistname = ").append(this.firstname);
        sb.append(", lastname = ").append(this.lastname);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id != other.id)
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        return true;
    }

    
    

}

