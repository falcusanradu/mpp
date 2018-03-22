package UI;

import model.Game;
import service.GameService;

import java.awt.*;
import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AfterLoginEclipse extends JFrame {

    private GameService gameService = new GameService();

    private JPanel contentPane;
    private JTable jtable;
    private static AfterLoginEclipse frame;
    //    private JScrollPane jScrollPane = new JScrollPane(jtable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);;
    private JScrollPane scrollPane_1 = new JScrollPane();


    // mock data
    private static String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};

    private static Object[][] data = {{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)},
            {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)},
            {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}};


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AfterLoginEclipse();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AfterLoginEclipse() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 659, 408);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // set table
        List<Game> games = this.gameService.getAllGames();
        String[] gamesArray = new String[games.size()];
        gamesArray = games.toArray(gamesArray);
        Object[][] data1 = {gamesArray};
        DefaultTableModel model = new DefaultTableModel(data1, columnNames);
        jtable = new JTable(model);
//        jtable.setModel(model);
        jtable.setBounds(23, 13, 578, 296);
        contentPane.add(jtable);


    }

}
