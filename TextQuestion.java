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
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/*
 * isCorrect
 * setQuestion
 * addChoice
 * setQuestionNumber
 * createPanel
 */
public class TextQuestion extends JPanel implements Question
{
	
	private JLabel question = new JLabel();
	private JTextField answerField = new JTextField(15);
	private ArrayList<String> choices = new ArrayList<>();
	
	private int questionNumber = 0;
	private String answer;
	private JPanel panel = new JPanel();
	
	public void createPanel()
	{
		String title = "Question " + questionNumber;
		
		setBorder(new TitledBorder(new EtchedBorder(), title));
		add(question);
		add(answerField);
	}
	
	public boolean isCorrect()
	{
		for(int i = 0; i < choices.size(); i++)
		{
			if(answerField.getText().equalsIgnoreCase(choices.get(i)))
			return true;
		}
		return false;
	}
	
	public void setAnswer(String answer)
	{
		choices.add(answer);
	}
	
	public void addChoice(String choice)
	{
		choices.add(choice);
	}
	
	public void setQuestion(String question)
	{
		this.question.setText(question);
	}
	
	public void setQuestionNumber(int num)
	{
		questionNumber = num;
	}

}
