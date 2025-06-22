package sk.malajter.surgi_track.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.malajter.surgi_track.api.request.SurgeryRequestDTO;
import sk.malajter.surgi_track.model.Surgery;
import sk.malajter.surgi_track.repository.SurgeryRepository;

import java.util.List;

@RestController
@RequestMapping("/surgeries")
@RequiredArgsConstructor
public class SurgeryController {

    private final SurgeryRepository surgeryRepository;

    @GetMapping
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surgery> getSurgeryById(@PathVariable Long id) {
        return surgeryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Surgery createSurgery(@RequestBody SurgeryRequestDTO dto) {
        Surgery surgery = new Surgery();
        surgery.setName(dto.getName());
        surgery.setType(dto.getType());
        surgery.setDepartment(dto.getDepartment());

        return surgeryRepository.save(surgery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Surgery> updateSurgery(@PathVariable Long id, @RequestBody SurgeryRequestDTO dto) {
        return surgeryRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setType(dto.getType());
                    existing.setDepartment(dto.getDepartment());
                    Surgery updated = surgeryRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Surgery> patchSurgery(@PathVariable Long id, @RequestBody SurgeryRequestDTO dto) {
        return surgeryRepository.findById(id)
                .map(existing -> {
                    if (dto.getName() != null) existing.setName(dto.getName());
                    if (dto.getType() != null) existing.setType(dto.getType());
                    if (dto.getDepartment() != null) existing.setDepartment(dto.getDepartment());
                    Surgery updated = surgeryRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Long id) {
        if (surgeryRepository.existsById(id)) {
            surgeryRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
