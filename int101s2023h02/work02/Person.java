package work02;


    import work01.Utilitor;
public class Person {
    private static int nextid = 1;
    private final int id;
    private String firstname;
    private String lastname;
   
    public  Person(String firstname, String lastname) {
        if(Utilitor.testString(firstname) && Utilitor.testString(lastname) ){
        this.firstname = Utilitor.testString(firstname);
        this.lastname = Utilitor.testString(lastname);
        this.id = nextid;
        nextid++;
        }else{
            throw new IllegalArgumentException("Invalid firstname or lastname");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person(").append(id).append(",").append(firstname).append(",").append(lastname).append(")");
        return sb.toString();
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
        if(Utilitor.testString(firstname)){
            this.firstname = firstname;
        }else{
            throw new IllegalArgumentException("Invalid firstname");
        }
        
    }

    public void setLastname(String lastname) {
        if(Utilitor.testString(lastname)){
            this.lastname = lastname;
        }else{
            throw new IllegalArgumentException("Invalid lastname");
        }
        
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; 
        }
        Person other = (Person) obj;
        return id == other.id;
    }
    
    

}

