package co.edu.unbosque.model.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Owner") // Optional
@NamedQueries({
        @NamedQuery(name = "Owner.findAll",
                query = "SELECT b FROM Owner b")
})

public class Owner {
    @Id
    @GeneratedValue
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "person_id", nullable = false)
    private String person_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;


    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;


    public Owner() {
    }

    public Owner(String person_id, String name, String adress, String neighborhood) {
        this.person_id = person_id;
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;

    }

    public Owner(String username, String person_id, String name, String adress, String neighborhood) {
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public UserApp getUserapp() {
        return userapp;
    }

    public void setUserapp(UserApp userapp) {
        this.userapp = userapp;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }


}