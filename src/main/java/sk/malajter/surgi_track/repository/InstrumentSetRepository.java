package sk.malajter.surgi_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.malajter.surgi_track.model.InstrumentSet;

public interface InstrumentSetRepository extends JpaRepository<InstrumentSet, Long> {
}
