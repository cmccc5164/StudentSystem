import java.util.Scanner;
import java.util.ArrayList;
public class StudentSystem {
    public static void startStudentSystem(){
    Scanner sc = new Scanner(System.in);
    ArrayList<Student>list = new ArrayList<>();
    while(true){
        showMenue();
        String choose=sc.next();
        switch(choose){
            case "1":addStudent(list);break;
            case "2":deleteStudent(list);break;
            case "3":uppdataStudent(list);break;
            case "4":queryStudent(list);break;
            case "5":System.exit(0);
        }
    }

    }
    public static void showMenue(){
        System.out.println("---------欢迎来到学生成绩管理系统---------");
        System.out.println("1:添加学生");
        System.out.println("2:删除学生");
        System.out.println("3:修改学生");
        System.out.println("4:查找学生");
        System.out.println("5:退出");
        System.out.println("请输入您的选择:");
    }
    public static void addStudent(ArrayList<Student>list){
        Scanner sc = new Scanner(System.in);
        Student stu=new Student();
        System.out.println("请输入添加学生ID:");
        String id=sc.next();
        int index=contain(list,id);
        if(index!=-1){
            System.out.println("该学生ID已存在!");
            return;
        }
        stu.setId(id);
        System.out.println("请输入添加学生姓名:");
        String name=sc.next();
        stu.setName(name);
        System.out.println("请输入添加学生年龄:");
        int age = sc.nextInt();
        stu.setAge(age);
        System.out.println("请输入添加学生家庭住址:");
        String address=sc.next();
        stu.setAddress(address);
        list.add(stu);
        System.out.println("添加学生成功!");
        return;
    }
    public static void deleteStudent(ArrayList<Student>list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除学生id:");
        String id=sc.next();
        int index=contain(list,id);
        if(index==-1){
            System.out.println("找不到该学生!");
            return;
        }
        else{
            System.out.println("您删除的学生信息为:");
            System.out.println("id\t姓名\t年龄\t家庭住址");
            System.out.println(list.get(index).getId()+"\t"+list.get(index).getName()+"\t"+list.get(index).getAge()+"\t"+list.get(index).getAddress());
            System.out.println("您确认删除该名学生吗?");
            System.out.println("请输入y/n:");
            String choice = sc.next();
            if(choice.equals("y")||choice.equals("Y")){
                list.remove(index);
                System.out.println("已成功删除");
            }
            else{
                System.out.println("已取消删除");
            }
        }
        return;
    }
    public static void uppdataStudent(ArrayList<Student>list){
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入修改学生ID:");
        String id=sc.next();
        int index=contain(list,id);
        if(index==-1){
            System.out.println("找不到该学生!");
            return;
        }
        else{
            System.out.println("您修改的学生原信息为:");
            System.out.println("id\t姓名\t年龄\t家庭住址");
            System.out.println(list.get(index).getId()+"\t"+list.get(index).getName()+"\t"+list.get(index).getAge()+"\t"+list.get(index).getAddress());
            stu=list.get(index);
        }
        System.out.println("请输入修改后的id:");
        String id2 = sc.next();
        stu.setId(id2);
        System.out.println("请输入修改后的姓名:");
        String name2 = sc.next();
        stu.setName(name2);
        System.out.println("请输入修改后的年龄:");
        int age2 = sc.nextInt();
        stu.setAge(age2);
        System.out.println("请输入修改后的家庭住址:");
        String address2 = sc.next();
        stu.setAddress(address2);
        System.out.println("修改成功!");
        return;
    }
    public static void queryStudent(ArrayList<Student>list){
        if(list.isEmpty()){
            System.out.println("当前无学生信息,请添加后再查询");
            return;
        }
        else{
            System.out.println("id\t姓名\t年龄\t家庭住址");
            for(int i=0;i<list.size();i++){
                Student stu=list.get(i);
                System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
            }
        }
    }
    public static int contain(ArrayList<Student>list,String id){
        for(int i=0;i<list.size();i++){
            if(id.equals(list.get(i).getId())){
                return i;
            }
        }
        return -1;
    }
}
