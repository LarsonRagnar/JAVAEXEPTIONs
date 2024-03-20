/**
* Заставьте выполниться следующий код
*/
public class Task4 {
    public static void main(String[] args) {
    InputStream inputStream;
    try {
    String[] strings = {"asdf", "asdf"};
    String str = strings[1];
    test();
    int a = 1 / 0;
    
    inputStream = new FileInputStream("sdafgdsaf");
    }
    catch (Throwable e) {
    e.printStackTrace();
    }
    catch (StackOverflowError error) {
    System.err.println("stack overflow error");
    }
