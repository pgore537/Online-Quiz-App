import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = loadQuestions();
        int score = 0;

        System.out.println("🔰 Welcome to the Online Quiz! 🔰\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1;

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.options[q.correctOption] + "\n");
            }
        }

        System.out.println("🎉 Quiz Completed!");
        System.out.println("✅ Your Score: " + score + " out of " + questions.size());

        scanner.close();
    }

    public static List<Question> loadQuestions() {
        List<Question> list = new ArrayList<>();

        list.add(new Question("What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 0));

        list.add(new Question("Which language runs in a web browser?",
                new String[]{"Python", "C", "JavaScript", "Java"}, 2));

        list.add(new Question("Who is the founder of Microsoft?",
                new String[]{"Elon Musk", "Bill Gates", "Steve Jobs", "Mark Zuckerberg"}, 1));

        list.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Venus", "Jupiter"}, 1));

        list.add(new Question("What does CPU stand for?",
                new String[]{"Central Process Unit", "Computer Personal Unit", "Central Processing Unit", "Control Processing Unit"}, 2));

        return list;
    }
}
