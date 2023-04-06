package org.isro.istrac.gov.in.NavicPerformanceDetails.controller;

import lombok.extern.slf4j.Slf4j;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicPerformanceDetails;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicRepository;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Predicate.AppPredicate;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Predicate.AppPredicateH;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.StationName;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseHealth;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiona.CommunicationIssue;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiona.LinkStatus;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiona.SectionA;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.*;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.archival.good.NavigationArchival;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.Uere;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.UserPosition;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc.ParallelChain;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc.SectionC;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.SectionE;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.Station;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionf.SectionF;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh.SectionH;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh.StnLookAngle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@Slf4j
public class NavicPerformanceController {
    @Autowired
    NavicRepository navicRepository;

    @PostMapping("performanceFormV1")
   public String saveNavicPerformance(@ModelAttribute NavicPerformanceDetails navicPerformanceDetails, Model model){
        model.addAttribute("navicPerformanceDetails", navicPerformanceDetails);

        SectionA sectionA=navicPerformanceDetails.getSectionA();

        SectionB sectionB= navicPerformanceDetails.getSectionB();
         StorageIssues storageIssues = sectionB.getStorageStatus();
         List<NsopStorageStatus> nsopStorageList = storageIssues.getNsopStorageSet();
         log.info("NSOP:  "+ nsopStorageList.toString());


        List<NavigationArchival> archivalList = sectionB.getArchivalList();
        archivalList.forEach((a->log.info(a.getName() + " | " + a.getStatus())));


        List<Uere> uereMeasurementsABlr = sectionB.getUereMeasurementsABlr();
        uereMeasurementsABlr.forEach(ele->log.info(ele.getValue() + "...|..." + ele.getLocation() + "...|..." + ele.getServer()+ "...|..." + ele.getSatellite()+ "...|...chain"+ ele.getChain() ));

        List<Uere> uereMeasurementsBBlr = sectionB.getUereMeasurementsBBlr();
        uereMeasurementsBBlr.forEach(b->log.info(b.getValue() + "...|..." + b.getLocation() + "...|..." + b.getServer()+ "...|..." + b.getSatellite()+ "...|...chain"+ b.getChain()));

        List<Uere> uereMeasurementsALck = sectionB.getUereMeasurementsALck();
        uereMeasurementsALck.forEach(b->log.info(b.getValue() + "...|..." + b.getLocation() + "...|..." + b.getServer()+ "...|..." + b.getSatellite()+ "...|...chain"+ b.getChain()));

        List<Uere> uereMeasurementsBLck = sectionB.getUereMeasurementsBLck();
        uereMeasurementsBLck.forEach(b->log.info(b.getValue() + "...|..." + b.getLocation() + "...|..." + b.getServer()+ "...|..." + b.getSatellite()+ "...|...chain"+ b.getChain()));

         List<UserPosition> userPos = sectionB.getUserPositionMeasurements();
         userPos.forEach(b->log.info(b.getValue() + "...|..." + b.getLocation() + "...|..." + b.getServer()));

        StandardFileStatus standardFileStatus = sectionB.getStandardFileStatus();
        List<StandardFile> availableDocuments = standardFileStatus.getAvailableDocuments();
        availableDocuments.forEach(file->log.info(file.getFileName() + "...|..." + file.getStatus()));


        CommunicationIssue communicationIssue=sectionA.getCommunicationStatus();
        List<LinkStatus> linkHealth=communicationIssue.getBaseHealths();
        sectionA.addCommunicationStatus(communicationIssue);
        List<LinkStatus> linkStatusCopy=List.copyOf(linkHealth);
        linkStatusCopy.forEach(lh->communicationIssue.addLinkStatus(lh));
        SectionC sectionC=navicPerformanceDetails.getSectionC();
        log.info("----"+ sectionC.getGnssOffsets().size());
        log.info(sectionC.toString());

        SectionE sectionE = navicPerformanceDetails.getSectionE();
        List<Station> stationsUnderMaintenance = sectionE.getStations();
        stationsUnderMaintenance.removeIf(AppPredicate.isNotEnabled);
        sectionE.setStations(stationsUnderMaintenance);
        log.info("Stations Under Maintenance in E: "+stationsUnderMaintenance);

        SectionF sectionF = navicPerformanceDetails.getSectionF();
        List<Station> stationsUnderMaintenanceF = sectionF.getStations();
        stationsUnderMaintenanceF.removeIf(AppPredicate.isNotEnabled);
        sectionF.setStations(stationsUnderMaintenanceF);
        log.info("Stations Under Maintenance in F: "+stationsUnderMaintenanceF);

        SectionH sectionH = navicPerformanceDetails.getSectionH();
        List<StnLookAngle> stnLookAngles = sectionH.getStnLookAngles();
        stnLookAngles.removeIf(AppPredicateH.isNotEnabled);
        sectionH.setStnLookAngles(stnLookAngles);
        log.info("Station Look angles: " + stnLookAngles);







        navicRepository.save(navicPerformanceDetails);
        return "NavicPerformanceFormV1";
   }

//   @PostMapping("/addIrimsMaintenanceStation")
//
//    public String addIrimsMaintenanceStation(@ModelAttribute NavicPerformanceDetails navicPerformanceDetails, Model model){
//       SectionE sectionE =navicPerformanceDetails.getSectionE();
//        String irimsStationInMaintenance=sectionE.getStationUnderMaintenance();
//        List<Station> stationsInMaintenance= sectionE.getStations();
//        log.info("before doing "+ stationsInMaintenance.toString());
//        Station addedStation=new Station( StationName.valueOf(irimsStationInMaintenance));
////        addedStation.setName(StationName.valueOf(irimsStationInMaintenance));
//        stationsInMaintenance.add(addedStation);
//        log.info("added "+ addedStation);
//        sectionE.setStations(stationsInMaintenance);
//
//        model.addAttribute("navicPerformanceDetails",navicPerformanceDetails);
//       log.info(stationsInMaintenance.toString());
//       return "NavicPerformanceFormV1";
//
//
//   }

}
