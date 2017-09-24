package mineSweeper;

public class MSweep1 implements MineSweeper {

	public boolean check = false;
	static String mineField = "*...\n..*.\n....";
	
	// main method for testing - to be removed
	public static void main(String[] args) {

		MSweep1 mSweeper = new MSweep1();
		mSweeper.setMineField(mineField);
		System.out.println(mSweeper.getHintField());

	}

	@Override
	public void setMineField(String mineField) throws IllegalArgumentException {
		// check if only permitted characters are given
		for (int i = 0; i < mineField.length(); i++) {
			char c = mineField.charAt(i);
			if (c != '*' && c != '\n' && c != 'n' && c != '.') {
				throw new IllegalArgumentException();
			}
		}
		check = true; // switch to tell if setMineField was called
		// TODO check if '\n' characters are on correct positions

	}

	@Override
	public String getHintField() throws IllegalStateException {
		// check if setMineField method was called
		if (check == false) {
			throw new IllegalStateException("Set Mine Field First!");
		}
		// TODO replace dots with relevant integers - to be finished
		String hintString = "";
		for (int i = 0; i < mineField.length(); i++) {
			char c = mineField.charAt(i);
			if (c == '*') {
				hintString = hintString + c;
			} else if (c == '.') {
				hintString = hintString + '1'; // TODO implement correct numbers
			} else if (c == '\n') {
				hintString = hintString + "\\n";
			} else if (c == 'n') {
				hintString = hintString + 'n';
			}
		}
		return hintString;
	}
}
