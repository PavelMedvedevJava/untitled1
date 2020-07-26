package company.model;

import java.io.Serializable;
import java.util.Objects;

public class Skill  implements Serializable {

    private String skil;

    private long id;

    public Skill(String skil) {

        this.skil = skil;

    }

    public Skill(String skill, long id) {
        this.skil = skill;
        this.id=id;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkil() {
        return skil;
    }

    public void setSkil(String skil) {
        this.skil = skil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id == skill.id &&
                Objects.equals(skil, skill.skil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skil, id);
    }

    @Override
    public String toString() {
        return id+" "+skil;
    }
}
