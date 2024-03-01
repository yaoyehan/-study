import java.util.HashMap;
import java.util.Map;

public class Db {
    Map<String,User> userMap=new HashMap<String,User>();

    public User getbyDb(String username) throws CloneNotSupportedException {
        if(userMap.get(username)!=null){
            User user = userMap.get(username);
            User clone = user.clone();
            return clone;
        }else {
            User getuserbydb = getuserbydb(username);
            User clone = getuserbydb.clone();
            return clone;
        }
    }
    public User getuserbydb(String username){
        System.out.println("从数据库中查询");
        User user = new User();
        user.setUsername(username);
        user.setAge(18);
        userMap.put(username,user);
        return user;
    }
}
