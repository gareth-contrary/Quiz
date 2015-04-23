import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
* A service to allow users to either setup new quizzes or play existing quizzes.
*/
public interface QuizService extends Remote {

	//Methods below are designed for use on either the Setup Client or the Player Client
	
	/**
	 * Registers a new Player on the QuizService.
	 * 
	 * @param userName is the userName submitted by the user.
	 * userName must be unique.
	 * @throws IllegalArgumentException if the userName already exists.
	 * @throws NullPointerException if the userName is null.
	 */
	void registerNewPlayer(String userName) throws RemoteException, IllegalArgumentException, NullPointerException;
	
	/**
	 * Takes a userName submitted by a Client and confirms that it is registered on the QuizService.
	 * If the userName argument is null, false is returned.
	 *
	 * @param userName submitted by the Player client.
	 * @return true if the userName has been registered.
	 */
	boolean userNameExists(String userName) throws RemoteException;
	
	
	//The following methods are designed for use by the Player Client.
	
	/**
	 * Sends a list of quizzes to a Player client so that a Player can choose a quiz to play.
	 *
	 * @return a list of all active quizzes.
	 * An active quiz is one which has not been terminated.
	 */
	List<Quiz> getAllActiveQuizzes() throws RemoteException;
	
	/**
	 * Allows a Player client to select a quiz to play.
	 *
	 * @param userName is Player's unique id.
	 * @param quizId of the quiz a Player wishes to play.
	 * @return the list of questions for the PLayer's chosen quiz.
	 */
	List<Question> playQuiz(String userName, int quizId) throws RemoteException;
		
	/**
	 * Once a Player has complted a quiz, this method adds a new Attempt.
	 * Moreover, if the Player has the new highest score, 
	 * the quiz's leader field is updated.
	 *
	 * @param quizId of the quiz the Player has completed.
	 * @param userName uniquely identifies the Player.
	 * @param score which the Player record for this quiz.
	 * @throws IllegalArgumentException if either quizId or userName does not exist.
	 */
	void addNewAttempt(int quizId, String userName, int score) throws RemoteException, IllegalArgumentException;	 
	
	
	//These methods are designed for use with the Setup Client.
	
	/**
	 * Registers a new quiz on the QuizService.
	 *
	 * @param quiz is the Quiz the user wishes to add to the QuizService.
	 * @return a unique quizId.
	 * @throws IllegalArgumentException if the author is not a registered Player.
	 * @throws NullPointerException if quiz is null.
	 */
	int addNewQuiz(Quiz quiz) throws RemoteException, IllegalArgumentException, NullPointerException;
	
	/**
	 * Terminates an active quiz. The quiz must be terminated by the author.
	 *
	 * @param userName of the Player terminating the quiz.
	 * @param quizId of the quiz to be terminated.
	 * @throws IllegalArgumentException if the quizId does not exist or if the quiz has already been terminated.
	 * @throws IllegalArgumentException if the userName does not macth the author of the quiz.
	 */
	void terminateQuiz(String userName, int quizId) throws RemoteException, IllegalArgumentException;
	
	
	// These methods are not accessible to the Play Client or Setup Client.
	
	/**
	 * Writes the contents of the QuizServer to disk.
	 *
	 */
	//private void flush();
	
	/**
	 * Read the contents of the QuizServer from disk.
	 */
	//private void read();	
}
