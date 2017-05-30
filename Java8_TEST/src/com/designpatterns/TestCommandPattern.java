package com.designpatterns;

import java.util.ArrayList;
import java.util.List;

/* The Command interface */
interface Command {
    void execute();
}

// in this example, suppose you use a switch to control computer

/* The Invoker class */
class Switch {
    private List<Command> history = new ArrayList<Command>();

    public Switch() {
    }

    public void storeAndExecute(Command command) {
	this.history.add(command); // optional, can do the execute only!
	command.execute();
    }
}

/* The Receiver class */
class Computer {

    public void shutDown() {
	System.out.println("computer is shut down");
    }

    public void restart() {
	System.out.println("computer is restarted");
    }
}

/* The Command for shutting down the computer */
class ShutDownCommand implements Command {
    private Computer computer;

    public ShutDownCommand(Computer computer) {
	this.computer = computer;
    }

    public void execute() {
	computer.shutDown();
    }
}

/* The Command for restarting the computer */
class RestartCommand implements Command {
    private Computer computer;

    public RestartCommand(Computer computer) {
	this.computer = computer;
    }

    public void execute() {
	computer.restart();
    }
}

/* The client */
public class TestCommandPattern {

    public static void main(String[] args) {
	System.out.println("Command Design Pattern");
	System.out.println("Command, Reciver, Invoker and Client");
	Computer computer = new Computer();
	Command shutdown = new ShutDownCommand(computer);
	Command restart = new RestartCommand(computer);

	Switch s = new Switch();

	String str = "re"; // get value based on real situation

	if (str == "shutdown") {
	    s.storeAndExecute(shutdown);
	} else {
	    s.storeAndExecute(restart);
	}
    }

}
