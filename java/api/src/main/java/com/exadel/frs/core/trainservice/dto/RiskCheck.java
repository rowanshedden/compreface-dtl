package com.exadel.frs.core.trainservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskCheck {

    @JsonProperty("check")
    private String check;

    @JsonProperty("passed")
    private String passed;

}
