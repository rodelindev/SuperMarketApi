package com.rodelindev.SuperMarketApi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CategoryRecord(
        Integer idCategory,
        String nameCategory,
        String descriptionCategory,
        boolean enabledCategory
) {
}
