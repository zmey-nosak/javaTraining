package FilmsCollection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 08.10.2016.
 */
public class FilmsCollectionTest {
    FilmsCollection collection = new FilmsCollection();

    @Test
    public void test() {
        Actor actor1 = new Actor("Arnold", "Schwarzenegger");
        Actor actor2 = new Actor("Kurt", "Russell");
        Actor actor3 = new Actor("Jean-Claude", "Van Damme");
        Actor actor4 = new Actor("Susan", "Weaver");
        Actor actor5 = new Actor("Michael", "Biehn");
        Actor actor6 = new Actor("Bill", "Paxton");
        Actor actor7 = new Actor("Сергей ", "Юрский");
        Film film = new Film("Aliens", new Actor[]{actor4, actor5, actor6});
        Film film1 = new Film("Predator", actor1);
        Film film2 = new Film("The thing", actor2);
        Film film3 = new Film("Lionheart", actor3);
        Film film4 = new Film("Золотой телёнок", actor7);
        collection.addFilm(film);
        collection.addFilm(film1);
        collection.addFilm(film2);
        collection.addFilm(film3);
        collection.addFilm(film4);
        collection.display();
        FilmsCollection.doSerialize(collection);
        System.out.println();
        System.out.println("REMOVE ЗОЛОТОЙ ТЕЛЁНОК...............................");
        collection.removeFilm(film4);
        collection.display();
        System.out.println();
        System.out.println("DESERIALIZATION...............................");
        FilmsCollection filmsCollection = FilmsCollection.doDeserealization();
        filmsCollection.display();

    }
}