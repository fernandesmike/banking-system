package threads;

import classes.AutomatedTellerMachine;

public class AtmThread implements Runnable {

    AutomatedTellerMachine atm = AutomatedTellerMachine.getInstance();
    @Override
    public void run() {
        atm.showMenu();
    }
}
