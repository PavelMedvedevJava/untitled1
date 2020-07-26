package company.controller;

import company.model.Skill;
import company.repo.repoImpl.SkillRepositoryImpl;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SkillController {


    private SkillRepositoryImpl skillRepository =new SkillRepositoryImpl();

    public List<Skill> getAllSkill() {
        return skillRepository.getAll();
    }

    public Skill addSkill(Skill skill ) {
        return skillRepository.create(skill);
    }

    public void deletSkill(long id) {
        skillRepository.delete(id);
    }

    public Skill apdateSkill(Skill skill) {
       return skillRepository.update(skill);
    }

    public Optional<Skill> getSkill(long id ) {
        return skillRepository.read(id);
    }


}

