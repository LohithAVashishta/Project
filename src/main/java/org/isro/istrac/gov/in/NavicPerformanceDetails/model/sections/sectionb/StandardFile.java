package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor

public class StandardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StandardFileIdSeq")
    @SequenceGenerator(name = "StandardFileIdSeq",sequenceName = "StandardFileIdSeqLearn",allocationSize = 1)
    @Column(name = "StandardFileId",updatable = false, nullable = false)
    private Long id;


    private String fileName;

    @ManyToOne
    private StandardFileStatus standardFileStatus;

    private Boolean status;

    public StandardFile(String fileName, Boolean status) {
        this.fileName = fileName;
        this.status = status;
    }

    public void addStandardFileStatus(StandardFileStatus standardFileStatus){
        this.setStandardFileStatus(standardFileStatus);
        standardFileStatus.addStandardFile(this);
    }
}
