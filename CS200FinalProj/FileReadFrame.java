
/**
 * This is Final Project for CS200
 *This program will simulate database management for a high school system. The user will have the option to search and sort for the student’s information 
 *(name, age, GPA, and grade), the teacher’s information (name, age, salary, and subjects). They will also be able to read and add to the CSV file.
 *(student.csv/teacher.csv) The user will also be able to find the teacher’s average and standard deviation of the salaries and ages and 
 *the student’s average and standard deviation of the ages and grades. 
 *Sound-effects is implemented as the user do a certain task in the program.
 *Techniques used:
 *Input/Output with files, Inheritance, user-defined methods, Exception Handling, Generics,
 *Collectiond(ArrayList), searching and sorting
 * 
 * @author (Junwen Huang)
 * @author (Touchsada Jan-On)
 * @version (Dec.2/2020)
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class FileReadFrame extends JFrame implements ActionListener {
   private JScrollPane scrollPane;       // Container adds scroll bar
   private JTextArea outputArea;         // Holds file output
   private JLabel selectedFileLabel;     // Label for file name
   private JLabel outputLabel;           // Label for file contents
   private JLabel nameLabel, ageLabel, gpaLabel, gradeLabel;   //student and generics label
   private JLabel tNameLabel, tAgeLabel, tSalaryLabel, tSubLabel; //teacher label
   private JTextField selectedFileField; // Holds name of file
   private JFileChooser fileChooser;     // Enables user to select file
   private JButton search; 
   private JButton reset;
   private JButton student, SAvgAge, SAvgGrade, studentSDAge, StudentSDGrade;
   private JButton teacher, tAvgAge, tAvgSalary, tSDSalary, tSDAge;
   private JComboBox sortStudent, sortTea;
   private JLabel s1,s2;
   private JButton sortButton, revert;
   private JButton addStudent, addTeacher, clearStudent, clearTeacher, clearMainBox;
   private JTextField target;
   private JTextField nameField, ageField, gpaField, gradeField, SAvgAgeField, SAvgGradeField, stuSDGradeField, stuSDAgeField; //student text field
   private JTextField tNameField, tAgeField, tSalaryField, tSubField, tAvgAgeField, tAvgSalaryField, tSDAgeField, tSDSalaryField; //teacher text field
   private boolean stuMode=false;
   private boolean teaMode=false;
   ArrayList<studentData> sData=new ArrayList<studentData>();
   ArrayList<teacherData> tData=new ArrayList<teacherData>();
   
   
   File applause = new File("applause_y.wav"); //add button sound
   File blip = new File("blip.wav"); // clear button sound
   File gong = new File("peeeooop_x.wav"); //avage button sound
   File boxing = new File("boxing_bell.wav"); // teacher, student, search button sound
   
   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   FileReadFrame() {
       
       
      GridBagConstraints layoutConst = null; // GUI component layout

      // Set frame's title
      setTitle("Final Project");

      outputLabel = new JLabel("File contents:");
      selectedFileLabel = new JLabel("Selected file:");
      //sorting
      String s1[]={"Name","Age","GPA","Grade"};
      String s2[]={"Name","Age","Salary","Subject"};
      sortStudent=new JComboBox(s1);
      sortTea=new JComboBox(s2);
      sortStudent.setSelectedIndex(0);
      sortTea.setSelectedIndex(0);
      sortButton=new JButton("Sort");
      sortButton.addActionListener(this);
      revert= new JButton("Revert");
      revert.addActionListener(this);
      //Student labels
      nameLabel = new JLabel("Name: ");
      ageLabel = new JLabel("Age: ");
      gpaLabel = new JLabel("GPA: ");
      gradeLabel = new JLabel("Grade(9-12):");
      //Teacher Label
      tNameLabel = new JLabel("Name: ");
      tAgeLabel = new JLabel("Age: ");
      tSalaryLabel = new JLabel("Salary/yr: ");
      tSubLabel = new JLabel("Subject:");

      selectedFileField = new JTextField(20);
      selectedFileField.setEditable(false);
      selectedFileField.setText("...");
      //teacher average age text box
      tAvgAgeField = new JTextField(15);
      tAvgAgeField.setEditable(false);
      tAvgAgeField.setText("0");
      
      //teacher average salary text box
      tAvgSalaryField = new JTextField(20);
      tAvgSalaryField.setEditable(false);
      tAvgSalaryField.setText("0");
      
      //teacher standard Deviation salary text box
      tSDSalaryField = new JTextField(20);
      tSDSalaryField.setEditable(false);
      tSDSalaryField.setText("0");
      
      //teacher standard Deviation age text box
      tSDAgeField = new JTextField(20);
      tSDAgeField.setEditable(false);
      tSDAgeField.setText("0");
      
      //student average age text box
      SAvgAgeField = new JTextField(15);
      SAvgAgeField.setEditable(false);
      SAvgAgeField.setText("0");
      
      //student average grade text box
      SAvgGradeField = new JTextField(10);
      SAvgGradeField.setEditable(false);
      SAvgGradeField.setText("0");
      
      //student SD grade text box
      stuSDGradeField = new JTextField(10);
      stuSDGradeField.setEditable(false);
      stuSDGradeField.setText("0");
      
      //student SD age text box
      stuSDAgeField = new JTextField(10);
      stuSDAgeField.setEditable(false);
      stuSDAgeField.setText("0");
      
      //student text
      nameField = new JTextField(20);
      nameField.setEditable(true);
      nameField.setText("");
      nameField.addActionListener(this);
      
      ageField = new JTextField(5);
      ageField.setEditable(true);
      ageField.setText("0");
      ageField.addActionListener(this);
      
      gpaField = new JTextField(5);
      gpaField.setEditable(true);
      gpaField.setText("0");
      gpaField.addActionListener(this);
      
      gradeField = new JTextField(5);
      gradeField.setEditable(true);
      gradeField.setText("0");
      gradeField.addActionListener(this);
      
      //teacher text
      tNameField = new JTextField(20);
      tNameField.setEditable(true);
      tNameField.setText("");
      tNameField.addActionListener(this);
      
      tAgeField = new JTextField(5);
      tAgeField.setEditable(true);
      tAgeField.setText("0");
      tAgeField.addActionListener(this);
      
      tSalaryField = new JTextField(10);
      tSalaryField.setEditable(true);
      tSalaryField.setText("0");
      tSalaryField.addActionListener(this);
      
      tSubField = new JTextField(20);
      tSubField.setEditable(true);
      tSubField.setText("");
      tSubField.addActionListener(this);

      outputArea = new JTextArea(10, 25);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);
      student= new JButton("student");  
      student.addActionListener(this);
      teacher= new JButton("teacher");
      teacher.addActionListener(this);
      search=new JButton("search");
      search.addActionListener(this);  
      reset=new JButton("Reset");
      reset.addActionListener(this);
      target=new JTextField(15);
      target.setEditable(true);
      target.setText("");
      //target.setColumns(15);
      addStudent = new JButton("Add Student"); // student button
      addStudent.addActionListener(this);
      
      addTeacher = new JButton("Add Teacher"); // teacher button
      addTeacher.addActionListener(this);
      tAvgAge = new JButton("Teacher Avg. Age"); // teacher average age button
      tAvgAge.addActionListener(this);
      tAvgSalary = new JButton("Teacher Avg. Salary"); // teacher average salary button
      tAvgSalary.addActionListener(this);
      SAvgAge = new JButton("Student Avg. Age"); // student average age button
      SAvgAge.addActionListener(this);
      SAvgGrade = new JButton("Student Avg. Grade"); // student average grade button
      SAvgGrade.addActionListener(this);
      //SD button 
      tSDAge = new JButton("Teacher Standard Dev. Age"); // teacher SD age button
      tSDAge.addActionListener(this);
      tSDSalary = new JButton("Teacher Standard Dev. Salary"); // teacher SD salary button
      tSDSalary.addActionListener(this);
      studentSDAge = new JButton("Student Standard Dev. Age"); // student SD age button
      studentSDAge.addActionListener(this);
      StudentSDGrade = new JButton("Student Standard Dev. Grade"); // student SD grade button
      StudentSDGrade.addActionListener(this);
      
      
      
      clearStudent = new JButton("Clear"); //clear button
      clearTeacher = new JButton("Clear");
      clearMainBox = new JButton("Clear");
      clearStudent.addActionListener(this);
      clearTeacher.addActionListener(this);
      clearMainBox.addActionListener(this);
      
      fileChooser = new JFileChooser();

      // Add components using GridBagLayout
      setLayout(new GridBagLayout());
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 10;
      add(sortStudent, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 10;
      add(sortTea, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 9;
      add(sortButton, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 10;
      add(revert, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 1;
      add(search, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 1;
      add(target, layoutConst);
      //student button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(student, layoutConst);
      //teacher button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      add(teacher, layoutConst);
      //file field
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 5, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(selectedFileLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.LINE_END;
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 2;
      layoutConst.gridheight = 1;
      add(selectedFileField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(outputLabel, layoutConst);
      //main text box
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 10;
      layoutConst.gridheight = 2;
      layoutConst.gridwidth = 5;
      add(scrollPane, layoutConst);
      //clear Main Box Button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 11;
      add(clearMainBox, layoutConst);
      //reset Button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.gridx = 1;
      layoutConst.gridy = 11;
      add(reset, layoutConst);
      
      //add student button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(addStudent, layoutConst);
      // clear student button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      add(clearStudent, layoutConst);
      
      //add teacher button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 6;
      add(addTeacher, layoutConst);
      //clear teacher button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 6;
      add(clearTeacher, layoutConst);
      //teacher average age/salary text/button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 6;
      add(tAvgAge, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 5;
      layoutConst.gridy = 6;
      layoutConst.insets = new Insets(2,2,2,2);
      add(tAvgAgeField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 7;
      add(tAvgSalary, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.gridx = 5;
      layoutConst.gridy = 7;
      add(tAvgSalaryField, layoutConst);
      //teacher standard deviation location
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 8;
      add(tSDAge, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 5;
      layoutConst.gridy = 8;
      layoutConst.insets = new Insets(2,2,2,2);
      add(tSDAgeField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 9;
      add(tSDSalary, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.gridx = 5;
      layoutConst.gridy = 9;
      add(tSDSalaryField, layoutConst);
      
      //student average age/grade text/button
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 8;
      add(SAvgAge, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 6;
      layoutConst.gridy = 8;
      layoutConst.insets = new Insets(2,2,2,2);
      add(SAvgAgeField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 9;
      add(SAvgGrade, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.gridx = 6;
      layoutConst.gridy = 9;
      add(SAvgGradeField, layoutConst);
      
      //student SD locations
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 10;
      add(studentSDAge, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 6;
      layoutConst.gridy = 10;
      layoutConst.insets = new Insets(2,2,2,2);
      add(stuSDAgeField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 11;
      add(StudentSDGrade, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.gridx = 6;
      layoutConst.gridy = 11;
      add(stuSDGradeField, layoutConst);
      
      /////Student 
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(nameLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      layoutConst.insets = new Insets(2,2,2,2);
      add(nameField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 2;
      layoutConst.gridy = 2;
      add(ageLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 3;
      layoutConst.gridy = 2;
      layoutConst.insets = new Insets(2,2,2,2);
      add(ageField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 4;
      layoutConst.gridy = 2;
      add(gpaLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 5;
      layoutConst.gridy = 2;
      layoutConst.insets = new Insets(2,2,2,2);
      add(gpaField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 6;
      layoutConst.gridy = 2;
      add(gradeLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 7;
      layoutConst.gridy = 2;
      layoutConst.insets = new Insets(2,2,2,2);
      add(gradeField, layoutConst);
      
      //////Teacher
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.fill = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 5;
      add(tNameLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 5;
      layoutConst.insets = new Insets(2,2,2,2);
      add(tNameField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 2;
      layoutConst.gridy = 5;
      add(tAgeLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 3;
      layoutConst.gridy = 5;
      layoutConst.insets = new Insets(2,2,2,2);
      add(tAgeField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 4;
      layoutConst.gridy = 5;
      add(tSalaryLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 5;
      layoutConst.gridy = 5;
      layoutConst.insets = new Insets(2,2,2,2);
      add(tSalaryField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(2,2,2,2);
      layoutConst.gridx = 6;
      layoutConst.gridy = 5;
      add(tSubLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 7;
      layoutConst.gridy = 5;
      layoutConst.insets = new Insets(2,2,2,2);
      add(tSubField, layoutConst);
      //initialize all teacher labels to be invisible for cleanliness
          sortStudent.setVisible(false);
          sortTea.setVisible(false);
          sortButton.setVisible(false);
          revert.setVisible(false);
          addTeacher.setVisible(false);
          tNameLabel.setVisible(false);
          tNameField.setVisible(false);
          tAgeLabel.setVisible(false);
          tAgeField.setVisible(false);
          tSalaryLabel.setVisible(false);
          tSalaryField.setVisible(false);
          tSubLabel.setVisible(false);
          tSubField.setVisible(false);
          clearTeacher.setVisible(false);
          tAvgSalary.setVisible(false);
          tAvgSalaryField.setVisible(false);
          tAvgAge.setVisible(false);
          tAvgAgeField.setVisible(false);
          tSDSalary.setVisible(false);
          tSDSalaryField.setVisible(false);
          tSDAge.setVisible(false);
          tSDAgeField.setVisible(false);
          //initialize all student labels to be invisible for cleanliness
          addStudent.setVisible(false);
          nameLabel.setVisible(false);
          nameField.setVisible(false);
          ageLabel.setVisible(false);
          ageField.setVisible(false);
          gpaLabel.setVisible(false);
          gpaField.setVisible(false);
          gradeLabel.setVisible(false);
          gradeField.setVisible(false);
          clearStudent.setVisible(false);
          SAvgGrade.setVisible(false);
          SAvgGradeField.setVisible(false);
          SAvgAge.setVisible(false);
          SAvgAgeField.setVisible(false);
          StudentSDGrade.setVisible(false);
          stuSDGradeField.setVisible(false);
          studentSDAge.setVisible(false);
          stuSDAgeField.setVisible(false);
          
      
   }

   /* Called when openFileButton is pressed. */
   @Override
   public void actionPerformed(ActionEvent event) {
       //student button
       if(event.getSource()==student){
          playSound(boxing);
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          setBounds(0,0,screenSize.width, screenSize.height);
          teacher.setVisible(false);
          addStudent.setVisible(true);
          nameLabel.setVisible(true);
          nameField.setVisible(true);
          ageLabel.setVisible(true);
          ageField.setVisible(true);
          gpaLabel.setVisible(true);
          gpaField.setVisible(true);
          gradeLabel.setVisible(true);
          gradeField.setVisible(true);
          clearStudent.setVisible(true);
          SAvgGrade.setVisible(true);
          SAvgGradeField.setVisible(true);
          SAvgAge.setVisible(true);
          SAvgAgeField.setVisible(true);
          StudentSDGrade.setVisible(true);
          stuSDGradeField.setVisible(true);
          studentSDAge.setVisible(true);
          stuSDAgeField.setVisible(true);
          sortStudent.setVisible(true);
          sortButton.setVisible(true);
          revert.setVisible(true);
          
          stuMode=true;
          BufferedReader readBuffer = null; // File input stream
          Scanner inFS = null;                   // Scanner object
          String readLine;                       // Input from file
          File readFile = null;                  // Input file
          int fileChooserVal;                    // File chooser
          
          // Open file chooser dialog and get the file to open
          fileChooserVal = fileChooser.showOpenDialog(this);
    
          // Check if file was selected
          if (fileChooserVal == JFileChooser.APPROVE_OPTION) {
             readFile = fileChooser.getSelectedFile();
             
             // Update selected file field
             selectedFileField.setText(readFile.getName());
             
             // Ensure file is valid
             if (readFile.canRead()) {
                try {
                   readBuffer = new BufferedReader(new FileReader(readFile));
                   //inFS = new Scanner(fileByteStream);
                   readBuffer.readLine();
                   // Clear output area
                   outputArea.setText(""); 
                   while ((readLine=readBuffer.readLine())!=null) {
                      studentData studentObj=new studentData(
                      (CSVtoArrayList(readLine).get(0)),Integer.parseInt
                      (CSVtoArrayList(readLine).get(1)),Double.parseDouble
                      (CSVtoArrayList(readLine).get(2)),Integer.parseInt
                      (CSVtoArrayList(readLine).get(3)));
                      sData.add(studentObj);
                      outputArea.append(readLine + "\n");
                      outputArea.append("\n");
                   }


                } catch (IOException e) {
                   outputArea.append("\n\nError occurred while creating file stream! " + e.getMessage());
                }
             }
             else { // Can't read file
                // Show failure dialog
                JOptionPane.showMessageDialog(this, "Can't read file!");
             }
          }
       }
       
       //teacher button
       if(event.getSource()==teacher){
          playSound(boxing);
           //once teacher is click by the user, options for the student will disappear
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          setBounds(0,0,screenSize.width, screenSize.height);
          student.setVisible(false);
          addTeacher.setVisible(true);
          tNameLabel.setVisible(true);
          tNameField.setVisible(true);
          tAgeLabel.setVisible(true);
          tAgeField.setVisible(true);
          tSalaryLabel.setVisible(true);
          tSalaryField.setVisible(true);
          tSubLabel.setVisible(true);
          tSubField.setVisible(true);
          clearTeacher.setVisible(true);
          tAvgSalary.setVisible(true);
          tAvgSalaryField.setVisible(true);
          tAvgAge.setVisible(true);
          tAvgAgeField.setVisible(true);
          tSDSalary.setVisible(true);
          tSDSalaryField.setVisible(true);
          tSDAge.setVisible(true);
          tSDAgeField.setVisible(true);
          sortTea.setVisible(true);
          revert.setVisible(true);
          sortButton.setVisible(true);
          
          teaMode=true;
          BufferedReader readBuffer = null; // File input stream
          Scanner inFS = null;                   // Scanner object
          String readLine;                       // Input from file
          File readFile = null;                  // Input file
          int fileChooserVal;                    // File chooser
          
          // Open file chooser dialog and get the file to open
          fileChooserVal = fileChooser.showOpenDialog(this);
    
          // Check if file was selected
          if (fileChooserVal == JFileChooser.APPROVE_OPTION) {
             readFile = fileChooser.getSelectedFile();
             
             // Update selected file field
             selectedFileField.setText(readFile.getName());
             
             // Ensure file is valid
             if (readFile.canRead()) {
                try {
                   readBuffer = new BufferedReader(new FileReader(readFile));
                   //inFS = new Scanner(fileByteStream);
                   readBuffer.readLine();
                   // Clear output area
                   outputArea.setText(""); 
                   while ((readLine=readBuffer.readLine())!=null) {
                      teacherData teacherObj=new teacherData(
                      (CSVtoArrayList(readLine).get(0)),Integer.parseInt
                      (CSVtoArrayList(readLine).get(1)),Integer.parseInt
                      (CSVtoArrayList(readLine).get(2)),
                      (CSVtoArrayList(readLine).get(3)));
                      tData.add(teacherObj);
                      outputArea.append(readLine + "\n");
                      outputArea.append("\n");
                   }


                } catch (IOException e) {
                   outputArea.append("\n\nError occurred while creating file stream! " + e.getMessage());
                }
             }
             else { // Can't read file
                // Show failure dialog
                JOptionPane.showMessageDialog(this, "Can't read file!");
             }
          }
       }
       //rest button
       if(event.getSource()==reset){
          sortStudent.setVisible(false);
          sortTea.setVisible(false);
          sortButton.setVisible(false);
          revert.setVisible(false);
          addTeacher.setVisible(false);
          tNameLabel.setVisible(false);
          tNameField.setVisible(false);
          tAgeLabel.setVisible(false);
          tAgeField.setVisible(false);
          tSalaryLabel.setVisible(false);
          tSalaryField.setVisible(false);
          tSubLabel.setVisible(false);
          tSubField.setVisible(false);
          clearTeacher.setVisible(false);
          tAvgSalary.setVisible(false);
          tAvgSalaryField.setVisible(false);
          tAvgAge.setVisible(false);
          tAvgAgeField.setVisible(false);
          tSDSalary.setVisible(false);
          tSDSalaryField.setVisible(false);
          tSDAge.setVisible(false);
          tSDAgeField.setVisible(false);
          //initialize all student labels to be invisible for cleanliness
          addStudent.setVisible(false);
          nameLabel.setVisible(false);
          nameField.setVisible(false);
          ageLabel.setVisible(false);
          ageField.setVisible(false);
          gpaLabel.setVisible(false);
          gpaField.setVisible(false);
          gradeLabel.setVisible(false);
          gradeField.setVisible(false);
          clearStudent.setVisible(false);
          SAvgGrade.setVisible(false);
          SAvgGradeField.setVisible(false);
          SAvgAge.setVisible(false);
          SAvgAgeField.setVisible(false);
          StudentSDGrade.setVisible(false);
          stuSDGradeField.setVisible(false);
          studentSDAge.setVisible(false);
          stuSDAgeField.setVisible(false);
          student.setVisible(true);
          teacher.setVisible(true);
          stuMode=false;
          teaMode=false;
       }
           
       //sorting button
       if(event.getSource()==sortButton){
           outputArea.setText(" ");
           if(sortStudent.getSelectedItem()=="Name"){
               Collections.sort(sData,new SortName());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
               
           }
           if(sortStudent.getSelectedItem()=="Age"){
               Collections.sort(sData, new SortAge());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortStudent.getSelectedItem()=="GPA"){
               Collections.sort(sData, new SortGPA());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortStudent.getSelectedItem()=="Grade"){
               Collections.sort(sData, new SortGrade());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortTea.getSelectedItem()=="Name"){
               Collections.sort(tData,new SortTName());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
               
           }
           if(sortTea.getSelectedItem()=="Age"){
               Collections.sort(tData, new SortTAge());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortTea.getSelectedItem()=="Salary"){
               Collections.sort(tData, new SortSalary());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortTea.getSelectedItem()=="Subject"){
               Collections.sort(tData, new SortSubject());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
       }
       if(event.getSource()==revert){
           outputArea.setText(" ");
           if(sortStudent.getSelectedItem()=="Name"){
               Collections.sort(sData,new SortName().reversed());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
               
           }
           if(sortStudent.getSelectedItem()=="Age"){
               Collections.sort(sData, new SortAge().reversed());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortStudent.getSelectedItem()=="GPA"){
               Collections.sort(sData, new SortGPA().reversed());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortStudent.getSelectedItem()=="Grade"){
               Collections.sort(sData, new SortGrade().reversed());
               for(int i=0; i<sData.size(); i++){
                   outputArea.append(sData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortTea.getSelectedItem()=="Name"){
               Collections.sort(tData,new SortTName().reversed());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
               
           }
           if(sortTea.getSelectedItem()=="Age"){
               Collections.sort(tData, new SortTAge().reversed());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortTea.getSelectedItem()=="Salary"){
               Collections.sort(tData, new SortSalary().reversed());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
           if(sortTea.getSelectedItem()=="Subject"){
               Collections.sort(tData, new SortSubject().reversed());
               for(int i=0; i<tData.size(); i++){
                   outputArea.append(tData.get(i).toString()+"\n");
                   outputArea.append("\n");
               }
           }
       }
           
           
       //search button
       if(event.getSource()==search){
           playSound(boxing);
           outputArea.setText(" ");
           if(stuMode==true){
               
               studentSearching(sData,target.getText());
               
           }
           if(teaMode==true){
               
               teacherSearching(tData,target.getText());
               
           }
           
       
       }
       if(event.getSource()==addStudent){
           // The name of the file to open.
                    String fileName = selectedFileField.getText();    
                    try {
                        playSound(applause);
                        // Assume default encoding.
                        FileWriter fileWriter =
                            new FileWriter(fileName, true);

                        // Always wrap FileWriter in BufferedWriter.
                        BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);

                        bufferedWriter.write(nameField.getText());
                        bufferedWriter.write(",");
                        bufferedWriter.write(ageField.getText());
                        bufferedWriter.write(",");
                        bufferedWriter.write(gpaField.getText());
                        bufferedWriter.write(",");
                        bufferedWriter.write(gradeField.getText());
                        bufferedWriter.write("\n");
                        // Always close files.
                        bufferedWriter.close();
                        outputArea.append("Added Student To "+ fileName+"\n");
                    }
                    catch(IOException ex) {
                        outputArea.append(
                            "Error writing to file '"
                            + fileName + "' Make sure your file is selected\n");
                    }
           
        }
        // when clear buttons are click
        if(event.getSource()==clearStudent){  
            playSound(blip); //sound method
            nameField.setText("");
            ageField.setText("0");
            gpaField.setText("0");
            gradeField.setText("0");
            SAvgGradeField.setText("0");
            SAvgAgeField.setText("0");
            stuSDGradeField.setText("0");
            stuSDAgeField.setText("0");
        }
        if(event.getSource()==clearTeacher){
            playSound(blip); //sound method
            tNameField.setText("");
            tAgeField.setText("0");
            tSalaryField.setText("0");
            tSubField.setText(" ");
            tAvgSalaryField.setText("0");
            tAvgAgeField.setText("0");
            tSDSalaryField.setText("0");
            tSDAgeField.setText("0");
        }
        if(event.getSource()==clearMainBox){
            playSound(blip); 
            outputArea.setText(" ");
        }
       
       
       if(event.getSource()==addTeacher){
           // The name of the file to open.
                    String fileName = selectedFileField.getText();    
                    try {
                        playSound(applause);
                        // default encoding.
                        FileWriter fileWriter =
                            new FileWriter(fileName, true);

                        // wrap FileWriter in BufferedWriter.
                        BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);

                        bufferedWriter.write(tNameField.getText());
                        bufferedWriter.write(",");
                        bufferedWriter.write(tAgeField.getText());
                        bufferedWriter.write(",");
                        bufferedWriter.write(tSalaryField.getText());
                        bufferedWriter.write(",");
                        bufferedWriter.write(tSubField.getText());
                        bufferedWriter.write("\n");
                        //close files.
                        bufferedWriter.close();
                        outputArea.append("Added Teacher To "+ fileName+"\n");
                    }
                    catch(IOException ex) {
                        outputArea.append(
                            "Error writing to file '"
                            + fileName + "' Make sure your file is selected\n");
                        
                    }
       }
       //when teacher averages are click
       if(event.getSource()==tAvgAge){
           playSound(gong);
           tAvgAgeField.setText(Integer.toString(teacherAgeAverage(tData)));
        }
        if(event.getSource()==tAvgSalary){
            playSound(gong);
           tAvgSalaryField.setText(teacherSalAverage(tData));
        }
        //when teacher standard deviation are click
        if(event.getSource()==tSDAge){
           playSound(gong);
           tSDAgeField.setText(teachSDAge(tData));
        }
        if(event.getSource()==tSDSalary){
            playSound(gong);
           tSDSalaryField.setText(teachSDSalary(tData));
        }
        //student averages
        if(event.getSource()==SAvgAge){
            playSound(gong);
           SAvgAgeField.setText(Integer.toString(studentAgeAverage(sData)));
        }
        if(event.getSource()==SAvgGrade){
            playSound(gong);
           SAvgGradeField.setText(Integer.toString(studentGradeAverage(sData)));
        }
        //student Standard Deviation
        if(event.getSource()==studentSDAge){
            playSound(gong);
           stuSDAgeField.setText(stuSDAge(sData));
        }
        if(event.getSource()==StudentSDGrade){
            playSound(gong);
           stuSDGradeField.setText(stuSDGrade(sData));
        }
        //reset everything
        if(event.getSource()==reset){
            playSound(blip);
           
        }
        
   }
   //sound method
   public static void playSound(File Sound) {
        
        try {
            //creating object
            Clip minute = AudioSystem.getClip();
            //read the sound file
            minute.open(AudioSystem.getAudioInputStream(Sound));
            minute.start();
            Thread.sleep(1000); //delay time
            minute.stop();
        }
        catch (Exception e ) 
        {
            //does not need message here 
        }
    }
    /**
    * adopted from Crunchify.com
    * 
    */
   public static ArrayList<String> CSVtoArrayList(String CSVFileName) {
        
        //TO DO: ensure this arraylist can handle integers, not only strings
        ArrayList<String> arrlist = new ArrayList<String>();
        
        
        if (CSVFileName != null) {
            String[] splitData = CSVFileName.split("\\,", -1); //the -1 helps handle the null values
            
            for (int i = 0; i < splitData.length; i++) {
                //if it is null, replace it with a 0
                if (splitData[i].length() == 0) {
                    splitData[i] = "0";
                }
                //as long as it is not null and the length is not 0, trim the value and add it to the arraylist
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    arrlist.add(splitData[i].trim());
                }
            }
         }
     return arrlist;
   }
   //Gernerics for searching method for student
   public <TheType extends Comparable<TheType>> void studentSearching(ArrayList<studentData> data
   , TheType target){
       boolean found=false;
       String info;
       for(studentData i: data){
           if(target.compareTo((TheType)i.name)==0){
               info=String.format("%s %-35s %-7s %5s %25s %10s %30s %8s","Name:",i.name,"Age:", i.age.toString(), "GPA:",i.gpa.toString(),"Grade:",i.grade.toString());
               found=true;
               outputArea.append(info+"\n");
           }

           else if(target.compareTo((TheType)i.age.toString())==0){
               info=String.format("%s %-35s %-7s %5s %25s %10s %30s %8s","Name:",i.name,"Age:", i.age.toString(), "GPA:",i.gpa.toString(),"Grade:",i.grade.toString());
               found=true;
               outputArea.append(info+"\n");
           }
           else if(target.compareTo((TheType)i.gpa.toString())==0){
               info=String.format("%s %-35s %-7s %5s %25s %10s %30s %8s","Name:",i.name,"Age:", i.age.toString(), "GPA:",i.gpa.toString(),"Grade:",i.grade.toString());
               found=true;
               outputArea.append(info+"\n");
           }
           else if(target.compareTo((TheType)i.grade.toString())==0){
               info=String.format("%s %-35s %-7s %5s %25s %10s %30s %8s","Name:",i.name,"Age:", i.age.toString(), "GPA:",i.gpa.toString(),"Grade:",i.grade.toString());
               found=true;
               outputArea.append(info+"\n");
           }
       }
       if(found==false){
           outputArea.append("Not Found");
       }
   }
   //teacher average methods
   public int teacherAgeAverage(ArrayList<teacherData> data){
        int average = 0;
        int age = 0;
        int count = 0;
        for (teacherData i: data){ //loop through data
            age += i.age;
            count ++;
        }
        average = age/count;
        return average;
    }
    public String teacherSalAverage(ArrayList<teacherData> data){
        double average = 0.0;
        int salary = 0;
        int count = 0;
        for (teacherData i: data){ //loop through data
            salary += i.salary;
            count ++;
        }
        average = (double)salary/count;
        return String.format("%.2f", average);
    }
    //student average methods
    public int studentAgeAverage(ArrayList<studentData> data){
        int average = 0;
        int age = 0;
        int count = 0;
        for (studentData i: data){ //loop through data
            age += i.age;
            count ++;
        }
        average = age/count;
        return average;
    }
    public int studentGradeAverage(ArrayList<studentData> data){
        int average = 0;
        int grade = 0;
        int count = 0;
        for (studentData i: data){ //loop through data
            grade += i.grade;
            count ++;
        }
        average = grade/count;
        return average;
    }
    //student standard deviation methods
    public String stuSDGrade(ArrayList<studentData> data)
    {
        int mean = studentGradeAverage(sData);
        double SD = 0;
        int count = 0;
        for (studentData i: data){ //loop through data
            count ++;
        }
        for(studentData i: data) {
            SD += Math.pow(i.grade - mean, 2);
        }

        return String.format("%.2f", Math.sqrt(SD/count));
    }
    public String stuSDAge(ArrayList<studentData> data){
        int mean = studentAgeAverage(sData);
        double SD = 0;
        int count = 0;
        for (studentData i: data){ //loop through data
            count ++;
        }
        for(studentData i: data) {
            SD += Math.pow(i.age - mean, 2);
        }

        return String.format("%.2f", Math.sqrt(SD/count));
    }
    //teacher standard deviation methods
    public String teachSDAge(ArrayList<teacherData> data)
    {
        int mean = teacherAgeAverage(tData);
        double SD = 0;
        int count = 0;
        for (teacherData i: data){ //loop through data
            count ++;
        }
        for(teacherData i: data) {
            SD += Math.pow(i.age - mean, 2);
        }

        return String.format("%.2f", Math.sqrt(SD/count));
    }
    public String teachSDSalary(ArrayList<teacherData> data){
        double mean = Double.parseDouble(teacherSalAverage(tData));
        double SD = 0;
        int count = 0;
        for (teacherData i: data){ //loop through data
            count ++;
        }
        for(teacherData i: data) {
            SD += Math.pow(i.salary - mean, 2);
        }

        return String.format("%.2f", Math.sqrt(SD/count));
    }
    //Generics searching method for teacher
   public <TheType extends Comparable<TheType>> void teacherSearching(ArrayList<teacherData> data
   , TheType target){
       boolean found=false;
       String info;
       for(teacherData i: data){
           if(target.compareTo((TheType)i.name)==0){
               info=String.format("%s %-35s %-7s %5s %15s %10s %20s %8s","Name:",i.name,"Age:", i.age.toString(), "Salary:",i.salary.toString(),"Subject:",i.subject.toString());
               found=true;
               outputArea.append(info+"\n");
           }

           if(target.compareTo((TheType)i.age.toString())==0){
                info=String.format("%s %-35s %-7s %5s %15s %10s %20s %8s","Name:",i.name,"Age:", i.age.toString(), "Salary:",i.salary.toString(),"Subject:",i.subject.toString());
               found=true;
               outputArea.append(info+"\n");
           }
           if(target.compareTo((TheType)i.salary.toString())==0){
                info=String.format("%s %-35s %-7s %5s %15s %10s %20s %8s","Name:",i.name,"Age:", i.age.toString(), "Salary:",i.salary.toString(),"Subject:",i.subject.toString());
               found=true;
               outputArea.append(info+"\n");
           }
           if(target.compareTo((TheType)i.subject)==0){
               info=String.format("%s %-35s %-7s %5s %15s %10s %20s %8s","Name:",i.name,"Age:", i.age.toString(), "Salary:",i.salary.toString(),"Subject:",i.subject.toString());
               found=true;
               outputArea.append(info+"\n");
           }

       }
       if(found==false){
           outputArea.append("Not Found");
       }
   }
}