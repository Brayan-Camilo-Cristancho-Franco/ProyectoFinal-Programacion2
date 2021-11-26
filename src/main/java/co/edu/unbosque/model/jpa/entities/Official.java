package co.edu.unbosque.model.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Official") // Optional
@NamedQueries({
        @NamedQuery(name = "Official.findAll",
                query = "SELECT b FROM Official b")
})

public class Official {
    @Id
    @GeneratedValue
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;

    public Official () {}

    public Official (String name) {
        this.name = name;
    }

    public Official (String username,String name) {
        this.username = username;
        this.name = name;
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

    public UserApp getUserapp() {
        return userapp;
    }

    public void setUserapp(UserApp userapp) {
        this.userapp = userapp;
    }
}