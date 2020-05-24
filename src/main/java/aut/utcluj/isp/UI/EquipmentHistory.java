package aut.utcluj.isp.UI;




import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class EquipmentHistory implements IEquipmentHistory {
    private List<EquipmentHistoryDetails> historyDetailsList = new ArrayList<>();

    public List<EquipmentHistoryDetails> filterEquipmentHistoryByOperation(final Operation operation) {
        List<EquipmentHistoryDetails> equipmentHistoryDetailsList = new ArrayList<>();
        for (EquipmentHistoryDetails equipmentHistoryDetails : historyDetailsList) {
            if (equipmentHistoryDetails.getOperation().equals(operation)) {
                equipmentHistoryDetailsList.add(equipmentHistoryDetails);
            }
        }
        return equipmentHistoryDetailsList;
    }
    
    public void addEquipmentHistory(String owner, Operation operation, LocalDateTime providedDate) {
        EquipmentHistoryDetails equipmentHistoryDetails = new EquipmentHistoryDetails(owner, operation, providedDate);
        historyDetailsList.add(equipmentHistoryDetails);
    }

    public List<EquipmentHistoryDetails> sortEquipmentHistoryByDateDesc() {
        historyDetailsList.sort(new Comparator<EquipmentHistoryDetails>() {
            @Override
            public int compare(EquipmentHistoryDetails equipmentHistoryDetails, EquipmentHistoryDetails t1) {
                if (equipmentHistoryDetails.getDate().isBefore(t1.getDate())) {
                    return 1;
                } else {
                    if (equipmentHistoryDetails.getDate().isEqual(t1.getDate())) {
                        return 0;
                    } else
                        return -1;
                }
            }
        });
        return historyDetailsList;
    }

    public List<EquipmentHistoryDetails> getHistoryDetailsList() {
        return historyDetailsList;
    }
}