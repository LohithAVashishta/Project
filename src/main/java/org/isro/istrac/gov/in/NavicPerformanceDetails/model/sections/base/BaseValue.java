package org.isro.istrac.gov.in.NavicPerformanceDetails.model.sections.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.isro.istrac.gov.in.NavicPerformanceDetails.model.enumer.Names;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseValue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "baseValueId")
    @SequenceGenerator(name = "baseValueseq",sequenceName = "baseValuelearn",allocationSize = 1)
    @Column(name = "baseValueid",updatable = false, nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Names name;
    private Double value;

    public BaseValue(Names name, Double value) {
        this.name = name;
        this.value = value;
    }
}
