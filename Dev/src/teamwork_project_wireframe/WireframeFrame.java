package teamwork_project_wireframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WireframeFrame extends JFrame implements FocusListener, ActionListener {
	
	//================Constants==================
	private static final String[] ALLOWED_ROOMS = {"4000", "4005", "4010", "4015",
			"4020", "4025", "4030", "4040", "4045", "4050", "4055", "4060", "4070", "4075",
			"4085", "4090", "4095", "4100", "4205", "4210", "4215", "4500", "4505", "4510",
			"4515", "4520"};
	
	//==================Fields====================
	private CardLayout cardLayout = new CardLayout();
	
	//----------------Home Content--------------------
	private JPanel homeContentPanel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel searchBarPanel;
	private JTextField searchBar;
	private JButton searchButton;
	private JComboBox<String> buildingSearch;
	private JPanel searchResultsPanel;
	private JScrollPane searchResultsScroll;
	private JLabel resultsLabel;
	
	//----------------Map Content--------------------
	private JPanel mapContentPanel;
	private JLabel map;
	
	//---------------Arrived Content-------------------
	private JPanel arrivedContentPanel;
	private JLabel arrivedImage;
	
	//==================Main=======================
	public static void main(String[] args) {
		new WireframeFrame();
	}
	
	//================Constructor====================
	public WireframeFrame() {
		
		//set up the search button
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchButton.setBounds(410, 10, 75, 80);
		searchButton.setBackground(Color.white);
		
		//set up the search bar
		searchBar = new JTextField();
		searchBar.setBounds(60, 10, 350, 80);
		searchBar.setText("Enter a room number (you may use '-' for unknown numbers)");
		searchBar.addFocusListener(this);
		
		//set up the building search menu
		buildingSearch = new JComboBox<String>();
		buildingSearch.setBackground(Color.white);
		buildingSearch.setBounds(10, 10, 50, 80);
		buildingSearch.addItem("MK");
		
		//set up the search panel
		searchBarPanel = new JPanel();
		searchBarPanel.setBackground(Color.white);
		searchBarPanel.setLayout(null);
		searchBarPanel.setBounds(0, 50, 500, 100);
		
		//add the search related components to the panel
		searchBarPanel.add(searchBar);
		searchBarPanel.add(searchButton);
		searchBarPanel.add(buildingSearch);
		
		//set up the bottom panel
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.red);
		bottomPanel.setBounds(0, 730, 500, 50);
		
		//set up the top panel
		topPanel = new JPanel();
		topPanel.setBackground(Color.red);
		topPanel.setBounds(0, 0, 500, 50);
		
		//set up the results label
		resultsLabel = new JLabel("Results:");
		resultsLabel.setBackground(Color.white);
		resultsLabel.setBounds(0, 0, 50, 25);
		
		//set up the search results panel
		searchResultsPanel = new JPanel();
		searchResultsPanel.setLayout(null);
		searchResultsPanel.setBounds(0, 0, 500, 580);
		searchResultsPanel.setBackground(Color.white);
		
		//set up the scrolling
		searchResultsScroll = new JScrollPane(searchResultsPanel);
		searchResultsScroll.setBounds(0, 150, 500, 580);
		searchResultsScroll.setBackground(Color.white);
		searchResultsScroll.getVerticalScrollBar().setUnitIncrement(16);
		
		//set up the content panel
		homeContentPanel = new JPanel();
		homeContentPanel.setBackground(Color.white);
		homeContentPanel.setLayout(null);
		homeContentPanel.setBounds(0, 0, 500, 800);
		
		//add the content to the panel
		homeContentPanel.add(topPanel);
		homeContentPanel.add(bottomPanel);
		homeContentPanel.add(searchBarPanel);
		homeContentPanel.add(searchResultsScroll);
		
		//set up the frame
		add(homeContentPanel);
		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Classroom Finder");
		setLayout(cardLayout);
		setResizable(false);
		setVisible(true);
		searchButton.requestFocus();
		cardLayout.show(getContentPane(), homeContentPanel.getName());
	}

	//===================Focus Listener====================
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == searchBar && 
				searchBar.getText().equals("Enter a room number (you may use '-' for unknown numbers)"))
			searchBar.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == searchBar && searchBar.getText().equals(""))
			searchBar.setText("Enter a room number (you may use '-' for unknown numbers)");
	}

	//===================Action Listener======================
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchButton)
			search();
		
	}

	private void search() {
		
		//validate the input
		if (isIntegerInRange(searchBar.getText())) {
			searchResultsPanel.removeAll();
			ArrayList<String> matches = new ArrayList<String>();
			for (String s : ALLOWED_ROOMS) {
				matches.add(s);
			}
			
			//check the input for matches
			for (int i = 0; i < searchBar.getText().length(); i++) {
				char c = searchBar.getText().charAt(i);
				matches = checkIndices(c, i, matches);
				
			}
			
			//if the room could not be found
			if (matches.isEmpty())
				System.out.println("This room could not be found");
			
			//add the results 
			searchResultsPanel.add(resultsLabel);
			for (int i = 0; i < matches.size(); i++) {
				String s = matches.get(i);
				JButton button = new JButton(s);
				button.setBackground(Color.white);
				button.setBounds(0, 25 + i * 50, 500, 50);
				button.addActionListener(this);
				searchResultsPanel.add(button);
				
			}
			
			//update the screen
			searchResultsPanel.setPreferredSize(new Dimension(480, 25 + 50 * matches.size()));
			revalidate();
			repaint();
		} else
			System.out.println("This is not allowed");
	}

	private ArrayList<String> checkIndices(char c, int i, ArrayList<String> matches) {
		
		//check if the room matches
		for (int j = 0; j < ALLOWED_ROOMS.length; j++) {
			if (c == '-') {
				continue;
			} else if (ALLOWED_ROOMS[j].charAt(i) != c) {
				matches.remove(ALLOWED_ROOMS[j]);
			}
		}
		return matches;
	}

	private boolean isIntegerInRange(String text) {
		
		//validate input
		for (char c : text.toCharArray()) {
			if (!Character.isDigit(c) && c != '-') {
				return false;
			}
		}
		return true;
	}

	
	

}
