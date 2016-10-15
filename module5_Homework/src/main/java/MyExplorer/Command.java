package MyExplorer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Echetik on 08.10.2016.
 */
public class Command {
    String commandString;
    private static Map<String, ExecutableOneParam> mapCom = new HashMap<>();
    {
        mapCom.put("ls", (param) -> displayDir(param));
        mapCom.put("mkFile", (param) -> makeFile(param));
        mapCom.put("cd", (param) -> changeCurDir(param));
        mapCom.put("writeToFile", (param) -> writeToFile(param));
        mapCom.put("rmFile", (param) -> rmFile(param));
    }


    public Command(String commandString) {
        this.commandString = commandString;
        parseCommandString(commandString);
    }

    public void parseCommandString(String commandString) {
        List<String> lst = Arrays.asList(commandString.split(" "));
        String command = "";
        String param = "";
        if (lst.size() > 1) {
            int index = commandString.indexOf(' ');
            command = lst.get(0);
            param = commandString.substring(index + 1, commandString.length());
        } else {
            command = commandString;
        }
        boolean isCommandFind = false;
        if (mapCom.containsKey(command)) {
            mapCom.get(command).execute(param.split(" "));
        } else {
            System.out.println("Command not found");
        }
    }

    private void displayDir(String... param) {
        File folder;
        if (param.length == 1) {
            if (!param[0].contains("\\")) {
                folder = new File(MyExplorer.currentDirectory);
            } else {
                folder = new File(param[0]);
            }
            if (folder.isDirectory()) {
                List<String> folderNames = new ArrayList();
                List<String> fileNames = new ArrayList();
                for (File file : folder.listFiles()) {
                    if (file.isDirectory()) {
                        folderNames.add(file.getName());
                    } else {
                        fileNames.add(file.getName());
                    }
                }
                for (String folderName : folderNames) {
                    System.out.println("директория: " + folderName);
                }
                for (String fileName : fileNames) {
                    System.out.println("файл: " + fileName);
                }
            } else {
                System.out.println("Не корректная директория");
            }
        } else {
            System.out.println("Не корректная директория");
        }
    }

    private void makeFile(String... param) {
        File file;
        if (param.length == 1) {
            if (!param[0].contains("\\")) {
                file = new File(MyExplorer.currentDirectory + MyExplorer.fileSeparator + param[0]);
            } else {
                file = new File(param[0]);
            }
            try {
                if (file.createNewFile()) {
                    System.out.println(param[0] + " файл создан");
                } else System.out.println(param[0] + " файл уже существует");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Не корректный параметр");
        }
    }

    private void rmFile(String... param) {
        File file;
        if (param.length == 1) {
            if (!param[0].contains("\\")) {
                file = new File(MyExplorer.currentDirectory + MyExplorer.fileSeparator + param[0]);
            } else {
                file = new File(param[0]);
            }
            if (file.delete()) {
                System.out.println(param[0] + " файл удалён");
            } else System.out.println(param[0] + " файл не удалён");
        } else {
            System.out.println("Не корректный параметр");
        }
    }

    private void changeCurDir(String... param) {
        if (param.length == 1) {
            File file = new File(param[0]);
            if (file.isDirectory()) {
                MyExplorer.currentDirectory = param[0];
            }else {
                System.out.println("Не корректная директория");
            }
        } else {
            System.out.println("Не корректный параметр");
        }
    }

    private void writeToFile(String... param) {
        if (param.length == 2) {
            File file = new File(MyExplorer.currentDirectory + MyExplorer.fileSeparator + param[0]);
            if (file.exists()) {
                try (FileWriter fw = new FileWriter(file, true);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(param[1]);
                    System.out.println("Информация записана");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Файл не сущестует");
            }
        } else {
            System.out.println("Не корректный параметр");
        }
    }

}
