package javacake.quiz;

import java.util.ArrayList;

public class QuestionBank {

    public ArrayList<BasicQuestion> BasicQuestions(){
        ArrayList<BasicQuestion> basicQuestions = new ArrayList<>();
        ArrayList<String> Questions = new ArrayList<>();
        ArrayList<String> Answers = new ArrayList<>();
        int NumOfQuestions = 3; //update number as num of questions increases

        Questions.add("Consider the following scenario. If you were to simulate this in an OOP program, " +
                "how many classes and the objects you would use?\n" +
                "A customer (name: John) gave a cheque to the Cashier (name: Peter) " +
                "to pay for the LoTR and GoT books he bought.\n" +
                "\n" +
                "(1) 1 Class, 5 Objects\n" +
                "(2) 4 Class, 5 Objects\n" +
                "(3) 4 Class, 4 Objects\n" +
                "(4) 5 Class, 5 Objects");
        Answers.add("2");

        Questions.add("A class attribute has a default value depending on its type. The following list shows the types and their corresponding default values. \n" +
                "i. int: 0\n" +
                "ii. int: no default value\n" +
                "iii. char: '\\u0000' (null character with ASCII value 0)\n" +
                "iv. char: null\n" +
                "v. String: null\n" +
                "vi. String: \"\" (empty string)\n" +
                "Which of the above are correct? \n" +
                "(1) Only (i), (iii) and (v) \n" +
                "(2) Only (i), (iii) and (vi) \n" +
                "(3) Only (i), (iv) and (v)\n" +
                "(4) Only (ii), (iii) and (v)\n" +
                "(5) Only (ii), (iv) and (vi)");
        Answers.add("1");

        Questions.add("The Scanner class allows a program to read from file. T/F?");
        Answers.add("t"); // Scanner s = new Scanner(file);

        for(int i = 0; i<NumOfQuestions; i++) {
            basicQuestions.add(new BasicQuestion(Questions.get(i), Answers.get(i)));
        }

        return basicQuestions;
    }

    public ArrayList<ExtensionQuestion> ExtensionQuestions() {
        ArrayList<ExtensionQuestion> ExtensionQuestions = new ArrayList<>();
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

        ExtensionQuestions.add(new ExtensionQuestion(q1, a1));
        ExtensionQuestions.add(new ExtensionQuestion(q2, a2));
        ExtensionQuestions.add(new ExtensionQuestion(q3, a3));

        return ExtensionQuestions;
    }

    public ArrayList<OopQuestion> OOPQuestions() {
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



}
