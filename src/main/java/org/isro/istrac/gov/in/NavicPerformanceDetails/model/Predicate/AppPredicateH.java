package org.isro.istrac.gov.in.NavicPerformanceDetails.model.Predicate;

import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.Station;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectionh.StnLookAngle;

import java.util.function.Predicate;

public class AppPredicateH {
    public static Predicate<StnLookAngle> isNotEnabled= station -> station.getEnable().equals(false);
}
