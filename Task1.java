import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Task1 {

static String inputMethod(Scanner sc, String message){
   System.out.println(message);
   String jsonString = sc.nextLine();
   return  jsonString;
}
   public static void main(String[] args) {
      StringBuilder string = new StringBuilder( "select * from students WHERE");
      Scanner sc = new Scanner(System.in);
      Map<String,String> jsonMap = new HashMap<>();
      String[] arr = inputMethod(sc, "Please input json String: ").replaceAll("[\"{}]","").split(",");
      String[] arr2 = new String[arr.length];
      String helperString = null;
      int count = 0;

      for(int i = 0; i<arr.length; i++){
         arr2 = arr[i].split(":");
         if(!arr2[0].equals("null") && !arr2[1].equals("null")) jsonMap.put(arr2[0], arr2[1]);
      }
      
      for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
        helperString = entry.getKey() + " = " + entry.getValue();
        string.append(count==0?""+ helperString :" AND"+ helperString );
        count++;
      }
      System.out.println(string);
   }
}
