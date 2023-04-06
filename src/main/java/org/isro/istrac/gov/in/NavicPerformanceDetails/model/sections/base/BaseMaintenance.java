package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione.Station;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseMaintenance extends BaseIssues {


    @OneToMany(mappedBy = "baseMaintenance",cascade = CascadeType.ALL)
    public List<Station> stations=new ArrayList<>();
//
//    public int idx;
//
//    public Boolean enable;



    public BaseMaintenance(String issues, List<Station> stations, String stationUnderMaintenance) {
        super(issues);
        this.stations = stations;

    }
    public void addStation(Station station){
        this.stations.add(station);
        station.setBaseMaintenance(this);
    }
}
