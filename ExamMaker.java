
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ExamMaker {
	static int page = 0;
	static JPanel panel2;
	static JLabel score;
	public static void main(String[] args) {
		
	RadioQuestion q1 = new RadioQuestion();
	q1.setQuestionNumber(1);
	q1.setQuestion("How many feet does a dog have?");
	q1.addChoice("1", false);
	q1.addChoice("2", false);
	q1.addChoice("3", false);
	q1.addChoice("4", true);
	q1.createPanel();
	
	RadioQuestion q2 = new RadioQuestion();
	q2.setQuestionNumber(2);
	q2.setQuestion("What color is the sky?");
	q2.addChoice("Jupiter", false);
	q2.addChoice("Blue", true);
	q2.addChoice("Boat", false);
	q2.addChoice("Brown", false);
	q2.createPanel();
	
	CheckQuestion q3 = new CheckQuestion();
	q3.setQuestionNumber(3);
	q3.setQuestion("x^2 = 1");
	q3.addChoice("0", false);
	q3.addChoice("-1", true);
	q3.addChoice("1", true);
	q3.addChoice("2", false);
	q3.createPanel();
	
	CheckQuestion q4 = new CheckQuestion();
	q4.setQuestionNumber(4);
	q4.setQuestion("West High Colors");
	q4.addChoice("Orange", false);
	q4.addChoice("Green", true);
	q4.addChoice("Red", false);
	q4.addChoice("Yellow", true);
	q4.createPanel();
	
	TextQuestion q5 = new TextQuestion();
	q5.setQuestionNumber(5);
	q5.setQuestion("What year was Zach born?");
	q5.setAnswer("2005");
	q5.createPanel();
	
	TextQuestion q6 = new TextQuestion();
	q6.setQuestionNumber(6);
	q6.setQuestion("What day of the month is Zach's Birthday");
	q6.setAnswer("7");
	q6.setAnswer("seven");
	q6.createPanel();
	
	RadioQuestion q7 = new RadioQuestion();
	q7.setQuestionNumber(7);
	q7.setQuestion("How much wood could a woodchuck chuck \nif a woodchuck could chuck wood");
	q7.addChoice("3", false);
	q7.addChoice("17", false);
	q7.addChoice("12", false);
	q7.addChoice("A woodchuck could chuck as much as a \nwoodchuck could chuck if a woodchuck\n could chuck wood", true);
	q7.createPanel();
	
	
	
	ArrayList<Question> questions = new ArrayList<>();
	questions.add(q1);
	questions.add(q2);
	questions.add(q3);
	questions.add(q4);
	questions.add(q5);
	questions.add(q6);
	questions.add(q7);
	
	
	
		
	JFrame frame = new JFrame();
	frame.setSize(400, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	
	JButton backward = new JButton("Previous Question");
	JButton forward = new JButton("Next Question");
	
	backward.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
		if(page > 0)
		{
			((Component) questions.get(page)).setVisible(false);
			page--;
			panel.add((Component) questions.get(page), BorderLayout.CENTER);
			((Component) questions.get(page)).setVisible(true);

		}
		
		frame.setVisible(true);
		}
	});
	
	forward.addActionListener((ActionEvent event) -> {
		if(page < questions.size() - 1)
		{
			((Component) questions.get(page)).setVisible(false);
			page++;
			panel.add((Component) questions.get(page), BorderLayout.CENTER);
			((Component) questions.get(page)).setVisible(true);

		}
		else
		{
			panel.setVisible(false);
			panel2 = new JPanel();
			score = new JLabel();
			int scor = getScore(questions);
			score.setText("Score: " + scor + " out of " + questions.size());
			score.setFont(new Font("", Font.PLAIN, 40));
			panel2.setLayout(new BorderLayout());
			panel2.add(score, BorderLayout.CENTER);
			frame.add(panel2);
		}
		frame.setVisible(true);
	});		
	
	JPanel buttons = new JPanel();
	buttons.setLayout(new GridLayout(1, 2));
	buttons.add(backward);
	buttons.add(forward);
	
	panel.add(buttons, BorderLayout.SOUTH);
	
	panel.add(q1, BorderLayout.CENTER);
	
	
			
	frame.add(panel);
	frame.setVisible(true);
	}
	
	public static int getScore(ArrayList<Question> questions)
	{
		int correct = 0;
		for(int i = 0; i < questions.size(); i++)
		{
			if(questions.get(i).isCorrect())
				correct++;
		}
		return correct;
	}
}
