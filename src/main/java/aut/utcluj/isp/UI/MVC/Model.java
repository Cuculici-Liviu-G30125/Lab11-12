package aut.utcluj.isp.UI.MVC;

import aut.utcluj.isp.UI.EquipmentController;

public class Model {

    private EquipmentController equipmentController;

    public Model() {
        equipmentController = new EquipmentController();
    }

    public EquipmentController getEquipmentController() {
        return equipmentController;
    }

    public void setEquipmentController(EquipmentController equipmentController) {
        this.equipmentController = equipmentController;
    }
}
