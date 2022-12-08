/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.epam.datalab.backendapi.resources.callback;

import com.epam.datalab.backendapi.domain.RequestId;
import com.epam.datalab.backendapi.service.BackupService;
import com.epam.datalab.dto.backup.EnvBackupStatusDTO;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("infrastructure/backup")
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class BackupCallback {

    @Inject
    private BackupService backupService;

    @Inject
    private RequestId requestId;

    @Context
    private UriInfo uriInfo;

    @POST
    @Path("/status")
    public Response status(EnvBackupStatusDTO dto) {
        requestId.remove(dto.getRequestId());
        log.debug("Updating status of backup status to {}", dto);
        backupService.updateStatus(dto.getEnvBackupDTO(), dto.getUser(),
                dto.getEnvBackupStatus().withErrorMessage(dto.getErrorMessage()));
        return Response.created(uriInfo.getRequestUri()).build();
    }
}