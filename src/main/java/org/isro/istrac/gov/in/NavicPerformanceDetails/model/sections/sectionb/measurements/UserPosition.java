package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.IrimsMode1Stn;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Servers;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.Measurement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class UserPosition extends Measurement {


    public UserPosition(String server, String location, Double value) {
        super(server, location, value);

    }


}
