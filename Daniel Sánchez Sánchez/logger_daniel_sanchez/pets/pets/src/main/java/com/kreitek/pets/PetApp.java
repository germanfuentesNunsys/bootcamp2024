package main.java.com.kreitek.pets;

import main.java.com.kreitek.pets.controllers.CatController;

import main.java.com.kreitek.pets.controllers.ControllerFactory;
import main.java.com.kreitek.pets.controllers.DogController;

import java.util.Scanner;

public class PetApp {

    private Logger logger = new Logger();

    public static void main(String[] args) {
        PetApp petApp = new PetApp();
        petApp.run();
    }

    private void run() {
        ControllerFactory controllerFactory = new ControllerFactory();
        boolean end = false;
        logger.debug("Pet app has been initiated");
        while (!end) {
            String command = waitForNewCommand();
            String[] commandArgs = command.split(":");
            try {
                String response = "";
                switch (commandArgs[0]) {
                    case "end":
                        end = true;
                        break;
                    case "get":
                        String param = getGetParam(commandArgs);
                        switch (param) {
                            case "dog":
                                Controller dogController = controllerFactory.getDogController();
                                response = dogController.executeGet();
                                break;
                            case "cat":
                                Controller catController = controllerFactory.getCatController();
                                response = catController.executeGet();
                                break;
                            default:
                                throw new BadCommandException();
                        }
                        System.out.println(response);
                        break;
                    case "put":
                        String[] params = getPutParams(commandArgs);
                        switch (params[0]) {
                            case "dog":
                                Controller dogController = new DogController();
                                response = dogController.executePut(params[1], params[2], params[3]);
                                break;
                            case "cat":
                                Controller catController = new CatController();
                                response = catController.executePut(params[1], params[2], params[3]);
                                break;
                            default:
                                throw new BadCommandException();
                        }
                        System.out.println(response);
                        break;
                }
            } catch (BadCommandException e) {
                System.out.println("Bad command error");
            }
        }
        logger.debug("Pet app has been ended");
    }

    private String getGetParam(String[] commandArgs) throws BadCommandException {
        if (commandArgs.length == 2) {
            return commandArgs[1];
        } else {
            throw new BadCommandException();
        }
    }

    private String[] getPutParams(String[] commandArgs) throws BadCommandException {
        if (commandArgs.length <= 1) {
            throw new BadCommandException();
        }
        String[] parameters = commandArgs[1].split(";");
        if (parameters.length < 4) {
            throw new BadCommandException();
        }
        return parameters;
    }

    private String waitForNewCommand() {
        System.out.print("Enter a command : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
