package com.medicaid.common.faces;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicaid.common.util.FormattingUtil;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler exceptionHandler;
	private Log log = LogFactoryUtil.getLog(getClass());

	public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return exceptionHandler;
	}

	@Override
	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

		while (queue.hasNext()) {
			ExceptionQueuedEvent item = queue.next();
			ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) item.getSource();

			try {
				Throwable throwable = exceptionQueuedEventContext.getException();
				log.error("Exception: " + throwable.fillInStackTrace());

				/*FacesContext context = FacesContext.getCurrentInstance();
				Map<String, Object> requestMap = context.getExternalContext().getRequestMap();
				NavigationHandler nav = context.getApplication().getNavigationHandler();
				
				requestMap.put("error-message", throwable.getMessage());
				requestMap.put("error-stack", throwable.getStackTrace());
				nav.handleNavigation(context, null, "/error");
				context.renderResponse();
				*/
			} catch (Exception e) {
				log.error(FormattingUtil.getMessage(e));
			} finally {
				queue.remove();
			}
		}
		// let the parent handle the rest
		getWrapped().handle();
	}

	/*@Override
	public void handle() throws FacesException {
	
		Iterator<ExceptionQueuedEvent> i = super.getUnhandledExceptionQueuedEvents().iterator();
		while (i.hasNext()) {
			Throwable t = i.next().getContext().getException();
			if (t instanceof ViewExpiredException) {
				try {
					// Handle the exception, for example:
					log.error("ViewExpiredException occurred!!");
					FacesRequestContext.getCurrentInstance().addScript(
							"alert('Dear Customer, your current session has expired.. please reload the page and try again');");
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				} finally {
					i.remove();
				}
			}
		}
		// let the parent handle the rest
		getWrapped().handle();
	}*/
}
