package company.repo.repoImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import company.model.Skill;
import company.repo.SkillRepository;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SkillRepositoryImpl implements SkillRepository {

    private long idcounter = 1;

    private Path filePath = Paths.get("skills.json");

    private final String fileName = "skills.json";

    private List<Skill> listOfSkills = new ArrayList<>();


    private List<Skill> getAllSkill() {
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
            e.printStackTrace();
        }
        Gson gson1 = new GsonBuilder().create();
        listOfSkills = gson1.fromJson(reader, new TypeToken<ArrayList<Skill>>() {
        }.getType());
        return listOfSkills;

    }

    @Override
    public Skill create(Skill skill) {

        if (Files.exists(filePath)) {

            try {
                if (Files.size(filePath) > 5) {
                    idcounter = getAllSkill().stream().max(Comparator.comparing(i -> i.getId())).get().getId() + 1;
                    skill.setId(idcounter);
                    listOfSkills.add(skill);
                } else {
                    skill.setId(idcounter);
                    idcounter++;
                    listOfSkills.add(skill);
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
            skill.setId(idcounter);
            idcounter++;
            listOfSkills.add(skill);

        }
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listOfSkills, writer);
        } catch (IOException e) {
            System.out.println("Error write file");
        }

        return skill;
    }

    @Override
    public List<Skill> getAll() {
        return getAllSkill();
    }

    @Override
    public Skill update(Skill skill) {
        delete(skill.getId());

        listOfSkills.add(skill);

        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listOfSkills, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skill;

    }

    @Override
    public void delete(Long id) {

        listOfSkills.removeIf(e -> e.getId() == id);

        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listOfSkills, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Этот гребанный метод не работает и я хз почему ;(
    @Override
    public Optional<Skill> read(Long id) {
        return listOfSkills.stream().filter(x -> x.getId() == id).findFirst();
    }


}

