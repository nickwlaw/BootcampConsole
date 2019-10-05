package bc.util;

public interface IConsole {
	String getString(String prompt);
	int getInt(String prompt);
	int getIntWithinRange(String prompt, int min, int max);
	double getDouble(String prompt);
	double getDoubleWithinRange(String prompt, double min, double max);
	boolean userWantsToContinue(String prompt, String choiceA, String choiceB);
	String askToContinue();
}
