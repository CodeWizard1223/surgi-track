package sk.malajter.surgi_track.api.request;

import lombok.Data;

import java.util.Set;

@Data
public class InstrumentSetRequestDTO {

    private String name;
    private String usage;
    private String description;
    private Set<String> instrumentNames;

}
