package sk.malajter.surgi_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.malajter.surgi_track.model.Instrument;

import java.util.Optional;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

    Optional<Instrument> findByName(String name);
}
