package gui;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import script.Characters;
import script.Hero;
import util.AudioFilePlayer;

public class Mirror {
	Terminal terminal;
	Screen screen;
	Panel pStatus, pMap;
	Map map;

	MultiWindowTextGUI board;

	Hero hero;
	Characters _chars;
	
	AudioFilePlayer ap;

	public Mirror() {
		try {
			init();

			_chars = new Characters();

			buildPanels();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void init() throws IOException {
		terminal = new DefaultTerminalFactory().createTerminal();	
		screen = new TerminalScreen(terminal);

		_chars = new Characters();
		map = new Map(_chars);

		screen.startScreen();
		board = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));

	}

	private void buildPanels(){
	    BasicWindow window = new BasicWindow();
	    window.setTitle("Mirror");
	    window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN));

	    Panel mainPanel = new Panel();
	    mainPanel.setLayoutManager(new GridLayout(2));

	    pStatus = new PanelStatus();

	    PanelStory pstory = new PanelStory();

	    mainPanel.addComponent(pStatus.withBorder(Borders.singleLine("Status")));
	    mainPanel.addComponent(map.withBorder(Borders.singleLine("Map")));
	    mainPanel.addComponent(new EmptySpace());
	    mainPanel.addComponent(pstory);

	    window.setComponent(mainPanel);
	    
	    
	    window.addWindowListener(new WindowListener() {
			
			public void onUnhandledInput(Window arg0, KeyStroke keyStroke, AtomicBoolean arg2) {
				// TODO Auto-generated method stub
				map.updatePlayer(keyStroke);
				
				if(keyStroke.getCharacter() == 'f') {
					BasicWindow diaFight = new WFight(Mirror.this);
					
					ap.stop();
					board.addWindow(diaFight);
					diaFight.addWindowListener(new WindowListener() {
						
						@Override
						public void onUnhandledInput(Window arg0, KeyStroke arg1, AtomicBoolean arg2) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onInput(Window arg0, KeyStroke arg1, AtomicBoolean arg2) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onResized(Window arg0, TerminalSize arg1, TerminalSize arg2) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onMoved(Window arg0, TerminalPosition arg1, TerminalPosition arg2) {
							// TODO Auto-generated method stub
							
						}
					});
					
				} else if (keyStroke.getCharacter() == 'm') {
					if (ap.isPlaying())
						ap.stop();
					else
						ap.startPlaying();
				}
			}
			
			public void onInput(Window arg0, KeyStroke arg1, AtomicBoolean arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onResized(Window arg0, TerminalSize arg1, TerminalSize arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onMoved(Window arg0, TerminalPosition arg1, TerminalPosition arg2) {
				// TODO Auto-generated method stub
				
			}
		});

		ap = AudioFilePlayer.getFilePlayer("myst.ogg");
		
		ap.startPlaying();
	          
//	    window.setSize(new TerminalSize(Map.COLUMNS+50, Map.LINES+10));
	    board.addWindowAndWait(window);
	    
	   
	}
	
	public void musicStatus(boolean status) {
		if (status)
			ap.startPlaying();
		else 
			ap.stop();
	}
	
	/*
	public void playMusic(){
	    try {
	    	/*
	    	URL in = getClass().getResource(); 
	    //	new File()
	    	InputStream is= getClass().getResourceAsStream("/assets/myst.mp3");
	    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
		//	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    //    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(in.getFile()).getAbsoluteFile());
	    //    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        
	    	URL in = getClass().getResource("/assets/myst.mp3");
	        Media hit = new Media(in.toString());
	        MediaPlayer mediaPlayer = new MediaPlayer(hit);
	        mediaPlayer.play();
	        
	    	URL in = getClass().getResource("/assets/myst.mp3");
	        FileInputStream fis = new FileInputStream(in.getFile());
	        Player playMP3 = new Player(fis);
	        playMP3.play();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	*/

}
