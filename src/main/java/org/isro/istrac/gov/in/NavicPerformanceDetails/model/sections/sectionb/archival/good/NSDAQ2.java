package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionb.archival.good;

import org.isro.istrac.gov.in.NavicPerformanceDetails.model.Status;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.ArchivalName;

public class NSDAQ2 extends NavigationArchival {
    public NSDAQ2(ArchivalName nsdaq2, Status status, String size) {
        super(nsdaq2,status, size);
    }
}
