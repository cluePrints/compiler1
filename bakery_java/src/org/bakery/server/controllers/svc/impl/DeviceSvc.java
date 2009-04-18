package org.bakery.server.controllers.svc.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bakery.server.controllers.svc.SvcController;
import org.bakery.server.controllers.svc.beans.AbstractFormMode;
import org.bakery.server.domain.hardware.Device;

public class DeviceSvc extends AbstractCommand {


	@Override
	public void init(SvcController controller) {
		setMainDAO(controller.getDAOFacade().getDeviceDAO());
		setCommand(new Device());
	}

	protected void executeInternal(HttpServletRequest request,
			HttpServletResponse response, SvcController controller, AbstractFormMode mode) throws Exception {
	}
}
