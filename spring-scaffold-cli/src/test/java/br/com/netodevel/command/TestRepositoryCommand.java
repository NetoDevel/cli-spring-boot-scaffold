package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.repository.RepositoryCommand;
import br.com.netodevel.command.repository.RepositoryHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestRepositoryCommand {

	@Test
	public void testRunRepositoryCommand() {
		try {
			new RepositoryCommand("repository", "generate repositories", new RepositoryHandler()).run("-nUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
