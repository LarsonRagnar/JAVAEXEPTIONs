package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 *
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 *
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task3 {
    private static final List<String> strings = List.of
            ("Анна=4", "Елена=5", "Марина=*", "Полина=?",
                    "Владимир=?", "Константин=?", "Иван=4");
//для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        writeTiFile(strings,"task3.txt");
        System.out.println(parseValue("task3.txt"));
        reWrite(filePath);

    }
    public static Map<String,Integer> parseValue(String filePath){
        Map<String,Integer> current=new HashMap<String,Integer>();
        BufferedReader bfr=null;
        try {
           bfr= new BufferedReader(new FileReader(filePath));
           String line;
           while ((line=bfr.readLine())!=null) {
               String[] splitData = line.split("=");
               String key=splitData[0];
               Integer value;
               if (splitData[1].equals("?")){
                   value=key.length();
               }else {
                   value=Integer.parseInt(splitData[1]);
               }
               current.put(key,value);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("invalid data");
        } finally{
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return current;
    }


    /**
     * @apiNote записываем данные в файл
     * @param strings
     * @param filePath
     */
    public static void writeTiFile(List<String> strings,String filePath){
        FileWriter newFileWriter=null;
        try {
            newFileWriter= new FileWriter(filePath);
            for (String item:strings) {
                newFileWriter.write(item + "\n");
            }
            newFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                newFileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void reWrite(String filePath){
        Map<String,Integer> data=parseValue(filePath);
        List<String> preparedData =new ArrayList<String>;
        for(Map.Entry<String,Integer> entry: data.entrySet()){
            preparedData.add(data,filePath)
        }
        writeTiFile(preparedData,filePath);
    }
}
