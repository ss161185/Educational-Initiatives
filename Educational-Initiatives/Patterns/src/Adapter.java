//Adapter Pattern
//Use Case: Adapting a legacy printer interface to a new printing system.

// Target interface
interface NewPrinter {
    void print(String text);
}

// Adaptee
class LegacyPrinter {
    public void legacyPrint(String text) {
        System.out.println("Legacy Printer: " + text);
    }
}

// Adapter
class PrinterAdapter implements NewPrinter {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String text) {
        legacyPrinter.legacyPrint(text);
    }
}
