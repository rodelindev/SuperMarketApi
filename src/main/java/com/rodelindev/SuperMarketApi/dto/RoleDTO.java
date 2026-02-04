package com.rodelindev.SuperMarketApi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO {

    @NotNull
    private Integer idRole;

    @NotNull
    @Size(min = 3, max = 50)
    private String nameRole;

    @NotNull
    private Boolean enabledRole;
}
