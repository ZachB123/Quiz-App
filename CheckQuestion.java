import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

/*
 * isCorrect
 * setQuestion
 * addChoice
 * setQuestionNumber
 * createPanel
 */
public class CheckQuestion extends JPanel implements Question
{

	private ArrayList<JCheckBox> choices = new ArrayList<>();
	private ArrayList<Integer> correctAnswers = new ArrayList<>();
	private JPanel panel = new JPanel();
	
	private int questionNumber = 0;
	private JLabel question = new JLabel();
	
	public void createPanel()
	{
		String title = "Question " + questionNumber;
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new EtchedBorder(), title));
		add(question, BorderLayout.NORTH);
		for(int i = 0; i < choices.size(); i++)
		{
			panel.add(choices.get(i));
		}
		add(panel, BorderLayout.CENTER);
	}
	
	public boolean isCorrect()
	{
		for(int i = 0; i < correctAnswers.size(); i++)
		{
			if(!(choices.get(correctAnswers.get(i)).isSelected()))
			{
				return false;
			}
		}
		return true;
	}
	
	public void addChoice(String choice, boolean correct)
	{
		choices.add(new JCheckBox(choice));
		if(correct)
		{
			correctAnswers.add(choices.size()-1);
		}
	}
	
	public void setQuestionNumber(int num)
	{
		questionNumber = num;
	}
	
	public void setQuestion(String question)
	{
		this.question.setText(question);
	}
	

}
