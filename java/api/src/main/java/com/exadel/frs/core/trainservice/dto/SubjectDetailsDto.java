package com.exadel.frs.core.trainservice.dto;

import com.exadel.frs.commonservice.entity.SubjectDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.exadel.frs.core.trainservice.system.global.Constants.IMAGE_WITH_ONE_FACE_DESC;

/* SITA MCoE - SubjectDetailsDto for request/response */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDetailsDto {

    @ApiParam(value = "flagged")
    @JsonProperty("flagged")
    @Nullable
    private Boolean flagged;

    @JsonProperty("image")
    @NotNull
    @ApiParam(value = IMAGE_WITH_ONE_FACE_DESC, required = true)
    private String image;

    @ApiParam(value = "first or given name(s) as shown on document", required = true)
    @JsonProperty("given_names")
    @NotBlank(message = "given_names cannot be empty")
    private String givenNames;

    @ApiParam(value = "last or family surname as shown on document", required = true)
    @JsonProperty("family_name")
    @NotNull(message = "family_name cannot be null - use empty filler if not present")
    private String familyName;

    @ApiParam(value = "sex or gender M/F/X as shown on document", required = true)
    @JsonProperty("sex")
    @NotBlank(message = "sex cannot be empty")
    private String gender;

    @ApiParam(value = "Date of birth as shown on document", required = true)
    @JsonProperty("dob")
    @NotBlank(message = "dob cannot be empty")
    private String dateOfBirth;

    @ApiParam(value = "Nationality as shown on document")
    @JsonProperty("nationality")
    @Nullable
    private String nationality;

    @ApiParam(value = "Document type - P/V", required = true)
    @JsonProperty("document_type")
    @NotBlank(message = "document_type cannot be empty")
    private String documentType;

    @ApiParam(value = "Document number", required = true)
    @JsonProperty("document_number")
    @NotBlank(message = "document_number cannot be empty")
    private String documentNumber;

    @ApiParam(value = "Issuing state of document")
    @JsonProperty("issuing_state")
    @Nullable
    private String issuingState;

    @ApiParam(value = "Expiry date of document", required = true)
    @JsonProperty("expiry_date")
    @NotBlank(message = "expiry_date cannot be empty")
    private String expiryDate;

    @ApiParam(value = "Itinerary of traveller")
    @JsonProperty("itinerary")
    @Nullable
    private String itinerary;

    @ApiParam(value = "Risk assessment of traveller")
    @JsonProperty("assessment")
    @Nullable
    private String assessment;

    @ApiParam(value = "Unique passenger key")
    @JsonProperty("upk")
    @Nullable
    private String upk;

    public String getName() {
        if (getGivenNames() != null && getFamilyName() != null)
           return getGivenNames() + " " + getFamilyName();
        else
            return "unknown";
    }

    public SubjectDetailsDto(SubjectDetails subjectDetails) {
        this.flagged = subjectDetails.getFlagged();
        this.givenNames = subjectDetails.getGivenNames();
        this.familyName = subjectDetails.getFamilyName();
        this.dateOfBirth = subjectDetails.getDateOfBirth();
        this.gender = subjectDetails.getGender();
        this.nationality = subjectDetails.getNationality();
        this.documentType = subjectDetails.getDocumentType();
        this.documentNumber = subjectDetails.getDocumentNumber();
        this.issuingState = subjectDetails.getIssuingState();
        this.expiryDate = subjectDetails.getExpiryDate();
        this.itinerary = subjectDetails.getItinerary();
        this.assessment = subjectDetails.getAssessment();
        this.upk = subjectDetails.getUpk();
    }

}
