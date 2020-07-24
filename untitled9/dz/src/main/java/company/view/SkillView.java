package company.view;

import company.controller.SkillController;
import company.model.Develloper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkillView {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private SkillController skillController = new SkillController();

    public  void addNewSkill(Develloper develloper) throws IOException {

        String skill ;

        while (!false) {


            System.out.println("Write skill developer ");
            skill = reader.readLine();


            if (!(skill.length() <= 2)&&!(skill.length() <= 2)) {
                skillController.addSkill(skill,develloper.getId());
                break;
            }
        }

    }

    public void getAllSkills(Develloper develloper) {
        skillController.getAllSkill().stream().filter(x->x.getIdDev()==develloper.getId()).forEach(System.out::println);


    }

    public void deleteSkill(Develloper develloper) throws IOException {
        getAllSkills(develloper);

        System.out.println("Please indicate the skill you want to delete");
        int idForDelete = Integer.parseInt(reader.readLine());
        if (idForDelete > skillController.getAllSkill().size()) {
            System.out.println("There is no such developer");
        } else {
            skillController.deletSkill(idForDelete);
        }

    }

    public void createSkill(Develloper develloper) throws IOException {
        getAllSkills(develloper);

        System.out.println("Please indicate the skill you want to create");
        int idForCreate = Integer.parseInt(reader.readLine());
        if (idForCreate > skillController.getAllSkill().size()) {
            System.out.println("There is no such developer");
        } else {
            System.out.println("Write new skill developer");
            String newSkill = reader.readLine();
            skillController.apdateSkill(idForCreate,newSkill,develloper.getId());
        }



    }
}

