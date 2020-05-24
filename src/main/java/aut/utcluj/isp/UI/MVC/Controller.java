package aut.utcluj.isp.UI.MVC;

import aut.utcluj.isp.UI.Equipment;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        view.getAddEquipmentButton().addActionListener(e -> addEquipment());
        view.getGetEquipmentsButton().addActionListener(e -> getEquipments());
        view.getGetEquipmentButton().addActionListener(e -> getEquipment());
        view.getGetEquipmentsGroupedByOwnerButton().addActionListener(e -> getEquipmentsGroupedByOwner());
        view.getGetNumberOfEquipmentsButton().addActionListener(e -> getNumberOfEquipments());
        view.getRemoveEquipmentButton().addActionListener(e -> removeEquipment());
    }

    private void addEquipment() {
        ImageIcon icon = new ImageIcon("docs/UT_E_02.png");
        String serialNumber = JOptionPane.showInputDialog(null,"Enter serial number:");
        String name = JOptionPane.showInputDialog(null, "Enter equipment name:");
        String currentOwner = JOptionPane.showInputDialog(null,"Does the equipment have a current owner?","None");
        Equipment equipment;
        if(currentOwner.equals("None")) {
            equipment = new Equipment(name, serialNumber);
        } else { equipment = new Equipment(name, serialNumber, currentOwner); }
        model.getEquipmentController().addEquipment(equipment);
        JOptionPane.showMessageDialog(null, "Equipment added:" + serialNumber,"Confirm add",JOptionPane.INFORMATION_MESSAGE,icon);
    }

    private void removeEquipment() {
        ImageIcon icon = new ImageIcon("docs/UT_E_02.png");
        String serialNumber = JOptionPane.showInputDialog(null,"Enter the serial number of the object to remove:");
        Equipment equipment = model.getEquipmentController().removeEquipmentBySerialNumber(serialNumber);
        if (equipment == null) {
            JOptionPane.showMessageDialog(null, "The equipment " + serialNumber + " was not found.","Remove Equipment",JOptionPane.INFORMATION_MESSAGE,icon);
        } else {
            JOptionPane.showMessageDialog(null, "The equipment " + serialNumber + " has been removed.","Remove Equipment",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }

    private void getNumberOfEquipments() {
        ImageIcon icon = new ImageIcon("docs/UT_E_02.png");
        int numberOfEquipments = model.getEquipmentController().getNumberOfEquipments();
        JOptionPane.showMessageDialog(null,"There are " + numberOfEquipments + " equipments registered.","Number of equipments",JOptionPane.INFORMATION_MESSAGE,icon);
    }

    private void getEquipment() {
        ImageIcon icon = new ImageIcon("docs/UT_E_02.png");
        String serialNumber = JOptionPane.showInputDialog(null,"Enter the serial number of the object to get:");

        Equipment equipment = null;
        List<Equipment> equipments = model.getEquipmentController().getEquipments();
        for(Equipment equipment1 : equipments) {
            if(equipment1.getSerialNumber().equals(serialNumber)) {
                equipment = equipment1;
                break;
            }
        }
        if(equipment == null) {
            JOptionPane.showMessageDialog(null,"The searched equipment was not found.","Selected Equipment",JOptionPane.INFORMATION_MESSAGE,icon);
            return;
        }
        JOptionPane.showMessageDialog(null, "The selected equipment: " + equipment,"Selected Equipment",JOptionPane.INFORMATION_MESSAGE,icon);
        if(!equipment.isTaken()) {
            String[] options = {"NOTHING", "PROVIDE"};
            String operation = (String) JOptionPane.showInputDialog(null, "What do you want to do with the equipment? ", "Operation", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
            if(operation == "PROVIDE") {
                String owner = JOptionPane.showInputDialog(null, "Enter the name of the new Owner:");
                equipment.provideEquipmentToUser(owner, LocalDateTime.now());
                JOptionPane.showMessageDialog(null, "The selected equipment: " + equipment + "was given to " + owner,"Selected Equipment",JOptionPane.INFORMATION_MESSAGE,icon);
            }
        } else {
            String[] options = {"NOTHING", "RETURN"};
            String operation = (String) JOptionPane.showInputDialog(null, "What do you want to do with the equipment? ", "Operation", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
            if (operation == "RETURN") {
                equipment.returnEquipmentToOffice();
                JOptionPane.showMessageDialog(null, "The selected equipment: " + equipment + "was returned.","Selected Equipment",JOptionPane.INFORMATION_MESSAGE,icon);
            }
        }
    }

    private void getEquipments() {
        List<Equipment> equipments = model.getEquipmentController().getEquipments();
        Object[] equipmentsArray = equipments.toArray();
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JList list = new JList(equipmentsArray);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(list));
        frame.setSize(600,250);
        frame.setVisible(true);
    }

    private void getEquipmentsGroupedByOwner() {
        Map<String, List<Equipment>> equipmentsGroupedByOwner = model.getEquipmentController().getEquipmentsGroupedByOwner();
        List<Equipment> equipments = new ArrayList<Equipment>();
        for( Map.Entry<String, List<Equipment>> entry : equipmentsGroupedByOwner.entrySet()) {
            equipments.addAll((List<Equipment>)entry.getValue());
        }
        Object[] equipmentsArray = equipments.toArray();
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JList list = new JList(equipmentsArray);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(list));
        frame.setSize(600,250);
        frame.setVisible(true);

    }



}
