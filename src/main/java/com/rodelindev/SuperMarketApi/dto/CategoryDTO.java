package com.rodelindev.SuperMarketApi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private Integer idCategory;

    @NotNull
    @Size(min = 3, max = 50)
    private String nameofCategory;

    @NotNull
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;
}
