package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class ClearCommand extends AbstractCommand implements Command {

	public ClearCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		if (getStorage().get().isEmpty())
		{ 
			throw new CmdProcessorException("Nothing to clear. The list of numbers is already empty");
		} else {
			getStorage().clearAll();
			setCommandStatus("Clear command executed.\r\nThe set of number is empty now ");
		}
	}
}
