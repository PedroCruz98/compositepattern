import model.*;

public class Application {

    public static void main(String[] args) {

        Evaluation tp1 = new SingleValue("tp1", .45f, 17.7f);
        Evaluation tp2 = new SingleValue("to2", .55f, 9.4f);

        Evaluation t1 = new SingleValue("test1", .25f, 14.5f);
        Evaluation t2 = new SingleValue("test2", .5f, 13.7f);
        Evaluation pw = new ComplexValue("practical work", .25f, tp1, tp2);

        Evaluation freq = new ComplexValue("freq", .7f, t1, t2, pw);
        Evaluation exam = new SingleValue("exam", .3f, 8f);

        Evaluation total = new ComplexValue("total", 1f, freq, exam);

        /*
            Simulate the following:
              total: [p = 1,00]
                freq: [p = 0,70]
                        test1:	[p = 0,25; n = 14,50]
                        test2:	[p = 0,50; n = 13,70]
                        practical work: [p = 0,25]
                                tp1:	[p = 0,45; n = 17,70]
                                to2:	[p = 0,55; n = 9,40]
                exam: [p = 0,30; n = 8,00]

            p -> percentage from 0 to 1
            n -> grade received in that evaluation
         */

        System.out.println("=============");
        System.out.println(total.toString());
        System.out.println();
        System.out.println("Valor final: " + total.value());
        System.out.println("=============");

    }

}
