package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiond;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Names;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseHealth;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SchemacsHealth extends BaseHealth {




    public SchemacsHealth(Names name, Status status, String issues) {
        super(name, status, issues);

    }
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionD_Id")
    private SectionD sectionD;

    public void addSectionD(SectionD sectionD){
        this.setSectionD(sectionD);
        sectionD.addSchemacsHealth(this);
    }

}
