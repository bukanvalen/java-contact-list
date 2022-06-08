public interface IUserList {
    public void addUser(int id, String nama, String username, String password, String phoneNumber);
    public User getUser(int id, String nama, String username);
    public boolean checkUserList(int id, String nama, String username);
}
