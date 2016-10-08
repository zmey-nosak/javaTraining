package MyExplorer;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Echetik on 08.10.2016.
 */
public class MyExplorer {
    Stack<String> commandsHistory = new Stack<>();
    public static String currentDirectory = "C:\\";
    public static String fileSeparator = System.getProperty("file.separator");

    public void addCommandToHistory(String command) {
        commandsHistory.push(command);
    }

    public String getCommandHistory() {
        return commandsHistory.pop();
    }

    public static void main(String[] args) {
        String s = "";
        MyExplorer explorer = new MyExplorer();
        while (!s.equals("quit")) {
            Command command = new Command(explorer.getPatch());
        }
    }

    private String getPatch() {
        Scanner con = new Scanner(System.in);
        String s = con.nextLine();
        return s;
    }

}
