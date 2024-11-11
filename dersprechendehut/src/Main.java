import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class SortingHatGUI extends JFrame {
    private final JTextField nameField;
    private final JComboBox<String> courageBox;
    private final JComboBox<String> intelligenceBox;
    private final JComboBox<String> loyaltyBox;
    private final JComboBox<String> ambitionBox;
    private final JLabel resultLabel;

    public SortingHatGUI() {
        setTitle("Sprechender Hut");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        courageBox = createComboBox("Mut");
        intelligenceBox = createComboBox("Klugheit");
        loyaltyBox = createComboBox("Loyalität");
        ambitionBox = createComboBox("Ehrgeiz");

        JButton sortButton = new JButton("Zuweisen!");
        sortButton.addActionListener(new SortListener());
        add(sortButton);

        resultLabel = new JLabel("Ergebnis: ");
        add(resultLabel);

        setVisible(true);
    }

    private JComboBox<String> createComboBox(String label) {
        add(new JLabel(label + ":"));
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        add(comboBox);
        return comboBox;
    }

    private class SortListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int courage = Integer.parseInt((String) Objects.requireNonNull(courageBox.getSelectedItem()));
            int intelligence = Integer.parseInt((String) Objects.requireNonNull(intelligenceBox.getSelectedItem()));
            int loyalty = Integer.parseInt((String) Objects.requireNonNull(loyaltyBox.getSelectedItem()));
            int ambition = Integer.parseInt((String) Objects.requireNonNull(ambitionBox.getSelectedItem()));

            String house = determineHouse(courage, intelligence, loyalty, ambition);
            resultLabel.setText(name + " gehört nach " + house + "!");
        }
    }

    private String determineHouse(int courage, int intelligence, int loyalty, int ambition) {
        if (courage >= intelligence && courage >= loyalty && courage >= ambition) {
            return "Gryffindor";
        } else if (intelligence >= courage && intelligence >= loyalty && intelligence >= ambition) {
            return "Ravenclaw";
        } else if (loyalty >= courage && loyalty >= intelligence && loyalty >= ambition) {
            return "Hufflepuff";
        } else {
            return "Slytherin";
        }
    }

    public static void main(String[] args) {
        new SortingHatGUI();
    }
}
