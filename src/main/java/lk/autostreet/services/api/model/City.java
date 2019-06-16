package lk.autostreet.services.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cities")
public class City implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    private String name;
    private String represent;
}
