package site;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BootstrapTest
{
  @Test
  public void defaultPortNumberWhenEnvNotSet() throws Exception
  {
    assertEquals(9090, Bootstrap.getPort());
  }

  @Test
  public void customPortNumberWhenEnvSet() throws Exception
  {
    System.getProperties().setProperty("APP_PORT", "80");

    assertEquals(80, Bootstrap.getPort());
  }
}
