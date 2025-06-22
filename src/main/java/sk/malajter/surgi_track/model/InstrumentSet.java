package sk.malajter.surgi_track.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "instrument_set")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstrumentSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String usage;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "instrument_set_instruments",
            joinColumns = @JoinColumn(name = "instrument_set_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    private Set<Instrument> instruments;

    @ManyToMany(mappedBy = "instrumentSets")
    private Set<Surgery> surgeries = new HashSet<>();

}
