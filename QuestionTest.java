import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Tests the class QuestionImpl and the interface Question.
 * @author Gareth Moore
 */
public class QuestionTest {

	Question testQuestion;
	//A Question object for use in the following tests.
	
	/**
	 * Instantiates the testQuestion object.
	 */
	@Before
	public void buildUp() {
		String question = "What was the capital of the Byzantine empire?";
		String[] possibleAnswers = new String[] {"Constantinople", "Rome", "Odessa", "Ephesus"};
		int correctAnswer = 1;
		testQuestion = new QuestionImpl(question, possibleAnswers, correctAnswer);
	}
	
	/**
	 * Tests getQuestion().
	 * Should return the correct question.
	 */
	@Test
	public void shouldReturnCorrectQuestion() {
		assertEquals("What was the capital of the Byzantine empire?", testQuestion.getQuestion());
	}

	/**
	 * Tests getPossibleAnswers().
	 * Should return the correct possible answers.
	 */
	@Test
	public void shouldReturnCorrectPossibleAnswers() {
		String[] expected = new String[] {"Constantinople", "Rome", "Odessa", "Ephesus"};
		assertArrayEquals(expected, testQuestion.getPossibleAnswers());
	}
	
	/**
	 * Tests getCorrectAnswer().
	 * Should return the int which represent the index where the correct answers lies.
	 */
	@Test
	public void shouldReturnCorrectAnswerInt() {
		assertEquals(1, testQuestion.getCorrectAnswer());
	}
	
	/**
	 * Tests constructor.
	 *
	 * Should throw an exception when a Question is constructed 
	 * using an array which does not have a length of 4.
	 */
	@Test
	public void shouldThrowExceptionWhenArrayDoesNotEqual4() {
		boolean exceptionThrown = false;
		try {
			String question = "What was the capital of the Byzantine empire?";
			String[] possibleAnswers = new String[] {"Constantinople", "Rome", "Odessa"};
			int correctAnswer = 1;
			Question testQuestion2 = new QuestionImpl(question, possibleAnswers, correctAnswer);
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
}
