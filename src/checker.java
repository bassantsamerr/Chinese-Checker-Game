import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class checker extends JFrame {

    private JPanel contentPane;
    private static JTextPane textPane;
    private static JTextField textField;
    private static JLabel turnLabel;
    private static JTextPane admin;
    static int x,y;
    private static boolean wait;

    /**
     * Launch the application.
     */

    public static void display(int rows, int columns, int[][] board)
    {
        String displayBoard = "";
        for (int i = 0; i < rows; i++)
        {
            for(int j=0;j<columns;j++) {
                if (board[i][j]!=-1)
                {
                    displayBoard+= board[i][j];
                }
                else displayBoard+=" ";
            }
            displayBoard += "\n";
        }
        textPane.setText(displayBoard);
    }


    public static void play(Board b, alphaBetaPlayer c) {
        while(b.isWin()==-1){
            wait = false;
            turnLabel.setText("Your Turn");
            admin.setText("Please enter the marble coordinate");
            wait = true;
            while(wait) {}

            marble mPlayer=new marble(x,y,2);
            mPlayer.getAvailableMoves(b);
            while(mPlayer.AvailableMarbles.size()==0)
            {
                admin.setText("This marble don't have any available moves!! \nPlease enter another marble coordinate");
                wait = true;
                while(wait) {}
                mPlayer=new marble(x,y,2);
                mPlayer.getAvailableMoves(b);
            }
            String moves = "";
            moves += "Your Available Moves is";
            for (int i = 0; i < mPlayer.AvailableMarbles.size(); i++) {
                moves += mPlayer.AvailableMarbles.get(i).x + " " + mPlayer.AvailableMarbles.get(i).y;
            }
            admin.setText(moves);
            int xOriginal = x, yOriginal = y;
            wait = true;
            while(wait) {}
            b.change(xOriginal, yOriginal, x, y);
            display(b.rows, b.columns, b.board);
            turnLabel.setText("Computer Turn");
            c.alphaBeta(b, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, 1,true);
            b=c.BestGrid;
            b.displayBoard();
        }
        if(b.isWin()==1){
            admin.setText("Computer Wins!");
        }
        else{
            admin.setText("CONGRATULATIONS, YOU WIN!");
        }
    }

    public static void main(String[] args) {
        try {
            Board b=new Board();
            b.initializingTheBoard();
            alphaBetaPlayer c =new alphaBetaPlayer(b);
            checker frame = new checker();
            display(b.rows, b.columns, b.board);
            frame.setVisible(true);
            play(b, c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public checker() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 620, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Welcome to the Game");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(150, 10, 371, 45);
        contentPane.add(lblNewLabel);

        textPane = new JTextPane();
        textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textPane.setEditable(false);
        textPane.setBounds(10, 105, 586, 345);
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        contentPane.add(textPane);

        JLabel lblNewLabel_1 = new JLabel("Input Console");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(259, 541, 130, 19);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(233, 557, 132, 33);
        contentPane.add(textField);
        textField.setColumns(10);

        turnLabel = new JLabel("Turn");
        turnLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        turnLabel.setBounds(197, 51, 192, 29);
        contentPane.add(turnLabel);

        admin = new JTextPane();
        admin.setBounds(34, 460, 544, 71);
        contentPane.add(admin);

        JButton btnNewButton = new JButton("Ok");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String str = textField.getText();
                String[] splitString = str.split(" ");
                x = Integer.parseInt(splitString[0]);
                y = Integer.parseInt(splitString[1]);
                wait = false;
            }
        });
        btnNewButton.setBounds(259, 592, 85, 21);
        contentPane.add(btnNewButton);
    }

}