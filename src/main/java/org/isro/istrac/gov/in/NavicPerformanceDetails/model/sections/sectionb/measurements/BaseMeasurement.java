package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.IrimsMode1Stn;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Servers;


@Getter
@ToString
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "baseMeasurementIdSeq")
    @SequenceGenerator(name = "baseMeasurementIdSeq",sequenceName = "baseMeasurementIdlearn",allocationSize = 1)
    @Column(name = "baseMeasurementId",updatable = false, nullable = false)
    private Long id;

//    @Enumerated(EnumType.STRING)
    private String server;
//    @Enumerated(EnumType.STRING)
    private String location;

    private Double value;


    protected BaseMeasurement(String server, String location, Double value) {
        this.server = server;
        this.location = location;
        this.value = value;

    }


}
