package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.IrimsChain;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.IrimsMode1Stn;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Satellite;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Servers;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.Measurement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity

public class Uere extends Measurement {
//    @Enumerated(EnumType.STRING)
    private String satellite;

//    @Enumerated(EnumType.STRING)
    private String chain;

    public Uere(String server, String location, Double value, String chain, String satellite ) {
        super(server, location, value);
        this.satellite = satellite;
        this.chain = chain;
    }



}
