package sk.malajter.surgi_track.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.malajter.surgi_track.api.request.InstrumentRequestDTO;
import sk.malajter.surgi_track.model.Instrument;
import sk.malajter.surgi_track.repository.InstrumentRepository;

@RestController
@RequestMapping("/api/instruments")
@RequiredArgsConstructor
public class InstrumentController {

    private final InstrumentRepository instrumentRepository;

    @PostMapping
    public ResponseEntity<Instrument> createInstrument(@RequestBody InstrumentRequestDTO dto) {
        Instrument instrument = new Instrument();
        instrument.setName(dto.getName());
        instrument.setReferenceNumber(dto.getReferenceNumber());

        Instrument saved = instrumentRepository.save(instrument);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAllInstruments() {
        return ResponseEntity.ok(instrumentRepository.findAll());
    }
}
