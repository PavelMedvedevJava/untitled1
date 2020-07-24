package company.repo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import company.model.Skill;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillRepositoryImpl implements SkillRepository{



    private List<Skill> listOfSkills =new ArrayList<>();

@Override
    public void create(Skill skill)  {
        if (getAll() != null) {
            listOfSkills = getAll();
        }

        listOfSkills.add(skill);

        try (Writer writer = new FileWriter("skills.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listOfSkills, writer);
        } catch (IOException e) {
            System.out.println("Error write file");
        }

}

    @Override
    public List<Skill> getAll() {
        Reader reader = null;
        try {
            reader = new FileReader("skills.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson1 = new GsonBuilder().create();
        listOfSkills = gson1.fromJson(reader, new TypeToken<ArrayList<Skill>>() {
        }.getType());
        return listOfSkills;
    }

@Override
    public void update(Skill skill) {
        delete(skill.getId());

        listOfSkills.add(skill);

        try (Writer writer = new FileWriter("skills.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listOfSkills, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {

        listOfSkills.removeIf(e -> e.getId() == id);

        try (Writer writer = new FileWriter("skills.json")) {
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

