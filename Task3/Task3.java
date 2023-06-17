package Task3;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import Task2.Task2;
public class Task3 {

   public static String fileReader(File file){
      String result = "";
      try(FileReader fileReader = new FileReader(file)){
        char[] arr = new char[(int) file.length()];
        fileReader.read(arr);
        for(char c: arr) result+=c;
      }catch(Exception e){
          System.out.print("Что-то пошло не так");
      }

      return result;
   }

   static void logger(String strToWrite, String path){
      try(FileWriter fw = new FileWriter(path,true)) {
         fw.write(strToWrite);
         fw.write("\n");
      } catch (Exception e) {
         System.out.println("Что-то пошло не так в записи файла.");
      }
   }

   public static void main(String[] args) {
      StringBuilder string = new StringBuilder("Student 1 had the 2 for 3 subject.");
      Map<String,String[]> jsonMap = new HashMap<>();
      File file = new File("Task3/textFortask3.txt");
      String str = fileReader(file);
      String[] arr = str.replaceAll("[\"\\[\\]{}]","").split(",");
      String[] arr2 = new String[3];
      int count = 0;
      int j = 1;


      for(int i = 0; i<arr.length; i++){
          arr2[j-1] = arr[i].split(":")[1];
            if(j%3==0 ){
                jsonMap.put("User"+count, arr2);
                arr2 = new String[3];
                count++;
                j=1;
            } 
            else {j++;}
            
         }   
         
      for (Map.Entry<String, String[]> entry : jsonMap.entrySet()) {
         String[] array = entry.getValue();
         String result = string.toString();
         result=result.replace("1",array[0]);
         result=result.replace("2",array[1]);
         result=result.replace("3",array[2]);
         logger(result, "Task3/textForwriting.txt");
      }
      

      
   }
}
