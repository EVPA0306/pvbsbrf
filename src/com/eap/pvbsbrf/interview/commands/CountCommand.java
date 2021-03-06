package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.Storage;

public class CountCommand extends AbstractCommand implements Command {

	public CountCommand(Storage storage) {
		super(storage);
	}

	public void execute() {
		setCommandStatus("Count command executed\r\n " + getStorage().count());
	}
}
