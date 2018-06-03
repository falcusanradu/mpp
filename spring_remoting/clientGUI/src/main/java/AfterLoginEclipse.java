
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class AfterLoginEclipse {

    private ClientCtrl clientCtrl;

    private JPanel contentPane;
    private JTable jtable;
    private DefaultTableModel model;
    public JFrame frame;
    JButton btnSort;


    // column headers
    private static String[] columnHeaders = {"id game", "team1", "team2", "title", "price of one ticket", "tickets available"};
    private JTextField clinetNameTextField;
    private JTextField numberOfTicketsTtextField;
    private JTextField idGameTextField;
    private JButton btnBuyTickets;

    /**
     * Create the application.
     */
    public AfterLoginEclipse(ClientCtrl clientCtrl) throws SQLException, RemoteException {
        this.clientCtrl = clientCtrl;
        initialize();
    }

    /**
     * Initialize.
     */
    private void initialize() throws SQLException, RemoteException {
        this.initializeFrame();
        this.setTable(1);
        this.setPaneAndScrollpane();
        this.logoutButton();
        this.initLabelsAndTextFields();

    }

    /**
     * initialize the frame.
     */
    private void initializeFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 694, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
    }


    /**
     * sets the table with the current db values
     *
     * @throws SQLException
     */
    private void setTable(int option) throws SQLException, RemoteException {
        this.model = new DefaultTableModel();
        List<Game> games;
        switch (option) {
            case 1:
                games = this.clientCtrl.getAllGames();
                newTable(games);
                break;
            case 2:
                games = this.clientCtrl.sortByNrPlaces();
                sortTable(games);
                break;
            default:
                games = this.clientCtrl.getAllGames();
                break;
        }


    }

    /**
     * for the sorted table.
     *
     * @param games
     */
    public void sortTable(List<Game> games) {
//        this.model = new DefaultTableModel();
        // add relevant information to a game

        this.model = (DefaultTableModel) jtable.getModel();
        this.model.getDataVector().removeAllElements();
        this.model.fireTableDataChanged();
        this.model.setColumnIdentifiers(AfterLoginEclipse.columnHeaders);
        games.forEach(game -> {
            this.model.addRow(new Object[]{game.getId(), game.getTeam1(), game.getTeam2(), game.getTitle(), game.getPriceOfTicket(), game.getTickets()});
        });
        this.jtable = new JTable(this.model);
    }

    /**
     * for a new table.
     *
     * @param games
     */
    public void newTable(List<Game> games) throws SQLException, RemoteException {
        this.model.setColumnIdentifiers(AfterLoginEclipse.columnHeaders);
        // add relevant information to a game
        games.forEach(game -> {
            this.model.addRow(new Object[]{game.getId(), game.getTeam1(), game.getTeam2(), game.getTitle(), game.getPriceOfTicket(), game.getTickets()});
        });
        this.model.fireTableDataChanged();
    }

    /**
     * log out btn
     */
    private void logoutButton() {
        JButton btnLogout = new JButton("logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                SwingGUIEclipse swingGUIEclipse = null;
                try {
                    swingGUIEclipse = new SwingGUIEclipse(clientCtrl);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                try {
                    clientCtrl.logout();
                    swingGUIEclipse.frame.setVisible(true);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        btnLogout.setBounds(482, 389, 97, 25);
        contentPane.add(btnLogout);

    }

    /**
     * JPane and JScrollPane for the table
     */
    private void setPaneAndScrollpane() {
        JPanel panel = new JPanel();
        panel.setBounds(23, 13, 578, 296);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 578, 296);
        panel.add(scrollPane);
        jtable = new JTable(this.model);
        scrollPane.setViewportView(this.jtable);
    }

    private void initLabelsAndTextFields() {
        JLabel lblNewLabel = new JLabel("client name");
        lblNewLabel.setBounds(23, 359, 83, 25);
        contentPane.add(lblNewLabel);

        JLabel lblNumberOfTickets = new JLabel("number of tickets");
        lblNumberOfTickets.setBounds(23, 389, 101, 25);
        contentPane.add(lblNumberOfTickets);

        JLabel lblIdGame = new JLabel("id game");
        lblIdGame.setBounds(23, 321, 83, 25);
        contentPane.add(lblIdGame);

        clinetNameTextField = new JTextField();
        clinetNameTextField.setBounds(169, 360, 116, 22);
        contentPane.add(clinetNameTextField);
        clinetNameTextField.setColumns(10);

        numberOfTicketsTtextField = new JTextField();
        numberOfTicketsTtextField.setColumns(10);
        numberOfTicketsTtextField.setBounds(169, 390, 116, 22);
        contentPane.add(numberOfTicketsTtextField);

        idGameTextField = new JTextField();
        idGameTextField.setColumns(10);
        idGameTextField.setBounds(169, 322, 116, 22);
        contentPane.add(idGameTextField);

        this.btnBuyTickets = new JButton("buy tickets");
        this.buyTickets();
        this.btnBuyTickets.setBounds(23, 417, 97, 25);
        contentPane.add(this.btnBuyTickets);

        this.btnSort = new JButton("sort");
        this.sort();
        btnSort.setBounds(482, 345, 97, 25);
        contentPane.add(btnSort);
    }

    private void sort() {
        btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    clientCtrl.sortByNrPlaces();
                    setTable(2);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void buyTickets() {
        this.btnBuyTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // verify if the input are intergers
                boolean numberFormatException = false;
                try {
                    try {
                        Integer.parseInt(idGameTextField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(btnBuyTickets, "the game id is a number!");
                        numberFormatException = true;
                    }
                    try {
                        Integer.parseInt(numberOfTicketsTtextField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(btnBuyTickets, "the number of tickets is a number!");
                        numberFormatException = true;
                    }

                    if (numberFormatException == false && !clientCtrl.buyTicketsCondition(clinetNameTextField.getText(), Integer.parseInt(idGameTextField.getText()),
                            Integer.parseInt(numberOfTicketsTtextField.getText()))) {
                        JOptionPane.showMessageDialog(btnBuyTickets, "game id or client name don't exist or not enough tickets available!");
                    } else if (numberFormatException == false) {
                        clientCtrl.buyTickets(clinetNameTextField.getText(), Integer.parseInt(idGameTextField.getText()),
                                Integer.parseInt(numberOfTicketsTtextField.getText()), AfterLoginEclipse.this);
                        JOptionPane.showMessageDialog(btnBuyTickets, "Success!!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void refreshTable() throws SQLException, RemoteException {
        this.setTable(1);
    }
}
