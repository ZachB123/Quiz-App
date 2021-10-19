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
public class RadioQuestion extends JPanel implements Question
{
	
	private JLabel question;
	private int answer; //index of correct answer
	private int questionNumber; //displayed at top of screen
	
	private ArrayList<JRadioButton> buttons;
	private ButtonGroup group;
	
	
	RadioQuestion()
	{
		questionNumber = 0;
		buttons = new ArrayList<>();
		group = new ButtonGroup();
		question = new JLabel();
	}
	
	public boolean isCorrect()
	{
		if(buttons.get(answer).isSelected())
		{
			return true;
		}
		return false;
	}

	
	public void setQuestion(String question) 
	{
		this.question.setText(question);
	}
	
	public void addChoice(String choice, boolean isCorrect)
	{
		buttons.add(new JRadioButton(choice));
		group.add(buttons.get(buttons.size()-1));
		if(isCorrect)
		{
			answer = buttons.size() - 1;
		}
	}
	
	public void setQuestionNumber(int num)
	{
		questionNumber = num;
	}
	
	public void createPanel()
	{
		
		String title = "Question " + questionNumber;
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new EtchedBorder(), title));
		
		add(question, BorderLayout.NORTH);
		
		JPanel button = new JPanel();
		for(int i = 0; i < buttons.size(); i++)
		{
			button.add(buttons.get(i));
		}
		add(button, BorderLayout.CENTER);
	}

}
