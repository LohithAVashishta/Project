package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicPerformanceDetails;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseIssues;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionH extends BaseIssues {
    @OneToMany(mappedBy="sectionH", cascade = CascadeType.ALL)
    private List<StnLookAngle> stnLookAngles=new ArrayList<>();

    @OneToOne(mappedBy = "sectionH",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


    public SectionH(String issuesFromSectionH, List<StnLookAngle> stnLookAngles) {
        super(issuesFromSectionH);
        this.stnLookAngles = stnLookAngles;
    }

    public void addStnLookAngle(StnLookAngle stnLookAngle){
        this.stnLookAngles.add(stnLookAngle);
        stnLookAngle.setSectionH(this);
    }
}
