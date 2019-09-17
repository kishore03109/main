import duke.DukeException;
import duke.Parser;
import duke.TaskList;
import duke.Ui;
import duke.Storage;
import duke.commands.Command;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        outContent.reset();
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void test() throws DukeException {
        Ui ui = new Ui();
        Storage storage = new Storage("./data/test_data.txt");
        String input = "event test /at 0000";
        setUpStreams();
        TaskList taskList = new TaskList();
        Command c = Parser.parse(input);
        c.execute(taskList, ui, storage);
        String exp = "Got it. I've added this task: \n   [E][✗] test (at: 0000)\nNow you have 1 tasks in the list.";
        assertEquals(exp, outContent.toString().trim());
        restoreStreams();
    }

    @Test
    public void birthdayAt_myBday() throws DukeException {
        Ui ui = new Ui();
        Storage storage = new Storage("./data/test_data.txt");
        String input = "event bday /at 06/06/2019";
        setUpStreams();
        TaskList taskList = new TaskList();
        Command c = Parser.parse(input);
        c.execute(taskList, ui, storage);
        String exp = "Got it. I've added this task: \n   [E]"
                + "[✗] bday (at: 06/06/2019)\nNow you have 1 tasks in the list.";
        assertEquals(exp, outContent.toString().trim());
        restoreStreams();
    }

    //    @Test
    //    public void clashEvent() throws DukeException {
    //        String input = "event bday /at 06/06/2019";
    //        setUpStreams();
    //        TaskList taskList = new TaskList();
    //        Command c = Parser.parse(input);
    //        c.execute(taskList, DukeTest.ui, DukeTest.storage);
    //        restoreStreams();
    //        setUpStreams();
    //        c.execute(taskList, DukeTest.ui, DukeTest.storage);
    //        String exp = "     ☹ OOPS!!! This new event clashes with\n"
    //                + " [E][✗] bday (at: 06/06/2019)";
    //        assertEquals(exp, errContent.toString().trim().replace("\r", ""));
    //        restoreStreams();
    //    }
}
