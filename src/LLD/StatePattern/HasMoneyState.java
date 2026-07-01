package LLD.StatePattern;

public class HasMoneyState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("The Item has already been selected " + context.getSelectedItem());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("The coin has already been inserted");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("The item " + context.getSelectedItem() + " is being dispensed");
        context.setState(new DispenseState());
        System.out.println("Item has been dispensed");
        context.reset();
    }
}
