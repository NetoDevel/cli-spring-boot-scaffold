package br.com.netodevel.command.template;

import br.com.generate.helpers.ScaffoldInfoHelper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TemplateHandlerTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryPath;

    @Before
    public void setUp() throws IOException {
        temporaryPath = temporaryFolder.newFolder("test-path");
    }

    @Test
    public void shouldReturnOk() throws Exception {
        ScaffoldInfoHelper scaffoldInfoHelper = mock(ScaffoldInfoHelper.class);

        Mockito.when(scaffoldInfoHelper.getPackage()).thenReturn("com.example");
        Mockito.when(scaffoldInfoHelper.getPathPackage()).thenReturn(temporaryPath.getAbsolutePath().concat("\\com\\example\\"));

        TemplateHandler templateHandler = new TemplateHandler(scaffoldInfoHelper);
        ExitStatus exitStatus = templateHandler.run("-t", "jms-aws-sqs");
        assertEquals(ExitStatus.OK, exitStatus);
    }

    @Test
    public void shouldReturnError() throws Exception {
        ScaffoldInfoHelper scaffoldInfoHelper = mock(ScaffoldInfoHelper.class);

        TemplateHandler templateHandler = new TemplateHandler(scaffoldInfoHelper);
        ExitStatus exitStatus = templateHandler.run("-t", "api-rest");
        assertEquals(ExitStatus.ERROR, exitStatus);
    }

    @Test
    public void givenArgumentList_shoudListTemplates() throws Exception {
        ScaffoldInfoHelper scaffoldInfoHelper = mock(ScaffoldInfoHelper.class);

        TemplateHandler templateHandler = new TemplateHandler(scaffoldInfoHelper);
        templateHandler.run("--list");
    }

}