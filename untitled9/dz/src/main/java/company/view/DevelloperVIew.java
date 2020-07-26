package company.view;

import company.controller.AccountController;
import company.controller.DeveloperController;
import company.model.Account;
import company.model.Developer;
import company.model.Skill;


import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DevelloperVIew {
    private DeveloperController developerController = new DeveloperController();
    private AccountController accountController = new AccountController();
    private SkillView skillView = new SkillView();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private AccountView accountView = new AccountView();
    private Developer developer;




    public void addNewDevelloper() {


        String name = "";
        String lastName = "";
        while (!false) {
            System.out.println("Write name developer ");
            try {
                name = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error try again");
            }
            System.out.println("Write Last name developer ");
            try {
                lastName = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error try again");
            }
            System.out.println(name + " " + lastName);
            if (!(name.length() <= 2) && !(lastName.length() <= 2)) {

                break;
            }
        }


            developer = new Developer(name,lastName);



            developer.setSkill(skillView.addNewSkill());

            while (!false) {
                System.out.println("Add more skills?");
                System.out.println("Write Yes or No");
                try {
                    if (reader.readLine().equalsIgnoreCase("Yes")) {
                        developer.setSkill(skillView.addNewSkill());
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            developer.setAccount(accountView.addAccount());


            System.out.println(developerController.addDeveloper(developer));
        }


    public List<Developer> showAllDevellopers() {


        List<Developer> developersList;
        developersList = developerController.getAllDev();

        for (Developer dev : developersList) {
            Optional<Account> optional;
            optional = accountController.getAccount(dev.getId());
            if (optional.isPresent()) {
                dev.setAccount(optional.get());

            }
            System.out.println(dev);

        }

        return developersList;
    }


    private void deleteDeveloper() {

        developer = viewDeveloper(indecateIdForCreate());
        skillView.deleteSkill(developer.getSkills());
        accountView.deleteAccount(developer.getAccount());
        developerController.deletDeveloper(developer.getId());
    }

    public void createDeveloper() {
        System.out.println("What do you want to change?");

        System.out.println("Name and last name , skills , account status, Add skill ,Delete skill , Delete developer?");

        String answer = "";
        while (!false) {
            System.out.println("Pleas write Name , Skills , Account , Add skill ,Delete skill , Delete developer");
            try {
                answer = reader.readLine();
                if (answer != "") {
                    switch (answer) {
                        case "Name":
                            createNameDeveloper();
                            break;

                        case "Skills":
                            createSkillDeveloper();
                            break;

                        case "Account":
                            createAccountForDeveloper();
                            break;

                        case "Add skill":
                            addSkillForDeveloper();
                            break;

                        case "Delete skill":
                            deleteSkillForDeveloper();
                            break;

                        case "Delete developer":
                            deleteDeveloper();
                            break;

                    }
                    break;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteSkillForDeveloper() {
        developer = viewDeveloper(indecateIdForCreate());
        long id = skillView.deleteSkill(developer.getSkills());
        developer.getSkills().remove((developer.getSkills().stream().filter(x -> x.getId() == id).findAny().get()));
        developerController.apdateDeveloper(developer);
    }

    private void addSkillForDeveloper() {
        developer = viewDeveloper(indecateIdForCreate());
        developer.setSkill(skillView.addNewSkill());
        developerController.apdateDeveloper(developer);
}

    private void createAccountForDeveloper() {
        developer = viewDeveloper(indecateIdForCreate());
        developer.setAccount(accountView.createAccount(developer.getAccount()));
        developerController.apdateDeveloper(developer);
    }

    private void createSkillDeveloper() {


        developer = viewDeveloper(indecateIdForCreate());

        System.out.println("What skill do you change ?");

        developer.getSkills().forEach(System.out::println);


        try {
            long idSkill = Long.parseLong(reader.readLine());


            if ((developer.getSkills().stream().filter(x -> x.getId() == idSkill).findAny().orElse(null)) != null) {
                developer.getSkills().remove((developer.getSkills().stream().filter(x -> x.getId() == idSkill).findAny().get()));


Skill skill2=developer.getSkills().stream().filter(x -> x.getId() == idSkill).findAny().orElse(null);

                Skill skill=skillView.createSkill(developer.getSkills().stream().filter(x -> x.getId() == idSkill).findFirst().orElse(null));

                System.out.println(skill2);

                developer.setSkill(skillView.createSkill(skill));

            } else {
                System.out.println("This skill does not exist please enter again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void createNameDeveloper() {


        developer = viewDeveloper(indecateIdForCreate());

        System.out.println("write a new name");

        String newName = null;
        try {
            newName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("write a new last name");

        String newLastName = null;
        try {
            newLastName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        developerController.apdateDeveloper(new Developer(developer.getId(), newName, newLastName, developer.getSkills(), developer.getAccount()));

    }

    private long indecateIdForCreate() {

        showAllDevellopers();
        while (true) {
            System.out.println("Please indicate the developer you want to create");

            try {
              long  idForCreate = Integer.parseInt(reader.readLine());
                return idForCreate;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public Developer viewDeveloper(Long id) {

            return developerController.getDeveloper(id).get();

    }
}
