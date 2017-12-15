package br.com.netodevel.command.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.netodevel.core.source.GeneratorOptions;
import br.com.netodevel.generators.java.service.GeneratorCleanService;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ServiceHandler extends OptionHandler {
	
	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate service").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		generateServiceJava(nameClass.trim());
		return ExitStatus.OK;
	}
	
	private void generateServiceJava(String nameClass) throws IOException {
		GeneratorOptions options = new GeneratorOptions().setNameModel(nameClass);
		new GeneratorCleanService(options).generate();
	}
	
}
