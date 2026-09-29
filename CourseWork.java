import java.util.*;
class CourseWork {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            printHeader();
            printMainMenuOptions();
            System.out.print("Enter Option -> ");
            String optStr = input.nextLine().trim();
            int option = 0;
            try {
                option = Integer.parseInt(optStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Option. Reloading Home...");
                continue;
            }

            switch (option) {
                case 1:
                    decimalConverterMenu();
                    break;
                case 2:
                    binaryConverterMenu();
                    break;
                case 3:
                    octalConverterMenu();
                    break;
                case 4:
                    hexadecimalConverterMenu();
                    break;
                case 5:
                    romanConverterMenu();
                    break;
                default:
                    System.out.println("Invalid selection Option! Select an option from [01 - 05].\n");
            }
        }
    }

    

    public static void printHeader() {
        System.out.println("\t\t\t\t\t __                     __");          
        System.out.println("\t\t\t\t\t|  \\                   |  \\");          
        System.out.println(" \t\t\t\t\t\\$$  _______  ______  | $$   _______ ");
        System.out.println("\t\t\t\t\t|  \\ /       \\|      \\ | $$ /       \\");
        System.out.println("\t\t\t\t\t| $$|  $$$$$$$ \\$$$$$$\\| $$|  $$$$$$$");
        System.out.println("\t\t\t\t\t| $$| $$      /      $$| $$| $$");     
        System.out.println("\t\t\t\t\t| $$| $$_____|  $$$$$$$| $$| $$_____"); 
        System.out.println("\t\t\t\t\t| $$ \\$$     \\$$    $$| $$ \\$$     \\");
        System.out.println("\t\t\t\t\t\\$$  \\$$$$$$$ \\$$$$$$$ \\$$  \\$$$$$$$");
                                 
        System.out.println(" _   _                 _                 _____                           _");            
        System.out.println("| \\ | |               | |               /  __ \\                         | |");           
        System.out.println("|  \\| |_   _ _ __ ___ | |__   ___ _ __  | /  \\/ ___  _ ____   _____ _ __| |_ ___ _ __"); 
        System.out.println("| . ` | | | | '_ ` _ \\| '_ \\ / _ \\ '__| | |    / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__|");
        System.out.println("| |\\  | |_| | | | | | | |_) |  __/ |    | \\__/\\ (_) | | | \\ V /  __/ |  | ||  __/ |");   
        System.out.println("\\_| \\_/\\__,_|_| |_| |_|_.__/ \\___|_|     \\____/\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|");
        System.out.println("=============================================================================================\n\n");
    }

    public static void printMainMenuOptions() {
        System.out.println("       [01] Decimal Converter");
        System.out.println("       [02] Binary Converter");
        System.out.println("       [03] Octal Converter");
        System.out.println("       [04] Hexadecimal Converter");
        System.out.println("       [05] Roman Number Converter\n");
    }

    public static boolean promptRetry(String message) {
        System.out.println(message);
        System.out.print("Do you want to input number again (Y/N) -> ");
        String choice = input.nextLine().trim();
        return choice.equalsIgnoreCase("Y");
    }

    public static void handleNavigation() {
        System.out.print("Do you want to go to homepage (Y/N) -> ");
        String choice = input.nextLine().trim();
        if (!choice.equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }

    // --- CONVERTER MENUS ---

    public static void decimalConverterMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                       Decimal Converter                              |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.print("Enter a Decimal number: ");
            String decInput = input.nextLine().trim();

            if (!isValidDecimal(decInput)) {
                if (promptRetry("\tInvalid input...")) continue;
                else break;
            }

            long decimalNum = Long.parseLong(decInput);

            System.out.println("\n\tBinary number: " + decimalToBinary(decimalNum));
            System.out.println("\tOctal number: " + decimalToOctal(decimalNum));
            System.out.println("\tHexadecimal number: " + decimalToHexadecimal(decimalNum) + "\n");

            handleNavigation();
            break;
        }
    }

    public static void binaryConverterMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                        Binary Converter                              |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.print("Enter a Binary number: ");
            String binInput = input.nextLine().trim();

            if (!isValidBinary(binInput)) {
                if (promptRetry("\tInvalid input...")) continue;
                else break;
            }

            long decimalVal = binaryToDecimal(binInput);

            System.out.println("\n\tDecimal Number: " + decimalVal);
            System.out.println("\tOctal number: " + decimalToOctal(decimalVal));
            System.out.println("\tHexadecimal number: " + decimalToHexadecimal(decimalVal) + "\n");

            handleNavigation();
            break;
        }
    }

    public static void octalConverterMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                         Octal Converter                              |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.print("Enter an Octal number: ");
            String octInput = input.nextLine().trim();

            if (!isValidOctal(octInput)) {
                if (promptRetry("\tInvalid input...")) continue;
                else break;
            }

            long decimalVal = octalToDecimal(octInput);

            System.out.println("\n\tDecimal Number: " + decimalVal);
            System.out.println("\tBinary Number: " + decimalToBinary(decimalVal));
            System.out.println("\tHexadecimal Number: " + decimalToHexadecimal(decimalVal) + "\n");

            handleNavigation();
            break;
        }
    }

    public static void hexadecimalConverterMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                      HexaDecimal Converter                           |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.print("Enter an HexaDecimal number: ");
            String hexInput = input.nextLine().trim();

            if (!isValidHexadecimal(hexInput)) {
                if (promptRetry("Invalid input...")) continue;
                else break;
            }

            long decimalVal = hexadecimalToDecimal(hexInput);

            System.out.println("\n\tDecimal Number: " + decimalVal);
            System.out.println("\tBinary Number: " + decimalToBinary(decimalVal));
            System.out.println("\tOctal Number: " + decimalToOctal(decimalVal) + "\n");

            handleNavigation();
            break;
        }
    }

    public static void romanConverterMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                      Roman Number Converter                          |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("       [01] Decimal Number to Roman Number Converter");
            System.out.println("       [02] Roman Number to Decimal Number Converter\n");
            System.out.print("Enter an option: ");
            
            String romOptStr = input.nextLine().trim();
            int romOption = 0;
            try {
                romOption = Integer.parseInt(romOptStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid sub-option.");
                continue;
            }

            if (romOption == 1) {
                decimalToRomanSubMenu();
                break;
            } else if (romOption == 2) {
                romanToDecimalSubMenu();
                break;
            } else {
                System.out.println("Invalid Selection options.");
            }
        }
    }

    public static void decimalToRomanSubMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|             Decimal Number to Roman Number Converter                 |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.print("Enter an Decimal number: ");
            String decInput = input.nextLine().trim();

            if (!isValidDecimal(decInput)) {
                if (promptRetry("\tInvalid input...")) continue;
                else break;
            }

            int num = Integer.parseInt(decInput);
            if (num <= 0 || num > 3999) {
                if (promptRetry("\tInvalid range (Must be 1-3999)...")) continue;
                else break;
            }

            System.out.println("\n\tRoman numeral: " + decimalToRoman(num) + "\n");
            handleNavigation();
            break;
        }
    }

    public static void romanToDecimalSubMenu() {
        while (true) {
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|             Roman Number to Decimal Number Converter                 |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.print("Enter an Roman number: ");
            String romInput = input.nextLine().trim().toUpperCase();

            if (!isValidRoman(romInput)) {
                if (promptRetry("\tInvalid input...")) continue;
                else break;
            }

            System.out.println("\n\tDecimal number: " + romanToDecimal(romInput) + "\n");
            handleNavigation();
            break;
        }
    }

    // --- VALIDATION METHODS ---

    public static boolean isValidDecimal(String input) {
        if (input == null || input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    public static boolean isValidBinary(String input) {
        if (input == null || input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '0' && c != '1') return false;
        }
        return true;
    }

    public static boolean isValidOctal(String input) {
        if (input == null || input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '7') return false;
        }
        return true;
    }

    public static boolean isValidHexadecimal(String input) {
        if (input == null || input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidRoman(String input) {
        if (input == null || input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D' && c != 'M') {
                return false;
            }
        }
        return true;
    }

    // --- CORE CONVERSION METHODS ---

    public static String decimalToBinary(long decimalNum) {
        if (decimalNum == 0) return "0";
        String binary = "";
        long temp = decimalNum;
        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp /= 2;
        }
        return binary;
    }

    public static String decimalToOctal(long decimalNum) {
        if (decimalNum == 0) return "0";
        String octal = "";
        long temp = decimalNum;
        while (temp > 0) {
            octal = (temp % 8) + octal;
            temp /= 8;
        }
        return octal;
    }

    public static String decimalToHexadecimal(long decimalNum) {
        if (decimalNum == 0) return "0";
        String hexa = "";
        long temp = decimalNum;
        while (temp > 0) {
            long rem = temp % 16;
            if (rem < 10) {
                hexa = rem + hexa;
            } else {
                hexa = (char) ('A' + (rem - 10)) + hexa;
            }
            temp /= 16;
        }
        return hexa;
    }

    public static long binaryToDecimal(String binInput) {
        long decimalVal = 0;
        long base = 1;
        for (int i = binInput.length() - 1; i >= 0; i--) {
            if (binInput.charAt(i) == '1') {
                decimalVal += base;
            }
            base *= 2;
        }
        return decimalVal;
    }

    public static long octalToDecimal(String octInput) {
        long decimalVal = 0;
        long base = 1;
        for (int i = octInput.length() - 1; i >= 0; i--) {
            decimalVal += (octInput.charAt(i) - '0') * base;
            base *= 8;
        }
        return decimalVal;
    }

    public static long hexadecimalToDecimal(String hexInput) {
        long decimalVal = 0;
        long base = 1;
        for (int i = hexInput.length() - 1; i >= 0; i--) {
            char c = hexInput.charAt(i);
            int val = 0;
            if (c >= '0' && c <= '9') {
                val = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                val = 10 + (c - 'A');
            } else if (c >= 'a' && c <= 'f') {
                val = 10 + (c - 'a');
            }
            decimalVal += val * base;
            base *= 16;
        }
        return decimalVal;
    }

    public static String decimalToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = "";
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman += symbols[i];
            }
        }
        return roman;
    }

    public static int romanToDecimal(String romInput) {
        int totalDecimal = 0;
        for (int i = 0; i < romInput.length(); i++) {
            int v1 = getRomanCharValue(romInput.charAt(i));

            if (i + 1 < romInput.length()) {
                int v2 = getRomanCharValue(romInput.charAt(i + 1));
                if (v1 >= v2) {
                    totalDecimal += v1;
                } else {
                    totalDecimal += (v2 - v1);
                    i++; 
                }
            } else {
                totalDecimal += v1;
            }
        }
        return totalDecimal;
    }

    public static int getRomanCharValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
