package ie.atu.sw;

public class TextualGUI {
    public static void showMainMenu() {
        System.out.println(ConsoleColour.WHITE);
        System.out.println("************************************************************");
        System.out.println("*       ATU - Dept. Computer Science & Applied Physics     *");
        System.out.println("*                                                          *");
        System.out.println("*              Virtual Threaded Text Indexer               *");
        System.out.println("*                                                          *");
        System.out.println("************************************************************");
        System.out.println("(1) Specify Text File");
        System.out.println("(2) Configure Dictionary");
        System.out.println("(3) Configure Common Words");
        System.out.println("(4) Specify Output File");
        System.out.println("(5) Execute");
        System.out.println("(6) Quit");
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        System.out.print("Select Option [1-4]>");
        System.out.println();
    }

    public static void  showIndexOptionsMenu(){
        System.out.println(ConsoleColour.WHITE);
        System.out.println("************************************************************");
        System.out.println("*                                                          *");
        System.out.println("*                 Dictionary Index Options                 *");
        System.out.println("*                                                          *");
        System.out.println("************************************************************");
        System.out.println("(1) Specify Text File");
        System.out.println("(2) Configure Dictionary");
        System.out.println("(3) Configure Common Words");
        System.out.println("(4) Specify Output File");
        System.out.println("(5) Execute");
        System.out.println("(6) Quit");
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        System.out.print("Select Option [1-4]>");
        System.out.println();
    }

    public static void startLoadingBar() throws InterruptedException {
        System.out.print(ConsoleColour.YELLOW);
        int size = 100;
        for (int i =0 ; i < size ; i++) {
            printProgress(i + 1, size);
            Thread.sleep(10);
        }
    }

    public static void printProgress(int index, int total) {
        if (index > total) return;
        int size = 50;
        char done = '█';
        char todo = '░';

        int complete = (100 * index) / total;
        int completeLen = size * complete / 100;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append((i < completeLen) ? done : todo);
        }

        System.out.print("\r" + sb + "] " + complete + "%");

        if (done == total) System.out.println("\n");
    }



}
