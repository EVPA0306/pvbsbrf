package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class SetCommand extends AbstractCommand implements Command {

	public SetCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Set command executed\r\n");
		if (getStorage().get().size() >  Integer.valueOf((String) getParams().get(0))) {
			getStorage().setAtPosition(Integer.valueOf((String) getParams().get(0)), (String) getParams().get(1));
		} else {
			throw new CmdProcessorException("Wrong [index] was described. Please specify it again");
		}
		setCommandStatus(stringBuilder.toString());
	}
	
}
