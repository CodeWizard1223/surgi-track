package sk.malajter.surgi_track.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sk.malajter.surgi_track.api.request.SurgeryAddRequest;
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

    @PostMapping
    public Surgery createSurgery(@RequestBody SurgeryAddRequest dto) {
        Surgery surgery = new Surgery();
        surgery.setName(dto.getName());
        surgery.setType(dto.getType());
        surgery.setDepartment(dto.getDepartment());

        return surgeryRepository.save(surgery);
    }
}
