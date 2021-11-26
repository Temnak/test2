import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Float> coordinateCircle = new ArrayList<>();
        ArrayList<Float> coordinatesDots = new ArrayList<>();

        // читаем данные файлов
        try {
            Scanner scanner = new Scanner(new File(args[0]), "UTF-8");
            while (scanner.hasNext()) {
                coordinateCircle.add(scanner.nextFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(new File(args[1]), "UTF-8");
            while (scanner.hasNext()) {
                coordinatesDots.add(scanner.nextFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        float circleX = coordinateCircle.get(0);
        float circleY = coordinateCircle.get(1);
        float radius = coordinateCircle.get(2);

        float dotX;
        float dotY;
        int countDots = 0;

        Iterator<Float> iterator = coordinatesDots.iterator();

        while (iterator.hasNext()) {
            dotX = iterator.next();
            if (iterator.hasNext()) {
                dotY = iterator.next();
            } else {
                return;
            }
            //вычесляем левую сторону уравнения (x – a)2 + (y – b)2 = R2
            double leftPart = Math.pow(dotX - circleX, 2) + Math.pow(dotY - circleY, 2);
            //проверяем где точка
            if (leftPart == Math.pow(radius, 2)) {
                System.out.println(countDots + " - точка лежит на окружности");
            } else if (leftPart < Math.pow(radius, 2)) {
                System.out.println(countDots + " - точка внутри");
            } else {
                System.out.println(countDots + " - точка снаружи");
            }

            countDots++;
        }
    }
}
