package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.IrimsMode1Stn;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Servers;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.BaseMeasurement;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.IrimsMode1Stn;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Servers;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Measurement extends BaseMeasurement {
    @ManyToOne
    @JoinColumn(name="measurement_sectionB")
    private SectionB sectionB;
    public Measurement(String server, String location, Double value) {
        super(server, location, value);

    }




}
