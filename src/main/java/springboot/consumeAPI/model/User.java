package springboot.consumeAPI.model;

public class User {

    private long id;
    private String name;
    private String surname;
    public User(long id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long Id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

}
