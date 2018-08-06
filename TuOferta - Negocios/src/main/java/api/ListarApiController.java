package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.NegocioRepository;
import model.JsonApiBodyRequest;
import model.JsonApiBodyResponseErrors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-01T20:14:25.176Z")

@Controller
public class ListarApiController implements ListarApi {

    @Autowired
    NegocioRepository negocioRepository;
    
	private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    


    @org.springframework.beans.factory.annotation.Autowired
    public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<JsonApiBodyRequest> listarGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequest>(objectMapper.readValue("{  \"persona\" : [ {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  }, {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequest.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequest> listarIdadminIdadminGet(@ApiParam(value = "Id de la persona dueña del negocio",required=true) @PathVariable("idadmin") String idadmin) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequest>(objectMapper.readValue("{  \"persona\" : [ {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  }, {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequest.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequest> listarIdnegocioGet(@ApiParam(value = "ID del negocio",required=true) @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequest>(objectMapper.readValue("{  \"persona\" : [ {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  }, {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequest.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<JsonApiBodyRequest> listarTiponegocioTiponegocioGet(@ApiParam(value = "Tipo de negocio",required=true) @PathVariable("tiponegocio") String tiponegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JsonApiBodyRequest>(objectMapper.readValue("{  \"persona\" : [ {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  }, {    \"idnegocio\" : \"idnegocio\",    \"nombre_negocio\" : \"nombre_negocio\",    \"tipo\" : \"tipo\",    \"ubicacion\" : \"ubicacion\",    \"foto\" : \"foto\",    \"correo\" : \"correo\",    \"nit\" : \"nit\",    \"idadmin\" : \"idadmin\",    \"telefono\" : \"telefono\",    \"detalle\" : \"detalle\"  } ]}", JsonApiBodyRequest.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

}
