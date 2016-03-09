package net.sourceforge.marathon.javafxrecorder.component;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import net.sourceforge.marathon.javafxrecorder.IJSONRecorder;
import net.sourceforge.marathon.javafxrecorder.JSONOMapConfig;

public class RFXTextInputControl extends RFXComponent {

	private String prevText = null;

	public RFXTextInputControl(Node source, JSONOMapConfig omapConfig, Point2D point, IJSONRecorder recorder) {
		super(source, omapConfig, point, recorder);
	}

	@Override
	public void focusGained(RFXComponent prev) {
		prevText = ((TextField) getComponent()).getText();
	}

	@Override
	public void focusLost(RFXComponent next) {
		String text = ((TextField) getComponent()).getText();
		if (!text.equals(prevText))
			recorder.recordSelect(this, text);
	}
}