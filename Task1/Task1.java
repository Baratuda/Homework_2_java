package Task1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Task1 {
   
public static String inputMethod(Scanner sc, String message){
   System.out.println(message);
   String jsonString = sc.nextLine();
   return  jsonString;
}

public static void jsonParser(Map<String, String> jsonMap, String str){
      String[] arr = str.replaceAll("[\"{}]","").split(",");
      String[] arr2 = new String[arr.length];
      for(int i = 0; i<arr.length; i++){
         arr2 = arr[i].split(":");
         if(!arr2[0].equals("null") && !arr2[1].equals("null")) jsonMap.put(arr2[0], arr2[1]);
      }
}

public static StringBuilder outPutResult(Map<String, String> jsonMap, StringBuilder string){
   int count = 0;
   String helperString = null;
   for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
        helperString = entry.getKey() + " = " + entry.getValue();
        string.append(count==0?""+ helperString :" AND"+ helperString );
        count++;
   }
   return string;   
}
   public static void main(String[] args) {
      StringBuilder string = new StringBuilder( "select * from students WHERE ");
      Scanner sc = new Scanner(System.in);
      Map<String,String> jsonMap = new HashMap<>();
      String jsonString = inputMethod(sc, "Please input json String: ");

      jsonParser(jsonMap,jsonString);
      System.out.println(outPutResult(jsonMap, string));
   }
}
