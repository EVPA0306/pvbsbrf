package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.Storage;

public class UniqueCommand extends AbstractCommand implements Command {

	
	public UniqueCommand(Storage storage) {
		super(storage);
	}

	public void execute() {
		setCommandStatus("Unique command executed");
		getStorage().unique();
	}
	
}
