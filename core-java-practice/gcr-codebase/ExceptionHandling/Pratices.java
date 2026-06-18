import java.io.FileReader;

public class Pratices {
    public static void main(String[] args) throws Exception {
        int i = 0;
        try{
            FileReader read = new FileReader("question.txt");
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("xyzException");
        }
        
        func1();
        System.out.println("xyz");
    }
    
    static void func1() throws Exception{
        int i = 1;
        int age = 10;
        System.out.println(2/1);
        if(age<18)
            throw new AgeIsWrong();
    }
}