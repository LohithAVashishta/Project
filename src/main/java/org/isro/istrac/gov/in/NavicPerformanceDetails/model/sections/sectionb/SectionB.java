package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb;

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
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.archival.good.NavigationArchival;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.Uere;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.UserPosition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
public class SectionB extends BaseIssues {
    public SectionB(StorageIssues storageStatus, StandardFileStatus standardFileStatus, List<NavigationArchival> navigationArchivals, List<Uere> uereMeasurements, List<UserPosition> userPositionMeasurements, String issues) {
        super(issues);
        this.storageStatus = storageStatus;
        this.standardFileStatus = standardFileStatus;
        this.archivalList = navigationArchivals;
        this.uereMeasurementsABlr = uereMeasurementsABlr;
        this.uereMeasurementsBBlr = uereMeasurementsBBlr;
        this.uereMeasurementsALck = uereMeasurementsALck;
        this.uereMeasurementsBLck = uereMeasurementsBLck;

        this.userPositionMeasurements = userPositionMeasurements;
    }

    @OneToOne(mappedBy = "sectionB",cascade = CascadeType.ALL)
    private StorageIssues storageStatus;

    @OneToOne(mappedBy = "sectionB", cascade = CascadeType.ALL)
    private StandardFileStatus standardFileStatus;

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private List<NavigationArchival> archivalList=new ArrayList<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private List<Uere> uereMeasurementsABlr=new ArrayList<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private List<Uere> uereMeasurementsBBlr=new ArrayList<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private List<Uere> uereMeasurementsALck=new ArrayList<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private List<Uere> uereMeasurementsBLck=new ArrayList<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private List<UserPosition> userPositionMeasurements=new ArrayList<>();

    @OneToOne(mappedBy = "sectionB",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


    public void addStorageStatus(StorageIssues storageStatus){
        this.setStorageStatus(storageStatus);
        storageStatus.setSectionB(this);
    }


    public void addNavigationArchival(NavigationArchival navigationArchival) {
        this.archivalList.add(navigationArchival);
        navigationArchival.setSectionB(this);
    }

    public void addUereABlr(Uere uere){
        this.uereMeasurementsABlr.add(uere);
        uere.setSectionB(this);
    }
    public void addUereBBlr(Uere uere){
        this.uereMeasurementsBBlr.add(uere);
        uere.setSectionB(this);
    }
    public void addUereALck(Uere uere){
        this.uereMeasurementsALck.add(uere);
        uere.setSectionB(this);
    }
    public void addUereBLck(Uere uere){
        this.uereMeasurementsBLck.add(uere);
        uere.setSectionB(this);
    }

    public void addUserPosition(UserPosition userPosition){
        this.userPositionMeasurements.add(userPosition);
        userPosition.setSectionB(this);
    }

    public void addStandardFilesStatus(StandardFileStatus standardFileStatus){
        this.setStandardFileStatus(standardFileStatus);
        standardFileStatus.setSectionB(this);
    }







}
