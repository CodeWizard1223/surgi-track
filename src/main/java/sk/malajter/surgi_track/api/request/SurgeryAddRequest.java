package sk.malajter.surgi_track.api.request;


import lombok.Data;

@Data
public class SurgeryAddRequest {

    private String name;

    private String type;

    private String department;
}
