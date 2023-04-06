package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.archival.good;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.ArchivalName;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.SectionB;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor

public class NavigationArchival extends ArchivalBaseClass{

    @ManyToOne
    private SectionB sectionB;
    public NavigationArchival(ArchivalName name, Status status, String size) {
        super(name, status, size);
    }
    public void addSectionB(SectionB sectionB){
        this.setSectionB(sectionB);
        sectionB.addNavigationArchival(this);
    }
}
