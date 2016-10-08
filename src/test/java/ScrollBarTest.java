import java.io.IOException;
import java.util.regex.Pattern;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.CheckBox;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.ScrollBar;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;

public class ScrollBarTest extends TestBase {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ScrollBarTest().run(args);
    }

    @Override
    public void init(WindowBasedTextGUI textGUI) {
        final BasicWindow basicWindow = new BasicWindow("ScrollBar test");
        Panel contentPanel = new Panel();
        contentPanel.setLayoutManager(new GridLayout(2));

        Panel controlPanel = new Panel();
        final CheckBox checkVerticalTrackerGrow = new CheckBox().setChecked(true);
        final CheckBox checkHorizontalTrackerGrow = new CheckBox().setChecked(true);
        final TextBox textBoxVerticalSize = new TextBox("10").setValidationPattern(Pattern.compile("[0-9]+"));
        final TextBox textBoxHorizontalSize = new TextBox("10").setValidationPattern(Pattern.compile("[0-9]+"));
        final TextBox textBoxVerticalPosition = new TextBox("0").setValidationPattern(Pattern.compile("[0-9]+"));
        final TextBox textBoxHorizontalPosition = new TextBox("0").setValidationPattern(Pattern.compile("[0-9]+"));
        final TextBox textBoxVerticalMax = new TextBox("100").setValidationPattern(Pattern.compile("[0-9]+"));
        final TextBox textBoxHorizontalMax = new TextBox("100").setValidationPattern(Pattern.compile("[0-9]+"));
        final ScrollBar verticalScroll = new ScrollBar(Direction.VERTICAL);
        final ScrollBar horizontalScroll = new ScrollBar(Direction.HORIZONTAL);
        Button buttonRefresh = new Button("Refresh", new Runnable() {
            public void run() {
                ((ScrollBar.DefaultScrollBarRenderer)verticalScroll.getRenderer()).setGrowScrollTracker(checkVerticalTrackerGrow.isChecked());
                verticalScroll.setScrollMaximum(getInteger(textBoxVerticalMax.getText(), 100));
                verticalScroll.setScrollPosition(getInteger(textBoxVerticalPosition.getText(), 100));
                verticalScroll.setViewSize(getInteger(textBoxVerticalSize.getText(), 1));
                ((ScrollBar.DefaultScrollBarRenderer)horizontalScroll.getRenderer()).setGrowScrollTracker(checkHorizontalTrackerGrow.isChecked());
                horizontalScroll.setScrollMaximum(getInteger(textBoxHorizontalMax.getText(), 0));
                horizontalScroll.setScrollPosition(getInteger(textBoxHorizontalPosition.getText(), 0));
                horizontalScroll.setViewSize(getInteger(textBoxHorizontalSize.getText(), 1));
            }
        });
        Button closeButton = new Button("Close", new Runnable() {
            public void run() {
                basicWindow.close();
            }
        });

        verticalScroll.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.FILL, false, true));
        horizontalScroll.setLayoutData(GridLayout.createHorizontallyFilledLayoutData(2));
        buttonRefresh.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.BEGINNING, true, true, 2, 1));

        contentPanel.addComponent(controlPanel.withBorder(Borders.singleLine("Control")));
        contentPanel.addComponent(verticalScroll);
        contentPanel.addComponent(horizontalScroll);

        controlPanel.setLayoutManager(new GridLayout(2));
        controlPanel.addComponent(new Label("Vertical tracker grows:")).addComponent(checkVerticalTrackerGrow);
        controlPanel.addComponent(new Label("Vertical view size:")).addComponent(textBoxVerticalSize);
        controlPanel.addComponent(new Label("Vertical scroll position:")).addComponent(textBoxVerticalPosition);
        controlPanel.addComponent(new Label("Vertical scroll max:")).addComponent(textBoxVerticalMax);
        controlPanel.addComponent(new EmptySpace(TerminalSize.ONE)).addComponent(new EmptySpace(TerminalSize.ONE));
        controlPanel.addComponent(new Label("Horizontal tracker grows:")).addComponent(checkHorizontalTrackerGrow);
        controlPanel.addComponent(new Label("Horizontal view size:")).addComponent(textBoxHorizontalSize);
        controlPanel.addComponent(new Label("Horizontal scroll position:")).addComponent(textBoxHorizontalPosition);
        controlPanel.addComponent(new Label("Horizontal scroll max:")).addComponent(textBoxHorizontalMax);
        controlPanel.addComponent(new EmptySpace(TerminalSize.ONE)).addComponent(new EmptySpace(TerminalSize.ONE));
        controlPanel.addComponent(buttonRefresh);
        contentPanel.addComponent(closeButton);

        basicWindow.setComponent(contentPanel);
        textGUI.addWindow(basicWindow);
    }

    private int getInteger(String text, int defaultValue) {
        try {
            return Integer.parseInt(text);
        }
        catch(NumberFormatException e) {
            return defaultValue;
        }
    }
}