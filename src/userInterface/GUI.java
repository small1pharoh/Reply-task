package userInterface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI extends JFrame implements ActionListener{
	
	private JTextField loginuser;
	private JButton login;
	private JButton logout;
	private JButton deregister;
	private JTextField reguser;
	private JTextField reggender;
	private JTextField regage;
	private JButton register;
	private JTextField updateuser;
	private JTextField updategender;
	private JTextField updateage;
	private JButton updateuserinfo;
	// ser --> search
	private JTextField sercarid;
	private JTextField sercarmod;
	private JTextField sercareng;
	private JTextField sercarinfot;
	private JTextField sercardes;
	private JTextField sercarcurrloc;
	private JTextField sercardroploc;
	private JTextField sercarpicktime;
	private JTextField sercardroptime;
	private JButton search;
	// bo--> book , dem -->  demand , up --> update
	private JTextField bocarid;
	private JButton book;
	private JTextField bodemandid;
	private JButton removedem;
	private JButton showdem;
	private JTextField updemid;
	private JTextField updropoffloc;
	private JTextField uppicktime;
	private JTextField updroptime;
	private JButton updatedem;
	
	private JTextField carmod;
	private JTextField careng;
	private JTextField carinfot;
	private JTextField cardes;
	private JTextField carcurrloc;
	private JButton newCar;
	private JTextField removecarid;
	private JButton removeCar;

	inputVerification inputVer = new inputVerification();
	buttonOperation butop = new buttonOperation();
	
	private JTextArea textArea;
	
	
	public GUI() {
		super("UI Listener");
		
		textArea = new JTextArea();
		//Jpanel for authentication
		JPanel authenticationContainer = new JPanel(new GridLayout(3, 4));
		// authentication components
		loginuser = new JTextField("user100");
		login = new JButton("Login");
		logout = new JButton("Logout");
		deregister =new JButton("Deregister");
		reguser = new JTextField("amer");
		reggender = new JTextField("Male");
		regage  = new JTextField("22");
		register =new JButton("Regester"); 
		updateuser = new JTextField();
		updategender  = new JTextField();
		updateage  = new JTextField();
		updateuserinfo =new JButton("Update user");
		
		login.addActionListener(this);
		logout.addActionListener(this);
		deregister.addActionListener(this);
		register.addActionListener(this);
		updateuserinfo.addActionListener(this);
		
		// add compenets to authenticationContainer
		authenticationContainer.add(loginuser);
		authenticationContainer.add(login);
		authenticationContainer.add(logout);
		authenticationContainer.add(deregister);
		authenticationContainer.add(reguser);
		authenticationContainer.add(reggender);
		authenticationContainer.add(regage);
		authenticationContainer.add(register);
		authenticationContainer.add(updateuser);
		authenticationContainer.add(updategender);
		authenticationContainer.add(updateage);
		authenticationContainer.add(updateuserinfo);
		
		// search cars and book demands compenets
		JPanel searchContainer = new JPanel(new GridLayout(4, 5));
		sercarid = new JTextField ();
		sercarmod = new JTextField ();
		sercareng = new JTextField ();
		sercarinfot = new JTextField ();
		sercardes = new JTextField ();
		sercarcurrloc = new JTextField ("Chemnitz");
		sercardroploc = new JTextField ("Dresden");
		sercarpicktime = new JTextField ("2018-08-07");
		sercardroptime = new JTextField ("2018-09-07");
		search = new JButton("Search");
		
		search.addActionListener(this);
		
		searchContainer.add(sercarid);
		searchContainer.add(sercarmod);
		searchContainer.add(sercareng);
		searchContainer.add(sercarinfot);
		searchContainer.add(sercardes);
		searchContainer.add(sercarcurrloc);
		searchContainer.add(sercardroploc);
		searchContainer.add(sercarpicktime);
		searchContainer.add(sercardroptime);
		searchContainer.add(search);
		
		
		bocarid = new JTextField ();
		book = new JButton("Book car");
		bodemandid = new JTextField ();
		removedem = new JButton("Remove demand");
		showdem = new JButton("Show my demands");
		updemid = new JTextField ();
		updropoffloc = new JTextField ("Chemnitz");
		uppicktime = new JTextField ("2018-09-07");
		updroptime = new JTextField ("2018-09-09");
		updatedem = new JButton("Update demand");
		
		book.addActionListener(this);
		removedem.addActionListener(this);
		showdem.addActionListener(this);
		updatedem.addActionListener(this);
		
		searchContainer.add(bocarid);
		searchContainer.add(book);
		searchContainer.add(bodemandid);
		searchContainer.add(removedem);
		searchContainer.add(showdem);
		searchContainer.add(updemid);
		searchContainer.add(updropoffloc);
		searchContainer.add(uppicktime);
		searchContainer.add(updroptime);
		searchContainer.add(updatedem);
		
		JPanel carContainer = new JPanel(new GridLayout(2, 4));
		
		carmod = new JTextField ("model1");
		careng = new JTextField ("engine1");
		carinfot = new JTextField ("infotainment1");
		cardes = new JTextField ("desgin1");
		carcurrloc = new JTextField ("Chemnitz");
		newCar= new JButton("New car");
		removecarid = new JTextField ();
		removeCar= new JButton("Removecar car");
		
		newCar.addActionListener(this);
		removeCar.addActionListener(this);
		
		carContainer.add(carmod);
		carContainer.add(careng);
		carContainer.add(carinfot);
		carContainer.add(cardes);
		carContainer.add(carcurrloc);
		carContainer.add(newCar);
		carContainer.add(removecarid);
		carContainer.add(removeCar);
				
		
		this.setLayout(new GridLayout(4,1));
		this.add(authenticationContainer);
		this.add(searchContainer);
		this.add(carContainer);
		this.add(new JScrollPane(textArea));
		
		
		this.setSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == login) {
			textArea.setText("");
			String r = inputVer.loginButton(loginuser.getText());
			if (r != "1") {
				textArea.append(r);
				return;
			}
			r = butop.loginOperButton(loginuser.getText());
			textArea.append(r);
		}
		
		if (e.getSource() == logout) {
			textArea.setText("");
			String r  = butop.logoutOprButton();
			if (r != "1") {
				textArea.append(r);
				return;
			}
			textArea.append("User Logout");
		}
		
		if (e.getSource() == register) {
			textArea.setText("");
			String r = inputVer.registerButton(reguser.getText(),reggender.getText(),regage.getText());
			if (r != "1") {
				textArea.append(r);
				return;
			}
			r = butop.registerOperButton(reguser.getText(), reggender.getText(), regage.getText());
			textArea.append(r);
		}
		
		if (e.getSource() == deregister) {
			textArea.setText("");
			String r = butop.deregisterOperButton();
			textArea.append(r);
		}
		
		if(e.getSource() == updateuserinfo) {
			textArea.setText("");
			String r = inputVer.updateuserinfoButtom(updateage.getText());
			if(r != "1") {
				textArea.append(r);
				return;
			}
			r  = butop.updateuserinfo(updateuser.getText(),updategender.getText(),updateage.getText());
			textArea.append(r);
		}
		
		if(e.getSource() == search) {
			textArea.setText("");
			String xcarlist = butop.search(sercarid.getText(),sercarmod.getText(),sercareng.getText(),
					sercarinfot.getText(),sercardes.getText(),sercarcurrloc.getText(),"","");
			textArea.append(xcarlist);
		}
			if(e.getSource() == showdem) {
				textArea.setText("");
				String xdemlist = butop.showdemOperButton();
				textArea.append(xdemlist);
			}
			
			if(e.getSource() == book) {
				textArea.setText("");
				String r = inputVer.bookButton(sercarcurrloc.getText(),sercardroploc.getText(),sercarpicktime.getText(),sercardroptime.getText(),bocarid.getText());
				if (r != "1") {
					textArea.append(r);
					return;
				}
				r = butop.bookOperButton(sercarcurrloc.getText(),sercardroploc.getText(),sercarpicktime.getText(),sercardroptime.getText(),bocarid.getText());
				textArea.append(r);
			}
			if(e.getSource() == removedem) {
				textArea.setText("");
				String r = inputVer.removedemButton(bodemandid.getText());
				if (r != "1") {
					textArea.append(r);
					return;
				}
				r = butop.removedemOperButton(bodemandid.getText());
				textArea.append(r);
			}
			
			if(e.getSource() == updatedem) {
				textArea.setText("");
				String r = inputVer.updatedemButton(updemid.getText(),updropoffloc.getText(),uppicktime.getText(),updroptime.getText());
				if (r != "1") {
					textArea.append(r);
					return;
				}
				r = butop.updatedemOperButton(updemid.getText(),updropoffloc.getText(),uppicktime.getText(),updroptime.getText());
				textArea.append(r);
			}
			
			if(e.getSource() == newCar) {
				textArea.setText("");
				String r = inputVer.newCarButton(carmod.getText(),careng.getText(),carinfot.getText(),cardes.getText(),carcurrloc.getText());
				if (r != "1") {
					textArea.append(r);
					return;
				}
				r = butop.newCarOperButton(carmod.getText(),careng.getText(),carinfot.getText(),cardes.getText(),carcurrloc.getText());
				textArea.append(r);
			}
			
			if(e.getSource() == removeCar) {
				textArea.setText("");
				String r = inputVer.removeCarButton(removecarid.getText());
				if (r != "1") {
					textArea.append(r);
					return;
				}
				r = butop.removeCarOperButton(removecarid.getText());
				textArea.append(r);
			}
		
	}
	
	public static void main(String[] args) {
		new GUI();
	}

}
