package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.StorageNames;

import javax.persistence.Entity;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity

public class NsopStorageStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nsopStorageStatus_seq")
    @SequenceGenerator(name = "nsopStorageStatus_seq",sequenceName = "nsopStorageStatus_learn",allocationSize = 3)
    @Column(name = "nsopStorageStatus_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="base_issue_id ")
    private StorageIssues storageStatus;

    @Enumerated(EnumType.STRING)
    private StorageNames name;
    @Enumerated(EnumType.STRING)
    private Status status;


    public NsopStorageStatus(StorageNames name, Status status) {
        this.name = name;
        this.status = status;
    }

    public void addStorageStatus(StorageIssues storageStatus){
        this.setStorageStatus(storageStatus);
        storageStatus.addNsopStorageStatus(this);
    }
}
