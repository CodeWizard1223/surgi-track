package sk.malajter.surgi_track.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "instrument_set")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstrumentSet {

    private Long id;

    private Long name;
    private String usage;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "instrument_set_instruments",
            joinColumns = @JoinColumn(name = "instrument_set_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    private Set<Instrument> instruments;
}
