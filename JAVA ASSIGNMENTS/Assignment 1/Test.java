// ASSIGNMENT 1

import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] subjects = new String[]{"English", "Maths", "GK"};

        String[][] questions = new String[][]{
                {"English Question 1 (Vowels)", "English Question 2 (Poem)", "English Question 3 (Lesson)"},
                {"Maths Question 1 Addition(10+10)", "Maths Question 2 Multiplication(25*10)", "Maths Question 3 Division(20/2)"},
                {"GK Question 1 (Animal Name)", "GK Question 2 (Bird Name)", "GK Question 3 (State Name)"}
        };

        String[][] answers = new String[][]{
                {"aeiou", "Poem", "Lesson"},
                {"20", "250", "10"},
                {"Dog", "Parrot", "Karnataka"}
        };

        int marks;

        do {
            marks = 0;
            boolean[] attempt = new boolean[]{false, false, false};

            do {
                System.out.println("Online Examination");
                System.out.println("1.English");
                System.out.println("2.Maths");
                System.out.println("3.GK");
                System.out.print("Enter your choice: ");
                int sub = sc.nextInt();

                while (attempt[sub - 1]) {
                    System.out.println("You have already attended this subject, choose another subject");
                    System.out.print("Enter your choice: ");
                    sub = sc.nextInt();
                }

                switch(sub) {
                    case 1:
                        System.out.println("Subject: " + subjects[0]);
                        sc.nextLine();
                        
                        for (int i = 0; i < 3; i++) {
                            System.out.println((i + 1) + ". " + questions[0][i]);
                            System.out.println("\nEnter your answer\n");
                            String answer = sc.nextLine();
                            if (answer.equals(answers[0][i])) {
                                marks += 10;
                                System.out.println("Correct answer\n10 marks awarded");
                            } else {
                                System.out.println("Incorrect answer");
                            }
                        }
                        attempt[0] = true;
                        break;

                    case 2:
                        System.out.println("Subject: " + subjects[1]);
                        sc.nextLine();

                        for (int i = 0; i < 3; i++) {
                            System.out.println((i + 1) + ". " + questions[1][i]);
                            System.out.println("\nEnter your answer\n");
                            String answer = sc.nextLine();
                            if (answer.equals(answers[1][i])) {
                                marks += 10;
                                System.out.println("Correct answer\n10 marks awarded");
                            } else {
                                System.out.println("Incorrect answer");
                            }
                        }
                        attempt[1] = true;
                        break;

                    case 3:
                        System.out.println("Subject: " + subjects[2]);
                        sc.nextLine();

                        for (int i = 0; i < 3; i++) {
                            System.out.println((i + 1) + ". " + questions[2][i]);
                            System.out.println("\nEnter your answer\n");
                            String answer = sc.nextLine();
                            if (answer.equals(answers[2][i])) {
                                marks += 10;
                                System.out.println("Correct answer\n10 marks awarded");
                            } else {
                                System.out.println("Incorrect answer");
                            }
                        }
                        attempt[2] = true;
                        break;
                }

                System.out.print("Do you wish to continue: ");
                String ch = sc.nextLine();
                if (attempt[0] && attempt[1] && attempt[2]) {
                    System.out.println("You have attended all subjects");
                    break;
                } else if (ch.equals("no")) {
                    System.out.println("You have not attended all subjects. Attend all subject questions");
                }
            } while (true);

            if (marks >= 70)
                break;
            else
                System.out.println("Minimum citeria not fulfilled. Try again.");
        } while (true);

        if (marks > 70)
            marks += 10;
        if (marks >= 90)
            System.out.println("Selected");
        else
            System.out.println("Try next time");
    }
}