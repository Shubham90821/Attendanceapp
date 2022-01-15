import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.sun.jdi.connect.Connector.SelectedArgument;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

public class student {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public student() {
		initialize();
	}

	// FRAME CODE
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 779, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// FRAME CODE ENDS HERE

		// TEXT CODE IN FIRST PAGE
		JLabel textinfirstpage = new JLabel("STUDENT ATTENDANCE");
		textinfirstpage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		textinfirstpage.setForeground(Color.BLACK);
		textinfirstpage.setHorizontalAlignment(SwingConstants.CENTER);
		textinfirstpage.setBounds(265, 120, 423, 70);
		frame.getContentPane().add(textinfirstpage);
		// TEXT CODE ENDS HERE

		// START BUTTON CODE IN FIRST PAGE
		JButton STARTBTN = new JButton("START");
		STARTBTN.setAction(action);
		STARTBTN.setBackground(Color.LIGHT_GRAY);
		STARTBTN.addActionListener(new ActionListener() {

			// ACTION PERFORMED ON START BUTTON
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().removeAll();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.getContentPane().setLayout(null);

				// REGISTRATION BUTTON and login button are palced here
				JButton REGESTERBTN = new JButton("REGISTRATION");
				JButton STUDENTLOGINBTN = new JButton("LOGIN");
				REGESTERBTN.addActionListener(new ActionListener() {

					// CLICK ACTION FOR REGISTRATION BUTTON on 2 page
					public void actionPerformed(ActionEvent e) {

						frame.getContentPane().removeAll();

						// back button
						JButton backbtn = new JButton("Back");
						backbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();
								frame.getContentPane().add(STUDENTLOGINBTN);
								frame.getContentPane().add(REGESTERBTN);

								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}
						});
						backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
						backbtn.setBackground(Color.LIGHT_GRAY);
						backbtn.setBounds(0, 0, 62, 27);
						frame.getContentPane().add(backbtn);
						// back button
						frame.getContentPane().setBackground(Color.WHITE);
						frame.getContentPane().setLayout(null);

						// BOTH THE BUTTON ARE PLACED HERE TO PERFORM BACK ACTION HERE
						JButton TEACHERREG = new JButton("TEACHER REGISTRATION");
						JButton STUDENTREG = new JButton("STUDENT REGISTRATION");

						STUDENTREG.addActionListener(new ActionListener() {
							// ACTION ON STUDENT REGISTRATION
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();
								frame.getContentPane().setBackground(Color.WHITE);
								frame.getContentPane().setLayout(null);

								JLabel STUDENTREGISTERHEADING = new JLabel("STUDENT REGISTER");
								STUDENTREGISTERHEADING.setFont(new Font("Times New Roman", Font.BOLD, 23));
								STUDENTREGISTERHEADING.setBackground(Color.LIGHT_GRAY);
								STUDENTREGISTERHEADING.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTREGISTERHEADING.setBounds(244, 31, 292, 44);
								frame.getContentPane().add(STUDENTREGISTERHEADING);

								JLabel STUDENTFIRSTNAME = new JLabel("FIRST NAME");
								STUDENTFIRSTNAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTFIRSTNAME.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTFIRSTNAME.setBounds(10, 137, 123, 27);
								frame.getContentPane().add(STUDENTFIRSTNAME);

								JLabel STUDENTMIDDLENAME = new JLabel("MIDDLE NAME");
								STUDENTMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTMIDDLENAME.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTMIDDLENAME.setBounds(10, 181, 123, 33);
								frame.getContentPane().add(STUDENTMIDDLENAME);

								JLabel STUDENTLASTNAME = new JLabel("LAST NAME");
								STUDENTLASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTLASTNAME.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTLASTNAME.setBounds(10, 224, 123, 29);
								frame.getContentPane().add(STUDENTLASTNAME);

								JTextField STUDENTFIRSTNAMEtextfiled = new JTextField();
								STUDENTFIRSTNAMEtextfiled.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								STUDENTFIRSTNAMEtextfiled.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTFIRSTNAMEtextfiled.setBounds(143, 141, 174, 32);
								frame.getContentPane().add(STUDENTFIRSTNAMEtextfiled);
								STUDENTFIRSTNAMEtextfiled.setColumns(10);

								JTextField STUDENTMIDDLENAMEtextField = new JTextField();
								STUDENTMIDDLENAMEtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								STUDENTMIDDLENAMEtextField.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTMIDDLENAMEtextField.setBounds(143, 182, 174, 33);
								frame.getContentPane().add(STUDENTMIDDLENAMEtextField);
								STUDENTMIDDLENAMEtextField.setColumns(10);

								JTextField STUDENTLASTNAMEtextField = new JTextField();
								STUDENTLASTNAMEtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								STUDENTLASTNAMEtextField.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTLASTNAMEtextField.setBounds(143, 221, 174, 32);
								frame.getContentPane().add(STUDENTLASTNAMEtextField);
								STUDENTLASTNAMEtextField.setColumns(10);
								JPasswordField STUDENTpasswordField = new JPasswordField();
								JTextField STUDENTMOBILENUMBERTEXTFIELD = new JTextField();
								JTextField rllnotextField = new JTextField();
								JComboBox COURSEcomboBox = new JComboBox();
								JLabel studentsucessfullyregister = new JLabel("");

								// registration button on student registration page
								JButton STUDENTREGISTERBTN = new JButton("REGISTER");
								STUDENTREGISTERBTN.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										// database connection done here
//										data entered for bscit students
										String cou = (String) COURSEcomboBox.getSelectedItem();
										if (cou == "Bachelor of Science(Bsc(IT))") {
											try {
												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into studentregistrationdata(first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from studentregistrationdata");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();
												System.out.println("bscit entered");

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();

												con.close();
											} catch (Exception x) {
												System.out.println("hello");
											}

										}

//										data enter for bcom students
										if (cou == "Bachelor of Commerce (B. Com)") {

											try {
												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into bcomstudentdata(first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from bcomstudentdata");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();
												System.out.println("bcom entered");

												con.close();
											} catch (Exception x) {
												x.printStackTrace();
											}

										}
//										data enter for be stusnts
										if (cou == "Bachelor of Economics (BE)")

										{
											try {

												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into bachelorofeconomics(first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from bachelorofeconomics");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();
												System.out.println("economics  entered");

												con.close();
											} catch (Exception x) {
												x.printStackTrace();
											}

										}

//										

//										data enter for baf studemts
										if (cou == "Bachelor of Accounting and Finance (BAF)") {
											try {

												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into bachelorofaccountingandfinancebaf(first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from bachelorofaccountingandfinancebaf");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();
												System.out.println("baf  entered");

												con.close();
											} catch (Exception x) {
												x.printStackTrace();
											}
										}
//										data enter for bbi students
										if (cou == "Bachelor of Commerce in Banking and Insurance (BBI)") {
											try {

												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into bachelorofcommerceinbankingandinsurancebbi(first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from bachelorofcommerceinbankingandinsurancebbi");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();
												System.out.println("bbi  entered");

												con.close();
											} catch (Exception x) {
												x.printStackTrace();
											}

										}
//										rehister database for bfm
										if (cou == "Bachelor of Commerce in Financial Market (BFM)") {
											try {

												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into bachelorofcommerceinfinancialmarketbfm (first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from bachelorofcommerceinfinancialmarketbfm");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();
												System.out.println("bfm  entered");

												con.close();
											} catch (Exception x) {
												x.printStackTrace();
											}

										}

//										database enter for bca register
										if (cou == "Bachelor of Computer Application(BCA)") {
											try {

												Class.forName("com.mysql.cj.jdbc.Driver");
												Connection con = DriverManager.getConnection(
														"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												PreparedStatement s = con.prepareStatement(
														"insert into bachelorofcomputerapplicationbca(first_name,middle_name,last_name,course,phone,S_password,roll_number) values(?,?,?,?,?,?,?)");
												String firstname = String.valueOf(STUDENTFIRSTNAMEtextfiled.getText());
												String middlename = String
														.valueOf(STUDENTMIDDLENAMEtextField.getText());
												String lastname = String.valueOf(STUDENTLASTNAMEtextField.getText());
												String course = String.valueOf(COURSEcomboBox.getSelectedItem());
												String phonenumber = String
														.valueOf(STUDENTMOBILENUMBERTEXTFIELD.getText());
												String roll = String.valueOf(rllnotextField.getText());
												@SuppressWarnings("deprecation")
												String pass = String.valueOf(STUDENTpasswordField.getText());

												s.setString(4, course);
												s.setString(1, firstname);
												s.setString(2, middlename);
												s.setString(3, lastname);
												s.setString(5, phonenumber);
												s.setString(6, pass);
												s.setString(7, roll);

												String query = ("select * from bachelorofcomputerapplicationbca");
												ResultSet myRs = s.executeQuery(query);
												myRs.next();

												display(myRs);

												@SuppressWarnings("unused")
												int i = s.executeUpdate();
												System.out.println("bca  entered");

												con.close();
											} catch (Exception x) {
												x.printStackTrace();
											}

										}

									}

									private void display(ResultSet myRs) {
										// TODO Auto-generated method stub

									}
								});

								STUDENTREGISTERBTN.setBackground(Color.LIGHT_GRAY);
								STUDENTREGISTERBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTREGISTERBTN.setBounds(329, 330, 123, 44);
								frame.getContentPane().add(STUDENTREGISTERBTN);

								JLabel STUDENTMOBILENUMBER = new JLabel("PHONE MUMBER");
								STUDENTMOBILENUMBER.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTMOBILENUMBER.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTMOBILENUMBER.setBounds(380, 144, 143, 27);
								frame.getContentPane().add(STUDENTMOBILENUMBER);

								// placed above to perform database connection
								STUDENTMOBILENUMBERTEXTFIELD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								STUDENTMOBILENUMBERTEXTFIELD.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTMOBILENUMBERTEXTFIELD.setBounds(532, 142, 174, 33);
								frame.getContentPane().add(STUDENTMOBILENUMBERTEXTFIELD);
								STUDENTMOBILENUMBERTEXTFIELD.setColumns(10);

								// placed above to perform database connection
								STUDENTpasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								STUDENTpasswordField.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTpasswordField.setBounds(532, 182, 174, 34);
								frame.getContentPane().add(STUDENTpasswordField);

								JLabel STUDENTPASSWORDTEXT = new JLabel("PASSWORD");
								STUDENTPASSWORDTEXT.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTPASSWORDTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTPASSWORDTEXT.setBounds(380, 181, 133, 33);
								frame.getContentPane().add(STUDENTPASSWORDTEXT);

								JLabel rollnotext = new JLabel("ROLL NO.");
								rollnotext.setFont(new Font("Times New Roman", Font.BOLD, 15));
								rollnotext.setHorizontalAlignment(SwingConstants.CENTER);
								rollnotext.setBounds(380, 224, 133, 33);
								frame.getContentPane().add(rollnotext);

								// placed above to perform database connection
								rllnotextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								rllnotextField.setHorizontalAlignment(SwingConstants.CENTER);
								rllnotextField.setBounds(532, 220, 174, 39);
								frame.getContentPane().add(rllnotextField);
								rllnotextField.setColumns(10);

								JLabel STUDENTINFORMATIONTEXT = new JLabel(
										"ROLL NO FOR STUDENTS WILL BE PROVIDED BY TEACHERS ONLY.");
								STUDENTINFORMATIONTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTINFORMATIONTEXT.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTINFORMATIONTEXT.setBounds(132, 85, 528, 33);
								frame.getContentPane().add(STUDENTINFORMATIONTEXT);

								JLabel STUDENTCOURSENAME = new JLabel("COURSE NAME");
								STUDENTCOURSENAME.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTCOURSENAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								STUDENTCOURSENAME.setBounds(10, 263, 123, 27);
								frame.getContentPane().add(STUDENTCOURSENAME);

								// placed above to perform database connection
								COURSEcomboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
								COURSEcomboBox.setMaximumRowCount(50);
								COURSEcomboBox.setModel(new DefaultComboBoxModel(new String[] { "SELECT COURSE NAME ",
										"Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)",
										"Bachelor of Accounting and Finance (BAF)",
										"Bachelor of Commerce in Banking and Insurance (BBI)",
										"Bachelor of Commerce in Financial Market (BFM)",
										"Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)" }));
								COURSEcomboBox.setSelectedIndex(0);
								COURSEcomboBox.setToolTipText("SELECT COUSRE");
								COURSEcomboBox.setBounds(140, 260, 532, 34);
								frame.getContentPane().add(COURSEcomboBox);

								JButton backbtn = new JButton("Back");
								backbtn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										frame.getContentPane().removeAll();
										frame.getContentPane().add(STUDENTREG);
										frame.getContentPane().add(TEACHERREG);
										JButton backbtn = new JButton("Back");
										backbtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												frame.getContentPane().removeAll();
												frame.getContentPane().add(REGESTERBTN);
												frame.getContentPane().add(STUDENTLOGINBTN);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();
											}
										});
										backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
										backbtn.setBackground(Color.LIGHT_GRAY);
										backbtn.setBounds(0, 0, 62, 27);
										frame.getContentPane().add(backbtn);

										frame.getContentPane().repaint();
										frame.getContentPane().revalidate();
									}
								});
								backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
								backbtn.setBackground(Color.LIGHT_GRAY);
								backbtn.setBounds(0, 0, 62, 27);
								frame.getContentPane().add(backbtn);

								studentsucessfullyregister.setHorizontalAlignment(SwingConstants.CENTER);
								studentsucessfullyregister.setForeground(Color.GREEN);
								studentsucessfullyregister.setFont(new Font("Times New Roman", Font.BOLD, 17));
								studentsucessfullyregister.setBackground(Color.WHITE);
								studentsucessfullyregister.setBounds(56, 385, 676, 25);
								frame.getContentPane().add(studentsucessfullyregister);

								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}

						});
						STUDENTREG.setFont(new Font("Times New Roman", Font.BOLD, 25));
						STUDENTREG.setBackground(Color.LIGHT_GRAY);
						STUDENTREG.setBounds(207, 113, 372, 57);
						frame.getContentPane().add(STUDENTREG);

						// teacher registration button code starts here
						// THE BUTTON IS BEEN PLACED ABOVE TO PERFOEM THE BACK ACTION
						TEACHERREG.addActionListener(new ActionListener() {
							// ACTION ON TRACHER REGISTRATION
							public void actionPerformed(ActionEvent e) {

								frame.getContentPane().removeAll();
								frame.getContentPane().setBackground(Color.WHITE);
								frame.getContentPane().setLayout(null);

								JLabel REGISTERHEADING = new JLabel("REGISTER");
								REGISTERHEADING.setFont(new Font("Times New Roman", Font.BOLD, 23));
								REGISTERHEADING.setBackground(Color.LIGHT_GRAY);
								REGISTERHEADING.setHorizontalAlignment(SwingConstants.CENTER);
								REGISTERHEADING.setBounds(306, 32, 133, 44);
								frame.getContentPane().add(REGISTERHEADING);

								JLabel FIRSTNAME = new JLabel("FIRST NAME");
								FIRSTNAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								FIRSTNAME.setHorizontalAlignment(SwingConstants.CENTER);
								FIRSTNAME.setBounds(10, 137, 123, 27);
								frame.getContentPane().add(FIRSTNAME);

								JLabel MIDDLENAME = new JLabel("MIDDLE NAME");
								MIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								MIDDLENAME.setHorizontalAlignment(SwingConstants.CENTER);
								MIDDLENAME.setBounds(10, 181, 123, 33);
								frame.getContentPane().add(MIDDLENAME);

								JLabel LASTNAME = new JLabel("LAST NAME");
								LASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
								LASTNAME.setHorizontalAlignment(SwingConstants.CENTER);
								LASTNAME.setBounds(10, 224, 123, 29);
								frame.getContentPane().add(LASTNAME);

								JTextField FIRSTNAMEtextField = new JTextField();
								FIRSTNAMEtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								FIRSTNAMEtextField.setHorizontalAlignment(SwingConstants.CENTER);
								FIRSTNAMEtextField.setBounds(143, 141, 174, 32);
								frame.getContentPane().add(FIRSTNAMEtextField);
								FIRSTNAMEtextField.setColumns(10);

								JTextField MIDDLENAMEtextField = new JTextField();
								MIDDLENAMEtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								MIDDLENAMEtextField.setHorizontalAlignment(SwingConstants.CENTER);
								MIDDLENAMEtextField.setBounds(143, 182, 174, 33);
								frame.getContentPane().add(MIDDLENAMEtextField);
								MIDDLENAMEtextField.setColumns(10);

								JTextField LASTNAMEtextField = new JTextField();
								LASTNAMEtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								LASTNAMEtextField.setHorizontalAlignment(SwingConstants.CENTER);
								LASTNAMEtextField.setBounds(143, 221, 174, 32);
								frame.getContentPane().add(LASTNAMEtextField);
								LASTNAMEtextField.setColumns(10);

								JTextField MOBILENUMBERTEXTFIELD = new JTextField();
								JPasswordField passwordField = new JPasswordField();
								JTextField UNIQUEIDtextField = new JTextField();
								JLabel sucessfullyregister = new JLabel("");

								// REGISTER BUTTON ON teachers REGISTRATION PAGE ACTION CODE STARTS HERE
								JButton REGISTERBTN = new JButton("REGISTER");
								REGISTERBTN.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										try {
											Class.forName("com.mysql.cj.jdbc.Driver");
											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											PreparedStatement s = con.prepareStatement(
													"insert into teacherregistrationdata(first_name,middle_name,last_name,phone_number,teachers_password,unique_id) values(?,?,?,?,?,?)");
											System.out.println("connected sucessfully");
											String firstname = String.valueOf(FIRSTNAMEtextField.getText());
											String middlename = String.valueOf(MIDDLENAMEtextField.getText());
											String lastname = String.valueOf(LASTNAMEtextField.getText());
											String phonenumber = String.valueOf(MOBILENUMBERTEXTFIELD.getText());
											String uniqueid = String.valueOf(UNIQUEIDtextField.getText());
											@SuppressWarnings("deprecation")
											String pass = String.valueOf(passwordField.getText());

											s.setString(4, phonenumber);
											s.setString(1, firstname);
											s.setString(2, middlename);
											s.setString(3, lastname);
											s.setString(5, pass);
											s.setString(6, uniqueid);

											String query = ("select * from teacherregistrationdata");
											ResultSet myRs = s.executeQuery(query);
											myRs.next();

											display(myRs);
											if (!(firstname == null)) {
												String suc = " YOUR DATA IS SUCESSFULLY REGISTERED";
												sucessfullyregister.setText(suc);

											}
											@SuppressWarnings("unused")
											int i = s.executeUpdate();

											System.out.println("data entered");
											con.close();
										} catch (Exception x) {
											x.printStackTrace();
										}

									}

									private void display(ResultSet myRs) {
										// TODO Auto-generated method stub

									}
								});
								REGISTERBTN.setBackground(Color.LIGHT_GRAY);
								REGISTERBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
								REGISTERBTN.setBounds(329, 332, 123, 44);
								frame.getContentPane().add(REGISTERBTN);

								JLabel MOBILENUMBER = new JLabel("PHONE MUMBER");
								MOBILENUMBER.setFont(new Font("Times New Roman", Font.BOLD, 15));
								MOBILENUMBER.setHorizontalAlignment(SwingConstants.CENTER);
								MOBILENUMBER.setBounds(380, 144, 143, 27);
								frame.getContentPane().add(MOBILENUMBER);

								MOBILENUMBERTEXTFIELD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								MOBILENUMBERTEXTFIELD.setHorizontalAlignment(SwingConstants.CENTER);
								MOBILENUMBERTEXTFIELD.setBounds(532, 142, 174, 33);
								frame.getContentPane().add(MOBILENUMBERTEXTFIELD);
								MOBILENUMBERTEXTFIELD.setColumns(10);

								passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								passwordField.setHorizontalAlignment(SwingConstants.CENTER);
								passwordField.setBounds(532, 182, 174, 34);
								frame.getContentPane().add(passwordField);

								JLabel PASSWORDTEXT = new JLabel("PASSWORD");
								PASSWORDTEXT.setFont(new Font("Times New Roman", Font.BOLD, 15));
								PASSWORDTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								PASSWORDTEXT.setBounds(380, 181, 133, 33);
								frame.getContentPane().add(PASSWORDTEXT);

								JLabel UNIQUEIDLABEL = new JLabel("UNIQUE ID ");
								UNIQUEIDLABEL.setFont(new Font("Times New Roman", Font.BOLD, 15));
								UNIQUEIDLABEL.setHorizontalAlignment(SwingConstants.CENTER);
								UNIQUEIDLABEL.setBounds(380, 224, 133, 33);
								frame.getContentPane().add(UNIQUEIDLABEL);

								UNIQUEIDtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
								UNIQUEIDtextField.setHorizontalAlignment(SwingConstants.CENTER);
								UNIQUEIDtextField.setBounds(532, 220, 174, 39);
								frame.getContentPane().add(UNIQUEIDtextField);
								UNIQUEIDtextField.setColumns(10);

								JLabel INFORMATIONTEXT = new JLabel(
										"UNIQUE ID FOR TEACHERS WILL BE PROVIDED BY ADMIN ONLY.");
								INFORMATIONTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								INFORMATIONTEXT.setFont(new Font("Times New Roman", Font.BOLD, 15));
								INFORMATIONTEXT.setBounds(133, 280, 502, 33);
								frame.getContentPane().add(INFORMATIONTEXT);

								JButton backbtn = new JButton("Back");
								backbtn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										frame.getContentPane().removeAll();
										frame.getContentPane().add(STUDENTREG);
										frame.getContentPane().add(TEACHERREG);
										JButton backbtn = new JButton("Back");
										backbtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												frame.getContentPane().removeAll();
												frame.getContentPane().add(REGESTERBTN);
												frame.getContentPane().add(STUDENTLOGINBTN);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();
											}
										});
										backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
										backbtn.setBackground(Color.LIGHT_GRAY);
										backbtn.setBounds(0, 0, 62, 27);
										frame.getContentPane().add(backbtn);
										frame.getContentPane().repaint();
										frame.getContentPane().revalidate();
									}
								});
								backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
								backbtn.setBackground(Color.LIGHT_GRAY);
								backbtn.setBounds(0, 0, 62, 27);
								frame.getContentPane().add(backbtn);

								// sucessfully register msg label

								sucessfullyregister.setHorizontalAlignment(SwingConstants.CENTER);
								sucessfullyregister.setForeground(Color.GREEN);
								sucessfullyregister.setFont(new Font("Times New Roman", Font.BOLD, 17));
								sucessfullyregister.setBackground(Color.WHITE);
								sucessfullyregister.setBounds(56, 385, 676, 25);
								frame.getContentPane().add(sucessfullyregister);
								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}
						});
						TEACHERREG.setFont(new Font("Times New Roman", Font.BOLD, 25));
						TEACHERREG.setBackground(Color.LIGHT_GRAY);
						TEACHERREG.setBounds(207, 180, 372, 57);
						frame.getContentPane().add(TEACHERREG);
						frame.getContentPane().repaint();
						frame.getContentPane().revalidate();

					}

				});
				REGESTERBTN.setBackground(Color.LIGHT_GRAY);
				REGESTERBTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
				REGESTERBTN.setBounds(240, 94, 291, 68);
				frame.getContentPane().add(REGESTERBTN);

				// LOGIN BUTTON
				// login button code is placed above with registration button
				STUDENTLOGINBTN.addActionListener(new ActionListener() {

					// CLICK ACTION ON LOGIN BUTTON
					public void actionPerformed(ActionEvent e) {

						frame.getContentPane().removeAll();

						// back button
						JButton backbtn = new JButton("Back");
						backbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();
								frame.getContentPane().add(STUDENTLOGINBTN);
								frame.getContentPane().add(REGESTERBTN);

								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}
						});
						backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
						backbtn.setBackground(Color.LIGHT_GRAY);
						backbtn.setBounds(0, 0, 62, 27);
						frame.getContentPane().add(backbtn);
						// back button

						frame.getContentPane().setBackground(Color.WHITE);
						frame.getContentPane().setLayout(null);

						JLabel LOGINTEXT = new JLabel("LOGIN");
						LOGINTEXT.setFont(new Font("Times New Roman", Font.BOLD, 23));
						LOGINTEXT.setBackground(Color.LIGHT_GRAY);
						LOGINTEXT.setHorizontalAlignment(SwingConstants.CENTER);
						LOGINTEXT.setBounds(310, 32, 125, 44);
						frame.getContentPane().add(LOGINTEXT);

						// student login button starts here
						// teacher login
						// admin login
						JButton stdnloginbtn = new JButton("STUDENT LOGIN");
						JButton Tcherloginbtn = new JButton("TEACHER LOGIN");
						JButton ADMINLGNBTN = new JButton("ADMIN LOGIN");

						// ACTION ON STUDENT LOGIN BTN
						stdnloginbtn.addActionListener(new ActionListener() {
							@SuppressWarnings({ "unchecked", "rawtypes" })
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();

								// STUDENT LOGIN FORM STARTS HERE
								frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
								frame.getContentPane().setBackground(Color.WHITE);
								frame.getContentPane().setLayout(null);

								JLabel STUDENTLOGINTXT = new JLabel("STUDENT LOGIN");
								STUDENTLOGINTXT.setBackground(Color.LIGHT_GRAY);
								STUDENTLOGINTXT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
								STUDENTLOGINTXT.setHorizontalAlignment(SwingConstants.CENTER);
								STUDENTLOGINTXT.setBounds(231, 21, 306, 52);
								frame.getContentPane().add(STUDENTLOGINTXT);

								JLabel ROLLNOTEXT = new JLabel("ROLL NUMBER");
								ROLLNOTEXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
								ROLLNOTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								ROLLNOTEXT.setBounds(187, 95, 182, 49);
								frame.getContentPane().add(ROLLNOTEXT);

								JLabel PASSWORDTEXT = new JLabel("PASSWORD");
								PASSWORDTEXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
								PASSWORDTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								PASSWORDTEXT.setBounds(197, 161, 126, 49);
								frame.getContentPane().add(PASSWORDTEXT);

								JTextField ROLLNOtextField = new JTextField();
								ROLLNOtextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								ROLLNOtextField.setHorizontalAlignment(SwingConstants.CENTER);
								ROLLNOtextField.setBounds(379, 103, 206, 34);
								frame.getContentPane().add(ROLLNOtextField);
								ROLLNOtextField.setColumns(10);
								JPasswordField LOGINpasswordField = new JPasswordField();
								@SuppressWarnings("rawtypes")
								JComboBox studentcoursecombobox = new JComboBox();studentcoursecombobox.setFont(new Font("Times New Roman", Font.BOLD, 18));
								studentcoursecombobox.setMaximumRowCount(50);
								studentcoursecombobox.setModel(new DefaultComboBoxModel(new String[] { "SELECT COURSE NAME ","Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)",
										"Bachelor of Accounting and Finance (BAF)",
										"Bachelor of Commerce in Banking and Insurance (BBI)",
										"Bachelor of Commerce in Financial Market (BFM)",
										"Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)" 
										}));
								studentcoursecombobox.setSelectedIndex(0);
								studentcoursecombobox.setToolTipText("SELECT COUSRE");
								studentcoursecombobox.setBounds(175, 236, 444, 32);
								frame.getContentPane().add(studentcoursecombobox);

								JButton LOGINBTNSTUDENT = new JButton("LOGIN");
								LOGINBTNSTUDENT.addActionListener(new ActionListener() {
									// ACTION ON LOGIN BUTTON ON STUDENT LOGIN FORM
									public void actionPerformed(ActionEvent e) {
								    String studcou=(String) studentcoursecombobox.getSelectedItem();
								    JButton backbtn = new JButton("Back");
									backbtn.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											frame.getContentPane().removeAll();
											frame.getContentPane().add(stdnloginbtn);
											frame.getContentPane().add(Tcherloginbtn);
											frame.getContentPane().add(ADMINLGNBTN);
											JButton backbtn = new JButton("Back");
											backbtn.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													frame.getContentPane().removeAll();
													frame.getContentPane().add(REGESTERBTN);
													frame.getContentPane().add(STUDENTLOGINBTN);
													frame.getContentPane().repaint();
													frame.getContentPane().revalidate();
												}
											});
											backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
											backbtn.setBackground(Color.LIGHT_GRAY);
											backbtn.setBounds(0, 0, 62, 27);
											frame.getContentPane().add(backbtn);
											frame.getContentPane().repaint();
											frame.getContentPane().revalidate();
										}
									});
									backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
									backbtn.setBackground(Color.LIGHT_GRAY);
									backbtn.setBounds(0, 0, 62, 27);
									frame.getContentPane().add(backbtn);
								    if(studcou=="Bachelor of Commerce (B. Com)")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from bcomstudentdata where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 25));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 34, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 25));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 83, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 25));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 135, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.LEADING);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 25));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 185, 600, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.BOLD,20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												
												
//fetching data from database for students info
												
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from bcomstudentdata where roll_number='"+ studentroll+ "'");

													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													

													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												
												
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcomattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);											
												
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }
								    
//								    second if for economics student
								    
								    if(studcou=="Bachelor of Economics (BE)")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from bachelorofeconomics where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 39, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 78, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 128, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 178, 190, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/economicsattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from bachelorofeconomics where roll_number='"+ studentroll+ "'");
//													
													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													

													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												
												
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														

														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }
								    
//								    third if statement
								    
								    if(studcou=="Bachelor of Accounting and Finance (BAF)")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from bachelorofaccountingandfinancebaf where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 39, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 78, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 128, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 178, 190, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														
														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bafattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from bachelorofaccountingandfinancebaf where roll_number='"+ studentroll+ "'");
													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													

													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												
												
												
												
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }
								    
//								    fourth if  
								    
								    if(studcou=="Bachelor of Commerce in Banking and Insurance (BBI)")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from bachelorofcommerceinbankingandinsurancebbi where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 39, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 78, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 128, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 178, 190, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbiattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from bachelorofcommerceinbankingandinsurancebbi where roll_number='"+ studentroll+ "'");
													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													

													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												
												
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }
								    
//								    5th if
								    
								    if(studcou=="Bachelor of Commerce in Financial Market (BFM)")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from bachelorofcommerceinfinancialmarketbfm where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 39, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 78, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 128, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 178, 190, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bfmattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from bachelorofcommerceinfinancialmarketbfm where roll_number='"+ studentroll+ "'");
													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													
													

													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												
												
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }
								    
//								    6th if 
								    
								    if(studcou=="Bachelor of Science(Bsc(IT))")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from studentregistrationdata where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 39, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 78, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 128, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 178, 190, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bscitattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from studentregistrationdata where roll_number='"+ studentroll+ "'");
													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													

													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }
								    
//								    7th if 
								    
								    if(studcou=="Bachelor of Computer Application(BCA)")
								    {
								    	try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String rollnumb = ROLLNOtextField.getText();
											String studentpass = LOGINpasswordField.getText();

											Statement lstudent = con.createStatement();

											String sqll = "select * from bachelorofcomputerapplicationbca where roll_number='"+ rollnumb + "' and S_password='" + studentpass + "'";
											ResultSet rstudent = lstudent.executeQuery(sqll);

											if (rstudent.next()) 
											{
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();
												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JLabel firstnamestudents = new JLabel("FIRST NAME");
												firstnamestudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
												firstnamestudents.setBackground(Color.WHITE);
												firstnamestudents.setBounds(44, 28, 142, 40);
												frame.getContentPane().add(firstnamestudents);
												
												JLabel LASTNAMESTUDENTTXT = new JLabel("LAST NAME");
												LASTNAMESTUDENTTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												LASTNAMESTUDENTTXT.setBackground(Color.WHITE);
												LASTNAMESTUDENTTXT.setBounds(44, 78, 142, 40);
												frame.getContentPane().add(LASTNAMESTUDENTTXT);
												
												JLabel ROLLNUMBERSTUDENTSTXT = new JLabel("ROLL NUMBER");
												ROLLNUMBERSTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ROLLNUMBERSTUDENTSTXT.setBackground(Color.WHITE);
												ROLLNUMBERSTUDENTSTXT.setBounds(44, 128, 160, 40);
												frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
												
												JLabel COURSENAMESTUDENTSTXT = new JLabel("COURSE NAME");
												COURSENAMESTUDENTSTXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												COURSENAMESTUDENTSTXT.setBackground(Color.WHITE);
												COURSENAMESTUDENTSTXT.setBounds(44, 178, 160, 40);
												frame.getContentPane().add(COURSENAMESTUDENTSTXT);
												
												JLabel FIRSTNAMESTUDENTTXTFLD = new JLabel("");
												FIRSTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												FIRSTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												FIRSTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												FIRSTNAMESTUDENTTXTFLD.setBounds(214, 39, 190, 29);
												frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
												
												JLabel LASTNAMESTUDENTTXTFLD = new JLabel("");
												LASTNAMESTUDENTTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												LASTNAMESTUDENTTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												LASTNAMESTUDENTTXTFLD.setBackground(Color.LIGHT_GRAY);
												LASTNAMESTUDENTTXTFLD.setBounds(214, 78, 190, 29);
												frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
												
												JLabel ROLLNUMBERTXTFLD = new JLabel("");
												ROLLNUMBERTXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ROLLNUMBERTXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ROLLNUMBERTXTFLD.setBackground(Color.LIGHT_GRAY);
												ROLLNUMBERTXTFLD.setBounds(214, 128, 190, 29);
												frame.getContentPane().add(ROLLNUMBERTXTFLD);
												
												JLabel COURSENAMETXTFLD = new JLabel("");
												COURSENAMETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												COURSENAMETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												COURSENAMETXTFLD.setBackground(Color.LIGHT_GRAY);
												COURSENAMETXTFLD.setBounds(214, 178, 190, 29);
												frame.getContentPane().add(COURSENAMETXTFLD);
												
												JLabel ATTENDANCEPERCENTAGETXT = new JLabel("ATTENDANCE PERCENTAGE");
												ATTENDANCEPERCENTAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
												ATTENDANCEPERCENTAGETXT.setBackground(Color.WHITE);
												ATTENDANCEPERCENTAGETXT.setBounds(44, 228, 282, 40);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
												
												JLabel ATTENDANCEPERCENTAGETXTFLD = new JLabel("");
												ATTENDANCEPERCENTAGETXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
												ATTENDANCEPERCENTAGETXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
												ATTENDANCEPERCENTAGETXTFLD.setBackground(Color.LIGHT_GRAY);
												ATTENDANCEPERCENTAGETXTFLD.setBounds(336, 228, 190, 29);
												frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
												//CALCULATE BTN FOR PERCENTAGE
												JButton CALCULATEPERCENTAGEBTN = new JButton("CALCULATE");
												CALCULATEPERCENTAGEBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															String studentroll1=rollnumb;
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcaattendancedata","root","admin");
															PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS studentcount from attendance where roll_no='"+studentroll1+"'");
															ResultSet rs=pst.executeQuery();
															while(rs.next())
															{
																int count=rs.getInt("studentcount");
																float percentage=(count*100)/195;
																ATTENDANCEPERCENTAGETXTFLD.setText(String.valueOf(percentage+"%"));
															}
															}
														catch(Exception x)
														{
															x.printStackTrace();
														}
													}
												});
												CALCULATEPERCENTAGEBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
												CALCULATEPERCENTAGEBTN.setBackground(Color.LIGHT_GRAY);
												CALCULATEPERCENTAGEBTN.setBounds(553, 228, 132, 29);
												frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
												try {
													String studentroll=rollnumb;
													Class.forName("com.mysql.cj.jdbc.Driver");
													Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
													Statement s = con.createStatement();

													ResultSet myRs = s.executeQuery("select * from bachelorofcomputerapplicationbca where roll_number='"+ studentroll+ "'");
													while (myRs.next()) 
													{
														FIRSTNAMESTUDENTTXTFLD.setText(myRs.getString("first_name"));
														LASTNAMESTUDENTTXTFLD.setText(myRs.getString("last_name"));
														COURSENAMETXTFLD.setText(myRs.getString("course"));
														ROLLNUMBERTXTFLD.setText(myRs.getString("roll_number"));

													}

													display(myRs);

													
													con.close();
													}
												catch(Exception x)
												{
													x.printStackTrace();
												}
												//APPLY LEAVE BTN FOR STUDENT ACTION 
												JButton AAPLYLEAVESTUDENTBTN = new JButton("APPLY LEAVE");
												AAPLYLEAVESTUDENTBTN.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														
														
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);
														
														JLabel appplyleavestudenttxt = new JLabel("APPLY LEAVE ");
														appplyleavestudenttxt.setHorizontalAlignment(SwingConstants.CENTER);
														appplyleavestudenttxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														appplyleavestudenttxt.setBounds(210, 10, 333, 43);
														frame.getContentPane().add(appplyleavestudenttxt);
														
														JTextArea leavetxtarea = new JTextArea();
														leavetxtarea.setWrapStyleWord(true);
														leavetxtarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leavetxtarea.setBackground(Color.LIGHT_GRAY);
														leavetxtarea.setBounds(80, 164, 619, 206);
														frame.getContentPane().add(leavetxtarea);
														
														JLabel leaverollnotxtx = new JLabel("ROLL NUMBER");
														leaverollnotxtx.setFont(new Font("Times New Roman", Font.BOLD, 20));
														leaverollnotxtx.setBackground(Color.WHITE);
														leaverollnotxtx.setBounds(80, 63, 158, 31);
														frame.getContentPane().add(leaverollnotxtx);
														
														JTextField LEAVEROLLFLD = new JTextField();
														LEAVEROLLFLD.setHorizontalAlignment(SwingConstants.CENTER);
														LEAVEROLLFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVEROLLFLD.setBounds(259, 63, 177, 31);
														frame.getContentPane().add(LEAVEROLLFLD);
														LEAVEROLLFLD.setColumns(10);
														
														JLabel LEAVECOURSETXT = new JLabel("SELECT COURSE");
														LEAVECOURSETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
														LEAVECOURSETXT.setBackground(Color.WHITE);
														LEAVECOURSETXT.setBounds(80, 104, 166, 31);
														frame.getContentPane().add(LEAVECOURSETXT);
														
														JComboBox comboBoxstudent = new JComboBox();
														comboBoxstudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
														comboBoxstudent.setMaximumRowCount(10);
														comboBoxstudent.setToolTipText("SELECT COURSE NAME\r\nBachelor of Commerce (B. Com)\r\nBachelor of Economics (BE)\r\nBachelor of Accounting and Finance (BAF)\r\nBachelor of Commerce in Banking and Insurance (BBI)\r\nBachelor of Commerce in Financial Market (BFM)\r\nBachelor of Science(Bsc(IT))\r\nBachelor of Computer Application(BCA)");
														comboBoxstudent.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
														comboBoxstudent.setSelectedIndex(0);
														comboBoxstudent.setBounds(259, 111, 445, 24);
														frame.getContentPane().add(comboBoxstudent);
														
														JButton SBMTLEAVESTUDENTBTN = new JButton("SUBMIT LEAVE");
														SBMTLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
														SBMTLEAVESTUDENTBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	String studentleaverollno=LEAVEROLLFLD.getText();
																	String courseleavestudent=(String) comboBoxstudent.getSelectedItem();
																	String studentleavereason=leavetxtarea.getText();
																			
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager
																			.getConnection(
																					"jdbc:mysql://localhost:3306/studcrud",
																					"root", "admin");
												                     PreparedStatement s = con.prepareStatement("insert into studentleavedata(Course_name,Roll_no,leave_reason) values(?,?,?)");

																	s.setString(3, studentleavereason);
																	s.setString(1, courseleavestudent);
																	s.setString(2, studentleaverollno);

																	String query = ("select * from studentleavedata");
																	ResultSet myRs = s.executeQuery(query);
																	myRs.next();
																	System.out.println("inserted leave data");

																	display(myRs);

																	@SuppressWarnings("unused")
																	int i = s.executeUpdate();

																	con.close();

																} catch (Exception x) {
																	x.printStackTrace();
																}
																
																
																
																
																
															}
														});
														SBMTLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 15));
														SBMTLEAVESTUDENTBTN.setBounds(312, 380, 158, 30);
														frame.getContentPane().add(SBMTLEAVESTUDENTBTN);
														
														JButton back4btn = new JButton("BACK");
														back4btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(firstnamestudents);
																frame.getContentPane().add(LASTNAMESTUDENTTXT);
																frame.getContentPane().add(ROLLNUMBERSTUDENTSTXT);
																frame.getContentPane().add(COURSENAMESTUDENTSTXT);
																frame.getContentPane().add(FIRSTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(LASTNAMESTUDENTTXTFLD);
																frame.getContentPane().add(ROLLNUMBERTXTFLD);
																frame.getContentPane().add(COURSENAMETXTFLD);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXT);
																frame.getContentPane().add(ATTENDANCEPERCENTAGETXTFLD);
																frame.getContentPane().add(CALCULATEPERCENTAGEBTN);
																frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
																JButton back4btn = new JButton("BACK");
																back4btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(STUDENTLOGINTXT);
																		frame.getContentPane().add(ROLLNOTEXT);
																		frame.getContentPane().add(PASSWORDTEXT);
																		frame.getContentPane().add(ROLLNOtextField);
																		frame.getContentPane().add(studentcoursecombobox);
																		frame.getContentPane().add(LOGINBTNSTUDENT);
																		frame.getContentPane().add(LOGINpasswordField);
																		JButton back4btn = new JButton("BACK");
																		back4btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back4btn = new JButton("BACK");
																				back4btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						frame.getContentPane().removeAll();
																						
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																						
																					}
																				});
																				back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back4btn.setBounds(0, 0, 74, 24);
																				frame.getContentPane().add(back4btn);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																				
																			}
																		});
																		back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back4btn.setBounds(0, 0, 74, 24);
																		frame.getContentPane().add(back4btn);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																		
																	}
																});
																back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back4btn.setBounds(0, 0, 74, 24);
																frame.getContentPane().add(back4btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
															}
														});
														back4btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back4btn.setBounds(0, 0, 74, 24);
														frame.getContentPane().add(back4btn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
														
														
														
														
													
													}
												});
												AAPLYLEAVESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
												AAPLYLEAVESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
												AAPLYLEAVESTUDENTBTN.setBounds(291, 314, 237, 47);
												frame.getContentPane().add(AAPLYLEAVESTUDENTBTN);
												JButton back5btn = new JButton("BACK");
												back5btn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														
														
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
												back5btn.setBackground(Color.LIGHT_GRAY);
												back5btn.setBounds(0, 0, 77, 29);
												frame.getContentPane().add(back5btn);
												
												
												
												
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();	
											} 
											else
											{
												System.out.println("invalid roll number and password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG ROLL NUMBER OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}
								    }





								    
								    

									}

									private void display(ResultSet myRs) {
										// TODO Auto-generated method stub
										
									}

									private void dispose() {
										// TODO Auto-generated method stub

									}
								});
								
								
								// ACTION ON LOGIN BUTTON
								LOGINBTNSTUDENT.setFont(new Font("Times New Roman", Font.BOLD, 20));
								LOGINBTNSTUDENT.setBackground(Color.LIGHT_GRAY);
								LOGINBTNSTUDENT.setBounds(280, 336, 182, 34);
								frame.getContentPane().add(LOGINBTNSTUDENT);

								LOGINpasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								LOGINpasswordField.setHorizontalAlignment(SwingConstants.CENTER);
								LOGINpasswordField.setBounds(379, 169, 206, 34);
								frame.getContentPane().add(LOGINpasswordField);
								// STUDENT LOGIN FORM ENDS HERE

								// back button
								JButton backbtn = new JButton("Back");
								backbtn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										frame.getContentPane().removeAll();
										frame.getContentPane().add(stdnloginbtn);
										frame.getContentPane().add(Tcherloginbtn);
										frame.getContentPane().add(ADMINLGNBTN);
										JButton backbtn = new JButton("Back");
										backbtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												frame.getContentPane().removeAll();
												frame.getContentPane().add(REGESTERBTN);
												frame.getContentPane().add(STUDENTLOGINBTN);
												
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();
											}
										});
										backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
										backbtn.setBackground(Color.LIGHT_GRAY);
										backbtn.setBounds(0, 0, 62, 27);
										frame.getContentPane().add(backbtn);
										frame.getContentPane().repaint();
										frame.getContentPane().revalidate();
									}
								});
								backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
								backbtn.setBackground(Color.LIGHT_GRAY);
								backbtn.setBounds(0, 0, 62, 27);
								frame.getContentPane().add(backbtn);
								// back button
								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}
						});
						stdnloginbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
						stdnloginbtn.setBackground(Color.LIGHT_GRAY);
						stdnloginbtn.setBounds(240, 203, 279, 65);
						frame.getContentPane().add(stdnloginbtn);

						// teacher login button starts here
						// code for teacher login btn is above with student login btn.

						// ACTION ON TEACHER LOGIN BTN
						Tcherloginbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();

								frame.getContentPane().setBackground(Color.WHITE);
								frame.getContentPane().setLayout(null);

								JLabel logintext = new JLabel("TEACHER LOGIN");
								logintext.setFont(new Font("Times New Roman", Font.BOLD, 25));
								logintext.setHorizontalAlignment(SwingConstants.CENTER);
								logintext.setBackground(Color.LIGHT_GRAY);
								logintext.setBounds(249, 10, 244, 49);
								frame.getContentPane().add(logintext);

								JLabel UNIQUEIDTEXT = new JLabel("UNIQUE ID");
								UNIQUEIDTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								UNIQUEIDTEXT.setFont(new Font("Times New Roman", Font.BOLD, 19));
								UNIQUEIDTEXT.setBackground(Color.LIGHT_GRAY);
								UNIQUEIDTEXT.setBounds(190, 96, 138, 29);
								frame.getContentPane().add(UNIQUEIDTEXT);

								JLabel PASSWORDTEXT = new JLabel("PASSWORD");
								PASSWORDTEXT.setBackground(Color.LIGHT_GRAY);
								PASSWORDTEXT.setFont(new Font("Times New Roman", Font.BOLD, 19));
								PASSWORDTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								PASSWORDTEXT.setBounds(190, 135, 138, 29);
								frame.getContentPane().add(PASSWORDTEXT);

								JTextField UNIQUEtXTField = new JTextField();
								UNIQUEtXTField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								UNIQUEtXTField.setHorizontalAlignment(SwingConstants.CENTER);
								UNIQUEtXTField.setBounds(363, 98, 152, 29);
								frame.getContentPane().add(UNIQUEtXTField);
								UNIQUEtXTField.setColumns(10);

								JTextField PASSWORDTEXTFLD = new JTextField();
								PASSWORDTEXTFLD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								PASSWORDTEXTFLD.setHorizontalAlignment(SwingConstants.CENTER);
								PASSWORDTEXTFLD.setBounds(363, 137, 152, 32);
								frame.getContentPane().add(PASSWORDTEXTFLD);
								PASSWORDTEXTFLD.setColumns(10);

								JButton tchrloginbtn = new JButton("LOGIN");
								// action on login button on teachers login page
								tchrloginbtn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										frame.getContentPane().repaint();
										frame.getContentPane().revalidate();

										try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
											String tuid = UNIQUEtXTField.getText();
											String tpass = PASSWORDTEXTFLD.getText();

											Statement sss = con.createStatement();

											String sqll = "select * from teacherregistrationdata  where unique_id='"
													+ tuid + "' and teachers_password='" + tpass + "'";
											ResultSet rss = sss.executeQuery(sqll);

											if (rss.next()) {
												dispose();
												System.out.println("sucess");
												frame.getContentPane().removeAll();

												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();

												frame.getContentPane().setBackground(Color.WHITE);
												frame.getContentPane().setLayout(null);
												
												JButton backbtn = new JButton("Back");
												backbtn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														frame.getContentPane().removeAll();
														frame.getContentPane().add(stdnloginbtn);
														frame.getContentPane().add(Tcherloginbtn);
														frame.getContentPane().add(ADMINLGNBTN);
														JButton backbtn = new JButton("Back");
														backbtn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().add(REGESTERBTN);
																frame.getContentPane().add(STUDENTLOGINBTN);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
														backbtn.setBackground(Color.LIGHT_GRAY);
														backbtn.setBounds(0, 0, 62, 27);
														frame.getContentPane().add(backbtn);
														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});
												backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
												backbtn.setBackground(Color.LIGHT_GRAY);
												backbtn.setBounds(0, 0, 62, 27);
												frame.getContentPane().add(backbtn);

												// ACTION ON TAKE ATTENDANCE BUTTON
												JButton takeattendbtn = new JButton("TAKE ATTENDANCE");
												takeattendbtn.addActionListener(new ActionListener() {
													@SuppressWarnings({ "unchecked", "rawtypes" })
													public void actionPerformed(ActionEvent e) {
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);

														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);

														JLabel ENTERDATETXT = new JLabel("ENTER DATE AND SUBJECT NAME");
														ENTERDATETXT.setHorizontalAlignment(SwingConstants.CENTER);
														ENTERDATETXT
																.setFont(new Font("Times New Roman", Font.BOLD, 25));
														ENTERDATETXT.setBackground(Color.WHITE);
														ENTERDATETXT.setBounds(89, 22, 590, 50);
														frame.getContentPane().add(ENTERDATETXT);

														JLabel ENTERDATELABEL = new JLabel("ENTER DATE");
														ENTERDATELABEL
																.setFont(new Font("Times New Roman", Font.BOLD, 20));
														ENTERDATELABEL.setBackground(Color.WHITE);
														ENTERDATELABEL.setBounds(184, 129, 177, 47);
														frame.getContentPane().add(ENTERDATELABEL);

														JTextField DATEtextField = new JTextField();
														DATEtextField.setHorizontalAlignment(SwingConstants.CENTER);
														DATEtextField
																.setFont(new Font("Times New Roman", Font.PLAIN, 20));
														DATEtextField.setBackground(Color.WHITE);
														DATEtextField.setBounds(371, 127, 212, 50);
														frame.getContentPane().add(DATEtextField);
														DATEtextField.setColumns(10);
														JTextField SUBBJECTtextField = new JTextField();
														JLabel EntercourseLABEL_1 = new JLabel("ENTER COURSE");
														String currentDATE = String.valueOf(DATEtextField.getText());
														String subject = String.valueOf(SUBBJECTtextField.getText());

														String star = "**************************";
														String hash = "##########################";
														String div = "///////////////////////////";

														JComboBox hp = new JComboBox();
														// ACTION ON PROCEED BTN
														JButton PROCEEDButton = new JButton("PROCEED");
														PROCEEDButton.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																String cbox = (String) hp.getSelectedItem();
//1st if statement
																if (cbox == "Bachelor of Commerce (B. Com)") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/bcomattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s.executeQuery("select * from bcomstudentdata where roll_number='"+ rrr+ "'");
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																							display(myRs);

																							

																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcomattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,pesent,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																	
																	
																}
																
																
																
																
												
																
//																2nd if statemt for attendance
																
																if (cbox == "Bachelor of Economics (BE)") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/economicsattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s.executeQuery("select * from bachelorofeconomics where roll_number='"+ rrr+ "'");
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																							display(myRs);

																							

																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/economicsattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,present,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																}
																
//																3rd if statement for attendancedata
																
																
																if (cbox == "Bachelor of Accounting and Finance (BAF)") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/bafattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s.executeQuery("select * from bachelorofaccountingandfinancebaf where roll_number='"+ rrr+ "'");
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																							display(myRs);

																						

																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bafattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,present,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																}
																
//																4th if statement 
																
																if (cbox == "Bachelor of Commerce in Banking and Insurance (BBI)") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/bbiattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s.executeQuery("select * from bachelorofcommerceinbankingandinsurancebbi where roll_number='"+ rrr+ "'");;
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																							display(myRs);

																							

																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbiattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,present,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																}
																
//																5th if statement
																
																if (cbox == "Bachelor of Commerce in Financial Market (BFM)") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/bfmattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s.executeQuery("select * from bachelorofcommerceinfinancialmarketbfm where roll_number='"+ rrr+ "'");;
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																							display(myRs);

																							

																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bfmattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,present,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																}
																
//																6th if statement
																
																
																
																if (cbox == "Bachelor of Science(Bsc(IT))") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/bscitattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s
																									.executeQuery("select * from studentregistrationdata where roll_number='"+ rrr+ "'");
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																						display(myRs);

																							
																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bscitattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,present,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																}
																
//																7th if statement
																
																
																if (cbox == "Bachelor of Computer Application(BCA)") {
																	try {
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection(
																				"jdbc:mysql://localhost:3306/bcaattendancedata",
																				"root", "admin");
																		PreparedStatement s = con.prepareStatement(
																				"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_) values(?,?,?,?,?,?)");

																		String firstname = star;
																		String lastname = hash;
																		String rollno = div;
																		String date = String
																				.valueOf(DATEtextField.getText());
																		String subject = String
																				.valueOf(SUBBJECTtextField.getText());
																		String stream = cbox;

																		s.setString(4, date);
																		s.setString(1, firstname);
																		s.setString(2, lastname);
																		s.setString(3, rollno);
																		s.setString(5, subject);
																		s.setString(6, stream);

																		String query = ("select * from attendance");
																		ResultSet myRs = s.executeQuery(query);
																		myRs.next();
																		System.out.println("data  entered");

																		display(myRs);

																		@SuppressWarnings("unused")
																		int i = s.executeUpdate();

																		con.close();

																		frame.getContentPane().removeAll();
																		frame.getContentPane()
																				.setBackground(Color.WHITE);
																		frame.getContentPane().setLayout(null);

																		JLabel headtxt = new JLabel("");
																		headtxt.setText(cbox);
																		headtxt.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		headtxt.setFont(new Font("Times New Roman",
																				Font.BOLD, 25));
																		headtxt.setBackground(Color.WHITE);
																		headtxt.setBounds(47, 26, 679, 44);
																		frame.getContentPane().add(headtxt);

																		JLabel enteroll = new JLabel(
																				"ENTER ROLL NUMBER");
																		enteroll.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enteroll.setBackground(Color.WHITE);
																		enteroll.setBounds(65, 108, 238, 44);
																		frame.getContentPane().add(enteroll);

																		JTextField enterollfld = new JTextField();
																		enterollfld.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		enterollfld.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		enterollfld.setBackground(Color.WHITE);
																		enterollfld.setBounds(339, 109, 138, 44);
																		frame.getContentPane().add(enterollfld);
																		enterollfld.setColumns(10);
																		JLabel FSTNAMETXT = new JLabel("");
																		JLabel LASTNAMETXT = new JLabel("");
																		JLabel ROLLNOTXT = new JLabel("");

//                    																	ACTION ON SEARCH BTN
																		JButton searchbtn = new JButton("SEARCH");
																		searchbtn.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {

																						try {

																							String rrr = enterollfld
																									.getText();

																							Class.forName(
																									"com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager
																									.getConnection(
																											"jdbc:mysql://localhost:3306/studcrud",
																											"root",
																											"admin");
																							Statement s = con.createStatement();

																							ResultSet myRs = s
																									.executeQuery("select * from bachelorofcomputerapplicationbca where roll_number='"+ rrr+ "'");
																							while (myRs.next()) {
																								FSTNAMETXT.setText(
																										myRs.getString(
																												"first_name"));
																								LASTNAMETXT.setText(
																										myRs.getString(
																												"last_name"));
																								ROLLNOTXT.setText(
																										myRs.getString(
																												"roll_number"));

																							}

																							display(myRs);

																							
																							con.close();
																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		searchbtn.setFont(new Font("Times New Roman",
																				Font.BOLD, 15));
																		searchbtn.setBackground(Color.LIGHT_GRAY);
																		searchbtn.setBounds(520, 109, 138, 44);
																		frame.getContentPane().add(searchbtn);

																		FSTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		FSTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		FSTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		FSTNAMETXT.setBounds(65, 237, 225, 44);
																		frame.getContentPane().add(FSTNAMETXT);

																		LASTNAMETXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		LASTNAMETXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		LASTNAMETXT.setBackground(Color.LIGHT_GRAY);
																		LASTNAMETXT.setBounds(300, 237, 225, 44);
																		frame.getContentPane().add(LASTNAMETXT);

																		ROLLNOTXT.setHorizontalAlignment(
																				SwingConstants.CENTER);
																		ROLLNOTXT.setFont(new Font("Times New Roman",
																				Font.BOLD, 20));
																		ROLLNOTXT.setBackground(Color.LIGHT_GRAY);
																		ROLLNOTXT.setBounds(544, 237, 182, 44);
																		frame.getContentPane().add(ROLLNOTXT);
//                    																	ACTION ON PRESENT BTN
																		JButton PRESENTBTN = new JButton("PRESENT");
																		PRESENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																						try {
																							String _first = FSTNAMETXT
																									.getText();
																							String _last = LASTNAMETXT
																									.getText();
																							String ro_ll = ROLLNOTXT
																									.getText();
																							String pres = "present";
																							Class.forName("com.mysql.cj.jdbc.Driver");
																							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcaattendancedata",
																											"root",
																											"admin");
																							PreparedStatement s = con
																									.prepareStatement(
																											"insert into attendance(first_name,last_name,roll_no,date_,subject_,stream_,present,absent) values(?,?,?,?,?,?,?,?)");

																							String firstname = _first;
																							String lastname = _last;
																							String rollno = ro_ll;
																							String date1 = date;
																							String subject1 = subject;
																							String stream1 = stream;
																							String absent = "";

																							s.setString(4, date1);
																							s.setString(1, firstname);
																							s.setString(2, lastname);
																							s.setString(3, rollno);
																							s.setString(5, subject1);
																							s.setString(6, stream1);
																							s.setString(7, absent);
																							s.setString(8, pres);

																							String query = ("select * from attendance");
																							ResultSet myRs = s
																									.executeQuery(
																											query);
																							myRs.next();

																							display(myRs);

																							@SuppressWarnings("unused")
																							int i = s.executeUpdate();
																							System.out
																									.println("entered");

																							con.close();

																						} catch (Exception x) {
																							System.out.println(
																									" not entered");
																							x.printStackTrace();
																						}

																					}
																				});
																		PRESENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		PRESENTBTN.setBackground(Color.LIGHT_GRAY);
																		PRESENTBTN.setBounds(427, 350, 144, 44);
																		frame.getContentPane().add(PRESENTBTN);
//                    																	ACTION ON ABSENT BTN
																		JButton ABSENTBTN = new JButton("ABSENT");
																		ABSENTBTN.addActionListener(
																				new ActionListener() {
																					public void actionPerformed(
																							ActionEvent e) {
																					}
																				});
																		ABSENTBTN.setFont(new Font("Times New Roman",
																				Font.PLAIN, 19));
																		ABSENTBTN.setBackground(Color.LIGHT_GRAY);
																		ABSENTBTN.setBounds(231, 350, 144, 44);
																		frame.getContentPane().add(ABSENTBTN);

																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();

																	}

																	catch (Exception x) {
																		System.out.println(" not entered");
																		x.printStackTrace();
																	}
																	JButton backbtn3 = new JButton("BACK");
																	backbtn3.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(ENTERDATETXT);
																			frame.getContentPane().add(ENTERDATELABEL);
																			frame.getContentPane().add(EntercourseLABEL_1);
																			frame.getContentPane().add(DATEtextField);
																			frame.getContentPane().add(SUBBJECTtextField);
																			frame.getContentPane().add(hp);
																			frame.getContentPane().add(PROCEEDButton);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	backbtn3.setBackground(Color.LIGHT_GRAY);
																	backbtn3.setBounds(0, 0, 77, 30);
																	frame.getContentPane().add(backbtn3);
																}
																
																

															}

															private void display(ResultSet myRs) {
																

															}

														});
														PROCEEDButton
																.setFont(new Font("Times New Roman", Font.BOLD, 17));
														PROCEEDButton.setBounds(316, 317, 157, 40);
														frame.getContentPane().add(PROCEEDButton);

														JLabel EnterSubjectLABEL = new JLabel("ENTER SUBJECT");
														EnterSubjectLABEL
																.setFont(new Font("Times New Roman", Font.BOLD, 20));
														EnterSubjectLABEL.setBackground(Color.WHITE);
														EnterSubjectLABEL.setBounds(184, 186, 177, 47);
														frame.getContentPane().add(EnterSubjectLABEL);

														SUBBJECTtextField.setHorizontalAlignment(SwingConstants.CENTER);
														SUBBJECTtextField
																.setFont(new Font("Times New Roman", Font.PLAIN, 20));
														SUBBJECTtextField.setColumns(10);
														SUBBJECTtextField.setBackground(Color.WHITE);
														SUBBJECTtextField.setBounds(371, 187, 212, 50);
														frame.getContentPane().add(SUBBJECTtextField);

														
														EntercourseLABEL_1
																.setFont(new Font("Times New Roman", Font.BOLD, 20));
														EntercourseLABEL_1.setBackground(Color.WHITE);
														EntercourseLABEL_1.setBounds(184, 243, 177, 47);
														frame.getContentPane().add(EntercourseLABEL_1);

//                                                		dropdown button plced above to perdorm dataconnection

														hp.setFont(new Font("Times New Roman", Font.BOLD, 18));
														hp.setBackground(Color.WHITE);
														hp.setMaximumRowCount(50);
														hp.setModel(new DefaultComboBoxModel(new String[] {
																"SELECT COURSE NAME ", "Bachelor of Commerce (B. Com)",
																"Bachelor of Economics (BE)",
																"Bachelor of Accounting and Finance (BAF)",
																"Bachelor of Commerce in Banking and Insurance (BBI)",
																"Bachelor of Commerce in Financial Market (BFM)",
																"Bachelor of Science(Bsc(IT))",
																"Bachelor of Computer Application(BCA)" }));
														hp.setSelectedIndex(0);
														hp.setToolTipText("SELECT COUSRE");
														hp.setBounds(371, 247, 384, 50);
														frame.getContentPane().add(hp);
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																
																frame.getContentPane().removeAll();
																frame.getContentPane().add(stdnloginbtn);
																frame.getContentPane().add(Tcherloginbtn);
																frame.getContentPane().add(ADMINLGNBTN);
																JButton back5btn = new JButton("BACK");
																back5btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(REGESTERBTN);
																		frame.getContentPane().add(STUDENTLOGINBTN);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																	}
																});
																back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back5btn.setBackground(Color.LIGHT_GRAY);
																back5btn.setBounds(0, 0, 77, 29);
																frame.getContentPane().add(back5btn);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														

														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();

													}
												});
												takeattendbtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
												takeattendbtn.setBackground(Color.LIGHT_GRAY);
												takeattendbtn.setBounds(248, 115, 259, 65);
												frame.getContentPane().add(takeattendbtn);

												// ACTION ON TAKE MANAGE LEAVE BTN
												JButton manageleavebtn = new JButton("MANAGE LEAVE");
												manageleavebtn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														frame.getContentPane().removeAll();
														frame.getContentPane().setBackground(Color.WHITE);
														frame.getContentPane().setLayout(null);

														JLabel manageleavetxt = new JLabel("MANAGE LEAVE");
														manageleavetxt.setHorizontalAlignment(SwingConstants.CENTER);
														manageleavetxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
														manageleavetxt.setBackground(Color.WHITE);
														manageleavetxt.setBounds(263, 24, 258, 54);
														frame.getContentPane().add(manageleavetxt);

														JButton APPLYLEAVEBTN = new JButton("APPLY LEAVE");
														JButton VIEWLEAVEBTN = new JButton("VIEW LEAVE REQUEST");
														APPLYLEAVEBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {

																frame.getContentPane().removeAll();
																frame.getContentPane().setBackground(Color.WHITE);
																frame.getContentPane().setLayout(null);
																JLabel APPLYFORLEAVETXT = new JLabel("APPLY FOR LEAVE");
																APPLYFORLEAVETXT.setFont(
																		new Font("Times New Roman", Font.BOLD, 25));
																APPLYFORLEAVETXT
																		.setHorizontalAlignment(SwingConstants.CENTER);
																APPLYFORLEAVETXT.setBounds(226, 21, 337, 47);
																frame.getContentPane().add(APPLYFORLEAVETXT);

																JLabel ENTERUID = new JLabel("ENTER UNIQUE ID");
																ENTERUID.setFont(
																		new Font("Times New Roman", Font.BOLD, 20));
																ENTERUID.setBackground(Color.WHITE);
																ENTERUID.setBounds(206, 104, 202, 32);
																frame.getContentPane().add(ENTERUID);

																JTextField UIDTXTXFLD = new JTextField();
																UIDTXTXFLD
																		.setHorizontalAlignment(SwingConstants.CENTER);
																UIDTXTXFLD.setFont(
																		new Font("Times New Roman", Font.BOLD, 20));
																UIDTXTXFLD.setBackground(Color.WHITE);
																UIDTXTXFLD.setBounds(455, 103, 135, 35);
																frame.getContentPane().add(UIDTXTXFLD);
																UIDTXTXFLD.setColumns(10);

																JLabel ENTERULLNAMETXTX = new JLabel("ENTER  NAME");
																ENTERULLNAMETXTX.setFont(
																		new Font("Times New Roman", Font.BOLD, 20));
																ENTERULLNAMETXTX.setBackground(Color.WHITE);
																ENTERULLNAMETXTX.setBounds(206, 160, 202, 32);
																frame.getContentPane().add(ENTERULLNAMETXTX);

																JTextField FULLNAMEtextField = new JTextField();
																FULLNAMEtextField
																		.setHorizontalAlignment(SwingConstants.CENTER);
																FULLNAMEtextField.setFont(
																		new Font("Times New Roman", Font.BOLD, 20));
																FULLNAMEtextField.setColumns(10);
																FULLNAMEtextField.setBackground(Color.WHITE);
																FULLNAMEtextField.setBounds(455, 160, 285, 35);
																frame.getContentPane().add(FULLNAMEtextField);

																JLabel REASONTXT = new JLabel("ENTER LEAVE RESON");
																REASONTXT.setHorizontalAlignment(SwingConstants.CENTER);
																REASONTXT.setFont(
																		new Font("Times New Roman", Font.PLAIN, 20));
																REASONTXT.setBackground(Color.WHITE);
																REASONTXT.setBounds(258, 221, 298, 32);
																frame.getContentPane().add(REASONTXT);

																JTextPane LEAVEREASONtextPane = new JTextPane();
																LEAVEREASONtextPane.setFont(
																		new Font("Times New Roman", Font.PLAIN, 20));
																LEAVEREASONtextPane.setToolTipText("");
																LEAVEREASONtextPane.setForeground(Color.DARK_GRAY);
																LEAVEREASONtextPane.setBackground(Color.LIGHT_GRAY);
																LEAVEREASONtextPane.setDropMode(DropMode.USE_SELECTION);
																LEAVEREASONtextPane.setBounds(68, 263, 638, 113);
																frame.getContentPane().add(LEAVEREASONtextPane);

																JButton bckbtn = new JButton("BACK");
																bckbtn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(takeattendbtn);
																		frame.getContentPane().add(manageleavebtn);
																		JButton bckbtn2 = new JButton("BACK");
																		bckbtn2.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(REGESTERBTN);
																				frame.getContentPane().add(STUDENTLOGINBTN);
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																			}
																		});
																		bckbtn2.setFont(
																				new Font("Times New Roman", Font.PLAIN, 10));
																		bckbtn2.setBackground(Color.LIGHT_GRAY);
																		bckbtn2.setBounds(0, 0, 73, 21);
																		frame.getContentPane().add(bckbtn2);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																	}
																});
																bckbtn.setFont(
																		new Font("Times New Roman", Font.PLAIN, 10));
																bckbtn.setBackground(Color.LIGHT_GRAY);
																bckbtn.setBounds(0, 0, 73, 21);
																frame.getContentPane().add(bckbtn);

//action on submit leave btn
																JButton SUBMITLEAVEBTN = new JButton("SUBMIT");
																SUBMITLEAVEBTN.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {

																		String uid = UIDTXTXFLD.getText();
																		String fullname = FULLNAMEtextField.getText();
																		String reason = LEAVEREASONtextPane.getText();
																		try {
																			Class.forName("com.mysql.cj.jdbc.Driver");
																			Connection con = DriverManager
																					.getConnection(
																							"jdbc:mysql://localhost:3306/studcrud",
																							"root", "admin");
							                                                 PreparedStatement s = con.prepareStatement("insert into teacherleavedata(first_name,unique_id,leave_reason) values(?,?,?)");

																			s.setString(3, reason);
																			s.setString(1, fullname);
																			s.setString(2, uid);

																			String query = ("select * from teacherleavedata");
																			ResultSet myRs = s.executeQuery(query);
																			myRs.next();
																			System.out.println("inserted leave data");

																			display(myRs);

																			@SuppressWarnings("unused")
																			int i = s.executeUpdate();

																			con.close();

																		} catch (Exception x) {
																			x.printStackTrace();
																		}

																	}

																	private void display(ResultSet myRs) {
																		

																	}
																});

																SUBMITLEAVEBTN.setFont(
																		new Font("Times New Roman", Font.BOLD, 20));
																SUBMITLEAVEBTN.setBackground(Color.LIGHT_GRAY);
																SUBMITLEAVEBTN.setBounds(336, 386, 135, 34);
																frame.getContentPane().add(SUBMITLEAVEBTN);

																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();

															}
														});
														APPLYLEAVEBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
														APPLYLEAVEBTN.setBackground(Color.LIGHT_GRAY);
														APPLYLEAVEBTN.setBounds(251, 110, 299, 69);
														frame.getContentPane().add(APPLYLEAVEBTN);
//VIEW LEAVE BTN ACTION
														VIEWLEAVEBTN.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																frame.getContentPane().removeAll();
																frame.getContentPane().setBackground(Color.WHITE);
																frame.getContentPane().setLayout(null);
																
																JScrollPane scrollPane = new JScrollPane();
																scrollPane.setBounds(10, 94, 745, 250);
																frame.getContentPane().add(scrollPane);
																
																JTable leavetable = new JTable();
																scrollPane.setViewportView(leavetable);
																
																JLabel viewleavetxt = new JLabel("VIEW ALL LEAVES");
																viewleavetxt.setBounds(210, 0, 341, 48);
																viewleavetxt.setHorizontalAlignment(SwingConstants.CENTER);
																viewleavetxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
																viewleavetxt.setBackground(Color.WHITE);
																frame.getContentPane().add(viewleavetxt);
//		view btn for jtable action
																JButton VIEWBTN = new JButton("VIEW");
																VIEWBTN.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		
																		try {
																			Class.forName("com.mysql.cj.jdbc.Driver");
																			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																			
																			Statement pst = con.createStatement();
																			ResultSet rs3=pst.executeQuery("select * from studentleavedata");
																			leavetable.setModel(DbUtils.resultSetToTableModel(rs3));
																			
																			
																			
																		}
																		catch(Exception x)
																		{
																			x.printStackTrace();
																		}
																		
																		
																		
																		
																		
																		
																		
																	}
																});
																VIEWBTN.setBounds(327, 49, 101, 32);
																VIEWBTN.setBackground(Color.LIGHT_GRAY);
																VIEWBTN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
																frame.getContentPane().add(VIEWBTN);
																
																JButton deleteleavebtn = new JButton("DELETE");
																deleteleavebtn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		
																		DefaultTableModel tb1=(DefaultTableModel) leavetable.getModel();
																		if(leavetable.getSelectedRowCount()==1)
																		{
//																			try block starts here
																			
																			tb1.removeRow(leavetable.getSelectedRow());
																		}
																		else 
																		{
																			if(leavetable.getSelectedRowCount()==0)
																			{
																				JOptionPane.showMessageDialog( deleteleavebtn, this, "Select One Row Atleast", 0);
																			}
																		}
																		
																		
																		
																		
																		
															
																	}
																});
																deleteleavebtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
																deleteleavebtn.setBackground(Color.LIGHT_GRAY);
																deleteleavebtn.setBounds(323, 378, 132, 32);
																frame.getContentPane().add(deleteleavebtn);
																
																
																JButton back3btn = new JButton("BACK");
																back3btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(takeattendbtn);
																		frame.getContentPane().add(manageleavebtn);
																		JButton back5btn = new JButton("BACK");
																		back5btn.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				
																				frame.getContentPane().removeAll();
																				frame.getContentPane().add(stdnloginbtn);
																				frame.getContentPane().add(Tcherloginbtn);
																				frame.getContentPane().add(ADMINLGNBTN);
																				JButton back5btn = new JButton("BACK");
																				back5btn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						
																						frame.getContentPane().removeAll();
																						frame.getContentPane().add(REGESTERBTN);
																						frame.getContentPane().add(STUDENTLOGINBTN);
																						frame.getContentPane().repaint();
																						frame.getContentPane().revalidate();
																					}
																				});
																				back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				back5btn.setBackground(Color.LIGHT_GRAY);
																				back5btn.setBounds(0, 0, 77, 29);
																				frame.getContentPane().add(back5btn);
																				
																				frame.getContentPane().repaint();
																				frame.getContentPane().revalidate();
																			}
																		});
																		back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		back5btn.setBackground(Color.LIGHT_GRAY);
																		back5btn.setBounds(0, 0, 77, 29);
																		frame.getContentPane().add(back5btn);
																		
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																																				
																	}
																});
																back3btn.setFont(new Font("Times New Roman", Font.BOLD, 13));
																back3btn.setBackground(Color.LIGHT_GRAY);
																back3btn.setBounds(0, 0, 75, 27);
																frame.getContentPane().add(back3btn);
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
																
																
															}
														});
														VIEWLEAVEBTN
																.setFont(new Font("Times New Roman", Font.BOLD, 20));
														VIEWLEAVEBTN.setBackground(Color.LIGHT_GRAY);
														VIEWLEAVEBTN.setBounds(251, 209, 299, 69);
														frame.getContentPane().add(VIEWLEAVEBTN);
														JButton back5btn = new JButton("BACK");
														back5btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																
																frame.getContentPane().removeAll();
																frame.getContentPane().add(stdnloginbtn);
																frame.getContentPane().add(Tcherloginbtn);
																frame.getContentPane().add(ADMINLGNBTN);
																JButton back5btn = new JButton("BACK");
																back5btn.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		
																		frame.getContentPane().removeAll();
																		frame.getContentPane().add(REGESTERBTN);
																		frame.getContentPane().add(STUDENTLOGINBTN);
																		frame.getContentPane().repaint();
																		frame.getContentPane().revalidate();
																	}
																});
																back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																back5btn.setBackground(Color.LIGHT_GRAY);
																back5btn.setBounds(0, 0, 77, 29);
																frame.getContentPane().add(back5btn);
																
																frame.getContentPane().repaint();
																frame.getContentPane().revalidate();
															}
														});
														back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
														back5btn.setBackground(Color.LIGHT_GRAY);
														back5btn.setBounds(0, 0, 77, 29);
														frame.getContentPane().add(back5btn);
														

														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();

													}
												});
												manageleavebtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
												manageleavebtn.setBackground(Color.LIGHT_GRAY);
												manageleavebtn.setBounds(248, 211, 259, 65);
												frame.getContentPane().add(manageleavebtn);

												JButton bckbtn = new JButton("BACK");
												bckbtn.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														frame.getContentPane().removeAll();
														frame.getContentPane().add(manageleavebtn);
														frame.getContentPane().add(takeattendbtn);

														frame.getContentPane().repaint();
														frame.getContentPane().revalidate();
													}
												});

											}
//											ELSE STATEMENT STARTS HERE 
											else {
												System.out.println("invalid usernameand password");

												JLabel invalidlogin = new JLabel("");
												invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
												invalidlogin.setForeground(Color.RED);
												invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
												invalidlogin.setBackground(Color.WHITE);
												invalidlogin.setBounds(56, 385, 676, 25);
												frame.getContentPane().add(invalidlogin);

												String invalidlog = "YOU HAVE ENTERED WRONG UNIQUE_ID OR PASSWORD ";
												invalidlogin.setText(invalidlog);

											}

											con.close();

										} catch (Exception x) {
											x.printStackTrace();
										}

									}

									private void dispose() {

									}
								});
								tchrloginbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
								tchrloginbtn.setBackground(Color.LIGHT_GRAY);
								tchrloginbtn.setBounds(286, 191, 152, 29);
								frame.getContentPane().add(tchrloginbtn);
								// teacher logins page ends here

								// back button
								JButton backbtn = new JButton("Back");
								backbtn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										frame.getContentPane().removeAll();
										frame.getContentPane().add(stdnloginbtn);
										frame.getContentPane().add(Tcherloginbtn);
										frame.getContentPane().add(ADMINLGNBTN);
										JButton backbtn = new JButton("Back");
										backbtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												frame.getContentPane().removeAll();
												frame.getContentPane().add(REGESTERBTN);
												frame.getContentPane().add(STUDENTLOGINBTN);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();
											}
										});
										backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
										backbtn.setBackground(Color.LIGHT_GRAY);
										backbtn.setBounds(0, 0, 62, 27);
										frame.getContentPane().add(backbtn);
										frame.getContentPane().repaint();
										frame.getContentPane().revalidate();
									}
								});
								backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
								backbtn.setBackground(Color.LIGHT_GRAY);
								backbtn.setBounds(0, 0, 62, 27);
								frame.getContentPane().add(backbtn);
								// back button

								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}
						});
						Tcherloginbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
						Tcherloginbtn.setBackground(Color.LIGHT_GRAY);
						Tcherloginbtn.setBounds(240, 118, 279, 65);
						frame.getContentPane().add(Tcherloginbtn);

						// admin login button starts here
						// code for admin login button is above with student login
						ADMINLGNBTN.addActionListener(new ActionListener() {
							// ACTION ON ADMIN LOGIN BTN
							public void actionPerformed(ActionEvent e) {

								frame.getContentPane().removeAll();
								// ADMIN LOGIN FORM
								frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
								frame.getContentPane().setBackground(Color.WHITE);
								frame.getContentPane().setLayout(null);

								JLabel ADMINLOGINTEXT = new JLabel("ADMIN LOGIN");
								ADMINLOGINTEXT.setHorizontalAlignment(SwingConstants.CENTER);
								ADMINLOGINTEXT.setFont(new Font("Times New Roman", Font.BOLD, 25));
								ADMINLOGINTEXT.setBackground(Color.LIGHT_GRAY);
								ADMINLOGINTEXT.setBounds(251, 35, 242, 55);
								frame.getContentPane().add(ADMINLOGINTEXT);

								JLabel ADMINLOGINNO = new JLabel("REGISTER NUMBER");
								ADMINLOGINNO.setBackground(Color.LIGHT_GRAY);
								ADMINLOGINNO.setHorizontalAlignment(SwingConstants.CENTER);
								ADMINLOGINNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
								ADMINLOGINNO.setBounds(171, 144, 207, 45);
								frame.getContentPane().add(ADMINLOGINNO);

								JLabel ADMINPASSWORD = new JLabel("PASSWORD");
								ADMINPASSWORD.setHorizontalAlignment(SwingConstants.CENTER);
								ADMINPASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
								ADMINPASSWORD.setBackground(Color.LIGHT_GRAY);
								ADMINPASSWORD.setBounds(171, 199, 207, 45);
								frame.getContentPane().add(ADMINPASSWORD);

								JTextField ADMINNUMBERtextField = new JTextField();
								ADMINNUMBERtextField.setHorizontalAlignment(SwingConstants.CENTER);
								ADMINNUMBERtextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								ADMINNUMBERtextField.setBounds(401, 150, 255, 37);
								frame.getContentPane().add(ADMINNUMBERtextField);
								ADMINNUMBERtextField.setColumns(10);

								JTextField ADMINPASSWORDFIELD = new JTextField();
								ADMINPASSWORDFIELD.setHorizontalAlignment(SwingConstants.CENTER);
								ADMINPASSWORDFIELD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								ADMINPASSWORDFIELD.setColumns(10);
								ADMINPASSWORDFIELD.setBounds(401, 199, 255, 37);
								frame.getContentPane().add(ADMINPASSWORDFIELD);

								JButton ADMINLOGINBUTTON = new JButton("LOGIN");
								ADMINLOGINBUTTON.addActionListener(new ActionListener() {
									// ACTION ON ADMIN LOGIN BUTTON
									public void actionPerformed(ActionEvent e) {
										try {

										Class.forName("com.mysql.cj.jdbc.Driver");

										Connection con = DriverManager.getConnection(
												"jdbc:mysql://localhost:3306/studcrud", "root", "admin");
										String adminmobilenumber = ADMINNUMBERtextField.getText();
										String adminpass = ADMINPASSWORDFIELD.getText();

										Statement ss1 = con.createStatement();

										String sqll = "select * from admindata  where mobile_number='"
												+ adminmobilenumber + "' and A_password='" + adminpass + "'";
										ResultSet rs1 = ss1.executeQuery(sqll);

										if (rs1.next()) {
											System.out.println("successfully login");
											frame.getContentPane().removeAll();
											frame.getContentPane().setBackground(Color.WHITE);
											frame.getContentPane().setLayout(null);
											
											JLabel welcomeadmintxt = new JLabel("WELCOME ADMIN");
											welcomeadmintxt.setHorizontalAlignment(SwingConstants.CENTER);
											welcomeadmintxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
											welcomeadmintxt.setBackground(Color.WHITE);
											welcomeadmintxt.setBounds(253, 10, 240, 49);
											frame.getContentPane().add(welcomeadmintxt);
											//ADMIN STUDENT ACCES BTN
											JButton TEACHERADMINBTN = new JButton("TEACHER");
											JButton STUDENTADMINBTN = new JButton("STUDENT");
											//action on admin student button
											STUDENTADMINBTN.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													
													frame.getContentPane().removeAll();
													frame.getContentPane().setBackground(Color.WHITE);
													frame.getContentPane().setLayout(null);
													
													JButton back5btn = new JButton("BACK");
													back5btn.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															frame.getContentPane().removeAll();
															frame.getContentPane().add(stdnloginbtn);
															frame.getContentPane().add(Tcherloginbtn);
															frame.getContentPane().add(ADMINLGNBTN);
															JButton back5btn = new JButton("BACK");
															back5btn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(REGESTERBTN);
																	frame.getContentPane().add(STUDENTLOGINBTN);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																}
															});
															back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
															back5btn.setBackground(Color.LIGHT_GRAY);
															back5btn.setBounds(0, 0, 77, 29);
															frame.getContentPane().add(back5btn);
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
														}
													});
													back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
													back5btn.setBackground(Color.LIGHT_GRAY);
													back5btn.setBounds(0, 0, 77, 29);
													frame.getContentPane().add(back5btn);
													
													JLabel STUDENTINFOTXT = new JLabel("STUDENT INFORMATION");
													STUDENTINFOTXT.setHorizontalAlignment(SwingConstants.CENTER);
													STUDENTINFOTXT.setFont(new Font("Times New Roman", Font.BOLD, 25));
													STUDENTINFOTXT.setBackground(Color.WHITE);
													STUDENTINFOTXT.setBounds(197, 10, 347, 38);
													frame.getContentPane().add(STUDENTINFOTXT);
													
													JComboBox ADMINPAGESTUDENTCOMBOBOX = new JComboBox();
													ADMINPAGESTUDENTCOMBOBOX.setFont(new Font("Times New Roman", Font.BOLD, 20));
													ADMINPAGESTUDENTCOMBOBOX.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE NAME ", "Bachelor of Commerce (B. Com)", "Bachelor of Economics (BE)", "Bachelor of Accounting and Finance (BAF)", "Bachelor of Commerce in Banking and Insurance (BBI)", "Bachelor of Commerce in Financial Market (BFM)", "Bachelor of Science(Bsc(IT))", "Bachelor of Computer Application(BCA)"}));
													ADMINPAGESTUDENTCOMBOBOX.setSelectedIndex(0);
													ADMINPAGESTUDENTCOMBOBOX.setBounds(255, 58, 500, 31);
													frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
													
													JLabel SELECTCOURSEADMINPAGETXT = new JLabel("SELECT COURSE ");
													SELECTCOURSEADMINPAGETXT.setFont(new Font("Times New Roman", Font.BOLD, 20));
													SELECTCOURSEADMINPAGETXT.setBounds(38, 58, 189, 31);
													frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
													
													
													
													JScrollPane scrollPane = new JScrollPane();
													scrollPane.setBounds(10, 121, 745, 234);
													frame.getContentPane().add(scrollPane);
													
													JTable table2 = new JTable();
													scrollPane.setViewportView(table2);
													
													

													
													
													
													JButton DELETESTUDENTBTN = new JButton("DELETE");
													JButton fetchadminstudentbtn = new JButton("FETCH");
													
													fetchadminstudentbtn.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															String studentadmincombo=(String) ADMINPAGESTUDENTCOMBOBOX.getSelectedItem();
																if(studentadmincombo=="Bachelor of Commerce (B. Com)")
																{
																	try 
																	{
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from bcomstudentdata";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));																	
																	}
																	catch(Exception x)
																	{
																	x.printStackTrace();
																    }
															}
																
																
																
																
																if(studentadmincombo=="Bachelor of Economics (BE)")
																{
																	try {
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from bachelorofeconomics";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));
//																	
																
																	}
																	catch(Exception x)
																	{
																	x.printStackTrace();
																}
															}
																
																if(studentadmincombo=="Bachelor of Accounting and Finance (BAF)")
																{
																	try {
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from bachelorofaccountingandfinancebaf";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));
//																	
																	}
																catch(Exception x)
																	{
																	x.printStackTrace();
																}
															}
																
																if(studentadmincombo=="Bachelor of Commerce in Banking and Insurance (BBI)")
																{
																	try {
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from bachelorofcommerceinbankingandinsurancebbi";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));
//																	
																	
																	}
																	catch(Exception x)
																	{
																	x.printStackTrace();
																}
															}
																if(studentadmincombo=="Bachelor of Commerce in Financial Market (BFM)")
																{
																	try {
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from bachelorofcommerceinfinancialmarketbfm";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));
//																	
																	
																	}
																	catch(Exception x)
																	{
																	x.printStackTrace();
																}
															}
																if(studentadmincombo=="Bachelor of Science(Bsc(IT))")
																{
																	try {
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from studentregistrationdata";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));
//																	
																}
																	catch(Exception x)
																	{
																	x.printStackTrace();
																}
															}
																
																if(studentadmincombo=="Bachelor of Computer Application(BCA)")
																{
																	try {
																	Class.forName("com.mysql.cj.jdbc.Driver");
																	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																	String querys="select * from bachelorofcomputerapplicationbca";
																	PreparedStatement pst=con.prepareStatement(querys);
																	ResultSet rs3=pst.executeQuery();
																	table2.setModel(DbUtils.resultSetToTableModel(rs3));
//																	
																	
																}
																	catch(Exception x)
																	{
																	x.printStackTrace();
																}
															}

																
															
														}
													});
													fetchadminstudentbtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
													fetchadminstudentbtn.setBackground(Color.LIGHT_GRAY);
													fetchadminstudentbtn.setBounds(319, 89, 99, 31);
													frame.getContentPane().add(fetchadminstudentbtn);
													
													
													
													

//													UPDATE STUDENT BTN ACTION
													JButton updatestudentbtn = new JButton("UPDATE");
													updatestudentbtn.addActionListener(new ActionListener() {
														
														public void actionPerformed(ActionEvent e) {
															
															
															
															JTextField UPADTEFIRSTTXTXFLD = new JTextField();
															JTextField UPDATEMIDDLETXTFLD = new JTextField();
															JTextField UPADTELASTTXTFLD = new JTextField();
															JTextField UPADTEPHONETXTXFLD = new JTextField();
															JTextField UPADTEPASSTXTFLD = new JTextField();
															JLabel UPDATEROLLTXTFLD = new JLabel();
															
															
															
															String studentadmincombo3=(String) ADMINPAGESTUDENTCOMBOBOX.getSelectedItem();

															if(studentadmincombo3=="Bachelor of Commerce (B. Com)")
															{
																
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update bcomstudentdata set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from bcomstudentdata");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
													
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);

																			
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	
																	
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
															
															//2nd if for update data for Bachelor of Economics (BE)
															
															
															
															if(studentadmincombo3=="Bachelor of Economics (BE)")
															{	
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update bachelorofeconomics set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from bachelorofeconomics");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
															//3rd if for update Bachelor of Computer Application(BCA)
															
															if(studentadmincombo3=="Bachelor of Computer Application(BCA)")
															{
																
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update bachelorofcomputerapplicationbca set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from bachelorofcomputerapplicationbca");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
															
															//4th if for update Bachelor of Commerce in Financial Market (BFM)
															if(studentadmincombo3=="Bachelor of Commerce in Financial Market (BFM)")
															{
																
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update bachelorofcommerceinfinancialmarketbfm set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from bachelorofcommerceinfinancialmarketbfm");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
														
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
															//5th update for students of Bachelor of Commerce in Banking and Insurance (BBI)
															
															if(studentadmincombo3=="Bachelor of Commerce in Banking and Insurance (BBI)")
															{
																
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update bachelorofcommerceinbankingandinsurancebbi set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from bachelorofcommerceinbankingandinsurancebbi");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}	
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
//6th update for students of Bachelor of Accounting and Finance (BAF)
															
															if(studentadmincombo3=="Bachelor of Accounting and Finance (BAF)")
															{
																
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update bachelorofaccountingandfinancebaf set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from bachelorofaccountingandfinancebaf");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}		
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
//7th update for students of 'Bachelor of Science(Bsc(IT))'
															
															if(studentadmincombo3=="Bachelor of Science(Bsc(IT))")
															{
																
															try {	
																
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															DefaultTableModel model=(DefaultTableModel)table2.getModel();
															int selectedRowIndex = table2.getSelectedRow();
															UPADTEFIRSTTXTXFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
															UPDATEMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
															UPADTELASTTXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
															UPADTEPHONETXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
															UPADTEPASSTXTFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
															UPDATEROLLTXTFLD.setText(model.getValueAt(selectedRowIndex, 6).toString());
															
															}catch(Exception x)
															{
																x.printStackTrace();
															}
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JLabel lblNewLabel = new JLabel("UPDATE FORM");
															lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
															lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
															lblNewLabel.setBounds(233, 23, 298, 30);
															frame.getContentPane().add(lblNewLabel);
															
															JLabel updatefirstname = new JLabel("FIRST NAME");
															updatefirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
															updatefirstname.setBounds(38, 95, 141, 30);
															frame.getContentPane().add(updatefirstname);
															
															JLabel UPDATEMIDDLENAME = new JLabel("MIDDLE NAME");
															UPDATEMIDDLENAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLENAME.setBounds(38, 165, 150, 30);
															frame.getContentPane().add(UPDATEMIDDLENAME);
															
															JLabel UPDATELASTNAME = new JLabel("LAST NAME");
															UPDATELASTNAME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATELASTNAME.setBounds(38, 231, 141, 30);
															frame.getContentPane().add(UPDATELASTNAME);
															
															JLabel UPDATEPHONE = new JLabel("PHONE");
															UPDATEPHONE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPHONE.setBounds(386, 95, 141, 30);
															frame.getContentPane().add(UPDATEPHONE);
															
															JLabel UPDATEPASWORD = new JLabel("PASSWORD");
															UPDATEPASWORD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEPASWORD.setBounds(386, 161, 141, 30);
															frame.getContentPane().add(UPDATEPASWORD);
															
															JLabel UPDATEROLLNO = new JLabel("ROLL NO");
															UPDATEROLLNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEROLLNO.setBounds(386, 231, 141, 30);
															frame.getContentPane().add(UPDATEROLLNO);
															//2nd update btn
															JButton UPDATE2BTN = new JButton("UPDATE");
															UPDATE2BTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	try 
																	{
																		
																		
																		String updatedfirstname=UPADTEFIRSTTXTXFLD.getText();
																		String updatemiddlename=UPDATEMIDDLETXTFLD.getText();
																		String updatedlastname=UPADTELASTTXTFLD.getText();
																		String updatephone=UPADTEPHONETXTXFLD.getText();
																		String updatedpassword=UPADTEPASSTXTFLD.getText();
																		String updatedrollnumber=UPDATEROLLTXTFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update studentregistrationdata set first_name='"+updatedfirstname+"',middle_name='"+updatemiddlename+"',last_name='"+updatedlastname+"',phone='"+updatephone+"',S_password='"+updatedpassword+"' where roll_number='"+updatedrollnumber+"'");

								                                        String query = ("select * from studentregistrationdata");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
												         	
													                    display(myRs);
																		
												                     	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();
													
												                     	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}		
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATE2BTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
															UPDATE2BTN.setBackground(Color.LIGHT_GRAY);
															UPDATE2BTN.setBounds(303, 326, 175, 56);
															frame.getContentPane().add(UPDATE2BTN);
															
															
															UPADTEFIRSTTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEFIRSTTXTXFLD.setBounds(185, 95, 175, 35);
															frame.getContentPane().add(UPADTEFIRSTTXTXFLD);
															UPADTEFIRSTTXTXFLD.setColumns(10);
															
															
															UPDATEMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATEMIDDLETXTFLD.setColumns(10);
															UPDATEMIDDLETXTFLD.setBounds(185, 163, 175, 35);
															frame.getContentPane().add(UPDATEMIDDLETXTFLD);
															
															
															UPADTELASTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTELASTTXTFLD.setColumns(10);
															UPADTELASTTXTFLD.setBounds(185, 226, 175, 35);
															frame.getContentPane().add(UPADTELASTTXTFLD);
															
															
															UPADTEPHONETXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPHONETXTXFLD.setColumns(10);
															UPADTEPHONETXTXFLD.setBounds(504, 90, 175, 35);
															frame.getContentPane().add(UPADTEPHONETXTXFLD);
															
															
															UPADTEPASSTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTEPASSTXTFLD.setColumns(10);
															UPADTEPASSTXTFLD.setBounds(504, 156, 175, 35);
															frame.getContentPane().add(UPADTEPASSTXTFLD);
															
															
															UPDATEROLLTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															
															UPDATEROLLTXTFLD.setBounds(504, 226, 175, 35);
															frame.getContentPane().add(UPDATEROLLTXTFLD);
															
															
															JButton updatebackbtn = new JButton("BACK");
															updatebackbtn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(fetchadminstudentbtn);
																	frame.getContentPane().add(scrollPane);
																	frame.getContentPane().add(SELECTCOURSEADMINPAGETXT);
																	frame.getContentPane().add(ADMINPAGESTUDENTCOMBOBOX);
																	frame.getContentPane().add(STUDENTINFOTXT);
																	frame.getContentPane().add(DELETESTUDENTBTN);
																	frame.getContentPane().add(updatestudentbtn);
																	JButton updatebackbtn = new JButton("BACK");
																	updatebackbtn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);

																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																				
																		}
																	});
																	updatebackbtn.setBackground(Color.LIGHT_GRAY);
																	updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
																	updatebackbtn.setBounds(0, 0, 86, 27);
																	frame.getContentPane().add(updatebackbtn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																		
																}
															});
															updatebackbtn.setBackground(Color.LIGHT_GRAY);
															updatebackbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
															updatebackbtn.setBounds(0, 0, 86, 27);
															frame.getContentPane().add(updatebackbtn);
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
															}
															
															
															
															
														}
													});
													updatestudentbtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
													updatestudentbtn.setBackground(Color.LIGHT_GRAY);
													updatestudentbtn.setBounds(183, 372, 166, 38);
													frame.getContentPane().add(updatestudentbtn);
													
//													DELETE STUDENT BTN ACTION
													
													DELETESTUDENTBTN.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															System.out.println("delete clicked");
															int row = table2.getSelectedRow();
															DefaultTableModel tb2=(DefaultTableModel) table2.getModel();
															String selected = tb2.getValueAt(row, 0).toString();
															
															String studentadmincombo=(String) ADMINPAGESTUDENTCOMBOBOX.getSelectedItem();
//                                                           delete button for bcom students
															if(studentadmincombo=="Bachelor of Commerce (B. Com)")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from bcomstudentdata where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from bcomstudentdata where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from bcomstudentdata where last_name='"+selected+"' ");
												                    
												                    PreparedStatement ps4 = conn.prepareStatement("delete from bcomstudentdata where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from bcomstudentdata where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from bcomstudentdata where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                   
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                   
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
//															Delete button for be students 
															
															if(studentadmincombo=="Bachelor of Economics (BE)")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from bachelorofeconomics where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from bachelorofeconomics where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from bachelorofeconomics where last_name='"+selected+"' ");
												                    PreparedStatement ps4 = conn.prepareStatement("delete from bachelorofeconomics where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from bachelorofeconomics where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from bachelorofeconomics where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
															
															if(studentadmincombo=="Bachelor of Commerce in Financial Market (BFM)")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from `bachelorofcommerceinfinancialmarketbfm` where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from `bachelorofcommerceinfinancialmarketbfm` where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from `bachelorofcommerceinfinancialmarketbfm` where last_name='"+selected+"' ");
												                    PreparedStatement ps4 = conn.prepareStatement("delete from `bachelorofcommerceinfinancialmarketbfm` where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from `bachelorofcommerceinfinancialmarketbfm` where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from `bachelorofcommerceinfinancialmarketbfm` where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
															
															if(studentadmincombo=="Bachelor of Commerce in Banking and Insurance (BBI)")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from `bachelorofcommerceinbankingandinsurancebbi` where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from `bachelorofcommerceinbankingandinsurancebbi` where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from `bachelorofcommerceinbankingandinsurancebbi` where last_name='"+selected+"' ");
												                    PreparedStatement ps4 = conn.prepareStatement("delete from `bachelorofcommerceinbankingandinsurancebbi` where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from `bachelorofcommerceinbankingandinsurancebbi` where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from `bachelorofcommerceinbankingandinsurancebbi` where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
															
															if(studentadmincombo=="Bachelor of Accounting and Finance (BAF)")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from bachelorofaccountingandfinancebaf where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from bachelorofaccountingandfinancebaf where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from bachelorofaccountingandfinancebaf where last_name='"+selected+"' ");
												                    PreparedStatement ps4 = conn.prepareStatement("delete from bachelorofaccountingandfinancebaf where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from bachelorofaccountingandfinancebaf where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from bachelorofaccountingandfinancebaf where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
															if(studentadmincombo=="Bachelor of Science(Bsc(IT))")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from `studentregistrationdata` where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from `studentregistrationdata` where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from `studentregistrationdata` where last_name='"+selected+"' ");
												                    PreparedStatement ps4 = conn.prepareStatement("delete from `studentregistrationdata` where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from `studentregistrationdata` where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from `studentregistrationdata` where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
															if(studentadmincombo=="Bachelor of Computer Application(BCA)")
															{
															if(table2.getSelectedRowCount()==1)
															{
//																try block starts here
																tb2.removeRow(table2.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from `bachelorofcomputerapplicationbca` where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from `bachelorofcomputerapplicationbca` where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from `bachelorofcomputerapplicationbca` where last_name='"+selected+"' ");
												                    PreparedStatement ps4 = conn.prepareStatement("delete from `bachelorofcomputerapplicationbca` where phone='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from `bachelorofcomputerapplicationbca` where S_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from `bachelorofcomputerapplicationbca` where roll_number='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                    
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
														}
															
															
														}
													});
													DELETESTUDENTBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
													DELETESTUDENTBTN.setBackground(Color.LIGHT_GRAY);
													DELETESTUDENTBTN.setBounds(405, 372, 166, 38);
													frame.getContentPane().add(DELETESTUDENTBTN);
													
//													
													frame.getContentPane().repaint();
													frame.getContentPane().revalidate();
												}
											});
											STUDENTADMINBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
											STUDENTADMINBTN.setBackground(Color.LIGHT_GRAY);
											STUDENTADMINBTN.setBounds(224, 108, 311, 56);
											frame.getContentPane().add(STUDENTADMINBTN);
//											ADMIN TEACHERS ACCCESS BTN
											JButton TEACHERDELETEBTN = new JButton("DELETE");
											TEACHERADMINBTN.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													
													frame.getContentPane().removeAll();
													frame.getContentPane().setBackground(Color.WHITE);
													frame.getContentPane().setLayout(null);
													JButton back5btn = new JButton("BACK");
													back5btn.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															frame.getContentPane().removeAll();
															frame.getContentPane().add(stdnloginbtn);
															frame.getContentPane().add(Tcherloginbtn);
															frame.getContentPane().add(ADMINLGNBTN);
															JButton back5btn = new JButton("BACK");
															back5btn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(REGESTERBTN);
																	frame.getContentPane().add(STUDENTLOGINBTN);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																}
															});
															back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
															back5btn.setBackground(Color.LIGHT_GRAY);
															back5btn.setBounds(0, 0, 77, 29);
															frame.getContentPane().add(back5btn);

															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
														}
													});
													back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
													back5btn.setBackground(Color.LIGHT_GRAY);
													back5btn.setBounds(0, 0, 77, 29);
													frame.getContentPane().add(back5btn);
													
													JLabel teacherinfoxtxt = new JLabel("TEACHER INFORMATION");
													teacherinfoxtxt.setBounds(213, 10, 337, 46);
													teacherinfoxtxt.setHorizontalAlignment(SwingConstants.CENTER);
													teacherinfoxtxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
													frame.getContentPane().add(teacherinfoxtxt);
													
													JScrollPane TEACHERscrollPane = new JScrollPane();
													TEACHERscrollPane.setBounds(10, 92, 753, 240);
													frame.getContentPane().add(TEACHERscrollPane);
													
													JTable TEACHERSINFOTABLE = new JTable();
													TEACHERscrollPane.setViewportView(TEACHERSINFOTABLE);
													
													JButton FETCHTEACHERBTN = new JButton("FETCH");
													FETCHTEACHERBTN.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															try 
															{
															Class.forName("com.mysql.cj.jdbc.Driver");
															Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
															String querys="select * from teacherregistrationdata";
															PreparedStatement pst=con.prepareStatement(querys);
															ResultSet rs3=pst.executeQuery();
															TEACHERSINFOTABLE.setModel(DbUtils.resultSetToTableModel(rs3));																	
															}
															catch(Exception x)
															{
															x.printStackTrace();
														    }
														}
														
													});
													FETCHTEACHERBTN.setBackground(Color.LIGHT_GRAY);
													FETCHTEACHERBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
													FETCHTEACHERBTN.setBounds(322, 54, 112, 33);
													frame.getContentPane().add(FETCHTEACHERBTN);
													
													JButton UPADTETEACHERBTN = new JButton("UPDATE");
													UPADTETEACHERBTN.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															frame.getContentPane().removeAll();
															frame.getContentPane().setBackground(Color.WHITE);
															frame.getContentPane().setLayout(null);
															
															JButton back5btn = new JButton("BACK");
															back5btn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(teacherinfoxtxt);
																	frame.getContentPane().add(TEACHERscrollPane);
																	frame.getContentPane().add(FETCHTEACHERBTN);
																	frame.getContentPane().add(UPADTETEACHERBTN);
																	frame.getContentPane().add(TEACHERDELETEBTN);
																	JButton back5btn = new JButton("BACK");
																	back5btn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(welcomeadmintxt);
																			frame.getContentPane().add(STUDENTADMINBTN);
																			frame.getContentPane().add(TEACHERADMINBTN);
																			JButton back5btn = new JButton("BACK");
																			back5btn.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					
																					frame.getContentPane().removeAll();
																					frame.getContentPane().add(stdnloginbtn);
																					frame.getContentPane().add(Tcherloginbtn);
																					frame.getContentPane().add(ADMINLGNBTN);
																					JButton back5btn = new JButton("BACK");
																					back5btn.addActionListener(new ActionListener() {
																						public void actionPerformed(ActionEvent e) {
																							
																							frame.getContentPane().removeAll();
																							frame.getContentPane().add(REGESTERBTN);
																							frame.getContentPane().add(STUDENTLOGINBTN);
																							frame.getContentPane().repaint();
																							frame.getContentPane().revalidate();
																						}
																					});
																					back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																					back5btn.setBackground(Color.LIGHT_GRAY);
																					back5btn.setBounds(0, 0, 77, 29);
																					frame.getContentPane().add(back5btn);
																					frame.getContentPane().repaint();
																					frame.getContentPane().revalidate();
																				}
																			});
																			back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																			back5btn.setBackground(Color.LIGHT_GRAY);
																			back5btn.setBounds(0, 0, 77, 29);
																			frame.getContentPane().add(back5btn);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																	back5btn.setBackground(Color.LIGHT_GRAY);
																	back5btn.setBounds(0, 0, 77, 29);
																	frame.getContentPane().add(back5btn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																}
															});
															back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
															back5btn.setBackground(Color.LIGHT_GRAY);
															back5btn.setBounds(0, 0, 77, 29);
															frame.getContentPane().add(back5btn);
															
															JLabel teacherupdatetxt = new JLabel("UPDATE TEACHER INFORMATION");
															teacherupdatetxt.setHorizontalAlignment(SwingConstants.CENTER);
															teacherupdatetxt.setFont(new Font("Times New Roman", Font.BOLD, 25));
															teacherupdatetxt.setBounds(155, 10, 453, 48);
															frame.getContentPane().add(teacherupdatetxt);
															
															JLabel UPDATETEACHERSFRSTNME = new JLabel("FIRST NAME");
															UPDATETEACHERSFRSTNME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERSFRSTNME.setBounds(10, 94, 126, 39);
															frame.getContentPane().add(UPDATETEACHERSFRSTNME);
															
															JLabel UPDATETEACHERSMDLENME = new JLabel("MIDDLE NAME");
															UPDATETEACHERSMDLENME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERSMDLENME.setBounds(10, 193, 150, 39);
															frame.getContentPane().add(UPDATETEACHERSMDLENME);
															
															JLabel UPDATETEACHERSLSTNME = new JLabel("LAST NAME");
															UPDATETEACHERSLSTNME.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERSLSTNME.setBounds(10, 275, 126, 39);
															frame.getContentPane().add(UPDATETEACHERSLSTNME);
															
															JLabel UPDATETEACHERSPHNE = new JLabel("PHONE NUMBER");
															UPDATETEACHERSPHNE.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERSPHNE.setBounds(408, 94, 165, 39);
															frame.getContentPane().add(UPDATETEACHERSPHNE);
															
															JLabel UPDATETEACHERPSWRD = new JLabel("PASSWORD");
															UPDATETEACHERPSWRD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERPSWRD.setBounds(408, 193, 126, 39);
															frame.getContentPane().add(UPDATETEACHERPSWRD);
															
															JLabel UPDATETEACHERUNIQUID = new JLabel("UNIQUE ID");
															UPDATETEACHERUNIQUID.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERUNIQUID.setBounds(408, 275, 126, 39);
															frame.getContentPane().add(UPDATETEACHERUNIQUID);
															
															JTextField UPADTETEACHERFIRSTTXTFLD = new JTextField();
															UPADTETEACHERFIRSTTXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTETEACHERFIRSTTXTFLD.setBounds(169, 96, 181, 39);
															frame.getContentPane().add(UPADTETEACHERFIRSTTXTFLD);
															UPADTETEACHERFIRSTTXTFLD.setColumns(10);
															
															JTextField UPADTETEACHERMIDDLETXTFLD = new JTextField();
															UPADTETEACHERMIDDLETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTETEACHERMIDDLETXTFLD.setColumns(10);
															UPADTETEACHERMIDDLETXTFLD.setBounds(169, 193, 181, 39);
															frame.getContentPane().add(UPADTETEACHERMIDDLETXTFLD);
															
															JTextField UPADTETAEACHERLASTNAMETXTFLD = new JTextField();
															UPADTETAEACHERLASTNAMETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTETAEACHERLASTNAMETXTFLD.setColumns(10);
															UPADTETAEACHERLASTNAMETXTFLD.setBounds(169, 275, 181, 39);
															frame.getContentPane().add(UPADTETAEACHERLASTNAMETXTFLD);
															
															JTextField UPADTETEACHERPHONETXTFLD = new JTextField();
															UPADTETEACHERPHONETXTFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTETEACHERPHONETXTFLD.setColumns(10);
															UPADTETEACHERPHONETXTFLD.setBounds(582, 94, 181, 39);
															frame.getContentPane().add(UPADTETEACHERPHONETXTFLD);
															
															JTextField UPADTETEACHERPASSWORDTXTXFLD = new JTextField();
															UPADTETEACHERPASSWORDTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPADTETEACHERPASSWORDTXTXFLD.setColumns(10);
															UPADTETEACHERPASSWORDTXTXFLD.setBounds(582, 193, 181, 39);
															frame.getContentPane().add(UPADTETEACHERPASSWORDTXTXFLD);
															
															JLabel UPADTETEACHERUNIQUEIDTXTXFLD = new JLabel();
															UPADTETEACHERUNIQUEIDTXTXFLD.setFont(new Font("Times New Roman", Font.BOLD, 20));
															
															UPADTETEACHERUNIQUEIDTXTXFLD.setBounds(582, 275, 181, 39);
															frame.getContentPane().add(UPADTETEACHERUNIQUEIDTXTXFLD);
															
															try {	
																
																Class.forName("com.mysql.cj.jdbc.Driver");
																Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																DefaultTableModel model=(DefaultTableModel)TEACHERSINFOTABLE.getModel();
																int selectedRowIndex = TEACHERSINFOTABLE.getSelectedRow();
																UPADTETEACHERFIRSTTXTFLD.setText(model.getValueAt(selectedRowIndex, 0).toString());
																UPADTETEACHERMIDDLETXTFLD.setText(model.getValueAt(selectedRowIndex, 1).toString());
																UPADTETAEACHERLASTNAMETXTFLD.setText(model.getValueAt(selectedRowIndex, 2).toString());
																UPADTETEACHERPHONETXTFLD.setText(model.getValueAt(selectedRowIndex, 3).toString());
																UPADTETEACHERPASSWORDTXTXFLD.setText(model.getValueAt(selectedRowIndex, 4).toString());
																UPADTETEACHERUNIQUEIDTXTXFLD.setText(model.getValueAt(selectedRowIndex, 5).toString());
																System.out.println("step1");
																}catch(Exception x)
																{
																	x.printStackTrace();
																}
															
															JButton UPDATETEACHERBTN = new JButton("UPDATE");
															UPDATETEACHERBTN.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	
																	
																	try 
																	{
																		
																		
																		String updatedteacherfirstname=UPADTETEACHERFIRSTTXTFLD.getText();
																		String updatedteachermiddlename=UPADTETEACHERMIDDLETXTFLD.getText();
																		String updatedteacherlastanme=UPADTETAEACHERLASTNAMETXTFLD.getText();
																		String updatedteacherphone=UPADTETEACHERPHONETXTFLD.getText();
																		String updatedteacherpassword=UPADTETEACHERPASSWORDTXTXFLD.getText();
																		String updatedteacheruniqueid=UPADTETEACHERUNIQUEIDTXTXFLD.getText();
																		
																		Class.forName("com.mysql.cj.jdbc.Driver");
																		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																		PreparedStatement s = con.prepareStatement("update teacherregistrationdata set first_name='"+updatedteacherfirstname+"',middle_name='"+updatedteachermiddlename+"',last_name='"+updatedteacherlastanme+"',phone_number='"+updatedteacherphone+"',teachers_password='"+updatedteacherpassword+"' where unique_id='"+updatedteacheruniqueid+"'");

													                    String query = ("select * from teacherregistrationdata");
													                    ResultSet myRs=s.executeQuery(query);
													                    myRs.next();
													     	
													                    display(myRs);
																		
													                 	@SuppressWarnings("unused")
													                    int i = s.executeUpdate();

													                 	con.close();
																		
																	}
																	catch(Exception x)
																	{
																		x.printStackTrace();
																	}
																	
																	
																	
																	
																	
																	
																}

																private void display(ResultSet myRs) {
																	// TODO Auto-generated method stub
																	
																}
															});
															UPDATETEACHERBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
															UPDATETEACHERBTN.setBackground(Color.LIGHT_GRAY);
															UPDATETEACHERBTN.setBounds(320, 347, 165, 39);
															frame.getContentPane().add(UPDATETEACHERBTN);
															
															
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();

														
														
														
														}
													});
													UPADTETEACHERBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
													UPADTETEACHERBTN.setBackground(Color.LIGHT_GRAY);
													UPADTETEACHERBTN.setBounds(221, 360, 135, 46);
													frame.getContentPane().add(UPADTETEACHERBTN);
													
													
													TEACHERDELETEBTN.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															int row = TEACHERSINFOTABLE.getSelectedRow();
															DefaultTableModel tb2=(DefaultTableModel) TEACHERSINFOTABLE.getModel();
															String selected = tb2.getValueAt(row, 0).toString();
															if(TEACHERSINFOTABLE.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb2.removeRow(TEACHERSINFOTABLE.getSelectedRow());
																try {
												                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud", "root", "admin");
												                    PreparedStatement ps = conn.prepareStatement("delete from teacherregistrationdata where first_name='"+selected+"' ");
												                    PreparedStatement ps1 = conn.prepareStatement("delete from teacherregistrationdata where middle_name='"+selected+"' ");
												                    PreparedStatement ps2 = conn.prepareStatement("delete from teacherregistrationdata where last_name='"+selected+"' ");
												                    
												                    PreparedStatement ps4 = conn.prepareStatement("delete from teacherregistrationdata where phone_number='"+selected+"' ");
												                    PreparedStatement ps5 = conn.prepareStatement("delete from teacherregistrationdata where teachers_password='"+selected+"' ");
												                    PreparedStatement ps6 = conn.prepareStatement("delete from teacherregistrationdata where unique_id='"+selected+"' ");
												                    ps.executeUpdate();
												                    ps1.executeUpdate();
												                    ps2.executeUpdate();
												                   
												                    ps4.executeUpdate();
												                    ps5.executeUpdate();
												                    ps6.executeUpdate();
												                   
												                }
												                catch (Exception w) {
												                    System.out.println("error");
												                }      
															}
															
															
															
															
															
															
															
															
														}
													});
													TEACHERDELETEBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
													TEACHERDELETEBTN.setBackground(Color.LIGHT_GRAY);
													TEACHERDELETEBTN.setBounds(415, 360, 135, 46);
													frame.getContentPane().add(TEACHERDELETEBTN);
													
													
													frame.getContentPane().repaint();
													frame.getContentPane().revalidate();
												
													
												}
											});
											
											
											TEACHERADMINBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
											TEACHERADMINBTN.setBackground(Color.LIGHT_GRAY);
											TEACHERADMINBTN.setBounds(224, 189, 311, 56);
											frame.getContentPane().add(TEACHERADMINBTN);
											
											
											JButton teacherleacheadminbtn = new JButton("TEACHER LEAVE");
											teacherleacheadminbtn.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {

													frame.getContentPane().removeAll();
													frame.getContentPane().setBackground(Color.WHITE);
													frame.getContentPane().setLayout(null);
													
													
													JButton back5btn = new JButton("BACK");
													back5btn.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															frame.getContentPane().removeAll();
															frame.getContentPane().add(STUDENTADMINBTN);
															frame.getContentPane().add(TEACHERADMINBTN);
															frame.getContentPane().add(welcomeadmintxt);
															frame.getContentPane().add(teacherleacheadminbtn);
															JButton back5btn = new JButton("BACK");
															back5btn.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	
																	frame.getContentPane().removeAll();
																	frame.getContentPane().add(stdnloginbtn);
																	frame.getContentPane().add(Tcherloginbtn);
																	frame.getContentPane().add(ADMINLGNBTN);JButton back5btn = new JButton("BACK");
																	back5btn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			
																			frame.getContentPane().removeAll();
																			frame.getContentPane().add(REGESTERBTN);
																			frame.getContentPane().add(STUDENTLOGINBTN);
																			frame.getContentPane().repaint();
																			frame.getContentPane().revalidate();
																		}
																	});
																	back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																	back5btn.setBackground(Color.LIGHT_GRAY);
																	back5btn.setBounds(0, 0, 77, 29);
																	frame.getContentPane().add(back5btn);
																	frame.getContentPane().repaint();
																	frame.getContentPane().revalidate();
																}
															});
															back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
															back5btn.setBackground(Color.LIGHT_GRAY);
															back5btn.setBounds(0, 0, 77, 29);
															frame.getContentPane().add(back5btn);
															frame.getContentPane().repaint();
															frame.getContentPane().revalidate();
														}
													});
													back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
													back5btn.setBackground(Color.LIGHT_GRAY);
													back5btn.setBounds(0, 0, 77, 29);
													frame.getContentPane().add(back5btn);
													
													JScrollPane scrollPane = new JScrollPane();
													scrollPane.setBounds(10, 94, 745, 250);
													frame.getContentPane().add(scrollPane);
													
													JTable leavetable = new JTable();
													scrollPane.setViewportView(leavetable);
													
													JLabel viewleavetxt = new JLabel("VIEW ALL LEAVES");
													viewleavetxt.setBounds(210, 0, 341, 48);
													viewleavetxt.setHorizontalAlignment(SwingConstants.CENTER);
													viewleavetxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
													viewleavetxt.setBackground(Color.WHITE);
													frame.getContentPane().add(viewleavetxt);
									                //view btn for jtable action
													JButton VIEWBTN = new JButton("VIEW");
													VIEWBTN.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															try {
																Class.forName("com.mysql.cj.jdbc.Driver");
																Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studcrud","root","admin");
																
																Statement pst = con.createStatement();
																ResultSet rs3=pst.executeQuery("select * from teacherleavedata");
																leavetable.setModel(DbUtils.resultSetToTableModel(rs3));
																
																
																
															}
															catch(Exception x)
															{
																x.printStackTrace();
															}
															
															
															
															
															
															
															
														}
													});
													VIEWBTN.setBounds(327, 49, 101, 32);
													VIEWBTN.setBackground(Color.LIGHT_GRAY);
													VIEWBTN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
													frame.getContentPane().add(VIEWBTN);
													
													JButton deleteleavebtn = new JButton("DELETE");
													deleteleavebtn.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															DefaultTableModel tb1=(DefaultTableModel) leavetable.getModel();
															if(leavetable.getSelectedRowCount()==1)
															{
//																try block starts here
																
																tb1.removeRow(leavetable.getSelectedRow());
															}
															else 
															{
																if(leavetable.getSelectedRowCount()==0)
																{
																	JOptionPane.showMessageDialog( deleteleavebtn, this, "Select One Row Atleast", 0);
																}
															}
															
															
															
															
															
												
														}
													});
													deleteleavebtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
													deleteleavebtn.setBackground(Color.LIGHT_GRAY);
													deleteleavebtn.setBounds(323, 378, 132, 32);
													frame.getContentPane().add(deleteleavebtn);
													
													
													
													frame.getContentPane().repaint();
													frame.getContentPane().revalidate();
													
													
												
												}
											});
											teacherleacheadminbtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
											teacherleacheadminbtn.setBackground(Color.LIGHT_GRAY);
											teacherleacheadminbtn.setBounds(224, 264, 311, 56);
											frame.getContentPane().add(teacherleacheadminbtn);
											
											JButton back5btn = new JButton("BACK");
											back5btn.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													
													frame.getContentPane().removeAll();
													frame.getContentPane().repaint();
													frame.getContentPane().revalidate();
												}
											});
											back5btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
											back5btn.setBackground(Color.LIGHT_GRAY);
											back5btn.setBounds(0, 0, 77, 29);
											frame.getContentPane().add(back5btn);
											
											frame.getContentPane().repaint();
											frame.getContentPane().revalidate();
											
											
										}
//										ELSE STATEMENT STARTS HERE 
										else {
											System.out.println("invalid usernameand password");

											JLabel invalidlogin = new JLabel("");
											invalidlogin.setHorizontalAlignment(SwingConstants.CENTER);
											invalidlogin.setForeground(Color.RED);
											invalidlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
											invalidlogin.setBackground(Color.WHITE);
											invalidlogin.setBounds(56, 385, 676, 25);
											frame.getContentPane().add(invalidlogin);

											String invalidlog = "YOU HAVE ENTERED WRONG UNIQUE_ID OR PASSWORD ";
											invalidlogin.setText(invalidlog);

										}

										con.close();
									}
										catch(Exception x)
										{
											x.printStackTrace();
										}

									
									}
									
								});
								ADMINLOGINBUTTON.setBackground(Color.LIGHT_GRAY);
								ADMINLOGINBUTTON.setFont(new Font("Times New Roman", Font.BOLD, 20));
								ADMINLOGINBUTTON.setBounds(316, 254, 177, 45);
								frame.getContentPane().add(ADMINLOGINBUTTON);
								// ADMIN LOGIN FORM

								// back button
								JButton backbtn = new JButton("Back");
								backbtn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										frame.getContentPane().removeAll();
										frame.getContentPane().add(stdnloginbtn);
										frame.getContentPane().add(Tcherloginbtn);
										frame.getContentPane().add(ADMINLGNBTN);
										JButton backbtn = new JButton("Back");
										backbtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												frame.getContentPane().removeAll();
												frame.getContentPane().add(REGESTERBTN);
												frame.getContentPane().add(STUDENTLOGINBTN);
												frame.getContentPane().repaint();
												frame.getContentPane().revalidate();
											}
										});
										backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
										backbtn.setBackground(Color.LIGHT_GRAY);
										backbtn.setBounds(0, 0, 62, 27);
										frame.getContentPane().add(backbtn);
										frame.getContentPane().repaint();
										frame.getContentPane().revalidate();
									}
								});
								backbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
								backbtn.setBackground(Color.LIGHT_GRAY);
								backbtn.setBounds(0, 0, 62, 27);
								frame.getContentPane().add(backbtn);
								// back button

								frame.getContentPane().repaint();
								frame.getContentPane().revalidate();
							}
						});
						ADMINLGNBTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
						ADMINLGNBTN.setBackground(Color.LIGHT_GRAY);
						ADMINLGNBTN.setBounds(240, 283, 279, 65);
						frame.getContentPane().add(ADMINLGNBTN);

						frame.getContentPane().repaint();
						frame.getContentPane().revalidate();
					}
				});
				STUDENTLOGINBTN.setBackground(Color.LIGHT_GRAY);
				STUDENTLOGINBTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
				STUDENTLOGINBTN.setBounds(240, 197, 291, 68);
				frame.getContentPane().add(STUDENTLOGINBTN);

				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

			}
		});
		STARTBTN.setFont(new Font("Times New Roman", Font.BOLD, 18));
		STARTBTN.setForeground(Color.BLACK);
		STARTBTN.setBounds(390, 200, 139, 54);
		frame.getContentPane().add(STARTBTN);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Shubham\\Desktop\\chrome downloads\\attendance image.jfif"));
		lblNewLabel_1.setBounds(61, 0, 694, 410);
		frame.getContentPane().add(lblNewLabel_1);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "START");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
