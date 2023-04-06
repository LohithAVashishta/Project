package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiona;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Names;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseHealth;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class LinkStatus extends BaseHealth {
    @ManyToOne
    @JoinColumn(name = "communicationId")
    private CommunicationIssue communicationIssue;
    public LinkStatus(Names name, Status status, String issue) {
        super(name, status, issue);
    }

    public void addCommunicationIssue(CommunicationIssue communicationIssue){
        this.setCommunicationIssue(communicationIssue);
        communicationIssue.addLinkStatus(this);
    }


}
