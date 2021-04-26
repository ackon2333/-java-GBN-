import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyFileStream {
    public static void main(String[] args) throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
        //bis流的创建需要以一个输入流作为参数。这边使用的就是文件输入流fis。fis会根据你提供的地址打开对应文件流.
        //如果fis未找到指定文件，则会抛出异常。
        byte[] inputData = new byte[1024];
        //文件在bis流中是以二进制的方式存储，因此我们需要字节数组获得bis中的数据。
        int length = bis.read(inputData,0, inputData.length);
        //read函数：目标字节数组，偏移（起始位置），最大长度；返回值：实际读入长度。
        //如果文件读到末尾，无数据可读，此时read会返回-1，在实际使用中常常使用循环来读取大文件，length==-1即为循环跳出标识。

        String s = "";
        for(byte b:inputData){
            if(b==(byte)0) break;
            s+=b;
            s+=' ';
        }
        System.out.println("bis中的数据（二进制）："+s);
        //仔细观察你会发现，输出的恰好是a.txt中每个字符的Ascii码
        s = new String(inputData,0,length);
        System.out.println("bis中的数据（字符串）："+s);

        bis.close();
        //养成成功读入数据后关闭传输流的好习惯。

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("destination\\b.txt"));
        //bos的创建和bis类似。如果指定路径中不存在该文件，则bos会创造一个该文件。

        bos.write(inputData,0,length);
        //操作与read类似
        bos.flush();
        //清空缓冲流，将缓冲流中的内容写入下层流中。非常重要，切不可遗漏
        bos.close();
        //关闭输出流的好习惯。
        //此时你再打开destination文件夹会发现多了一个b.txt文件，其中的内容与a.txt中完全一致。
    }
}
