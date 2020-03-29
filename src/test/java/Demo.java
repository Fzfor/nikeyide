import java.io.FileWriter;
import java.io.IOException;

/**
 * Create by fz on 2020/3/23
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        //1.创建FileWriter对象
        FileWriter writer = new FileWriter("src\\names.txt",true);//追加
        //2.写入
        writer.write('中');
        writer.write("张三丰".toCharArray());
        writer.write("鸠摩智".toCharArray(), 2, 1);
        writer.write("古力娜扎");
        writer.write("古力娜扎", 3, 1);
        //3.关闭
//		writer.flush();//刷新，将内容写入到文件中
        writer.close();//①先刷新  ②关闭资源
    }
}
