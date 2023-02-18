package spc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "record")
@Getter
@Setter
public class Record {

    @Id
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", sector=" + sector.getId();
    }
}
