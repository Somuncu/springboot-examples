package com.example.projectpostgre.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "kisi_adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres {
    @Id
    @SequenceGenerator(name = "seq_kisi_adres", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "adres")
    private String adres;

    @Enumerated
    private AdresTip adresTip;

    @Column(name = "aktif")
    private Boolean aktif;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    public enum AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
}
