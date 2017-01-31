/**
 * WSO2 API Manager - Publisher API
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  It is written with [swagger 2](http://swagger.io/). 
 *
 * OpenAPI spec version: 0.10.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.wso2.carbon.apimgt.integration.client.publisher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * CORS configuration for the API 
 */
@ApiModel(description = "CORS configuration for the API ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-01-24T00:03:49.624+05:30")
public class APICorsConfiguration   {
  @JsonProperty("corsConfigurationEnabled")
  private Boolean corsConfigurationEnabled = false;

  @JsonProperty("accessControlAllowOrigins")
  private List<String> accessControlAllowOrigins = new ArrayList<String>();

  @JsonProperty("accessControlAllowCredentials")
  private Boolean accessControlAllowCredentials = false;

  @JsonProperty("accessControlAllowHeaders")
  private List<String> accessControlAllowHeaders = new ArrayList<String>();

  @JsonProperty("accessControlAllowMethods")
  private List<String> accessControlAllowMethods = new ArrayList<String>();

  public APICorsConfiguration corsConfigurationEnabled(Boolean corsConfigurationEnabled) {
    this.corsConfigurationEnabled = corsConfigurationEnabled;
    return this;
  }

   /**
   * Get corsConfigurationEnabled
   * @return corsConfigurationEnabled
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getCorsConfigurationEnabled() {
    return corsConfigurationEnabled;
  }

  public void setCorsConfigurationEnabled(Boolean corsConfigurationEnabled) {
    this.corsConfigurationEnabled = corsConfigurationEnabled;
  }

  public APICorsConfiguration accessControlAllowOrigins(List<String> accessControlAllowOrigins) {
    this.accessControlAllowOrigins = accessControlAllowOrigins;
    return this;
  }

  public APICorsConfiguration addAccessControlAllowOriginsItem(String accessControlAllowOriginsItem) {
    this.accessControlAllowOrigins.add(accessControlAllowOriginsItem);
    return this;
  }

   /**
   * Get accessControlAllowOrigins
   * @return accessControlAllowOrigins
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<String> getAccessControlAllowOrigins() {
    return accessControlAllowOrigins;
  }

  public void setAccessControlAllowOrigins(List<String> accessControlAllowOrigins) {
    this.accessControlAllowOrigins = accessControlAllowOrigins;
  }

  public APICorsConfiguration accessControlAllowCredentials(Boolean accessControlAllowCredentials) {
    this.accessControlAllowCredentials = accessControlAllowCredentials;
    return this;
  }

   /**
   * Get accessControlAllowCredentials
   * @return accessControlAllowCredentials
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getAccessControlAllowCredentials() {
    return accessControlAllowCredentials;
  }

  public void setAccessControlAllowCredentials(Boolean accessControlAllowCredentials) {
    this.accessControlAllowCredentials = accessControlAllowCredentials;
  }

  public APICorsConfiguration accessControlAllowHeaders(List<String> accessControlAllowHeaders) {
    this.accessControlAllowHeaders = accessControlAllowHeaders;
    return this;
  }

  public APICorsConfiguration addAccessControlAllowHeadersItem(String accessControlAllowHeadersItem) {
    this.accessControlAllowHeaders.add(accessControlAllowHeadersItem);
    return this;
  }

   /**
   * Get accessControlAllowHeaders
   * @return accessControlAllowHeaders
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<String> getAccessControlAllowHeaders() {
    return accessControlAllowHeaders;
  }

  public void setAccessControlAllowHeaders(List<String> accessControlAllowHeaders) {
    this.accessControlAllowHeaders = accessControlAllowHeaders;
  }

  public APICorsConfiguration accessControlAllowMethods(List<String> accessControlAllowMethods) {
    this.accessControlAllowMethods = accessControlAllowMethods;
    return this;
  }

  public APICorsConfiguration addAccessControlAllowMethodsItem(String accessControlAllowMethodsItem) {
    this.accessControlAllowMethods.add(accessControlAllowMethodsItem);
    return this;
  }

   /**
   * Get accessControlAllowMethods
   * @return accessControlAllowMethods
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<String> getAccessControlAllowMethods() {
    return accessControlAllowMethods;
  }

  public void setAccessControlAllowMethods(List<String> accessControlAllowMethods) {
    this.accessControlAllowMethods = accessControlAllowMethods;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APICorsConfiguration aPICorsConfiguration = (APICorsConfiguration) o;
    return Objects.equals(this.corsConfigurationEnabled, aPICorsConfiguration.corsConfigurationEnabled) &&
        Objects.equals(this.accessControlAllowOrigins, aPICorsConfiguration.accessControlAllowOrigins) &&
        Objects.equals(this.accessControlAllowCredentials, aPICorsConfiguration.accessControlAllowCredentials) &&
        Objects.equals(this.accessControlAllowHeaders, aPICorsConfiguration.accessControlAllowHeaders) &&
        Objects.equals(this.accessControlAllowMethods, aPICorsConfiguration.accessControlAllowMethods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(corsConfigurationEnabled, accessControlAllowOrigins, accessControlAllowCredentials, accessControlAllowHeaders, accessControlAllowMethods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APICorsConfiguration {\n");

    sb.append("    corsConfigurationEnabled: ").append(toIndentedString(corsConfigurationEnabled)).append("\n");
    sb.append("    accessControlAllowOrigins: ").append(toIndentedString(accessControlAllowOrigins)).append("\n");
    sb.append("    accessControlAllowCredentials: ").append(toIndentedString(accessControlAllowCredentials)).append("\n");
    sb.append("    accessControlAllowHeaders: ").append(toIndentedString(accessControlAllowHeaders)).append("\n");
    sb.append("    accessControlAllowMethods: ").append(toIndentedString(accessControlAllowMethods)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
