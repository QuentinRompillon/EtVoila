import java.awt.GridBagConstraints;

public class CreateGridBagConstraints {

    public CreateGridBagConstraints() {
    }

    public static GridBagConstraints create() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        return gbc;
    }
}
