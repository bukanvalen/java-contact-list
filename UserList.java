import java.util.ArrayList;

public class UserList implements IUserList {
    private ArrayList<User> userList;

    public UserList() {
        userList = new ArrayList<User>();
    }

    public void addUser(int id, String nama, String username, String password, String phoneNumber) {
        userList.add(new User(id, nama, username, password, phoneNumber));
    }

    public User getUser(int id, String nama, String username) {
        int i;
        
        for (i = 0; i < userList.size(); i++) {
            if (userList.get(i).checkUser(id, nama, username))
                break;
        }
        return userList.get(i);
    }

    public boolean checkUserList(int id, String nama, String username) {
        int i;

        for (i = 0; i < userList.size(); i++) {
            if (userList.get(i).checkUser(id, nama, username))
                return true;
        } return false;
    }

}
