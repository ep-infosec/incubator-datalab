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

package com.epam.datalab.backendapi.resources.aws;

import com.epam.datalab.auth.UserInfo;
import com.epam.datalab.backendapi.core.commands.DockerAction;
import com.epam.datalab.backendapi.resources.base.InfrastructureService;
import com.epam.datalab.dto.UserEnvironmentResources;
import io.dropwizard.auth.Auth;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/infrastructure")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class InfrastructureResourceAws extends InfrastructureService {
    public InfrastructureResourceAws() {
        log.info("{} is initialized", getClass().getSimpleName());
    }

    @Path("/status")
    @POST
    public String status(@Auth UserInfo ui, UserEnvironmentResources dto) {
        return action(ui.getName(), dto, dto.getCloudSettings().getIamUser(), DockerAction.STATUS);
    }
}
