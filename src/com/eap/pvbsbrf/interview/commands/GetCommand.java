package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class GetCommand extends AbstractCommand implements Command {

	
	public GetCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		if (getStorage().isEmpty()) {
			throw new CmdProcessorException("The list of numbers is empty.\r\nThere is nothing to get.");
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Get command executed\r\n");
		try {
			stringBuilder.append((getStorage().getAtPosition(Integer.valueOf((String) getParams().get(0)))));
		} catch (IndexOutOfBoundsException ioobe) {
			throw new CmdProcessorException("Wrong [index] was described. Please specify it again", ioobe);
		}
		setCommandStatus(stringBuilder.toString());
	}
	
}
