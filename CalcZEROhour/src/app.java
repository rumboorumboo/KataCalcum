
import java.util.*;
public class app {


    public static void info()
    {
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами");
        System.out.println("Калькулятор может принимать на вход числа от 1 до 10 включительно, не более");
        System.out.println("Пример вводa :a + b, a - b, a * b, a / b. ");
        String[] checkouut = {"Sory", "ForThis"};
        main(checkouut);
    }
    public static void main(String[] args)
    {

        System.out.println("Введите пример для начала работы, либо 'InfoPls' для вызова справки");
        Scanner scanner = new Scanner(System.in);
        String UserAns;
        UserAns = scanner.nextLine();


        if (UserAns.equalsIgnoreCase("InfoPls"))
        {
            info();
        }
        else
        {
            Calcum(UserAns);
        }



    }
    public static String Calcum(String Data)
    {
        HashMap<String, Integer> RomEnum = new HashMap <>();
        RomEnum.put("I", 1);
        RomEnum.put("II", 2);
        RomEnum.put("III", 3);
        RomEnum.put("IV", 4);
        RomEnum.put("V", 5);
        RomEnum.put("VI", 6);
        RomEnum.put("VII", 7);
        RomEnum.put("VIII", 8);
        RomEnum.put("IX", 9);
        RomEnum.put("X", 10);
        String[] DataAR = Data.split(" ");
        try
        {
            if (DataAR.length > 3)
            {
                throw new IllegalArgumentException("MoreLiteral");
            }
            int ArgOne = Integer.parseInt(DataAR[0]);
            int ArgTwo = Integer.parseInt(DataAR[2]);

            if (ArgOne < 0 || ArgOne > 10 || ArgTwo < 0 || ArgTwo > 10) //* Если эт не римские числа, проверяем на диапозон и кидаем исключение*//*
            {
                throw new IllegalArgumentException("OutOfRange");

            }
            if ( ArgOne >= 0 & ArgTwo <= 10) /* Проверка на INT двух аргументов*/
            {
                LetsCalc(0, Data, RomEnum);
            }

        }
        catch (IllegalArgumentException b)
        {
            if (b.getMessage() == "OutOfRange")
            {

                System.out.println("Выход из диапазона чисел от 0 до 10 включительно, проверьте ввод");
                info();
            }
            if (b.getMessage() == "MoreLiteral")
            {
                System.out.println("Не правильно количество символов в ВВОДЕ, смотрите справку InfoPls");
                info();
            }
            if (RomEnum.containsKey(DataAR[0]) & RomEnum.containsKey(DataAR[2]) )
            {
                LetsCalc(1, Data, RomEnum);
            }
            else
            {
                System.out.println("Не правильный ввод данных!");
            }
        }



        return (Data);
    }
    public static int LetsCalc(Integer Flag, String UserAns, HashMap RomEnum)
    {
        String[] DataAR = UserAns.split(" ");


        {
            try {
                Integer Arg1; Integer Arg2;
                // System.out.println(Arg1);
                if (Flag == 1 )
                {
                    Arg1 = (Integer) RomEnum.get(DataAR[0]);
                    Arg2 = (Integer) RomEnum.get(DataAR[2]);

                } else{
                    Arg1 = Integer.parseInt (DataAR[0]);
                    Arg2 = Integer.parseInt (DataAR[2]);
                    System.out.println("Data: "+ Arg1 + Arg2);
                }
                int OutData;
                switch (DataAR[1]) {
                    case "+":
                        OutData = Arg1 + Arg2;
                        break;
                    case "-":
                        OutData = Arg1 - Arg2;
                        break;
                    case "/":
                        OutData = Arg1 / Arg2;
                        break;
                    case "*":
                        OutData = Arg1 * Arg2;
                        break;
                    default:
                        throw new RuntimeException("TrashOperator");
                }

                DataPrint(Flag, OutData);
            }
            catch (Exception e)
            {
                if (e.getMessage() == "TrashOperator")
                {
                    System.out.println("Некорректный математический оператор");
                    info();
                }
            }
        }
        return 1;
    }
    public static void DataPrint (Integer Flag, Integer OutData)
    {
        try
        {

            if (Flag == 1)
            {
                if (OutData > 0)
                {
                    String romanNumber = Converter.convertToRoman(OutData);
                    System.out.println(romanNumber);
                }
                else
                {
                    System.out.println("Програма DIE бекоз, в римской системе нет отрицательных чисел, сорри.");
                }


            }
            else
            {
                System.out.println(Flag+OutData);
            }
        }
        catch (Exception e)
        {
            System.out.println(OutData);
        }
    }
}
