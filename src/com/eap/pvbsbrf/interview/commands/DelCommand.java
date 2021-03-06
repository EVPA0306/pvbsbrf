package com.eap.pvbsbrf.interview.commands;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class DelCommand extends AbstractCommand implements Command {

	public DelCommand(Storage storage) {
		super(storage);
	}

	public void execute() throws CmdProcessorException {
		if (getStorage().isEmpty()) {
			throw new CmdProcessorException("The list of numbers is already empty.\r\nThere is nothing to delete.");
		}
		int szz = getParams().size();
		int cnt = getStorage().count();
		if ( szz == 1 ) {
				int pos = Integer.valueOf((String) getParams().get(0));
					if (pos <= cnt) {
						getStorage().clear(pos);
						setCommandStatus("Del command executed.\r\nElement at position " + pos + " was deleted.");
					}
		} else if (szz > 0 && szz <= 2) {
			int sPos = Integer.valueOf((String)getParams().get(0));
			int ePos = Integer.valueOf((String)getParams().get(1));
				if ( sPos <= cnt && ePos <= cnt) {
					getStorage().clear(sPos,ePos);
					setCommandStatus("Del command executed.\r\nElements between position " + sPos + " and " + ePos + " were deleted.");
				}			
		} else {
			throw new CmdProcessorException("The [index] parameter is required for Del command. Please try again.");
		}
	}
}
