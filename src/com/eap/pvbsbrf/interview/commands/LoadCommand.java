package com.eap.pvbsbrf.interview.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.eap.pvbsbrf.interview.Command;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

public class LoadCommand extends AbstractCommand implements Command {
	
	public LoadCommand(Storage storage) {
		super(storage);
	}
	
	private static final Log log = LogFactory.getLog(LoadCommand.class);
	@Override
	public void execute() throws CmdProcessorException {
		{
			String filePath;
			List params = getParams();
			try {
			filePath = (String) params.get(0);
			File fileIn = new File(filePath);			
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
				String str = null;
				while ( (str = bufferedReader.readLine()) != null ) {
					getStorage().store(str);
				}
				bufferedReader.close();
			} catch (IOException e) {
				throw new CmdProcessorException(e.getMessage(),e);
			} catch (IndexOutOfBoundsException ioobe) {
				throw new CmdProcessorException("The [file name] parameter is required for Load command. Please try again.");
			}
			setCommandStatus("Load command executed. Data was loaded from " + filePath + " file");
		}	
	}
}
