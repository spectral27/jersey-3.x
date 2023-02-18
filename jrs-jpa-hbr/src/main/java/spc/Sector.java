package spc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sector")
@Getter
@Setter
public class Sector {

    @Id
    private String id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sector")
    private List<Record> records;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=" + id + ", name=" + name);
        if (records.size() > 0) {
            sb.append("\nrecords=" + records);
        }
        return sb.toString();
    }

}
