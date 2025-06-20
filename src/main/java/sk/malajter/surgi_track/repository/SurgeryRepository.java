package sk.malajter.surgi_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.malajter.surgi_track.model.Surgery;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
