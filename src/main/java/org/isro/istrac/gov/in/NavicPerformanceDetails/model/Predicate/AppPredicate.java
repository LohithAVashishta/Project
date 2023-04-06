package org.isro.istrac.gov.in.NavicPerformanceDetails.model.Predicate;

import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.Station;

import java.util.function.Predicate;

public class AppPredicate {
        public static Predicate<Station> isNotEnabled= station -> station.getEnable().equals(false);

}
