/**
 * 
 */
package com.eap.pvbsbrf.interview;

import com.eap.pvbsbrf.interview.utils.CmdProcessorException;

/**
 * @author Pavlenko
 *
 */
public interface Command {
	public void execute() throws CmdProcessorException;
}
