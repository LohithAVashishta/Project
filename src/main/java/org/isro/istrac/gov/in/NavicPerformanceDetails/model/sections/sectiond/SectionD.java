package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiond;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicPerformanceDetails;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseIssues;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionD extends BaseIssues {
    @OneToMany(mappedBy="sectionD", cascade = CascadeType.ALL)
    private List<SchemacsHealth> schemacsHealths=new ArrayList<>();

    @OneToOne(mappedBy = "sectionD",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;

    public SectionD(List<SchemacsHealth> schemacsHealths, String issues) {
        super(issues);
        this.schemacsHealths = schemacsHealths;
    }
    public void addSchemacsHealth(SchemacsHealth schemacsHealth){
        this.schemacsHealths.add(schemacsHealth);
        schemacsHealth.setSectionD(this);
    }
}
