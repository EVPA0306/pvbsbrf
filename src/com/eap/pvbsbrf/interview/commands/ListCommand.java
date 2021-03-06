package com.eap.pvbsbrf.interview.commands;

import java.util.Iterator;
import java.util.List;

import com.eap.pvbsbrf.interview.commands.AbstractCommand;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;
import com.eap.pvbsbrf.interview.Command;

public class ListCommand extends AbstractCommand implements Command {
	
	public ListCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		List list = getStorage().get();
		if (list != null && list.size() > 0) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("List command executed.\r\n");
			for (Iterator it = list.iterator(); it.hasNext();) {
				stringBuilder.append(it.next());
				stringBuilder.append("\r\n");
			}
			setCommandStatus(stringBuilder.toString());
		} else {
			throw new CmdProcessorException("The set of numbers is empty. Please do LOAD/ADD command first");
		}
	}
}
