package aut.utcluj.isp.UI.MVC;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JButton addEquipmentButton;
    private JButton getEquipmentsButton;
    private JButton getEquipmentsGroupedByOwnerButton;
    private JButton getEquipmentButton;
    private JButton removeEquipmentButton;
    private JButton getNumberOfEquipmentsButton;

    public View(String title) {
        setTitle(title);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 160);
        setLocationRelativeTo(null);
        setVisible(true);

        addEquipmentButton = new JButton("Add equipment");
        getEquipmentsButton = new JButton("Get registered equipments");
        getEquipmentsGroupedByOwnerButton = new JButton("Get equipments grouped by owner");
        getEquipmentButton = new JButton("Get equipment");
        getNumberOfEquipmentsButton = new JButton("Get number of equipments");
        removeEquipmentButton = new JButton("Remove equipment");

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getEquipmentsButton)
                        .addComponent(getNumberOfEquipmentsButton)
                        .addComponent(getEquipmentsGroupedByOwnerButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addEquipmentButton)
                        .addComponent(getEquipmentButton)
                        .addComponent(removeEquipmentButton)));


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addEquipmentButton)
                        .addComponent(getEquipmentsButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getEquipmentButton)
                        .addComponent(getNumberOfEquipmentsButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getEquipmentsGroupedByOwnerButton)
                        .addComponent(removeEquipmentButton)));

        layout.linkSize(SwingConstants.HORIZONTAL, addEquipmentButton, getEquipmentButton, removeEquipmentButton);
        layout.linkSize(SwingConstants.HORIZONTAL, getEquipmentsButton, getNumberOfEquipmentsButton, getEquipmentsGroupedByOwnerButton);
        getContentPane().setLayout(layout);
    }

    public JButton getAddEquipmentButton() {
        return addEquipmentButton;
    }

    public JButton getGetEquipmentsButton() {
        return getEquipmentsButton;
    }

    public JButton getGetEquipmentsGroupedByOwnerButton() {
        return getEquipmentsGroupedByOwnerButton;
    }

    public JButton getGetEquipmentButton() {
        return getEquipmentButton;
    }

    public JButton getGetNumberOfEquipmentsButton() {
        return getNumberOfEquipmentsButton;
    }

    public void setAddEquipmentButton(JButton addEquipment) {
        this.addEquipmentButton = addEquipment;
    }

    public void setGetEquipmentsButton(JButton getEquipments) {
        this.getEquipmentsButton = getEquipments;
    }

    public void setGetEquipmentsGroupedByOwnerButton(JButton getEquipmentsGroupedByOwner) {
        this.getEquipmentsGroupedByOwnerButton = getEquipmentsGroupedByOwner;
    }

    public void setGetEquipmentButton(JButton getEquipment) {
        this.getEquipmentButton = getEquipment;
    }

    public void setGetNumberOfEquipmentsButton(JButton getNumberOfEquipments) {
        this.getNumberOfEquipmentsButton = getNumberOfEquipments;
    }

    public JButton getRemoveEquipmentButton() {
        return removeEquipmentButton;
    }

    public void setRemoveEquipmentButton(JButton removeEquipmentButton) {
        this.removeEquipmentButton = removeEquipmentButton;
    }
}
