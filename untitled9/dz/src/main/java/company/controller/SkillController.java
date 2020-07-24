package company.controller;

import company.model.Skill;
import company.repo.SkillRepositoryImpl;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SkillController {
    private long idcounter=1;

    private SkillRepositoryImpl skillRepository =new SkillRepositoryImpl();

    public List<Skill> getAllSkill() {
        return skillRepository.getAll();
    }

    public void addSkill(String skill  , long devId) {

        if (!getAllSkill().isEmpty()&&getAllSkill()!=null) {
            idcounter=getAllSkill().stream().max(Comparator.comparing(i -> i.getId())).get().getId()+1;
        }

        skillRepository.create(new Skill(skill,idcounter,devId));
        idcounter++;
    }

    public void deletSkill(long id) {
        skillRepository.delete(id);
    }

    public void apdateSkill(long id, String newSkill,long idDev) {
        skillRepository.update(new Skill(newSkill,id,idDev));
    }

    public Optional<Skill> getSkill(long id ) {
        return skillRepository.read(id);
    }


}

