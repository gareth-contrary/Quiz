import java.util.Calendar;

/**
 * A Quiz object refers to each quiz created by a Player.
 *
 * It has a unique ID, a list of Questions, a name, and an author.
 * A quiz has a boolean flag to indicate if the quiz has terminated or not.
 * A leaderoard stores the scores in ascending order.
 */
public interface Quiz {

	/**
	 * Sets the unique id for each Quiz.
	 *
	 * @param quizId unique id provided by the QuizServer.
	 * The server provides the id to ensure uniqueness.
	 */
	void setQuizId(int quizId);
	
	/**
	 * Sets the name of the quiz. Name does not need to be unique.
	 *
	 * @param name of the quiz.
	 * @throws NullPointerException if name is null.
	 */
	void setName(String name) throws NullPointerException;
	
	/**
	 * Sets the status of the quiz to terminated.
	 *
	 */
	void setTerminated();
	
	/**
	 * Sets the userName of the leading Player.
	 * If the expiryDate has expired, this is the eventual Winner.
	 * But if the expiryDate is in the future, then this is the current leader.
	 *
	 * @param userName of the winning Player.
	 * @throws IllegalArgumentException if the Player does not exist.
	 */
	void setLeader(String userName) throws IllegalArgumentException;
	
	/**
	 * Adds a new Question to the quiz.
	 *
	 * @param question is the question itself.
	 * @param possibleAnswers the choice of answers for this Question.
	 * @param correctAnswer the index of the correct answer from possibleAnswers.
	 */
	void addNewQuestion(String question, String[] possibleAnswers, int correctAnswer);
	
	/**
	 * Sets the author of the quiz.
	 *
	 * @param userName is the Player who created the quiz.
	 */
	void setAuthor(String userName);
	
	/**
	 * @return quizId.
	 */
	int getQuizId();
	
	/**
	 * @return name.
	 */
	String getName();
	
	/**
	 * @return list of questions.
	 */
	List<Question> getQuestions(); 

	/**
	 * Adds a new attempt to the Quiz's leaderboard.
	 *
	 * @param userName is the Player who attempted the quiz.
	 * @param score that the Player scored on this attempt.
	 * @param date which the Player attempted this quiz.
	 */
	void addNewAttempt(String userName, int score, Calendar date);
	
	/**
	 * @return the full Leaderboard of this quiz.
	 */
	List<Attempt> getLeaderboard();
}
