package company.controller;

import company.model.Develloper;
import company.repo.DeveloperRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DeveloperController {

    private Develloper dev;

    private long idcounter = 1;

    private DeveloperRepositoryImpl developerRepository = new DeveloperRepositoryImpl();

    public List<Develloper> getAllDev() {
        return developerRepository.getAll();
    }

    public void addDeveloper(String name, String lastName) {

        if (!getAllDev().isEmpty() && getAllDev() != null) {
            idcounter = getAllDev().stream().max(Comparator.comparing(i -> i.getId())).get().getId() + 1;
        }

        dev = new Develloper(idcounter, name, lastName);
        developerRepository.create(dev);
        idcounter++;
    }

    public void deletDevelloper(long id) {
        developerRepository.delete(id);
    }

    public void apdateDevelloper(long id, String newName, String newLastName) {
        developerRepository.update(new Develloper(id, newName, newLastName));
    }

    public Optional<Develloper> getDevelloper(long id) {
        return developerRepository.read(id);
    }

}
