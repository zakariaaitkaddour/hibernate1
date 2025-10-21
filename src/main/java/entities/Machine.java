package entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "findBetweenDateNative", query = "select * from machine where dateAchat between :d1 and :d2",
    resultClass = Machine.class)
@NamedQuery(name = "findBetweenDate", query = "from Machine where dateAchat between :d1 and :d2")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    private Salle salle;

    public Machine() {
    }

    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }

    public String getRef() {
        return ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public Salle getSalle() {
        return salle;
    }

    public int getId() {
        return id;
    }
}

