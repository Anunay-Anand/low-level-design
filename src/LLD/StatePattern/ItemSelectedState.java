package LLD.StatePattern;

public class ItemSelectedState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item has already been selected" + context.getSelectedItem());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Coin has been inserted of amount" + amount);
        context.setInsertedAmount(amount);
        context.setState(new HasMoneyState());
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Please insert coin before Dispensing");
    }
}
