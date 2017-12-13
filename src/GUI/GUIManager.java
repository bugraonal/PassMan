package GUI;

public class GUIManager {
	private GUI gui;

	public GUIManager() {
		this.gui = new GUI(this);
	}

	public void printLoginPanel() {
		gui.printLoginPanel();
	}

}
