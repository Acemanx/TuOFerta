package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.RegistrarRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JsonApiBodyRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-06T16:22:00.908Z")

public class JsonApiBodyRequest   {
  @JsonProperty("usuario")
  @Valid
  private List<RegistrarRequest> usuario = null;

  public JsonApiBodyRequest usuario(List<RegistrarRequest> usuario) {
    this.usuario = usuario;
    return this;
  }

  public JsonApiBodyRequest addUsuarioItem(RegistrarRequest usuarioItem) {
    if (this.usuario == null) {
      this.usuario = new ArrayList<RegistrarRequest>();
    }
    this.usuario.add(usuarioItem);
    return this;
  }

  /**
   * Get usuario
   * @return usuario
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RegistrarRequest> getUsuario() {
    return usuario;
  }

  public void setUsuario(List<RegistrarRequest> usuario) {
    this.usuario = usuario;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiBodyRequest jsonApiBodyRequest = (JsonApiBodyRequest) o;
    return Objects.equals(this.usuario, jsonApiBodyRequest.usuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiBodyRequest {\n");
    
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

