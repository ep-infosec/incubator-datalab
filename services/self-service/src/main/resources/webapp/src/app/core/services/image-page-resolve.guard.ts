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

import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { Observable, of  } from 'rxjs';

import { ProjectImagesInfo } from '../../resources/images';
import { switchMap, take } from 'rxjs/operators';
import { ImagesPageService } from './images-page.service';

@Injectable({
  providedIn: 'root'
})
export class ImagePageResolveGuard implements Resolve<ProjectImagesInfo> {
  constructor(
    private router: Router,
    private userImagesPageService: ImagesPageService
  ) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ProjectImagesInfo> {
    return this.userImagesPageService.getFilterImagePage().pipe(
      switchMap((imagePageData: ProjectImagesInfo) => of(imagePageData)),
      take(1)
    );
  }
}
