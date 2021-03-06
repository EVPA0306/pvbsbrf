package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.Storage;

public class SortCommand extends AbstractCommand implements Command {

	public SortCommand(Storage storage) {
		super(storage);
	}

	public void execute() {
		if (getParams().size() == 0) {
			getStorage().sort("asc");
		} else {
			getStorage().sort((String)getParams().get(0));
		}
		setCommandStatus("Sort command executed");
	}
	
}
