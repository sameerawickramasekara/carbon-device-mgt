/*
 *   Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 *
 */
package org.wso2.carbon.device.mgt.jaxrs.service.api;

import io.swagger.annotations.*;
import org.wso2.carbon.apimgt.annotations.api.API;
import org.wso2.carbon.apimgt.annotations.api.Permission;
import org.wso2.carbon.device.mgt.common.notification.mgt.Notification;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Notifications related REST-API.
 */
@API(name = "Device Notification Management API", version = "1.0.0", context = "/devicemgt_admin/notifications",
        tags = {"devicemgt_admin"})
@Api(value = "Device Notification Management", description = "Device notification related operations can be found here.")
@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotificationManagementService {

    @GET
    @ApiOperation(
            produces = MediaType.APPLICATION_JSON,
            httpMethod = "GET",
            value = "Getting all device notification details.",
            notes = "Get the details of all notifications that were pushed to the device in WSO2 EMM using "
                    + "this REST API",
            response = Notification.class,
            responseContainer = "List",
            tags = "Device Notification Management")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            code = 200,
                            message = "OK. \n Successfully fetched the list of notifications.",
                            response = Notification.class,
                            responseContainer = "List",
                            responseHeaders = {
                                    @ResponseHeader(
                                            name = "Content-Type",
                                            description = "The content type of the body"),
                                    @ResponseHeader(
                                            name = "ETag",
                                            description = "Entity Tag of the response resource.\n" +
                                                    "Used by caches, or in conditional requests."),
                                    @ResponseHeader(
                                            name = "Last-Modified",
                                            description = "Date and time the resource has been modified the last time.\n" +
                                                    "Used by caches, or in conditional requests."),
                            }),
                    @ApiResponse(
                            code = 304,
                            message = "Not Modified. \n Empty body because the client has already the latest version of the requested resource."),
                    @ApiResponse(
                            code = 406,
                            message = "Not Acceptable.\n The requested media type is not supported"),
                    @ApiResponse(
                            code = 500,
                            message = "Internal Server ErrorResponse. \n Server error occurred while fetching the notification list.")
            })
    @Permission(scope = "device-notification-view", permissions = {
            "/permission/admin/device-mgt/admin/notifications/view",
            "/permission/admin/device-mgt/user/notifications/view"
    })
    Response getNotifications(
            @ApiParam(name = "status",
                    value = "Status of the notification.",
                    allowableValues = "NEW, CHECKED",
                    required = true)
            @QueryParam("status") String status,
            @ApiParam(
                    name = "If-Modified-Since",
                    value = "Validates if the requested variant has not been modified since the time specified",
                    required = false)
            @HeaderParam("If-Modified-Since") String ifModifiedSince,
            @ApiParam(
                    name = "offset",
                    value = "Starting point within the complete list of items qualified.",
                    required = false)
            @QueryParam("offset") int offset,
            @ApiParam(
                    name = "limit",
                    value = "Maximum size of resource array to return.",
                    required = false)
            @QueryParam("limit") int limit);


    @PUT
    @Path("/{id}/status")
    @ApiOperation(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON,
            httpMethod = "PUT",
            value = "Update the device notification status",
            notes = "When a user has read the the device notifications, the device notification status must "
                    + "change from NEW to CHECKED. Update the device notification status using this REST API.",
            tags = "Device Notification Management")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            code = 200,
                            message = "OK. \n Notification status has been updated successfully",
                            responseHeaders = {
                                    @ResponseHeader(
                                            name = "Content-Location",
                                            description = "The URL of the updated device."),
                                    @ResponseHeader(
                                            name = "Content-Type",
                                            description = "The content type of the body"),
                                    @ResponseHeader(
                                            name = "ETag",
                                            description = "Entity Tag of the response resource.\n" +
                                                    "Used by caches, or in conditional requests."),
                                    @ResponseHeader(
                                            name = "Last-Modified",
                                            description = "Date and time the resource has been modified the last time.\n" +
                                                    "Used by caches, or in conditional requests.")}),
                    @ApiResponse(
                            code = 400,
                            message = "Bad Request. \n Invalid request or validation error."),
                    @ApiResponse(
                            code = 404,
                            message = "Not Found. \n Resource to be deleted does not exist."),
                    @ApiResponse(
                            code = 415,
                            message = "Unsupported media type. \n The entity of the request was in a not supported format."),
                    @ApiResponse(
                            code = 500,
                            message = "Internal Server ErrorResponse. \n " +
                                    "Server error occurred while modifying status of the notification.")
            })
    @Permission(scope = "device-notification-modify",
            permissions = {"/permission/admin/device-mgt/admin/notifications/modify"})
    Response updateNotificationStatus(
            @ApiParam(
                    name = "id",
                    value = "Notification identifier.",
                    required = true)
            @PathParam("id") int id,
            @ApiParam(
                    name = "status",
                    value = "Status of the notification.",
                    allowableValues = "NEW, CHECKED",
                    required = true) String status);

    @POST
    @ApiOperation(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON,
            httpMethod = "POST",
            value = "Add a device notification.",
            notes = "Add a device notification, which will then be sent to a device.",
            tags = "Device Notification Management")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Created. \n Notification has been added successfully.",
                            responseHeaders = {
                                    @ResponseHeader(
                                            name = "Content-Location",
                                            description = "The URL of the added  notification."),
                                    @ResponseHeader(
                                            name = "Content-Type",
                                            description = "The content type of the body"),
                                    @ResponseHeader(
                                            name = "ETag",
                                            description = "Entity Tag of the response resource.\n" +
                                                    "Used by caches, or in conditional requests."),
                                    @ResponseHeader(
                                            name = "Last-Modified",
                                            description = "Date and time the resource has been modified the last time.\n" +
                                                    "Used by caches, or in conditional requests.")
                            }),
                    @ApiResponse(
                            code = 400,
                            message = "Bad Request. \n Invalid request or validation error."),
                    @ApiResponse(
                            code = 415,
                            message = "Unsupported media type. \n The entity of the request was in a not supported format."),
                    @ApiResponse(
                            code = 500,
                            message = "Internal Server ErrorResponse. \n " +
                                    "Server error occurred while adding the notification.")
            })
    @Permission(scope = "device-notification-modify",
            permissions = {"/permission/admin/device-mgt/admin/notifications/modify"})
    Response addNotification(
            @ApiParam(
                    name = "notification",
                    value = "Notification details to be added.",
                    required = true) Notification notification);

}