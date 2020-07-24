package company.repo;

import company.model.Skill;

import java.util.Collection;
import java.util.Optional;

public interface SkillRepository extends GenericRepository<Skill,Long> {
    @Override
    void create(Skill skill);

    @Override
    void update(Skill skill);

    @Override
    void delete(Long aLong);

    @Override
    Optional<Skill> read(Long aLong);

    @Override
    Collection<Skill> getAll();
}
