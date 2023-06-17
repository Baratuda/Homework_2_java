import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
   public static void main(String[] args) {
      StringBuilder string = new StringBuilder("Student 1 had the 2 for 3 subject.");
      Scanner sc = new Scanner(System.in);
      Map<String,String[]> jsonMap = new HashMap<>();
      String str = Task1.inputMethod(sc, "Please input json String: ");
      String[] arr = str.replaceAll("[\"{}]","").split(",");
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
         System.out.println(result);
      }
      
   }
}
