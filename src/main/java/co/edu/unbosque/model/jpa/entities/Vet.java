package co.edu.unbosque.model.jpa.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vet") // Optional
@NamedQueries({
        @NamedQuery(name = "Vet.findAll",
                query = "SELECT b FROM Vet b")
})
public class Vet {
    @Id
    @GeneratedValue
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;


    @OneToMany(mappedBy = "vet")
    private List<Visit> visits = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;


    public Vet() {
    }

    public Vet(String name, String adress, String neighborhood) {
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;
    }

    public Vet(String username, String name, String adress, String neighborhood) {
        this.username = username;
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

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public UserApp getUserapp() {
        return userapp;
    }

    public void setUserapp(UserApp userapp) {
        this.userapp = userapp;
    }
}