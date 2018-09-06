package com.accenture.api;

import com.accenture.model.JsonApiBodyRequest;
import com.accenture.model.JsonApiBodyResponseErrors;
import com.accenture.model.JsonApiBodyResponseSuccess;
import com.accenture.model.RegistrarRequest;
import com.accenture.repository.OfertaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-14T12:25:25.106-05:00")

@Controller
public class ListarApiController implements ListarApi {

    private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private OfertaRepository oferta_respository;
    
    private JsonApiBodyResponseSuccess exito = new JsonApiBodyResponseSuccess();
    private JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
    
    @org.springframework.beans.factory.annotation.Autowired
    public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> listarGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<RegistrarRequest> ofertas= new ArrayList<>();
            	oferta_respository.findAll().forEach(ofertas::add);
            	JsonApiBodyRequest retorno= new JsonApiBodyRequest();
            	retorno.setOferta(ofertas);
                return new ResponseEntity<JsonApiBodyRequest>(retorno,HttpStatus.OK);
            } catch (Exception e) {
                error.setCodigo("");
                error.setDetalle("");
                return new ResponseEntity<JsonApiBodyResponseErrors>(error,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        error.setCodigo("");
        error.setDetalle("error de cabezera");
        return new ResponseEntity<JsonApiBodyResponseErrors>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //Listar ofertas por Negocio
    public ResponseEntity<?> listarOfertasbyNegocio(@ApiParam(value = "",required=true) @PathVariable("idnegocio") String idnegocio) {
    	 String accept = request.getHeader("Accept");
         if (accept != null && accept.contains("application/json")) {
         	 try {
              	List<RegistrarRequest> ofertas= new ArrayList<>();
              	oferta_respository.findByIdnegocio(idnegocio).forEach(ofertas::add);
              	JsonApiBodyRequest retorno= new JsonApiBodyRequest();
              	retorno.setOferta(ofertas);
                  return new ResponseEntity<JsonApiBodyRequest>(retorno,HttpStatus.OK);
              } catch (Exception e) {
                  error.setCodigo("");
                  error.setDetalle("");
                  return new ResponseEntity<JsonApiBodyResponseErrors>(error,HttpStatus.INTERNAL_SERVER_ERROR);
              }
          }
          error.setCodigo("");
          error.setDetalle("error de cabezera");
          return new ResponseEntity<JsonApiBodyResponseErrors>(error,HttpStatus.INTERNAL_SERVER_ERROR);
     }

}
