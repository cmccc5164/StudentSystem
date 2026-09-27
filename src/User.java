public class User {
    private String username;
    private String UserPassword;
    private String phone;
    private String idCard;
    public User(){};
    public User(String username, String userPassword, String phone, String idCard) {
        this.username = username;
        UserPassword = userPassword;
        this.phone = phone;
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
