package com.exadel.frs.core.trainservice.controller;

import com.exadel.frs.commonservice.entity.App;
import com.exadel.frs.commonservice.entity.Model;
import com.exadel.frs.commonservice.repository.ModelRepository;
import com.exadel.frs.core.trainservice.repository.AppRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.exadel.frs.core.trainservice.system.global.Constants.API_V1;

/**
 * SITA MCoE
 * Cheeky little workaround to obtain the apikey for the first recognition service with no security controls
 */

@Validated
@RestController
@RequestMapping(API_V1 + "/backdoor")
@RequiredArgsConstructor
public class BackdoorController {

    private final AppRepository appRepository;
    private final ModelRepository modelRepository;

    /**
     * Get recognition service apikey for nominated CompreFace application
     * specify 'default' to return the apikey of the first application
     *
     * @param application CompreFace application name or "default"
     * @return apikey - "0" means not found
     */
    @GetMapping(value = "/{application}")
    @ApiOperation(value = "Get recognition service apikey for nominated CompreFace application - specify 'default' to return the apikey of the first application")
    public ResponseEntity<String> getApikey(
            @ApiParam(value = "Application name", required = false, example = "Digital Travel Lane")
            @PathVariable final String application
    ) {
        String apikey = "0";
        if (application.equalsIgnoreCase("default")) {
            List<Model> models = modelRepository.findAll();
            for (Model model : models) {
                if (model.getType().getCode().equals("R")) {
                    apikey = model.getApiKey();
                    break;
                }
            }
        } else {
            List<App> apps = appRepository.findAllByOrderByNameAsc();
            for (App app : apps) {
                if (app.getName().equalsIgnoreCase(application)) {
                    List<Model> models = app.getModels();
                    for (Model model : models) {
                        if (model.getType().getCode().equalsIgnoreCase("R")) {
                            apikey = model.getApiKey();
                            break;
                        }
                    }
                }
            }
        }
        return ResponseEntity.ok(apikey);
    }

}
