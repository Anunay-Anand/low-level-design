package LLD.CommandPattern;

import LLD.AdapterPattern.PaymentProcessor;

public class SetTemperatureCommand implements Command {

    private final Thermostat thermostat;
    private int previousTemperature;
    private final int newTemperature;

    public SetTemperatureCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.newTemperature = temperature;
    }

    public void execute() {
        previousTemperature = thermostat.getCurrentTemperature();
        thermostat.setTemperature(newTemperature);
    }

    public void undo() {
        thermostat.setTemperature(previousTemperature);
    }
}
