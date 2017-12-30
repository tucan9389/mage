package mage.client.util.gui;

import mage.choices.ChoiceImpl;
import mage.client.dialog.PickChoiceDialog;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JayDi85
 */
public class FastSearchUtil {

    public static String DEFAULT_EXPANSION_SEARCH_MESSAGE = "Select set or expansion";
    public static String DEFAULT_EXPANSION_TOOLTIP_MESSAGE = "Fast search set or expansion";

    /**
     * Show fast choice modal dialog with incremental searching for any string combobox components
     * @param combo combobox control with default data model
     * @param chooseMessage caption message for dialog
     */
    public static void showFastSearchForStringComboBox(JComboBox combo, String chooseMessage){
        // fast search/choice dialog for string combobox

        mage.choices.Choice choice = new ChoiceImpl(false);

        // collect data from expansion combobox (String)
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel)combo.getModel();
        Map<String, String> choiceItems = new HashMap<>(comboModel.getSize());
        Map<String, Integer> choiceSorting = new HashMap<>(comboModel.getSize());
        String item;

        for(int i = 0; i < comboModel.getSize() - 1; i++){
            item = (String)comboModel.getElementAt(i);
            choiceItems.put(item, item);
            choiceSorting.put(item, i); // need so sorting
        }

        choice.setKeyChoices(choiceItems);
        choice.setSortData(choiceSorting);
        choice.setMessage(chooseMessage);

        // current selection value restore
        String needSelectValue;
        needSelectValue = (String)comboModel.getSelectedItem();

        // ask for new value
        PickChoiceDialog dlg = new PickChoiceDialog();
        dlg.setWindowSize(300, 500);
        dlg.showDialog(choice, needSelectValue);
        if(choice.isChosen()){
            item = choice.getChoiceKey();
            comboModel.setSelectedItem(item);
        }
    }
}