package co.edu.unbosque.model.resources.pojos;

public class OwnerPojo {
    private String username;
    private String person_id;
    private String name;
    private String adress;
    private String neighborhood;


    public OwnerPojo() {
    }

    public OwnerPojo(String username, String person_id, String name, String adress, String neighborhood) {
        this.username = username;
        this.person_id = person_id;
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
