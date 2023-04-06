package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiona;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class CommunicationIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comIssue")
    @SequenceGenerator(name = "comIssue",sequenceName = "comIssueSeq",allocationSize = 1)
    @Column(name = "communicationId",updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "communicationIssue", cascade = CascadeType.ALL)
    private List<LinkStatus> baseHealths = new ArrayList<>();
    @OneToOne
    private SectionA sectionA;


    public CommunicationIssue(List<LinkStatus> baseHealths) {
        this.baseHealths = baseHealths;
    }

    public void addSectionA(SectionA sectionA){
        this.setSectionA(sectionA);
        sectionA.setCommunicationStatus(this);
    }

    public void addLinkStatus(LinkStatus linkStatus){
        this.baseHealths.add(linkStatus);
        linkStatus.setCommunicationIssue(this);
    }

}
