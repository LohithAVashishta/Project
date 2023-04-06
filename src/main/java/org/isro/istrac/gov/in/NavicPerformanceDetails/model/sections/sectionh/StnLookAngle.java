package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.StationName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ToString
@Getter
@Entity
@Setter
@NoArgsConstructor
public class StnLookAngle {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stnLookAngle_seq")
    @SequenceGenerator(name = "stnLookAngle_seq",sequenceName = "StnLookAngle_learn",allocationSize = 1)
    @Column(name = "stnLookAngle_id", updatable = false, nullable = false)
    private Long id;


//@Enumerated(EnumType.STRING)
    private String location;
    private LocalDateTime availableTill;
    private Boolean enable;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="base_issue_id")
    private SectionH sectionH;

    public StnLookAngle(String location, LocalDateTime availableTill, Boolean enable) {
        this.location = location;
        this.availableTill = availableTill;

        this.enable = enable;
    }

    public void addSectionH(SectionH sectionH){
        this.setSectionH(sectionH);
        sectionH.addStnLookAngle(this);
    }

}
