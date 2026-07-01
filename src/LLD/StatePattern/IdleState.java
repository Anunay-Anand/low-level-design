package LLD.StatePattern;

public class IdleState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item Selected : " + itemCode);
        context.setSelectedItem(itemCode);
        context.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please select the item first before inserting the coins");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("No Item is selected. Nothing to Dispense");
    }
}
