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

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MaterialModule } from '../../shared/material.module';
import { FormControlsModule } from '../../shared/form-controls';

import { ProjectFormComponent } from './project-form/project-form.component';
import { ProjectListComponent } from './project-list/project-list.component';

import { ProjectComponent, EditProjectComponent } from './project.component';
import { ProjectDataService } from './project-data.service';
import {InformMessageModule} from '../../shared/inform-message';
import { DirectivesModule } from '../../core/directives';
import { BubbleModule } from '../../shared';
import { UnderscorelessPipeModule } from '../../core/pipes';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        MaterialModule,
        FormControlsModule,
        UnderscorelessPipeModule,
        BubbleModule,
        InformMessageModule,
        DirectivesModule
    ],
  declarations: [ProjectComponent, EditProjectComponent, ProjectFormComponent, ProjectListComponent],
  entryComponents: [EditProjectComponent],
  providers: [ProjectDataService],
  exports: [ProjectComponent]
})
export class ProjectModule { }
