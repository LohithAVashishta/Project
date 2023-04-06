package org.isro.istrac.gov.in.NavicPerformanceDetails.controller;

import lombok.extern.slf4j.Slf4j;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.NavicPerformanceDetails;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.*;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.*;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.archival.good.NavigationArchival;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.Uere;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.measurements.UserPosition;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc.GnssOffset;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc.SectionC;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionc.TwstftOffset;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiond.SchemacsHealth;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectiond.SectionD;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.SectionE;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.Station;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionf.SectionF;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh.SectionH;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh.StnLookAngle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class ViewController {
    public static  int noofGnssOffset=6;
    public static int nooftwstftOffset = 3;
    public static int noOfSchemacs = 9;
    public static int noOfArchival = 4;

    @GetMapping("performanceFormV1")
    public String showNavICPerformanceForm(@ModelAttribute NavicPerformanceDetails navicPerformanceDetails, Model model){

        System.out.println("here---------------------");

       SectionB sectionB = new SectionB();
       ArchivalName archivalListName[] = {ArchivalName.NSOP2, ArchivalName.NSOP4, ArchivalName.NSDAQ1, ArchivalName.NSDAQ2};
       List<NavigationArchival> archivalList= new ArrayList<>();
        for(int i=0; i<noOfArchival; i++){
            NavigationArchival navigationArchival = new NavigationArchival();
            navigationArchival.setName(ArchivalName.valueOf(archivalListName[i].toString()));
            navigationArchival.setStatus(Status.OK);
            archivalList.add(navigationArchival);

            log.info("This is navigation archival: " + navigationArchival.getName());
        }
        sectionB.setArchivalList(archivalList);

        StandardFileStatus standardFileStatus = getStandardFileStatus();
        sectionB.setStandardFileStatus(standardFileStatus);

        String serverList[] = {"INC1NSOP2", "INC1NSOP4", "INC2NSOP1", "INC2NSOP2"};
        String satelliteList[] = {"SAT02", "SAT03", "SAT06", "SAT09"};
        String locationList[] = {"LCK", "BLR"};
        String locationListStnLookAngles[] = {"Bengaluru", "Lucknow", "Hassan", "Delhi", "Port Blair", "Mauritius"};

        List<Uere> uereBlrA = getMeasurementsABlr();
        sectionB.setUereMeasurementsABlr(uereBlrA);

        List<Uere> uereBlrB = getMeasurementsBBlr();
        sectionB.setUereMeasurementsBBlr(uereBlrB);

        List<Uere> uereLckA = getMeasurementsALck();
        sectionB.setUereMeasurementsALck(uereLckA);

        List<Uere> uereLckB = getMeasurementsBLck();
        sectionB.setUereMeasurementsBLck(uereLckB);

        List<UserPosition> userPositions = getUserPosition();
        sectionB.setUserPositionMeasurements(userPositions);

        navicPerformanceDetails.setSectionB(sectionB);





        Names gnssNames[] = {Names.ItsAGnss, Names.ItsBGnss, Names.ItsCGnss, Names.VremyaA, Names.VremyaB, Names.ItsInc2};
        List<GnssOffset> gnssOffsets=new ArrayList<>();
        SectionC sectionC = new SectionC();
        for(int i=0;i<noofGnssOffset;i++){
            GnssOffset gnssOffset=new GnssOffset();
            gnssOffset.setName(gnssNames[i]);
            gnssOffsets.add(gnssOffset);
        }

        Names twstft[] = {Names.TwstftOffsetItsA, Names.TwstftOffsetItsB, Names.TwstftOffsetItsC};
        List<TwstftOffset> twstftOffsets=new ArrayList<>();

        for(int i=0; i<nooftwstftOffset; i++) {
            TwstftOffset twstftOffset = new TwstftOffset();
            twstftOffset.setName(twstft[i]);
            twstftOffsets.add(twstftOffset);
        }
        sectionC.setGnssOffsets(gnssOffsets);
        sectionC.setTwstftOffsets(twstftOffsets);
        navicPerformanceDetails.setSectionC(sectionC);

        SectionD sectionD = new SectionD();
        Names schemacs[] = {Names.MonitStatus, Names.Inc1Cs5, Names.Inc1Cs6, Names.Inc1Cs7, Names.Inc1Cs8, Names.Inc2Cs5, Names.Inc2Cs6, Names.Inc2Cs7, Names.Inc2Cs8};
        List<SchemacsHealth> schemacsHealthList = new ArrayList<>();
        for (int i=0; i<noOfSchemacs; i++) {
            SchemacsHealth schemacsHealth = new SchemacsHealth();
            schemacsHealth.setName(schemacs[i]);
            schemacsHealthList.add(schemacsHealth);
        }
        sectionD.setSchemacsHealths(schemacsHealthList);
        navicPerformanceDetails.setSectionD(sectionD);

        SectionE sectionE = new SectionE();
        List<Station> stationsToBeShownInUI = getStations();
        sectionE.setStations(stationsToBeShownInUI);
        navicPerformanceDetails.setSectionE(sectionE);

        SectionF sectionF = new SectionF();
        List<Station> stationsToBeShownInFUI = getStations();
        sectionF.setStations(stationsToBeShownInFUI);
        navicPerformanceDetails.setSectionF(sectionF);

        SectionH sectionH = new SectionH();
        List<StnLookAngle> stnLookAngleList = getStnLookAngles();
        sectionH.setStnLookAngles(stnLookAngleList);
        navicPerformanceDetails.setSectionH(sectionH);



        log.info("Stations TO Be shown:  "+stationsToBeShownInUI.toString());

//        model.addAttribute("stationsToBeShownInUI",stationsToBeShownInUI);
        model.addAttribute("serverList", serverList);
        model.addAttribute("satelliteList", satelliteList);
        model.addAttribute("locationList", locationList);
        model.addAttribute("locationListStnLookAngles", locationListStnLookAngles);
        model.addAttribute("navicPerformanceDetails", navicPerformanceDetails);
        log.info("---asdas--"+sectionD.toString());
        return "NavicPerformanceFormV1";
    }

    private static List<StnLookAngle> getStnLookAngles() {
        List<StnLookAngle> stnLookAngles = new ArrayList<>();

        StnLookAngle blrStn = new StnLookAngle();
        blrStn.setLocation("Bengaluru");
        blrStn.setEnable(false);
        blrStn.setAvailableTill(LocalDateTime.now());
        stnLookAngles.add(blrStn);

        StnLookAngle hsnStn = new StnLookAngle();
        hsnStn.setLocation("Hassan");
        hsnStn.setEnable(false);
        hsnStn.setAvailableTill(LocalDateTime.now());
        stnLookAngles.add(hsnStn);

        StnLookAngle lckStn = new StnLookAngle();
        lckStn.setLocation("Lucknow");
        lckStn.setEnable(false);
        lckStn.setAvailableTill(LocalDateTime.now());
        stnLookAngles.add(lckStn);

        StnLookAngle dliStn = new StnLookAngle();
        dliStn.setLocation("Delhi");
        dliStn.setEnable(false);
        dliStn.setAvailableTill(LocalDateTime.now());
        stnLookAngles.add(dliStn);

        StnLookAngle pblrStn = new StnLookAngle();
        pblrStn.setLocation("Port Blair");
        pblrStn.setEnable(false);
        pblrStn.setAvailableTill(LocalDateTime.now());
        stnLookAngles.add(pblrStn);

        StnLookAngle mrtStn = new StnLookAngle();
        mrtStn.setLocation("Mauritius");
        mrtStn.setEnable(false);
        mrtStn.setAvailableTill(LocalDateTime.now());
        stnLookAngles.add(mrtStn);

        return stnLookAngles;
    }

    private List<UserPosition> getUserPosition() {
        List<UserPosition> userPositions=new ArrayList<>();

        UserPosition m0= new UserPosition();
        m0.setLocation("LCK");
        m0.setServer("INC1NSOP2");
        userPositions.add(m0);

        UserPosition m1= new UserPosition();
        m1.setLocation("LCK");
        m1.setServer("INC1NSOP4");
        userPositions.add(m1);

        UserPosition m2= new UserPosition();
        m2.setLocation("LCK");
        m2.setServer("INC2NSOP1");
        userPositions.add(m2);

        UserPosition m3 = new UserPosition();
        m3.setLocation("LCK");
        m3.setServer("INC2NSOP2");
        userPositions.add(m3);

        UserPosition m4= new UserPosition();
        m4.setLocation("BLR");
        m4.setServer("INC1NSOP2");
        userPositions.add(m4);

        UserPosition m5= new UserPosition();
        m5.setLocation("BLR");
        m5.setServer("INC1NSOP4");
        userPositions.add(m5);

        UserPosition m6= new UserPosition();
        m6.setLocation("BLR");
        m6.setServer("INC2NSOP1");
        userPositions.add(m6);

        UserPosition m7 = new UserPosition();
        m7.setLocation("BLR");
        m7.setServer("INC2NSOP2");
        userPositions.add(m7);

        return userPositions;

    }

    private static List<Station> getStations() {
        List<Station> stationsToBeShownInUI = new ArrayList<>();

        Station blrStn = new Station();
        blrStn.setName("Bengaluru");
        blrStn.setEnable(false);
        stationsToBeShownInUI.add(blrStn);

        Station dlhStn = new Station();
        dlhStn.setName("Delhi");
        dlhStn.setEnable(false);
        stationsToBeShownInUI.add(dlhStn);

        Station hsnStn = new Station();
        hsnStn.setName("Hassan");
        hsnStn.setEnable(false);
        stationsToBeShownInUI.add(hsnStn);

        Station lckStn = new Station();
        lckStn.setName("Lucknow");
        lckStn.setEnable(false);
        stationsToBeShownInUI.add(lckStn);

        Station pblrStn = new Station();
        pblrStn.setName("PortBlair");
        pblrStn.setEnable(false);
        stationsToBeShownInUI.add(pblrStn);


        return stationsToBeShownInUI;
    }

    private static StandardFileStatus getStandardFileStatus() {
        StandardFileStatus standardFileStatus = new StandardFileStatus();
        List<StandardFile> availableDocuments = new ArrayList<>();

        StandardFile file1= new StandardFile();
        file1.setFileName("Doc1.txt");
        availableDocuments.add(file1);

        StandardFile file2= new StandardFile();
        file2.setFileName("Doc2.txt");
        availableDocuments.add(file2);

        StandardFile file3= new StandardFile();
        file3.setFileName("Doc3.txt");
        availableDocuments.add(file3);

        StandardFile file4= new StandardFile();
        file4.setFileName("Doc4.txt");
        availableDocuments.add(file4);

        StandardFile file5= new StandardFile();
        file5.setFileName("Doc5.txt");
        availableDocuments.add(file5);
        standardFileStatus.setAvailableDocuments(availableDocuments);
        return standardFileStatus;
    }

    private static List<Uere> getMeasurementsABlr() {
        List<Uere> uereBlrA = new ArrayList<>();

        Uere m0= new Uere();
        m0.setLocation("BLR");
        m0.setServer("INC1NSOP2");
        m0.setSatellite("SAT02");
        m0.setChain("A");
        uereBlrA.add(m0);

        Uere m1= new Uere();
        m1.setLocation("BLR");
        m1.setServer("INC1NSOP4");
        m1.setSatellite("SAT02");
        m1.setChain("A");
        uereBlrA.add(m1);

        Uere m2= new Uere();
        m2.setLocation("BLR");
        m2.setServer("INC2NSOP1");
        m2.setSatellite("SAT02");
        m2.setChain("A");
        uereBlrA.add(m2);

        Uere m3 = new Uere();
        m3.setLocation("BLR");
        m3.setServer("INC2NSOP2");
        m3.setSatellite("SAT02");
        m3.setChain("A");
        uereBlrA.add(m3);

        Uere m4= new Uere();
        m4.setLocation("BLR");
        m4.setServer("INC1NSOP2");
        m4.setSatellite("SAT03");
        m4.setChain("A");
        uereBlrA.add(m4);

        Uere m5= new Uere();
        m5.setLocation("BLR");
        m5.setServer("INC1NSOP4");
        m5.setSatellite("SAT03");
        m5.setChain("A");
        uereBlrA.add(m5);

        Uere m6= new Uere();
        m6.setLocation("BLR");
        m6.setServer("INC2NSOP1");
        m6.setSatellite("SAT03");
        m6.setChain("A");
        uereBlrA.add(m6);

        Uere m7 = new Uere();
        m7.setLocation("BLR");
        m7.setServer("INC2NSOP2");
        m7.setSatellite("SAT03");
        m7.setChain("A");
        uereBlrA.add(m7);

        Uere m8= new Uere();
        m8.setLocation("BLR");
        m8.setServer("INC1NSOP2");
        m8.setSatellite("SAT06");
        m8.setChain("A");
        uereBlrA.add(m8);

        Uere m9= new Uere();
        m9.setLocation("BLR");
        m9.setServer("INC1NSOP4");
        m9.setSatellite("SAT06");
        m9.setChain("A");
        uereBlrA.add(m9);

        Uere m10= new Uere();
        m10.setLocation("BLR");
        m10.setServer("INC2NSOP1");
        m10.setSatellite("SAT06");
        m10.setChain("A");
        uereBlrA.add(m10);

        Uere m11 = new Uere();
        m11.setLocation("BLR");
        m11.setServer("INC2NSOP2");
        m11.setSatellite("SAT06");
        m11.setChain("A");
        uereBlrA.add(m11);

        Uere m12= new Uere();
        m12.setLocation("BLR");
        m12.setServer("INC1NSOP2");
        m12.setSatellite("SAT09");
        m12.setChain("A");
        uereBlrA.add(m12);

        Uere m13= new Uere();
        m13.setLocation("BLR");
        m13.setServer("INC1NSOP4");
        m13.setSatellite("SAT09");
        m13.setChain("A");
        uereBlrA.add(m13);

        Uere m14= new Uere();
        m14.setLocation("BLR");
        m14.setServer("INC2NSOP1");
        m14.setSatellite("SAT09");
        m14.setChain("A");
        uereBlrA.add(m14);

        Uere m15 = new Uere();
        m15.setLocation("BLR");
        m15.setServer("INC2NSOP2");
        m15.setSatellite("SAT09");
        m15.setChain("A");
        uereBlrA.add(m15);

        return uereBlrA;
    }


    private static List<Uere> getMeasurementsBBlr() {
        List<Uere> uereBlrB = new ArrayList<>();

        Uere m0= new Uere();
        m0.setLocation("BLR");
        m0.setServer("INC1NSOP2");
        m0.setSatellite("SAT02");
        m0.setChain("B");
        uereBlrB.add(m0);

        Uere m1= new Uere();
        m1.setLocation("BLR");
        m1.setServer("INC1NSOP4");
        m1.setSatellite("SAT02");
        m1.setChain("B");
        uereBlrB.add(m1);

        Uere m2= new Uere();
        m2.setLocation("BLR");
        m2.setServer("INC2NSOP1");
        m2.setSatellite("SAT02");
        m2.setChain("B");
        uereBlrB.add(m2);

        Uere m3 = new Uere();
        m3.setLocation("BLR");
        m3.setServer("INC2NSOP2");
        m3.setSatellite("SAT02");
        m3.setChain("B");
        uereBlrB.add(m3);

        Uere m4= new Uere();
        m4.setLocation("BLR");
        m4.setServer("INC1NSOP2");
        m4.setSatellite("SAT03");
        m4.setChain("B");
        uereBlrB.add(m4);

        Uere m5= new Uere();
        m5.setLocation("BLR");
        m5.setServer("INC1NSOP4");
        m5.setSatellite("SAT03");
        m5.setChain("B");
        uereBlrB.add(m5);

        Uere m6= new Uere();
        m6.setLocation("BLR");
        m6.setServer("INC2NSOP1");
        m6.setSatellite("SAT03");
        m6.setChain("B");
        uereBlrB.add(m6);

        Uere m7 = new Uere();
        m7.setLocation("BLR");
        m7.setServer("INC2NSOP2");
        m7.setSatellite("SAT03");
        m7.setChain("B");
        uereBlrB.add(m7);

        Uere m8= new Uere();
        m8.setLocation("BLR");
        m8.setServer("INC1NSOP2");
        m8.setSatellite("SAT06");
        m8.setChain("B");
        uereBlrB.add(m8);

        Uere m9= new Uere();
        m9.setLocation("BLR");
        m9.setServer("INC1NSOP4");
        m9.setSatellite("SAT06");
        m9.setChain("B");
        uereBlrB.add(m9);

        Uere m10= new Uere();
        m10.setLocation("BLR");
        m10.setServer("INC2NSOP1");
        m10.setSatellite("SAT06");
        m10.setChain("B");
        uereBlrB.add(m10);

        Uere m11 = new Uere();
        m11.setLocation("BLR");
        m11.setServer("INC2NSOP2");
        m11.setSatellite("SAT06");
        m11.setChain("B");
        uereBlrB.add(m11);

        Uere m12= new Uere();
        m12.setLocation("BLR");
        m12.setServer("INC1NSOP2");
        m12.setSatellite("SAT09");
        m12.setChain("B");
        uereBlrB.add(m12);

        Uere m13= new Uere();
        m13.setLocation("BLR");
        m13.setServer("INC1NSOP4");
        m13.setSatellite("SAT09");
        m13.setChain("B");
        uereBlrB.add(m13);

        Uere m14= new Uere();
        m14.setLocation("BLR");
        m14.setServer("INC2NSOP1");
        m14.setSatellite("SAT09");
        m14.setChain("B");
        uereBlrB.add(m14);

        Uere m15 = new Uere();
        m15.setLocation("BLR");
        m15.setServer("INC2NSOP2");
        m15.setSatellite("SAT09");
        m15.setChain("B");
        uereBlrB.add(m15);

        return uereBlrB;
    }

    private static List<Uere> getMeasurementsALck() {
        List<Uere> uereLckA = new ArrayList<>();

        Uere m0= new Uere();
        m0.setLocation("LCK");
        m0.setServer("INC1NSOP2");
        m0.setSatellite("SAT02");
        m0.setChain("A");
        uereLckA.add(m0);

        Uere m1= new Uere();
        m1.setLocation("LCK");
        m1.setServer("INC1NSOP4");
        m1.setSatellite("SAT02");
        m1.setChain("A");
        uereLckA.add(m1);

        Uere m2= new Uere();
        m2.setLocation("LCK");
        m2.setServer("INC2NSOP1");
        m2.setSatellite("SAT02");
        m2.setChain("A");
        uereLckA.add(m2);

        Uere m3 = new Uere();
        m3.setLocation("LCK");
        m3.setServer("INC2NSOP2");
        m3.setSatellite("SAT02");
        m3.setChain("A");
        uereLckA.add(m3);

        Uere m4= new Uere();
        m4.setLocation("LCK");
        m4.setServer("INC1NSOP2");
        m4.setSatellite("SAT03");
        m4.setChain("A");
        uereLckA.add(m4);

        Uere m5= new Uere();
        m5.setLocation("LCK");
        m5.setServer("INC1NSOP4");
        m5.setSatellite("SAT03");
        m5.setChain("A");
        uereLckA.add(m5);

        Uere m6= new Uere();
        m6.setLocation("LCK");
        m6.setServer("INC2NSOP1");
        m6.setSatellite("SAT03");
        m6.setChain("A");
        uereLckA.add(m6);

        Uere m7 = new Uere();
        m7.setLocation("LCK");
        m7.setServer("INC2NSOP2");
        m7.setSatellite("SAT03");
        m7.setChain("A");
        uereLckA.add(m7);

        Uere m8= new Uere();
        m8.setLocation("LCK");
        m8.setServer("INC1NSOP2");
        m8.setSatellite("SAT06");
        m8.setChain("A");
        uereLckA.add(m8);

        Uere m9= new Uere();
        m9.setLocation("LCK");
        m9.setServer("INC1NSOP4");
        m9.setSatellite("SAT06");
        m9.setChain("A");
        uereLckA.add(m9);

        Uere m10= new Uere();
        m10.setLocation("LCK");
        m10.setServer("INC2NSOP1");
        m10.setSatellite("SAT06");
        m10.setChain("A");
        uereLckA.add(m10);

        Uere m11 = new Uere();
        m11.setLocation("LCK");
        m11.setServer("INC2NSOP2");
        m11.setSatellite("SAT06");
        m11.setChain("A");
        uereLckA.add(m11);

        Uere m12= new Uere();
        m12.setLocation("LCK");
        m12.setServer("INC1NSOP2");
        m12.setSatellite("SAT09");
        m12.setChain("A");
        uereLckA.add(m12);

        Uere m13= new Uere();
        m13.setLocation("LCK");
        m13.setServer("INC1NSOP4");
        m13.setSatellite("SAT09");
        m13.setChain("A");
        uereLckA.add(m13);

        Uere m14= new Uere();
        m14.setLocation("LCK");
        m14.setServer("INC2NSOP1");
        m14.setSatellite("SAT09");
        m14.setChain("A");
        uereLckA.add(m14);

        Uere m15 = new Uere();
        m15.setLocation("LCK");
        m15.setServer("INC2NSOP2");
        m15.setSatellite("SAT09");
        m15.setChain("A");
        uereLckA.add(m15);

        return uereLckA;
    }

    private static List<Uere> getMeasurementsBLck() {
        List<Uere> uereLckB = new ArrayList<>();

        Uere m0= new Uere();
        m0.setLocation("LCK");
        m0.setServer("INC1NSOP2");
        m0.setSatellite("SAT02");
        m0.setChain("B");
        uereLckB.add(m0);

        Uere m1= new Uere();
        m1.setLocation("LCK");
        m1.setServer("INC1NSOP4");
        m1.setSatellite("SAT02");
        m1.setChain("B");
        uereLckB.add(m1);

        Uere m2= new Uere();
        m2.setLocation("LCK");
        m2.setServer("INC2NSOP1");
        m2.setSatellite("SAT02");
        m2.setChain("B");
        uereLckB.add(m2);

        Uere m3 = new Uere();
        m3.setLocation("LCK");
        m3.setServer("INC2NSOP2");
        m3.setSatellite("SAT02");
        m3.setChain("B");
        uereLckB.add(m3);

        Uere m4= new Uere();
        m4.setLocation("LCK");
        m4.setServer("INC1NSOP2");
        m4.setSatellite("SAT03");
        m4.setChain("B");
        uereLckB.add(m4);

        Uere m5= new Uere();
        m5.setLocation("LCK");
        m5.setServer("INC1NSOP4");
        m5.setSatellite("SAT03");
        m5.setChain("B");
        uereLckB.add(m5);

        Uere m6= new Uere();
        m6.setLocation("LCK");
        m6.setServer("INC2NSOP1");
        m6.setSatellite("SAT03");
        m6.setChain("B");
        uereLckB.add(m6);

        Uere m7 = new Uere();
        m7.setLocation("LCK");
        m7.setServer("INC2NSOP2");
        m7.setSatellite("SAT03");
        m7.setChain("B");
        uereLckB.add(m7);

        Uere m8= new Uere();
        m8.setLocation("LCK");
        m8.setServer("INC1NSOP2");
        m8.setSatellite("SAT06");
        m8.setChain("B");
        uereLckB.add(m8);

        Uere m9= new Uere();
        m9.setLocation("LCK");
        m9.setServer("INC1NSOP4");
        m9.setSatellite("SAT06");
        m9.setChain("B");
        uereLckB.add(m9);

        Uere m10= new Uere();
        m10.setLocation("LCK");
        m10.setServer("INC2NSOP1");
        m10.setSatellite("SAT06");
        m10.setChain("B");
        uereLckB.add(m10);

        Uere m11 = new Uere();
        m11.setLocation("LCK");
        m11.setServer("INC2NSOP2");
        m11.setSatellite("SAT06");
        m11.setChain("B");
        uereLckB.add(m11);

        Uere m12= new Uere();
        m12.setLocation("LCK");
        m12.setServer("INC1NSOP2");
        m12.setSatellite("SAT09");
        m12.setChain("B");
        uereLckB.add(m12);

        Uere m13= new Uere();
        m13.setLocation("LCK");
        m13.setServer("INC1NSOP4");
        m13.setSatellite("SAT09");
        m13.setChain("B");
        uereLckB.add(m13);

        Uere m14= new Uere();
        m14.setLocation("LCK");
        m14.setServer("INC2NSOP1");
        m14.setSatellite("SAT09");
        m14.setChain("B");
        uereLckB.add(m14);

        Uere m15 = new Uere();
        m15.setLocation("LCK");
        m15.setServer("INC2NSOP2");
        m15.setSatellite("SAT09");
        m15.setChain("B");
        uereLckB.add(m15);

        return uereLckB;
    }




    @GetMapping("performanceFormV2")
    public String showNavICPerformanceFormV2(){
        return "NavicPerformanceFormV2";
    }
}
