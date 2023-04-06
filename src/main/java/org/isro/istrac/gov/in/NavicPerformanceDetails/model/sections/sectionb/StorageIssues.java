package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseIssues;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
public class StorageIssues extends BaseIssues {




    @OneToOne
    private SectionB sectionB;

    @OneToMany(mappedBy="storageStatus", cascade = CascadeType.ALL)
    private List<NsopStorageStatus> nsopStorageSet = new ArrayList<>();


    public StorageIssues(Set<NsopStorageStatus> nsopStorage, String issues) {
        super(issues);
        this.nsopStorageSet = nsopStorageSet;
    }

    public void addNsopStorageStatus(NsopStorageStatus nsopStorageStatus){
        this.nsopStorageSet.add(nsopStorageStatus);
        nsopStorageStatus.setStorageStatus(this);
    }

}
