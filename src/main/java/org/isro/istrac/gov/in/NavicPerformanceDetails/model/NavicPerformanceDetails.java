package org.isro.istrac.gov.in.NavicPerformanceDetails.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiona.SectionA;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.SectionB;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc.SectionC;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiond.SectionD;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.SectionE;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionf.SectionF;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiong.SectionG;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh.SectionH;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity


public class NavicPerformanceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "navicPerformenceDetailsIdSeq")
    @SequenceGenerator(name = "navicPerformenceDetailsId",sequenceName = "navicPerformenceDetailsIdSeq",allocationSize = 1)
    private  Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    private  SectionA sectionA;

    @OneToOne(cascade = CascadeType.ALL)
    private SectionB sectionB;
    
    @OneToOne(cascade = CascadeType.ALL)
    private SectionC sectionC;
    
    @OneToOne(cascade = CascadeType.ALL)
    private SectionD sectionD;
    
    @OneToOne(cascade = CascadeType.ALL)
    private SectionE sectionE;
    
    @OneToOne(cascade = CascadeType.ALL)
    private SectionF sectionF;
    
    @OneToOne(cascade = CascadeType.ALL)
    private SectionG sectionG;
    
    @OneToOne(cascade = CascadeType.ALL)
    private SectionH sectionH;
    
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public NavicPerformanceDetails(SectionA sectionA, SectionB sectionB, SectionC sectionC, SectionD sectionD, SectionE sectionE, SectionF sectionF, SectionG sectionG, SectionH sectionH, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.sectionA = sectionA;
        this.sectionB = sectionB;
        this.sectionC = sectionC;
        this.sectionD = sectionD;
        this.sectionE = sectionE;
        this.sectionF = sectionF;
        this.sectionG = sectionG;
        this.sectionH = sectionH;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void addSectionA(SectionA sectionA){
        this.setSectionA(sectionA);
        sectionA.setNavicPerformanceDetails(this);
    }
    public void addSectionB(SectionB sectionB){
        this.setSectionB(sectionB);
        sectionB.setNavicPerformanceDetails(this);
    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.setNavicPerformanceDetails(this);
    }
    public void addSectionD(SectionD sectionD){
        this.setSectionD(sectionD);
        sectionD.setNavicPerformanceDetails(this);
    }
    public void addSectionE(SectionE sectionE){
        this.setSectionE(sectionE);
        sectionE.setNavicPerformanceDetails(this);
    }
    public void addSectionF(SectionF sectionF){
        this.setSectionF(sectionF);
        sectionF.setNavicPerformanceDetails(this);
    }
    public void addSectionG(SectionG sectionG){
        this.setSectionG(sectionG);
        sectionG.setNavicPerformanceDetails(this);
    }
    public void addSectionH(SectionH sectionH){
        this.setSectionH(sectionH);
        sectionH.setNavicPerformanceDetails(this);
    }
}

