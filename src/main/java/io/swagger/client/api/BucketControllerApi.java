/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package io.swagger.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.client.ApiClient;
import io.swagger.client.model.BucketMetadata;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-08T12:41:35.988+01:00")
@Component("io.swagger.client.api.BucketControllerApi")
public class BucketControllerApi {
    private ApiClient apiClient;

    public BucketControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public BucketControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete the empty buckets
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void cleanEmptyUsingDELETE() throws RestClientException {
        Object postBody = null;

        String path = UriComponentsBuilder.fromPath("/buckets").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {};

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        apiClient.invokeAPI(path,
                            HttpMethod.DELETE,
                            queryParams,
                            postBody,
                            headerParams,
                            formParams,
                            accept,
                            contentType,
                            authNames,
                            returnType);
    }

    /**
     * Creates a new bucket
     * 
     * <p><b>201</b> - Created
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Not Found
     * @param sessionID sessionID
     * @param name The unique name of the Bucket. /n The name of bucket can be between 3 and 63 characters long, and can contain only lower-case characters, numbers, and dashes. /nA bucket&#39;s name must start with a lowercase letter and cannot terminate with a dash
     * @param owner The name of the user that will own the Bucket
     * @return BucketMetadata
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BucketMetadata createUsingPOST(String sessionID, String name, String owner) throws RestClientException {
        Object postBody = null;

        String path = UriComponentsBuilder.fromPath("/buckets").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner", owner));

        if (sessionID != null)
            headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {};

        ParameterizedTypeReference<BucketMetadata> returnType = new ParameterizedTypeReference<BucketMetadata>() {
        };
        return apiClient.invokeAPI(path,
                                   HttpMethod.POST,
                                   queryParams,
                                   postBody,
                                   headerParams,
                                   formParams,
                                   accept,
                                   contentType,
                                   authNames,
                                   returnType);
    }

    /**
     * Delete an empty bucket
     * It&#39;s forbidden to delete a non-empty bucket. You need to delete manually all workflows in the bucket before.
     * <p><b>204</b> - No Content
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket not found
     * @param bucketName bucketName
     * @param sessionID sessionID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteUsingDELETE(String bucketName, String sessionID) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'bucketName' is set
        if (bucketName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                                               "Missing the required parameter 'bucketName' when calling deleteUsingDELETE");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketName", bucketName);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketName}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (sessionID != null)
            headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {};

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        apiClient.invokeAPI(path,
                            HttpMethod.DELETE,
                            queryParams,
                            postBody,
                            headerParams,
                            formParams,
                            accept,
                            contentType,
                            authNames,
                            returnType);
    }

    /**
     * Gets a bucket&#39;s metadata by ID
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Bucket not found
     * @param bucketName bucketName
     * @param sessionID sessionID
     * @return BucketMetadata
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BucketMetadata getMetadataUsingGET(String bucketName, String sessionID) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'bucketName' is set
        if (bucketName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                                               "Missing the required parameter 'bucketName' when calling getMetadataUsingGET");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("bucketName", bucketName);
        String path = UriComponentsBuilder.fromPath("/buckets/{bucketName}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (sessionID != null)
            headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {};

        ParameterizedTypeReference<BucketMetadata> returnType = new ParameterizedTypeReference<BucketMetadata>() {
        };
        return apiClient.invokeAPI(path,
                                   HttpMethod.GET,
                                   queryParams,
                                   postBody,
                                   headerParams,
                                   formParams,
                                   accept,
                                   contentType,
                                   authNames,
                                   returnType);
    }

    /**
     * Lists the buckets
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - User not authenticated
     * <p><b>403</b> - Permission denied
     * <p><b>404</b> - Not Found
     * @param sessionID sessionID
     * @param owner The name of the user who owns the Bucket
     * @param kind The kind of objects that buckets must contain
     * @return List&lt;BucketMetadata&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<BucketMetadata> listUsingGET(String sessionID, String owner, String kind) throws RestClientException {
        Object postBody = null;

        String path = UriComponentsBuilder.fromPath("/buckets").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner", owner));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "kind", kind));

        if (sessionID != null)
            headerParams.add("sessionID", apiClient.parameterToString(sessionID));

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {};

        ParameterizedTypeReference<List<BucketMetadata>> returnType = new ParameterizedTypeReference<List<BucketMetadata>>() {
        };
        return apiClient.invokeAPI(path,
                                   HttpMethod.GET,
                                   queryParams,
                                   postBody,
                                   headerParams,
                                   formParams,
                                   accept,
                                   contentType,
                                   authNames,
                                   returnType);
    }
}
