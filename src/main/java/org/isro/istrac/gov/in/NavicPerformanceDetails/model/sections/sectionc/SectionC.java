package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicPerformanceDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
@Setter
@Getter

public class SectionC {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sectionCIdSeq")
    @SequenceGenerator(name = "sectionCIdSeq",sequenceName = "sectionCIdSeq",allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;


    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private List<ParallelChain> parallelChains=new ArrayList<>();

    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private List<Irnwt> Irnwts = new ArrayList<>();

    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private List<TwstftOffset> twstftOffsets=new ArrayList<>();

    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private List<GnssOffset> gnssOffsets=new ArrayList<>();

    @OneToOne(mappedBy = "sectionC",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;

    public SectionC(List<ParallelChain> parallelChains, List<TwstftOffset> twstftOffsets, List<GnssOffset> gnssOffsets) {
        this.parallelChains = parallelChains;
        this.twstftOffsets = twstftOffsets;
        this.gnssOffsets = gnssOffsets;
    }

    public void addParallelChain(ParallelChain parallelChain){
        this.parallelChains.add(parallelChain);
        parallelChain.setSectionC(this);
    }
    public void addTwstftOffset(TwstftOffset twstftOffset){
        this.twstftOffsets.add(twstftOffset);
        twstftOffset.setSectionC(this);
    }
    public void addGnssOffset(GnssOffset gnssOffset){
        this.gnssOffsets.add(gnssOffset);
        gnssOffset.setSectionC(this);
    }
    public void addIrnwt(Irnwt irnwt) {
        this.Irnwts.add(irnwt);
        irnwt.setSectionC(this);
    }

}
