package parametrization.FilmsCollection;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by Echetik on 08.10.2016.
 */
public class FilmsCollection implements Serializable {
    private static String FILE_OUTPUT=
    HashSet<Film> films = new HashSet<>();
    public void addFilm(Film film) {
        films.add(film);
    }
    public static void doSerialize(FilmsCollection collection){
    try(FileOutputStream os =new FileOutputStream()

            )
    }
}
