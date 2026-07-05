package LLD.CommandPattern;

import java.util.Stack;

public class RemoteControl {

    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if(!history.empty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        } else {
            System.out.println("Nothing to Undo");
        }
    }

}
