import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMain {
	public static void main(String args[]){
		try (BufferedReader b = new BufferedReader(new FileReader(args[0]));){
			System.out.println("Reading from file:" + args[0]);
			String s = null;
			while((s = b.readLine()) != null) {
			System.out.println(s);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("未輸入檔案名");
			System.err.println("程式結束");
			System.exit(0);
		} catch(FileNotFoundException ea) {
			System.err.println("未找到檔案");
			System.err.println("程式結束");
			System.exit(0);
		} catch(IOException es) {
			System.err.println("檔案讀取失敗");
			System.err.println("程式結束");
			System.exit(0);
		} 
	}
}
