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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;
import org.wso2.carbon.identity.event.services.IdentityEventService;
import org.wso2.carbon.identity.sample.event.handler.SampleEventHandler;
/**
 * @scr.component name="sample.event.handler"
 * immediate="true"
 * @scr.reference name="EventMgtService"
 * interface="org.wso2.carbon.identity.event.services.IdentityEventService" cardinality="1..1"
 * policy="dynamic" bind="setIdentityEventService" unbind="unsetIdentityEventService"
 */
public class SampleEventServiceComponent {

    private static Log log = LogFactory.getLog(SampleEventServiceComponent.class);

    protected void activate(ComponentContext context) {

        SampleEventDataHolder.getInstance().setBundleContext(context.getBundleContext());
        SampleEventHandler sampleEventHandler = new SampleEventHandler();
        context.getBundleContext().registerService(AbstractEventHandler.class.getName(), sampleEventHandler,
                null);
        if (log.isDebugEnabled()) {
            log.debug("SampleEventServiceComponent is registered");
        }
    }

    protected void deactivate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("SampleEventServiceComponent is de-activated");
        }
    }


    protected void unsetIdentityEventService(IdentityEventService eventService) {
        SampleEventDataHolder.getInstance().setIdentityEventService(null);
    }

    protected void setIdentityEventService(IdentityEventService eventService) {
        SampleEventDataHolder.getInstance().setIdentityEventService(eventService);
    }

}
