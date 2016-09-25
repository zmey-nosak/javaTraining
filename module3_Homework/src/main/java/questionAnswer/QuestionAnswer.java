package questionAnswer;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Echetik on 25.09.2016.
 */
public class QuestionAnswer {
    private class PairQuestionAnswer {
        String Question;
        String Answer;

        public PairQuestionAnswer(String question, String answer) {
            Question = question;
            Answer = answer;
        }
    }

    private Locale rusLocale = new Locale("ru", "RU");


    Map<Integer, PairQuestionAnswer> map = new LinkedHashMap<>();
    ResourceBundle answersBundle;
    ResourceBundle questionsBundle;

    {
        if (Locale.getDefault().equals(Locale.US)) {
            questionsBundle = ResourceBundle.getBundle("Questions", Locale.US);
            answersBundle = ResourceBundle.getBundle("Answers", Locale.US);
        } else if (Locale.getDefault().equals(rusLocale)) {
            questionsBundle = ResourceBundle.getBundle("Questions", Locale.getDefault());
            answersBundle = ResourceBundle.getBundle("Answers", Locale.getDefault());
        }

        for (int i = 0; i < 10; i++) {
            map.put(i, new PairQuestionAnswer(questionsBundle.getString("question" + (i+1)), answersBundle.getString("answer" + (i+1))));
        }

    }

    public Map<Integer, String> getQuestions() {
        Map<Integer, String> answers = new LinkedHashMap<>();
        for (Map.Entry<Integer, PairQuestionAnswer> pair : map.entrySet()) {
            answers.put(pair.getKey(), pair.getValue().Question);
        }
        return answers;
    }

    public String getAnswer(int numberOfQuestion) {
        return map.get(numberOfQuestion).Answer;
    }

}
