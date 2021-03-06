/**
 * 
 */
package com.eap.pvbsbrf.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

/**
 * @author Pavlenko
 *
 */
public class BulkCommandExecutor {
	
	public boolean executeCommand(Command command) {
		return false;
	}
	
	public void executeCommand(List<Command> command) throws CmdProcessorException {
		for (Iterator it = command.iterator(); it.hasNext();) {
			((Command) it.next()).execute();
		}
	}
	
	public List parse(String fileName, Storage storage) throws CmdProcessorException {
		List returnList = new ArrayList();
		try {
			File fileIn = new File(fileName);			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
			String str = null;
			while ( (str = bufferedReader.readLine()) != null ) {					
					returnList.add(CommandHelper.createCommand(str, storage));
				}
			bufferedReader.close();
		} catch (IOException e) {
			throw new CmdProcessorException(e.getMessage(),e);
		} 
		return returnList;
	}
}
