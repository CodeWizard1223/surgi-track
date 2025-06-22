package sk.malajter.surgi_track.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "surgery")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String department;

    @ManyToMany
    @JoinTable(
            name = "surgery_instrument_set",
            joinColumns = @JoinColumn(name = "surgery_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_set_id")
    )
    private Set<InstrumentSet> instrumentSets = new HashSet<>();
}
