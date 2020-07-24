package company.model;

import java.io.Serializable;
import java.util.Objects;

public class Skill  implements Serializable {

    private long idDev;

    private String skil;

    private long id;




    public Skill(String skil, long id) {

        this.skil = skil;
        this.id=id;
    }

    public Skill(String skill, long idcounter, long devId) {
        this.skil = skill;
        this.id=idcounter;
        this.idDev=devId;
    }


    public long getIdDev() {
        return idDev;
    }

    public void setIdDev(long idDev) {
        this.idDev = idDev;
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
