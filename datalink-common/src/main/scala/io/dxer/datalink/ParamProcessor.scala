package io.dxer.datalink

import org.apache.commons.cli.{BasicParser, CommandLine, HelpFormatter, Option, Options}

/**
  * 参数处理处理类
  */
class ParamProcessor {

  private val cmdLineSyntax = "DataLinkApp"

  private val options = new Options()

  private var commandLine: CommandLine = null

  def process(args: Array[String]) {
    initOptions()
    val parser = new BasicParser()
    commandLine = parser.parse(options, args)

    if (commandLine.hasOption('h')) {
      val hf = new HelpFormatter
      hf.printHelp(cmdLineSyntax, "", options, "")
      System.exit(0);
    }

    if (commandLine.hasOption('v')) {

    }

    var map = Map[String, Boolean]()
    if (commandLine.hasOption('f')) map += ("f" -> true)
    if (commandLine.hasOption('e')) map += ("e" -> true)
    if (commandLine.hasOption('s')) map += ("s" -> true)


    if (map.size != 1) {
      //  println("-e/-f/-s only one can used")
      // System.exit(-1)
    }
  }

  private def initOptions(): Unit = {
    // -h
    options.addOption("h", "help", false, "Print help information");
    // -v
    options.addOption("v", "verbose", false, "Verbose mode (echo executed SQL to the console)");

    // -e
    val optOfE = new Option("e", null, true, "SQL from command line")
    optOfE.setArgName("quoted-query-string")
    options.addOption(optOfE);

    // -f
    val optOfF = new Option("f", null, true, "Initialization SQL file")
    optOfF.setArgName("filename")
    options.addOption(optOfF)

    // -s, --server
    val optOfS = new Option("s", null, false, "Server for execute command")
    optOfS.setArgName("Server")
    options.addOption(optOfS)
  }

  def getValue(opt: Char): String = {
    commandLine.getOptionValue(opt)
  }

  def hasOption(opt: Char): Boolean = {
    commandLine.hasOption(opt)
  }
}
