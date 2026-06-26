import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;
    private boolean gameOver;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        this.gameOver = false;

        setTitle("Tic-Tac-Toe - Game");
        setSize(350, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblStatus = new JLabel("Your turn! (X)", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i].setPreferredSize(new Dimension(90, 90));
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            boardPanel.add(buttons[i]);
        }
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        });
        mainPanel.add(btnBack, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handlePlayerMove(int index) {
        if (gameOver) return;

        // TODO: Make player move
        boolean moved = gameLogic.makeMove(index, 'X');
        if (!moved) {
            JOptionPane.showMessageDialog(this, "Invalid move! Cell is already taken.");
            return;
        }

        buttons[index].setText("X");
        buttons[index].setForeground(Color.BLUE);

        // TODO: Check if player wins
        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }

        // TODO: Check draw
        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Computer is thinking...");

        // TODO: Computer move
        int compIndex = gameLogic.computerMove();
        if (compIndex != -1) {
            gameLogic.makeMove(compIndex, 'O');
            buttons[compIndex].setText("O");
            buttons[compIndex].setForeground(Color.RED);
        }

        // TODO: Check if computer wins
        if (gameLogic.checkWinner('O')) {
            finishGame("LOSE");
            return;
        }

        // TODO: Check draw again after computer move
        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Your turn! (X)");
    }

    private void finishGame(String result) {
        gameOver = true;
        disableAllButtons();

        // TODO: Update statistics in database
        playerService.updateStatistics(currentPlayer, result);

        String message;
        if (result.equals("WIN")) message = "You WIN! +10 points";
        else if (result.equals("LOSE")) message = "You LOSE!";
        else message = "It's a DRAW! +3 points";

        lblStatus.setText(message);
        JOptionPane.showMessageDialog(this, message);

        // Refresh player data and return to menu
        PlayerService ps = new PlayerService();
        Player updatedPlayer = ps.getPlayerById(currentPlayer.getId());
        if (updatedPlayer != null) currentPlayer = updatedPlayer;

        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }

    private void disableAllButtons() {
        for (JButton btn : buttons) btn.setEnabled(false);
    }
}
