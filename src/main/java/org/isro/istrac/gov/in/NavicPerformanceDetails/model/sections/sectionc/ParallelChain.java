package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Names;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseHealth;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class ParallelChain extends BaseHealth {

    @ManyToOne
    private SectionC sectionC;

    private String issue;
    public ParallelChain(Names name, Status status, String issue) {
        super(name, status, issue);

    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.addParallelChain(this);
    }


}
