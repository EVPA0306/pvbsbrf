package com.eap.pvbsbrf.interview.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class SaveCommand extends AbstractCommand implements Command {
	
	public SaveCommand(Storage storage) {
		super(storage);
	}

	private static final Log log = LogFactory.getLog(SaveCommand.class);
	
	public void execute() throws CmdProcessorException {
		List params = getParams();
		String filePath = (String) params.get(params.size()-1);
		File fileOut = new File(filePath);
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
			for (Iterator<String> it = getStorage().get().iterator(); it.hasNext();) {
				bufferedWriter.append(it.next());
				bufferedWriter.append("\r\n");
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			throw new CmdProcessorException(e.getMessage(),e);
		}
		setCommandStatus("Save command executed. Set was stored to " + filePath + " file");
	}

}
