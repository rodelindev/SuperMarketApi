package com.rodelindev.SuperMarketApi.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class IngressDetailPK {

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_ingress", foreignKey = @ForeignKey(name = "INGRESS_DETAIL_ING"))
    private Ingress ingress;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_product", foreignKey = @ForeignKey(name = "INGRESS_DETAIL_PRO"))
    private Product product;
}
