import java.io.File;

public class pddaowdb {
    public static void main(String[] args) {

        extracted("C:\\Users\\y'y'h\\Desktop\\新建文件夹\\base\\user\\impl");
    }

    private static void extracted(String strname) {
        File file = new File(strname);
        File[] list = file.listFiles();
        for (int i = 0; i < list.length; i++) {
            if(list[i].isDirectory()) {
                extracted(list[i].getAbsolutePath());
            }else {
                String name = list[i].getName();
                //  我这里是通过下标来找到字符串的位置，也可以有很多种方式，比如，lastIndexOf()
                //  具体请学习String的常用方法
                name= name.substring(2,name.length());
                name="Wbd"+name;
                //  接下来就是将文件名修改 【XXX项目】+你截取的字符串
                //  我截取的是整条文件名
                //  也可以通过i进行排列，比如：加上i+"、"就会变成  1、【XXX项目】文件名称
                String absolutePath = list[i].getParent();
                //  将文件保存回aaa文件夹，也可存放在其他你需要保存的地方
                File dest = new File(absolutePath+"/"+name);
                list[i].renameTo(dest);
                System.out.println(dest.getName());
        }
    }
}
}
