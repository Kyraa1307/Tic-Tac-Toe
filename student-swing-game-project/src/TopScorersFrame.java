import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();

        setTitle("Top 5 Scorers");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        String[] columns = {"Rank", "Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        ArrayList<Player> topPlayers = playerService.getTopFiveScorers();
        int rank = 1;
        for (Player p : topPlayers) {
            model.addRow(new Object[]{rank++, p.getUsername(), p.getWins(), p.getLosses(), p.getDraws(), p.getScore()});
        }

        table = new JTable(model);
        table.setEnabled(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> this.dispose());
        panel.add(btnClose, BorderLayout.SOUTH);

        add(panel);
    }
}
