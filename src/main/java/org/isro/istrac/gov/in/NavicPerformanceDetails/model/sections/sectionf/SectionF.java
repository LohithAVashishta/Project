package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionf;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicPerformanceDetails;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseMaintenance;


@ToString
@NoArgsConstructor
@Getter
@Entity
@Setter

public class SectionF extends BaseMaintenance {

    @OneToOne(mappedBy = "sectionF",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


}
