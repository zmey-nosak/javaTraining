package nuclearBoat;

/**
 * Created by Echetik on 25.09.2016.
 */
@NuclearBoatAnnotation(name = "Kursk",year = 2000)
public class NuclearBoat {

    private Engine engine = new Engine();
    private boolean isSailing = false;

    public void startSailing(){
        engine.run();
        isSailing = true;
    }

    public boolean isSailing() {
        return isSailing;
    }

    class Engine {
        boolean isWorking = false;
        public void run() {
            isWorking = true;
        }
    }
}

