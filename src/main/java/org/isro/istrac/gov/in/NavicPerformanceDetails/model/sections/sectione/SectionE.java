package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione;

import javax.persistence.*;
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
public class SectionE extends BaseMaintenance {
/**
 *  The association relating to Section E is completely taken care by its hierarchical parents all the way up !
 *  Hence, we need not give any association mapping for it !!!
 *  Here Station attribute pertaining to Section E has been taken care by Base Maintenance
 *  Here Issue attribute pertaining to Section E has been taken care by Base Issue via Base Maintenance.
 *
 *  So we don't need to provide any association in Section E
 */

@OneToOne(mappedBy = "sectionE",cascade = CascadeType.ALL)
private NavicPerformanceDetails navicPerformanceDetails;

}
