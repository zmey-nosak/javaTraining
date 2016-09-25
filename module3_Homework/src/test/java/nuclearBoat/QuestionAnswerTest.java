package nuclearBoat;

import org.junit.Assert;
import org.junit.Test;
import questionAnswer.QuestionAnswer;

import java.util.Locale;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Echetik on 25.09.2016.
 */
public class QuestionAnswerTest {
    @Test
    public void getUsQuestionsAndAnswer() {
        QuestionAnswer questionAnswer = new QuestionAnswer();
        Map<Integer, String> map = questionAnswer.getQuestions();
        Assert.assertEquals("вопрос_1", map.get(0));
        Assert.assertEquals("ответ_1", questionAnswer.getAnswer(0));
    }

    @Test
    public void getRuQuestionsAndAnswer() {
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(new Locale("ru", "RU"));
        QuestionAnswer questionAnswer = new QuestionAnswer();
        Map<Integer, String> map = questionAnswer.getQuestions();
        Assert.assertEquals(map.get(0), "вопрос_1");
        Assert.assertEquals(questionAnswer.getAnswer(0), "ответ_1");
        Locale.setDefault(new Locale("en", "En"));
        Locale.setDefault(defLocale);
    }

    @Test
    public void getEnQuestionsAndAnswer() {
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        QuestionAnswer questionAnswer = new QuestionAnswer();
        Map<Integer, String> map = questionAnswer.getQuestions();
        assertThat(map.get(0), is("question_1"));
        Assert.assertEquals(questionAnswer.getAnswer(0), "answer_1");
        Locale.setDefault(defLocale);
    }
}