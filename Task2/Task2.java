package Task2;
import java.io.FileWriter;
public class Task2 {

   static void logger(int[] array, int numberIteration , String path){
      try(FileWriter fw = new FileWriter(path,true)) {
         fw.write(numberIteration+") ");
         for(int i = 0; i<array.length; i++) fw.write(array[i]+", ");
         fw.write("\n");
      } catch (Exception e) {
         System.out.println("Что-то пошло не так.");
      }
   }
   public static void main(String[] args) {
      int[] array = {7,8,3,8,1,2,4,6,8,9,34,76,234,567,1234,56756,224,234,2,456,675,234,645,79};

      int x = 0;
      for(int i = 0; i<array.length; i++){
         for(int j = array.length-1; j!=i; j--){
             if(array[j]<=array[i]){
               x = array[i];
               array[i] = array[j];
               array[j] = x;
             }
         }
         logger(array,i,"Task2/text.txt");
      }

      
   }
}
