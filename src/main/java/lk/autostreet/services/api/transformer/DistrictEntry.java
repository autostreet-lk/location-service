package lk.autostreet.services.api.transformer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistrictEntry {

    private Long id;
    private String name;
    private String represent;
}
