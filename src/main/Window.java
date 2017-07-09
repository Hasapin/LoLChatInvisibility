package main;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {

	private settings set;
	private invisibilityCaller invCaller;
	private JFrame f;
	private JButton ApplyButton;
	
	private JPanel naPanel;
	private JPanel euwPanel;
	private JPanel eunePanel;
	private JPanel ocePanel;
	
	private JLabel l;
	private JLabel l_NA;
	private JLabel l_EUW;
	private JLabel l_EUNE;
	private JLabel l_OCE;
	
	public Window(){
		set = new settings();
		invCaller = new invisibilityCaller();
		prepareGUI();
	}
	
	private void prepareGUI(){
		f = new JFrame("LoL Invisibility Mode");
		f.setSize(set.Width, set.Height);
		f.setLocationRelativeTo(null);
		f.setLayout(new GridLayout(6,3));
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});

		CheckboxGroup naGroup = new CheckboxGroup();
		CheckboxGroup euwGroup = new CheckboxGroup();
		CheckboxGroup euneGroup = new CheckboxGroup();
		CheckboxGroup oceGroup = new CheckboxGroup();
		
		/////////////////////////////////////////////////////////
		Checkbox chkNAtrue = new Checkbox("Invisible", naGroup, false);
		Checkbox chkNAfalse = new Checkbox("Visible", naGroup, true);
		
		chkNAtrue.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.naAction = "block";
			}
		});
		chkNAfalse.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.naAction = "allow";
			}
		});
		
		////////////////////////////////////////////////////////
		Checkbox chkEUWtrue = new Checkbox("Invisible", euwGroup, false);
		Checkbox chkEUWfalse = new Checkbox("Visible", euwGroup, true);
		
		chkEUWtrue.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.euwAction = "block";
			}
		});
		chkEUWfalse.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.euwAction = "allow";
			}
		});
		
		//////////////////////////////////////////////////////////
		Checkbox chkEUNEtrue = new Checkbox("Invisible", euneGroup, false);
		Checkbox chkEUNEfalse = new Checkbox("Visible", euneGroup, true);
		
		chkEUNEtrue.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.euneAction = "block";
			}
		});
		chkEUNEfalse.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.euneAction = "allow";
			}
		});
		
		/////////////////////////////////////////////////////////
		Checkbox chkOCEtrue = new Checkbox("Invisible", oceGroup, false);
		Checkbox chkOCEfalse = new Checkbox("Visible", oceGroup, true);
		
		chkOCEtrue.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.oceAction = "block";
			}
		});
		chkOCEfalse.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				set.oceAction = "allow";
			}
		});
		
		l = new JLabel();
		l.setText("Chose your invisibility for the following servers!");
		l.setHorizontalAlignment(JLabel.CENTER);
		
		l_NA = new JLabel();
		l_NA.setText("NA");
		l_NA.setAlignmentX(JLabel.LEFT);
		
		l_EUW = new JLabel();
		l_EUW.setText("EUW");
		l_EUW.setAlignmentX(JLabel.LEFT);
		
		l_EUNE = new JLabel();
		l_EUNE.setText("EUNE");
		l_EUNE.setAlignmentX(JLabel.LEFT);
		
		l_OCE = new JLabel();
		l_OCE.setText("OCE");
		l_OCE.setAlignmentX(JLabel.LEFT);
		
		naPanel = new JPanel();
		naPanel.setLayout(new FlowLayout());
		
		euwPanel = new JPanel();
		euwPanel.setLayout(new FlowLayout());
		
		eunePanel = new JPanel();
		eunePanel.setLayout(new FlowLayout());
		
		ocePanel = new JPanel();
		ocePanel.setLayout(new FlowLayout());
		
		naPanel.add(l_NA);
		naPanel.add(chkNAtrue);
		naPanel.add(chkNAfalse);
		
		euwPanel.add(l_EUW);
		euwPanel.add(chkEUWtrue);
		euwPanel.add(chkEUWfalse);
		
		eunePanel.add(l_EUNE);
		eunePanel.add(chkEUNEtrue);
		eunePanel.add(chkEUNEfalse);
		
		ocePanel.add(l_OCE);
		ocePanel.add(chkOCEtrue);
		ocePanel.add(chkOCEfalse);
		
		
		
		
		
		ApplyButton = new JButton("Apply!");
		ApplyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					invCaller.runtime.exec("netsh advfirewall firewall set rule name=\"nalolchat\" new action="+ set.naAction +"");
					invCaller.runtime.exec("netsh advfirewall firewall set rule name=\"euwlolchat\" new action="+ set.euwAction +"");
					invCaller.runtime.exec("netsh advfirewall firewall set rule name=\"eunelolchat\" new action="+ set.euneAction +"");
					invCaller.runtime.exec("netsh advfirewall firewall set rule name=\"ocelolchat\" new action="+ set.oceAction +"");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		f.add(l);
		f.add(naPanel);
		f.add(euwPanel);
		f.add(eunePanel);
		f.add(ocePanel);
		f.add(ApplyButton);
		f.setVisible(true);
	}
}
