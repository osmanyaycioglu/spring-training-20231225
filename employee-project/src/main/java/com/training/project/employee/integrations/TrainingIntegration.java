package com.training.project.employee.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.project.employee.bussiness.services.models.Employee;
import com.training.project.employee.input.rest.error.ErrorObj;
import com.training.project.employee.integrations.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class TrainingIntegration {
    private static final Logger logger = LoggerFactory.getLogger(TrainingIntegration.class);

    public boolean requestPersonInfo(Employee employeeParam){
        RestTemplate restTemplateLoc = new RestTemplate();

        String stringLoc = null;
        try {
            stringLoc = restTemplateLoc.postForObject("http://127.0.0.1:8080/api/v1/first/hello/person",
                                                      Person.builder()
                                                            .withFirstName(employeeParam.getFirstName())
                                                            .withLastName(employeeParam.getLastName())
                                                            .build(),
                                                      String.class);
        } catch (RestClientException eParam) {
            if (eParam instanceof RestClientResponseException){
                RestClientResponseException exp = (RestClientResponseException) eParam;
                ObjectMapper objectMapperLoc = new ObjectMapper();
                try {
                    ErrorObj errorObjLoc = objectMapperLoc.readValue(exp.getResponseBodyAsByteArray(),
                                                                     ErrorObj.class);
                    if (logger.isInfoEnabled()) {
                        logger.info("[TrainingIntegration][requestPersonInfo]-> " + errorObjLoc);
                    }

                } catch (IOException exParam) {
                    logger.error("[TrainingIntegration][requestPersonInfo]-> *Error* : " + eParam.getMessage(),eParam);
                }
            }
        }
        if (logger.isInfoEnabled()) {
            logger.info("[TrainingIntegration][requestPersonInfo]-> Response : " + stringLoc );
        }
        return true;

    }

}
