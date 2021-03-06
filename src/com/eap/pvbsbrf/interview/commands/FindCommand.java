package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class FindCommand extends AbstractCommand implements Command {

	public FindCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		if (getStorage().isEmpty()) {
			throw new CmdProcessorException("The list of numbers is empty.\r\nThere is nothing to find.");
		}
		int cnt = getParams().size();
		if ( cnt == 1 ) {
			String value = (String) getParams().get(0);
			int index = getStorage().find(value);
			if (index > 0 ) {
				setCommandStatus("Find command executed.\r\nValue " +value+ " was found at position " + index);
			} else {
				setCommandStatus("Find command executed.\r\nValue " +value+ " has not been found");
			}
		} else {
			throw new CmdProcessorException("The [value] parameter is required for Find command. Please try again.");
		}
	}
}
