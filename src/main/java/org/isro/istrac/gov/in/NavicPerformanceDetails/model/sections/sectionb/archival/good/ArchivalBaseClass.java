package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.archival.good;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.ArchivalName;

import javax.persistence.*;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class ArchivalBaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ArchivalsIdSeq")
    @SequenceGenerator(name = "ArchivalsIdSeq",sequenceName = "ArchivalsIdLearn",allocationSize = 1)
    @Column(name = "ArchivalsId",updatable = false, nullable = false)
    private Long id;


    @Enumerated(EnumType.STRING)
    private ArchivalName name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String Size;

    public ArchivalBaseClass(ArchivalName name, Status status, String size) {
        this.name=name;
        this.status = status;
        this.Size = size;
    }

}
