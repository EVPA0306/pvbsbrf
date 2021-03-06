package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.Storage;

public class ExitCommand extends AbstractCommand implements Command {

	public ExitCommand(Storage storage) {
		super(storage);
	}

	public void execute() {
		System.out.println("Exit command executed. System stopped.");
		System.exit(0);
	}
}
