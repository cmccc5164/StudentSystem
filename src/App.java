import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class App {
    public static void main(String[]args){
        ArrayList<User>list = new ArrayList<>();
        while(true){
            System.out.println("----------欢迎来到登录界面----------");
            System.out.println("请选择操作:1.登录 2.注册 3.忘记密码 4.退出");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch(choose){
                case "1"->login(list);
                case "2"->register(list);
                case "3"->forgetPassword(list);
                case "4"->{
                    System.out.println("谢谢使用,再见");
                    System.exit(0);
                }
                default->System.out.println("没有这个选项!");
            }
        }
        }
    private static int userContain(ArrayList<User>list, String username){
        for(int i=0;i<list.size();i++){
                if(username.equals(list.get(i).getUsername())){
                return i;
            }
        }
    return -1;
    }
    private static void register(ArrayList<User>list){
    Scanner sc = new Scanner(System.in);
    String username;
    String userPassword;
    String idCard;
    String phone;
    while(true){
        System.out.println("请输入用户名:");
        username = sc.next();
        boolean flag=checkUsername(list,username);
        if(!flag){
           continue;
        }
        else break;
    }
    while(true){
        System.out.println("请输入密码:");
        userPassword = sc.next();
        System.out.println("请再次输入密码:");
        String againUserPassword = sc.next();
        if(!userPassword.equals(againUserPassword)){
            System.out.println("您输入的两次密码不一致!");
            continue;
        }
        else break;
    }
    while(true){
        System.out.println("请输入身份证号码:");
        idCard = sc.next();
        boolean flag=checkIdCard(idCard);
        if(!flag){
            System.out.println("您输入的身份证有误,请核对再次输入!");
            continue;
        }
        else break;
    }
    while(true){
        System.out.println("请输入手机号:");
        phone = sc.next();
        boolean flag=checkPhone(phone);
        if(!flag){
            System.out.println("您输入的手机号有误,请核对再次输入!");
            continue;
        }
        else break;
    }
    User u =new User(username,userPassword,phone,idCard);
    list.add(u);
    System.out.println("注册成功!");
    return;
}

    private static boolean checkUsername(ArrayList<User>list,String username) {
        int len=username.length();
        if(len<3||len>15)
        {
            System.out.println("用户名长度必须在3-15之间!");
            return false;
        }
        int count1=0,count2=0;
        for(int i=0;i<len;i++){
            char ch = username.charAt(i);
            if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
                count1++;
            }
            else if(ch>='0'&&ch<='9'){
                count2++;
            }
            else{
                System.out.println("您的用户名只能包含字母和数字!");
                return false;
            }
        }
        if(count1==0||count2==0){
            System.out.println("您的用户名必须包含字母和数字!");
            return false;
        }
        if(userContain(list,username)!=-1){
            System.out.println("该用户名已存在!");
            return false;
        }
        return true;
    }
    private static boolean checkPhone(String phone){
        int len=phone.length();
        if(len!=11||phone.charAt(0)=='0'){
            return false;
        }
        for(int i=0;i<len;i++){
            char ch = phone.charAt(i);
            if(ch<'0'||ch>'9'){
                return false;
            }
        }
        return true;
    }

    private static void login(ArrayList<User>list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username =sc.next();
        int index=userContain(list,username);
        if(index==-1){
            System.out.println("用户名:"+username+"未注册,请先注册再登录!");
            return;
        }
        System.out.println("请输入密码:");
        String userPassword =sc.next();
        System.out.println("请再次输入密码:");
        String againUserPassword =sc.next();
        while(true){
            String rightCode = getCode();
            System.out.println("当前正确的验证码为:"+rightCode);
            System.out.println("请输入验证码:");
            String code = sc.next();
            if(!code.equalsIgnoreCase(rightCode)){
                System.out.println("验证码错误,请重新输入");
                continue;
            }
            else break;
       }
        boolean flag=checkUserInfo(index,userPassword,list);
        if(!flag){
            System.out.println("用户名或密码错误!");
            return;
        }
        else{
            System.out.println("登录成功!");
            StudentSystem ss = new StudentSystem();
            ss.startStudentSystem();
            return;
        }
}

    private static boolean checkUserInfo(int index, String userPassword, ArrayList<User> list) {
        if(list.get(index).getUserPassword().equals(userPassword))return true;
        else return false;
    }



    private static void forgetPassword(ArrayList<User>list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        int index=userContain(list,username);
        if(index==-1){
            System.out.println("用户"+username+"未注册,请先注册");
            return;
        }
        System.out.println("请输入身份证号码:");
        String idCard=sc.next();
        System.out.println("请输入手机号码:");
        String phone=sc.next();
        User u =new User();
        u=list.get(index);
        if(!(idCard.equalsIgnoreCase(u.getIdCard())&&phone.equals(u.getPhone()))){
            System.out.println("身份证号码或手机号码输入有误,不能修改密码");
            return;
        }
        String UserPassword;
        while(true){
            System.out.println("请输入新密码:");
            UserPassword = sc.next();
            System.out.println("请再次输入新密码:");
            String againUserPassword=sc.next();
            if(againUserPassword.equals(UserPassword)){
                break;
            }
            else{
                System.out.println("两次密码输入不一致,请重新输入!");
                continue;
            }
        }
        u.setUserPassword(UserPassword);
        System.out.println("修改成功!");
        return;
    }

    private static boolean checkIdCard(String idCard){
        int len=idCard.length();
        if(len!=18||idCard.charAt(0)=='0'){
            return false;
        }
        for(int i=0;i<len-1;i++){
            char ch = idCard.charAt(i);
            if(ch<'0'||ch>'9') {
                return false;
            }
        }
        char lastNumber = idCard.charAt(17);
        if((lastNumber<'0'||lastNumber>'9')&&(lastNumber!='x'&&lastNumber!='X')){
            return false;
        }
        return true;
    }
    private static String getCode(){
        ArrayList<Character>list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        Random r=new Random();
        StringBuilder captcha = new StringBuilder();
        for(int i=0;i<4;i++){
            int index = r.nextInt(list.size());
            captcha.append(list.get(index));
        }
        int randomNum = r.nextInt(10);
        captcha.append(randomNum);
        char[]arr =captcha.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char tmp=arr[randomIndex];
        arr[randomIndex]=arr[arr.length-1];
        arr[arr.length-1]=tmp;
        return new String(arr);
    }
}
