package company.model;

import java.io.Serializable;
import java.util.Objects;


public class Develloper implements Serializable {

    private long id;

    private  String name ,lastName;

  //  private  transient  Set<Skill> skills=new HashSet<>();

   private transient  Account account;

    public Develloper(long id,String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
//
//    public void addSkills(Skill skill) {
//        skills.add(skill);
//    }
//
//    public Set<Skill> getSkills() {
//        return skills;
//    }


    public Develloper() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Develloper that = (Develloper) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }

    @Override
    public String toString() {
        return "Develloper (" +
                "id=" + id +
                ", name= " + name  +
                "  lastName= " + lastName  +
                "   "+account+

                ')';
    }
}
