package model;

public class License{
    private int id;
    private boolean isActive;

    public License(int id, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    
    @Override
    public String toString() {
        return "Licence [id=" + id + ", isActive=" + isActive + "]";
    }    
}
