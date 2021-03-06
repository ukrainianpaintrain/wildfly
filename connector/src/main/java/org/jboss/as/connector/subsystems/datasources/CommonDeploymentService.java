/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.connector.subsystems.datasources;

import static org.jboss.as.connector.logging.ConnectorLogger.ROOT_LOGGER;

import org.jboss.as.naming.deployment.ContextNames;
import org.jboss.jca.deployers.common.CommonDeployment;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

public class CommonDeploymentService implements Service<CommonDeployment> {

    private static final ServiceName SERVICE_NAME_BASE = ServiceName.JBOSS.append("data-source").append("common-deployment");

    public static ServiceName getServiceName(ContextNames.BindInfo bindInfo) {
        return SERVICE_NAME_BASE.append(bindInfo.getBinderServiceName().getCanonicalName());
    }

    private CommonDeployment value;

    /** create an instance **/
    public CommonDeploymentService(CommonDeployment value) {
        super();
        this.value = value;

    }

    @Override
    public CommonDeployment getValue() throws IllegalStateException, IllegalArgumentException {
        return value;
    }

    @Override
    public void start(StartContext context) throws StartException {
        ROOT_LOGGER.debugf("Started CommonDeployment %s", context.getController().getName());
    }

    @Override
    public void stop(StopContext context) {
        ROOT_LOGGER.debugf("Stopped CommonDeployment %s", context.getController().getName());
    }
}
