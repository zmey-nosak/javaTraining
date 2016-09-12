/**
 * Created by Echetik on 11.09.2016.
 */
public enum Discipline {
    MATHEMATICS(Integer.class),
    PHYSICS(Double.class),
    CHEMISTRY(Double.class),
    LINGUISTICS(Integer.class);
    private final Class type;

    Discipline(Class type) {
        this.type = type;
    }
    public String getType() {
        return this.type.getTypeName();
    }
}
