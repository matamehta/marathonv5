package net.sourceforge.marathon.javafxrecorder.component;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import ensemble.samples.controls.ProgressBarSample;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import net.sourceforge.marathon.javafxrecorder.component.LoggingRecorder.Recording;

public class RFXProgressBarTest extends RFXComponentTest {

    @Test public void select() {
        ProgressBar progressBar = (ProgressBar) getPrimaryStage().getScene().getRoot().lookup(".progress-bar");
        LoggingRecorder lr = new LoggingRecorder();
        Platform.runLater(() -> {
            RFXProgressBar rfxProgressBar = new RFXProgressBar(progressBar, null, null, lr);
            progressBar.setProgress(0.56);
            rfxProgressBar.mouseReleased(null);
        });
        List<Recording> recordings = lr.waitAndGetRecordings(1);
        Recording recording = recordings.get(0);
        AssertJUnit.assertEquals("recordSelect", recording.getCall());
        AssertJUnit.assertEquals("0.56", recording.getParameters()[0]);
    }

    @Override protected Pane getMainPane() {
        return new ProgressBarSample();
    }
}