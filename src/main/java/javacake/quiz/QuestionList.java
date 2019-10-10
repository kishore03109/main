package javacake.quiz;

import javacake.DukeException;

import java.util.ArrayList;
import java.util.Random;

public class QuestionList {
    private ArrayList<Question> chosenQuestions;
    /** The maximum number of questions in one session of a quiz. */
    public static final int MAX_QUESTIONS = 3;

    public QuestionList() {
        chosenQuestions = new ArrayList<>(MAX_QUESTIONS);
    }

    private ArrayList<BasicQuestion> initBasicList() {
        ArrayList<BasicQuestion> basicQuestionList = new ArrayList<>();

        String q1 = "How many members are in this team? Answer in int.";
        String a1 = "4";
        String q2 = "wake me up\n a. before you go go\n b. when september ends\n c. WAKE ME UP INSIDE";
        String a2 = "c";
        String q3 = "The Scanner class allows a program to read from file. T/F?";
        String a3 = "t"; // Scanner s = new Scanner(file);

        basicQuestionList.add(new BasicQuestion(q1, a1));
        basicQuestionList.add(new BasicQuestion(q2, a2));
        basicQuestionList.add(new BasicQuestion(q3, a3));

        return basicQuestionList;
    }

    private ArrayList<OopQuestion> initOopList() {
        ArrayList<OopQuestion> oopQuestionList = new ArrayList<>();

        String q1 = "What does OOP stand for in software engineering context?\n"
                + " a. Out Of Print\n b. Object-Oriented Programming\n c. Ogre Onion Paradigm";
        String a1 = "b";
        String q2 = "Name a class that does not inherit from any other class.";
        String a2 = "object";
        String q3 = "An interface implements methods that can be inherited by its subclasses. T/F?";
        String a3 = "f";

        oopQuestionList.add(new OopQuestion(q1, a1));
        oopQuestionList.add(new OopQuestion(q2, a2));
        oopQuestionList.add(new OopQuestion(q3, a3));

        return oopQuestionList;
    }

    private ArrayList<ExtensionQuestion> initExtensionList() {
        ArrayList<ExtensionQuestion> extensionQuestionList = new ArrayList<>();

        String q1 = "What should you NOT do to handle an exception in main?\n"
                + " a. Rethrow the exception\n b. Print error message \n c. Call backup method";
        String a1 = "a";
        String q2 = "What does the [finally] block do? Choose the best answer.\n"
                + " a. specify code that is guaranteed to execute with or without exception.\n"
                + " b. specify code that is guaranteed to execute at the end of a program.\n"
                + " c. specify code that is guaranteed to execute after an assertion returns false.";
        String a2 = "a";
        String q3 = "What's the actual best programming language?";
        String a3 = "assembly";

        extensionQuestionList.add(new ExtensionQuestion(q1, a1));
        extensionQuestionList.add(new ExtensionQuestion(q2, a2));
        extensionQuestionList.add(new ExtensionQuestion(q3, a3));

        return extensionQuestionList;
    }

    /**
     * Randomly selects MAX_QUESTIONS number of questions from the list of all questions.
     * @return ArrayList of Question of size MAX_QUESTIONS.
     */
    public ArrayList<Question> pickQuestions() throws DukeException {
        ArrayList<Question> allQuestions = new ArrayList<>();
        allQuestions.addAll(initBasicList());
        allQuestions.addAll(initOopList());
        allQuestions.addAll(initExtensionList());
        assert (allQuestions.size() >= MAX_QUESTIONS);

        Random rand = new Random();
        ArrayList<Integer> chosenNumbers = new ArrayList<>();

        for (int i = 0; i < MAX_QUESTIONS; i++) {
            int randomNum;
            do {
                randomNum = rand.nextInt(allQuestions.size());
            } while (chosenNumbers.contains(randomNum)); // prevents repeat questions
            chosenNumbers.add(randomNum);
            try {
                chosenQuestions.add(allQuestions.get(randomNum));
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException("Something went wrong when loading the quiz: index out of bounds.");
            }
        }
        return chosenQuestions;
    }

    /**
     * Randomly selects MAX_QUESTIONS number of questions of the specified topic from the list of all questions.
     * @param type QuestionType of questions to be selected.
     * @return ArrayList of Question of specified topic of size MAX_QUESTIONS.
     */
    public ArrayList<Question> pickQuestions(Question.QuestionType type) throws DukeException {
        ArrayList<Question> tempList = new ArrayList<>();
        switch (type) {
        case BASIC:
            assert (initBasicList().size() >= MAX_QUESTIONS);
            tempList.addAll(initBasicList());
            break;
        case OOP:
            assert (initOopList().size() >= MAX_QUESTIONS);
            tempList.addAll(initOopList());
            break;
        case EXTENSIONS:
            assert (initExtensionList().size() >= MAX_QUESTIONS);
            tempList.addAll(initExtensionList());
            break;
        default:
            tempList.addAll(initBasicList());
            tempList.addAll(initOopList());
            tempList.addAll(initExtensionList());
            assert (tempList.size() >= MAX_QUESTIONS);
            break;
        }

        Random rand = new Random();
        ArrayList<Integer> chosenNumbers = new ArrayList<>();

        for (int i = 0; i < MAX_QUESTIONS; i++) {
            int randomNum;
            do {
                randomNum = rand.nextInt(tempList.size());
            } while (chosenNumbers.contains(randomNum)); // prevents repeat questions
            chosenNumbers.add(randomNum);
            try {
                chosenQuestions.add(tempList.get(randomNum));
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException("Something went wrong when loading the quiz: index out of bounds.");
            }
        }
        return chosenQuestions;
    }
}
