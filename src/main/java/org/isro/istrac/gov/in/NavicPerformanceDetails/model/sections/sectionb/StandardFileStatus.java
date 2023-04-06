package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity

public class StandardFileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StandardFilesStatusIdSeq")
    @SequenceGenerator(name = "StandardFilesStatusIdSeq",sequenceName = "StandardFilesStatusIdSeqLearn",allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToOne
    private SectionB sectionB;

    @OneToMany(mappedBy="standardFileStatus", cascade = CascadeType.ALL)
    private List<StandardFile> availableDocuments = new ArrayList<>();



    public StandardFileStatus(List<StandardFile> availableDocuments) {
        this.availableDocuments =  availableDocuments;
    }
    public void addStandardFile(StandardFile standardFile){
        this.availableDocuments.add(standardFile);
        standardFile.setStandardFileStatus(this);
    }
}
