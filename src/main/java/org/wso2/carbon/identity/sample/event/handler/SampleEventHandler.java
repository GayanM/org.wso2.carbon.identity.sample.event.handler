package org.wso2.carbon.identity.sample.event.handler;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.base.IdentityRuntimeException;
import org.wso2.carbon.identity.core.bean.context.MessageContext;
import org.wso2.carbon.identity.core.handler.InitConfig;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.IdentityEventException;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;

import java.util.HashMap;
import java.util.Map;

public class SampleEventHandler extends AbstractEventHandler {

    private static final Log log = LogFactory.getLog(SampleEventHandler.class);

    public String getName() {

        return "sampleEventHandler";
    }

    public String getFriendlyName() {

        return "Sample Event Handler";
    }

    @Override
    public void init(InitConfig configuration) throws IdentityRuntimeException {
        super.init(configuration);
    }

    @Override
    public int getPriority(MessageContext messageContext) {

        return 101;
    }

    @Override
    public void handleEvent(Event event) throws IdentityEventException {

        Map<String, Object> eventProperties = event.getEventProperties();
        String userName = (String) eventProperties.get(IdentityEventConstants.EventProperty.USER_NAME);
        UserStoreManager userStoreManager = (UserStoreManager) eventProperties.get(IdentityEventConstants.EventProperty.USER_STORE_MANAGER);

        if (IdentityEventConstants.Event.PRE_AUTHENTICATION.equals(event.getEventName())) {

            Map<String, String> newClaims = new HashMap();
            newClaims.put("http://wso2.org/claims/identity/test", "0");
            try {
                userStoreManager.setUserClaimValues(userName, newClaims, null);
            } catch (UserStoreException e) {
                e.printStackTrace();
            }
        }
    }

}
