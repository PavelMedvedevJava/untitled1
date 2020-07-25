package company.repo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import company.model.Develloper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private List<Develloper> devellopersList = new ArrayList<>();

@Override
    public void  create(Develloper develloper){

        if (getAll()!=null) {
            devellopersList = getAll();
        }

        devellopersList.add(develloper);

        try (Writer writer = new FileWriter("developer.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(devellopersList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Develloper develloper){
delete(develloper.getId());
        devellopersList.add(develloper);

        try (Writer writer = new FileWriter("developer.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(devellopersList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




@Override
    public void delete(Long  id){
       devellopersList.removeIf(e -> e.getId()==id);
        try (Writer writer = new FileWriter("developer.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(devellopersList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


@Override
    public List<Develloper> getAll()  {

    if (!Files.exists(Paths.get("developer.json"))) {
        try {
            Files.createFile(Paths.get("developer.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    Reader reader = null;
        try {
            reader = new FileReader("developer.json");
        } catch (FileNotFoundException e) {
           return null;
        }
        Gson gson1 = new GsonBuilder().create();
        devellopersList=gson1.fromJson(reader, new TypeToken<ArrayList<Develloper>>(){}.getType());
        return devellopersList;
    }

    @Override
  public Optional<Develloper> read(Long id){
      return devellopersList.stream().filter(x->x.getId()==id).findFirst();
  }

}
