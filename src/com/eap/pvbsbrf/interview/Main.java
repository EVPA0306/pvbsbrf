package com.eap.pvbsbrf.interview;

import java.io.IOException;
import java.util.List;
import com.eap.pvbsbrf.interview.commands.AbstractCommand;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

/**
 * @author Pavlenko
 * Main class which reads command from the console or file.
 * This class calls the command's creation and runs the created command then. 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Storage storage = new Storage();
		boolean isExit = true;
		int i;
		byte bKbd[] = new byte[256];
		String str;
		//check if input parameter exists
		try {
		if (args.length > 0) {
			BulkCommandExecutor bulkCommandExecutor = new BulkCommandExecutor();
			List commandList = bulkCommandExecutor.parse(args[0],storage);
			bulkCommandExecutor.executeCommand(commandList);
		} else {
			while (isExit) {
				try {
					System.out.print("Enter the command: ");				
						i = System.in.read(bKbd);
						str = new String(bKbd,0,i);		
							AbstractCommand cmd = CommandHelper.createCommand(str,storage);
							if (cmd != null) {  
								cmd.execute();
								System.out.println(cmd.getCommandStatus());
							}
							else
							{
								System.out.println("Command not found");
								isExit = false;
							}
				} catch (CmdProcessorException cpe) {
					System.out.println(cpe.getMessage());
					}
				}
			}
		} catch (IOException e) {
		e.printStackTrace();
		} catch (CmdProcessorException cpe) {
		System.out.println(cpe.getMessage());
		}
	}
}

