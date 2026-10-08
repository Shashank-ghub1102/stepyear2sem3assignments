package polymorphismweek8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ExaminationQuestion {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public ExaminationQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluateScore();

    public abstract String getQuestionType();
}

class MultipleChoiceQuestion extends ExaminationQuestion {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends ExaminationQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }
}

class EssayQuestion extends ExaminationQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudentAnswer.contains(trimmedKw)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return 0.75 * points;
        } else if (matchCount == 1) {
            return 0.50 * points;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }
}

public class Week8_Polymorphism_ExaminationQuestionGrader {
    public static void gradeQuestions(ExaminationQuestion[] questions) {
        double totalScore = 0.0;
        for (ExaminationQuestion q : questions) {
            double score = q.evaluateScore();
            System.out.printf("%s: %.2f%n", q.getQuestionType(), score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            ExaminationQuestion[] sampleQuestions = {
                new MultipleChoiceQuestion("What is the capital of France?", "Paris", "Paris", 10),
                new TrueFalseQuestion("The Earth is flat?", "False", "True", 5),
                new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20),
                new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15)
            };
            gradeQuestions(sampleQuestions);
            scanner.close();
            return;
        }

        String firstLine = scanner.nextLine().trim();
        if (firstLine.isEmpty()) {
            ExaminationQuestion[] sampleQuestions = {
                new MultipleChoiceQuestion("What is the capital of France?", "Paris", "Paris", 10),
                new TrueFalseQuestion("The Earth is flat?", "False", "True", 5),
                new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20),
                new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15)
            };
            gradeQuestions(sampleQuestions);
            scanner.close();
            return;
        }

        int n;
        try {
            n = Integer.parseInt(firstLine);
        } catch (NumberFormatException e) {
            n = 0;
        }

        ExaminationQuestion[] questions = new ExaminationQuestion[n];

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            List<String> tokens = new ArrayList<>();
            boolean inQuotes = false;
            StringBuilder sb = new StringBuilder();
            for (int cIdx = 0; cIdx < line.length(); cIdx++) {
                char ch = line.charAt(cIdx);
                if (ch == '\"') {
                    inQuotes = !inQuotes;
                } else if (Character.isWhitespace(ch) && !inQuotes) {
                    if (sb.length() > 0) {
                        tokens.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    sb.append(ch);
                }
            }
            if (sb.length() > 0) {
                tokens.add(sb.toString());
            }

            if (tokens.size() >= 5) {
                String type = tokens.get(0);
                String questionText = tokens.get(1);
                String correctAnswer = tokens.get(2);
                String studentAnswer = tokens.get(3);
                int points = Integer.parseInt(tokens.get(4));

                if ("MCQ".equalsIgnoreCase(type)) {
                    questions[i] = new MultipleChoiceQuestion(questionText, correctAnswer, studentAnswer, points);
                } else if ("TF".equalsIgnoreCase(type)) {
                    questions[i] = new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points);
                } else if ("ESSAY".equalsIgnoreCase(type)) {
                    questions[i] = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
                }
            }
        }

        gradeQuestions(questions);
        scanner.close();
    }
}
