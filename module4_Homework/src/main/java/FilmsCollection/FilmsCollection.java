package FilmsCollection;

import java.io.*;
import java.util.HashSet;

/**
 * Created by Echetik on 08.10.2016.
 */
public class FilmsCollection implements Serializable {
    private static String FILE_OUTPUT = "D:\\Downloads\\javaTraining\\module4_Homework\\collection.bin";
    HashSet<Film> films = new HashSet<>();

    public void addFilm(Film film) {
        films.add(film);
    }

    public void removeFilm(Film film) {
        films.remove(film);
    }

    public static void doSerialize(FilmsCollection collection) {
        try (FileOutputStream os = new FileOutputStream(FILE_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(collection);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FilmsCollection doDeserealization() {
        FilmsCollection fc = null;
        try (FileInputStream is = new FileInputStream(FILE_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            fc = (FilmsCollection) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fc;
    }

    public void display() {
        for (Film film : films) {
            System.out.println(film.name.toUpperCase());
            System.out.println("Actors:");
            for (Actor actor : film.getActors()) {
                System.out.println(actor.name + " " + actor.sourName);
            }
            System.out.println("-------------------------------------");
        }
    }
}
