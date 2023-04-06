package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiong;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Names;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseHealth;
@Getter
@Entity
@Setter
@NoArgsConstructor
public class SyslogStatus extends BaseHealth {


    @OneToOne
    private SectionG sectionG;
    public SyslogStatus(Names name, Status status, String issues) {
        super(name, status, issues);
    }
}
