package moebrowser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class MoeBrowser extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public MoeBrowser(){
		super("MoeBrowser");
		
		addressBar = new JTextField("Enter a URL here");
		addressBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				loadPage(event.getActionCommand());
			}
		});
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(new HyperlinkListener(){
			public void hyperlinkUpdate(HyperlinkEvent event){
				if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					loadPage(event.getURL().toString());
				}
			}
		});
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	// load page to disply on screen
	private void loadPage(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			display.setText("Format: http://www.whatever.com");;
			
		}
	}

}
