package tr.noor.healloibra;

/**
 * Created by Abdullah on 8/7/2017.
 */
public class Course {

    private int ID = 10101;
    private double crdit;
    private String titale;
    private String description;

    public Course(int ID, String titale, String description, double crdit) {
        this.ID = ID;
        this.crdit = crdit;
        this.titale = titale;
        this.description = description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCrdit(int crdit) {
        this.crdit = crdit;
    }

    public void setTitale(String titale) {
        this.titale = titale;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public double getCrdit() {
        return crdit;
    }

    public String getTitale() {
        return titale;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        return getTitale();
    }

}
