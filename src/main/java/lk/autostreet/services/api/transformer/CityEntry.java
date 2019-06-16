package lk.autostreet.services.api.transformer;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CityEntry implements Serializable {

    private Long id;
    private String name;
    private String represent;
}
