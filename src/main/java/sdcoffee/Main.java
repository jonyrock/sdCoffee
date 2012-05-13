package sdcoffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String args[]) {

        Machine m = new VendingMachine();
        connectCommandsToMachine(m);

    }

    private static void connectCommandsToMachine(Machine machine) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {

                String command = reader.readLine();

                if (command.equalsIgnoreCase("add sugar")) {
                    machine.addSugar();
                    continue;
                }

                if (command.equalsIgnoreCase("cancel")) {
                    machine.cancel();
                    continue;
                }

                String commandTokens[] = command.split(" ");
                if (commandTokens[0].equalsIgnoreCase("select")) {
                    machine.select(commandTokens[1]);
                    continue;
                }

                if (commandTokens[0].equalsIgnoreCase("insert")) {
                    machine.insert(Integer.parseInt(commandTokens[1]));
                    continue;
                }

                if (commandTokens[0].equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Unknown command");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }


}
