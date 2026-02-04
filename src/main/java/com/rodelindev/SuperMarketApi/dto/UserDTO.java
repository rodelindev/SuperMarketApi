package com.rodelindev.SuperMarketApi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotNull
    private Integer idUser;

    @NotNull
    //@JsonIncludeProperties(value = {"idRole"})
    private RoleDTO role;

    @NotNull
    @JsonProperty(value = "user_name")
    private String username;

    //@JsonIgnore
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String password;

    @NotNull
    private Boolean enabled;
}
