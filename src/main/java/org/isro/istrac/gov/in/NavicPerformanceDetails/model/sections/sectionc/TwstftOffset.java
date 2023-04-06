package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Names;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseValue;
@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class TwstftOffset extends BaseValue {
    @ManyToOne
    private SectionC sectionC;

    private String issues;

    public TwstftOffset(Names name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.addTwstftOffset(this);
    }
}
