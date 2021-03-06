package com.eap.pvbsbrf.interview.commands;

import java.util.List;
import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.Storage;

/**
 * @author Pavlenko
 * 
 */
public abstract class AbstractCommand implements Command {
	
	private List params;
	private Storage storage;
	private String commandStatus;
	
	public String getCommandStatus() {
		return commandStatus;
	}

	public void setCommandStatus(String commandStatus) {
		this.commandStatus = commandStatus;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public AbstractCommand(Storage storage) {
		this.storage = storage;
	}
	
	public List getParams() {
		return params;
	}

	public void setParams(List params) {
		this.params = params;
	}
	
	
	
}
