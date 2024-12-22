import java.util.Scanner;

public class Main {

    // Метод для вычисления сложного процента
    public static double calculateCompoundInterest(double principal, double rate, int periods) {
        return principal * Math.pow(1 + rate / 100, periods);
    }

    // Метод для вычисления процентной ставки на основе входных данных
    public static double calculateRate(double initialAmount, double finalAmount, int periods) {
        return (Math.pow(finalAmount / initialAmount, 1.0 / periods) - 1) * 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Выберите операцию:");
            System.out.println("1. Вычислить сложный процент.");
            System.out.println("2. Вычислить процентную ставку для достижения конечной суммы.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите начальную сумму: ");
                    double principal = scanner.nextDouble();

                    System.out.print("Введите процентную ставку: ");
                    double rate = scanner.nextDouble();

                    System.out.print("Введите количество периодов: ");
                    int periods = scanner.nextInt();

                    double finalAmount = calculateCompoundInterest(principal, rate, periods);
                    System.out.printf("Конечная сумма после %d периодов: %.2f%n", periods, finalAmount);
                    break;

                case 2:
                    System.out.print("Введите начальную сумму: ");
                    double initialAmount = scanner.nextDouble();

                    System.out.print("Введите конечную сумму: ");
                    double targetAmount = scanner.nextDouble();

                    System.out.print("Введите количество периодов: ");
                    int nPeriods = scanner.nextInt();

                    double calculatedRate = calculateRate(initialAmount, targetAmount, nPeriods);
                    System.out.printf("Необходимая процентная ставка: %.2f%%%n", calculatedRate);
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите 1 или 2.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: пожалуйста, вводите только числа. Попробуйте снова.");
        } finally {
            scanner.close();
        }
    }
}
