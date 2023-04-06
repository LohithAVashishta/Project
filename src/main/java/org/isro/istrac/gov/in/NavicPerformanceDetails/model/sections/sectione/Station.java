package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.sectione;


import lombok.*;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.StationName;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base.BaseMaintenance;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor

public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StnNamesIdSeq")
    @SequenceGenerator(name = "StnNamesIdSeq",sequenceName = "StnNamesIdLearn",allocationSize = 1)
    @Column(name = "StnNameId",updatable = false, nullable = false)
    private Long id;

    public Boolean enable;

    @ManyToOne
    private BaseMaintenance baseMaintenance;


//    @Enumerated(EnumType.STRING)
    private String name;

    public Station(String name) {
        this.name = name;
    }



}
