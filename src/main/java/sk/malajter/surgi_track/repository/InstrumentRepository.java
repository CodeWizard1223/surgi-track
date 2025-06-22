package sk.malajter.surgi_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.malajter.surgi_track.model.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
