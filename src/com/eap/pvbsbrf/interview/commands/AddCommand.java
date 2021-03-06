package com.eap.pvbsbrf.interview.commands;

import java.util.Iterator;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class AddCommand extends AbstractCommand implements Command {

	public AddCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		for ( Iterator it = getParams().iterator(); it.hasNext();) {
			getStorage().store((String)it.next());
		}
		setCommandStatus("Add command executed");
	}	
}
