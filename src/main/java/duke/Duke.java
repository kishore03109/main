package duke;

import duke.commands.Command;

import java.io.File;
import java.io.IOException;

public class Duke {
    private static String savedDataPath = "data/saved_data.txt";
    private static Ui ui;
    private static Storage storage;
    private static TaskList tasks;

    /**
     * Constructor for main class to initialise the settings.
     */
    private Duke(String filePath) throws DukeException {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            throw new DukeException("FAILED TO LOAD");
        }
    }

    /**
     * Run the rest of the code here.
     */
    private void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Program Start.
     */
    public static void main(String[] args) throws DukeException {
        new Duke(savedDataPath).run();
    }

}