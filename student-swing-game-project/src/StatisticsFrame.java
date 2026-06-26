import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;

    public StatisticsFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();

        setTitle("My Statistics");
        setSize(300, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        Player freshPlayer = playerService.getPlayerById(currentPlayer.getId());
        if (freshPlayer != null) currentPlayer = freshPlayer;

        panel.add(new JLabel("Player:"));
        panel.add(new JLabel(currentPlayer.getUsername()));

        panel.add(new JLabel("Wins:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getWins())));

        panel.add(new JLabel("Losses:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getLosses())));

        panel.add(new JLabel("Draws:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getDraws())));

        panel.add(new JLabel("Score:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getScore())));

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> this.dispose());
        panel.add(new JLabel(""));
        panel.add(btnClose);

        add(panel);
    }
}
