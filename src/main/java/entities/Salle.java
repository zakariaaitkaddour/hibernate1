package entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "salles")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;

    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
    private List<Machine> machines;

    public int getId() {
        return id;
    }

    public Salle() {
    }


    public Salle(String code) {
        this.code = code;
    }

    public Salle(String code, List<Machine> machines) {
        this.code = code;
        this.machines = machines;
    }

    public String getCode() {
        return code;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
