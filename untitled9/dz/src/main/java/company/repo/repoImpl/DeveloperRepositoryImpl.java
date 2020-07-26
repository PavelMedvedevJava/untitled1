package company.repo.repoImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import company.model.Developer;
import company.repo.DeveloperRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private long idcounter = 1;

    private Path filePath = Paths.get("developer.json");

    private final String fileName = "developer.json";

    private List<Developer> developersList = new ArrayList<>();


    public List<Developer> getAllDeveloper() {

        if (!Files.exists(Paths.get(fileName))) {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Reader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            return null;
        }
        Gson gson1 = new GsonBuilder().create();
        developersList = gson1.fromJson(reader, new TypeToken<ArrayList<Developer>>() {
        }.getType());
        return developersList;
    }

    @Override
    public Developer create(Developer developer) {

        if (Files.exists(filePath)) {

            try {
                if (Files.size(filePath) > 5) {
                    idcounter = getAll().stream().max(Comparator.comparing(i -> i.getId())).get().getId() + 1;
                    developer.setId(idcounter);
                    developersList.add(developer);
                } else {
                    developer.setId(idcounter);
                    idcounter++;
                    developersList.add(developer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            developer.setId(idcounter);
            idcounter++;
            developersList.add(developer);

        }


        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(developersList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return developer;

    }

    @Override
    public Developer update(Developer developer) {

        delete(developer.getId());

        developersList.add(developer);

        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(developersList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }


    @Override
    public void delete(Long id) {
        developersList.removeIf(e -> e.getId() == id);
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(developersList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public List<Developer> getAll() {

        return getAllDeveloper();
    }

    @Override
    public Optional<Developer> read(Long id) {
        return developersList.stream().filter(x -> x.getId() == id).findFirst();
    }

}
