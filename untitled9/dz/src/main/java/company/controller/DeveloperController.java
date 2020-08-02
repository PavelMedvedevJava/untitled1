package company.controller;

import company.model.Developer;
import company.repo.repoImpl.DeveloperRepositoryImpl;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DeveloperController {

    private Developer dev;

    private long idcounter = 1;

    private DeveloperRepositoryImpl developerRepository = new DeveloperRepositoryImpl();

    public List<Developer> getAllDev() {
        return developerRepository.getAll();
    }

    public Developer addDeveloper(Developer developer) {

        return developerRepository.create(developer);
    }

    public void deletDeveloper(long id) {
        developerRepository.delete(id);
    }

    public Developer apdateDeveloper(Developer developer) {
       return developerRepository.update(developer);
    }

    public Optional<Developer> getDeveloper(long id) {
        return Objects.requireNonNull(developerRepository.read(id));
    }

}
