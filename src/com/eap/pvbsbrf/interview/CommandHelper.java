package com.eap.pvbsbrf.interview;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.eap.pvbsbrf.interview.commands.AbstractCommand;
import com.eap.pvbsbrf.interview.utils.CmdProcessorException;
import com.eap.pvbsbrf.interview.utils.Storage;

/**
 *  @author Pavlenko
 *
 */

/**
 * CommandHelper parses the arguments and creates the new command using the Reflection-mechanism.
 */

public class CommandHelper {
	private static final String CMD_PREFIX = "com.eap.pvbsbrf.interview.commands.";
	private static final String CMD_SUFFIX = "Command";	
	
	/**
	 * @param arguments
	 * @param storage
	 * @return If success returns the exact command
	 * @throws CmdProcessorException
	 */
	public static AbstractCommand createCommand(String arguments, Storage storage) throws CmdProcessorException {
		AbstractCommand abstractCommand = null;
		try {
		//TODO add \\ as demiliter
		StringTokenizer stringTokenizer = new StringTokenizer(arguments," \t\n\r\f;");
		String commandName = stringTokenizer.nextToken();
		abstractCommand = (AbstractCommand) getCommandClass(commandName, storage);
		List list = new ArrayList();
		while (stringTokenizer.hasMoreTokens()) {
			list.add(stringTokenizer.nextToken());
		}
		if (abstractCommand != null) 
			abstractCommand.setParams(list);
		} catch (NoSuchElementException nsee) {
			throw new CmdProcessorException("The command should't be empty. Please try again", nsee);
		}
		return abstractCommand; 
	}
	
	private static Command getCommandClass(String commandName, Storage storage) throws CmdProcessorException {
		Command retCommand = null;
		commandName = StringUtils.lowerCase(commandName);
		commandName = StringUtils.capitalize(commandName);
		try {
			Class commandClass = Class.forName(CMD_PREFIX + commandName + CMD_SUFFIX);
			Constructor constructor = commandClass.getConstructor(new Class[]{Storage.class});
			retCommand = (Command) constructor.newInstance(new Object[]{storage});
			
		} catch (ClassNotFoundException cnfe) {
			throw new CmdProcessorException("Command [" + commandName + "] was not found. Please try again", cnfe);
		} catch (IllegalAccessException ice) {
			throw new CmdProcessorException("Class for command " + commandName + " can not be created\r\n Illeagal Access " + ice.getMessage());
		} catch (InstantiationException ie) {
			throw new CmdProcessorException("Class for command " + commandName + " can not be instantiated " + ie.getMessage());
		} catch (NoSuchMethodException nsme) {
			throw new CmdProcessorException("Class for command " + commandName + " has no method requred " + nsme.getMessage());
		} catch (InvocationTargetException ite) {
			throw new CmdProcessorException("Class for command " + commandName + " can not be instantiated " + ite.getMessage());
		}
		return retCommand;
	}
}
