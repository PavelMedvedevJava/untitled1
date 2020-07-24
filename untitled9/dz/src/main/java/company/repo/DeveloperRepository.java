package company.repo;

import company.model.Develloper;

import java.util.Collection;
import java.util.Optional;

public interface DeveloperRepository extends GenericRepository<Develloper,Long> {
    @Override
    void create(Develloper develloper);

    @Override
    void update(Develloper develloper);

    @Override
    void delete(Long id);

    @Override
    Collection<Develloper> getAll();

    @Override
    Optional<Develloper> read(Long id);


}
