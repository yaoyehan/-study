public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Db db = new Db();
        User zhangsan1 = db.getbyDb("zhangsan");
        System.out.println(zhangsan1.toString());
        zhangsan1.setAge(1999);
        User zhangsan2 = db.getbyDb("zhangsan");
        System.out.println(zhangsan2.toString());
        User zhangsan3 =  db.getbyDb("zhangsan");
        System.out.println(zhangsan3.toString());
        User zhangsan4 =  db.getbyDb("zhangsan");
        System.out.println(zhangsan4.toString());
    }
}
