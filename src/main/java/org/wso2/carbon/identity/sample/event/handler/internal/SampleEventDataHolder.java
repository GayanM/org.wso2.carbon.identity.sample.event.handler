/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 * limitations und
 */

package org.wso2.carbon.identity.sample.event.handler.internal;

import org.osgi.framework.BundleContext;
import org.wso2.carbon.identity.event.services.IdentityEventService;

public class SampleEventDataHolder {

    private static volatile SampleEventDataHolder sampleEventDataHolder = new SampleEventDataHolder();

    private BundleContext bundleContext;
    private IdentityEventService identityEventService;

    private SampleEventDataHolder(){

    }

    public static SampleEventDataHolder getInstance() {
        return sampleEventDataHolder;
    }


    public BundleContext getBundleContext() {
        return bundleContext;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public IdentityEventService getIdentityEventService() {
        return identityEventService;
    }

    public void setIdentityEventService(IdentityEventService identityEventService) {
        this.identityEventService = identityEventService;
    }
}
