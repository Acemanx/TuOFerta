package api;

import utils.FlagsInformation;
import utils.Validar;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.UserRepository;
import model.JsonApiBodyRequest;
import model.JsonApiBodyRequest2;
import model.JsonApiBodyResponseErrors;
import model.JsonApiBodyResponseSuccess;
import model.RegistrarRequest;
import model.RegistrarRequest2;

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
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-25T19:32:17.596Z")

@Controller
public class ListarApiController implements ListarApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	FlagsInformation flags = new FlagsInformation();

	Validar validar = new Validar();

	@Autowired
	UserRepository userRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<?> listarEstadoEstadoGet(
			@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequest2 body) {

		JsonApiBodyRequest body1 = new JsonApiBodyRequest();
		JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
		JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
		// List<RegistrarRequest> lista = (List<RegistrarRequest>)
		// userRepository.findAll();
		List<RegistrarRequest> estado = userRepository.findByEstado(body.getPersona().get(0).getEstado());

		if (estado == null || estado.isEmpty()) {
			responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
			responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
			return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		} else if (!body.getPersona().get(0).getRol().equalsIgnoreCase("superadminmaster")
				|| !body.getPersona().get(0).getToken().equalsIgnoreCase("TOKEN")) {
			responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
			responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
			return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		} else {
		body1.setPersona(estado);
			return new ResponseEntity<JsonApiBodyRequest>(body1, HttpStatus.OK);
		}
		/*
		 * List<RegistrarRequest> lista = (List<RegistrarRequest>) userRepository
		 * .findByEstado(body.getPersona().get(0).getEstado());
		 * JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
		 * JsonApiBodyResponseSuccess responseSuccess = new
		 * JsonApiBodyResponseSuccess(); JsonApiBodyRequest body1 = new
		 * JsonApiBodyRequest(); if (lista.isEmpty()) {
		 * responseErrors.setCodigo(flags.CODE_3001);
		 * responseErrors.setDetalle(flags.MSN_CODE_3001); return new
		 * ResponseEntity<JsonApiBodyResponseErrors>(responseErrors,
		 * HttpStatus.BAD_REQUEST); } else { // JsonApiBodyRequest body = new
		 * JsonApiBodyRequest(); body1.setPersona(lista); return new
		 * ResponseEntity<JsonApiBodyRequest>(body1, HttpStatus.OK); }
		 */
	}

	public ResponseEntity<?> listarGet(
			@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequest2 body) {
	    String accept = request.getHeader("Accept");
		JsonApiBodyRequest body1 = new JsonApiBodyRequest();
		JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
		List<RegistrarRequest> lista = (List<RegistrarRequest>) userRepository.findAll();
		List<RegistrarRequest> token = userRepository.findByToken("SuperAdmin");


		System.out.println(body);
		

		
		if (accept != null && accept.contains("application/json")) {
		if (token == null || token.isEmpty()) {
			responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
			responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
			return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		} else if (!body.getPersona().get(0).getRol().equalsIgnoreCase("superadminmaster")
				&& !body.getPersona().get(0).getToken().equals("TOKEN")) {
			responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
			responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
			return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		} else {
			if (body.getPersona().get(0).getRol().equalsIgnoreCase("superadminmaster")
					&& body.getPersona().get(0).getToken().equals("SuperAdmin")) {
				body1.setPersona(lista);
				return new ResponseEntity<JsonApiBodyRequest>(body1, HttpStatus.OK);
			}
		}
		responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
		responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
		return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);

	}

	public ResponseEntity<?> listarIdGet(@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequest2 body) {
		String accept = request.getHeader("Accept");
		JsonApiBodyRequest body1 = new JsonApiBodyRequest();
		System.out.println(body);
		JsonApiBodyResponseErrors responseErrors = new JsonApiBodyResponseErrors();
		if (accept != null && accept.contains("application/json")) {
			RegistrarRequest persona = userRepository.findOne(body.getPersona().get(0).getId());
			System.out.println(persona);
			List<RegistrarRequest> lista = new ArrayList<RegistrarRequest>();
			if (body.getPersona().get(0).getRol().equalsIgnoreCase("SuperAdminMaster") && body.getPersona().get(0).getToken().equalsIgnoreCase("TOKEN")) { 
				lista.add(persona);
				for (RegistrarRequest registrarRequest : lista) {
					System.out.println(registrarRequest.getCorreo());
				}
				body1.setPersona(lista);
				return new ResponseEntity<JsonApiBodyRequest>(body1, HttpStatus.OK);
			} else if (persona == null) { 
				responseErrors.setCodigo(flags.CODE_1001);
				responseErrors.setDetalle(flags.MSN_CODE_1001);
				return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			} else { 
				responseErrors.setCodigo("111");
				responseErrors.setDetalle("NO TINES LOS PERMISOS PARA LISTAR, TIENES QUE SER ADMINISTRADOR.");				
				return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
			}	
		}
		return new ResponseEntity<JsonApiBodyResponseErrors>(responseErrors, HttpStatus.FAILED_DEPENDENCY);
	}

	public ResponseEntity<?> listarRolRolGet(
			@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequest2 body) {
		JsonApiBodyRequest body1 = new JsonApiBodyRequest();
		JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
		List<RegistrarRequest> rol = userRepository.findByRol(body.getPersona().get(0).getRol());

		if (rol == null || rol.isEmpty()) {
			responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
			responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
			return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		} else if (!body.getPersona().get(0).getRol().equalsIgnoreCase("superadminmaster")
				|| !body.getPersona().get(0).getToken().equalsIgnoreCase("TOKEN")) {
			responseError.setCodigo(flags.SUPERADMINMASTER_LISTAR_ERROR_CODE);
			responseError.setDetalle(flags.SUPERADMINMASTER_LISTAR_MSN);
			return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.BAD_REQUEST);
		} else {
			body1.setPersona(rol);
			return new ResponseEntity<JsonApiBodyRequest>(body1, HttpStatus.OK);
		}
		/*
		 * List<RegistrarRequest> lista = (List<RegistrarRequest>) userRepository
		 * .findByRol(body.getPersona().get(0).getRol()); JsonApiBodyResponseErrors
		 * responseErrors = new JsonApiBodyResponseErrors(); JsonApiBodyResponseSuccess
		 * responseSuccess = new JsonApiBodyResponseSuccess(); JsonApiBodyRequest body1
		 * = new JsonApiBodyRequest(); if (lista.isEmpty()) {
		 * responseErrors.setCodigo(flags.CODE_2001);
		 * responseErrors.setDetalle(flags.MSN_CODE_2001); return new
		 * ResponseEntity<JsonApiBodyResponseErrors>(responseErrors,
		 * HttpStatus.BAD_REQUEST); } else { body1.setPersona(lista); return new
		 * ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK); }
		 * 
		 */
	}

}
