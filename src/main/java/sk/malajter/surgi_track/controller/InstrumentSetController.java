package sk.malajter.surgi_track.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.malajter.surgi_track.api.request.InstrumentSetRequestDTO;
import sk.malajter.surgi_track.model.Instrument;
import sk.malajter.surgi_track.model.InstrumentSet;
import sk.malajter.surgi_track.repository.InstrumentRepository;
import sk.malajter.surgi_track.repository.InstrumentSetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/instrument-sets")
@RequiredArgsConstructor
public class InstrumentSetController {

    private final InstrumentSetRepository instrumentSetRepository;
    private final InstrumentRepository instrumentRepository;

    @PostMapping
    public ResponseEntity<InstrumentSet> createInstrumentSet(@RequestBody InstrumentSetRequestDTO dto) {
        Set<Instrument> instruments = new HashSet<>();

        for (String name : dto.getInstrumentNames()) {
            Optional<Instrument> instrumentOpt = instrumentRepository.findByName(name);
            instrumentOpt.ifPresent(instruments::add);
        }


        InstrumentSet instrumentSet = new InstrumentSet();
        instrumentSet.setName(dto.getName());
        instrumentSet.setUsage(dto.getUsage());
        instrumentSet.setDescription(dto.getDescription());
        instrumentSet.setInstruments(instruments);

        InstrumentSet saved = instrumentSetRepository.save(instrumentSet);
        return ResponseEntity.ok(saved);
    }
}
