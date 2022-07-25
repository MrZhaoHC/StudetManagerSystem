package ZhaoHaoCheng;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager
{
    public static void main(String[] args)
    {
        //创建集合对象用于存储学生数据
        ArrayList<Student>array=new ArrayList<Student>();


        while (true)
        {
            System.out.println("----------学生管理系统----------");
            System.out.println("                              ");
            System.out.println("          1.添加学生           ");
            System.out.println("          2.删除学生           ");
            System.out.println("          3.修改学生           ");
            System.out.println("          4.查看所有学生        ");
            System.out.println("          5.退出               ");
            System.out.println("                              ");
            System.out.println("------------------------------");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            switch (input)
            {
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    changeStudent(array);
                    break;
                case "4":
                    showStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用！");
                    System.exit(0);//JVM退出
                    break;
                default:
                    System.out.println("您的输入有误请重新输入！");
            }//switch
        }//while
    }//main

    //添加学生
    public static void addStudent(ArrayList<Student>array)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入学生学号：");
        String sid=sc.nextLine();
        System.out.println("请输入学生姓名：");
        String name=sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age=sc.nextLine();
        System.out.println("请输入学生居住地：");
        String adress=sc.nextLine();

        Student s=new Student();//创建学生对象
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAdress(adress);

        array.add(s);

        System.out.println("学生添加成功！");

    }//addStudent

    //删除学生信息
    public static void deleteStudent(ArrayList<Student>array)
    {
        if (array.size()==0)
        {
            System.out.println("没有学生信息!");
            return;
        }//if
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要删除学生的学号：");
        String sid=sc.nextLine();
        for (int i=0;i<array.size();i++)
        {
            Student s=array.get(i);
            if(s.getSid().equals(sid))
            {
                array.remove(i);
                System.out.println("学生信息删除成功！");
                return;
            }
        }//for
        System.out.println("没有找到你要删除学生信息！");
    }//deleteStudent

    //修改学生信息
    public  static void changeStudent(ArrayList<Student>array)
    {
        if (array.size()==0)
        {
            System.out.println("没有学生信息!");
            return;
        }//if

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要修改学生学号：");
        String sid =sc.nextLine();

        System.out.println("请输入学生新学号：");
        String newsid=sc.nextLine();
        System.out.println("请输入学生新姓名：");
        String newname=sc.nextLine();
        System.out.println("请输入学生新年龄：");
        String newage=sc.nextLine();
        System.out.println("请输入学生新地址：");
        String newadress=sc.nextLine();

        Student s=new Student();
        s.setSid(newsid);
        s.setName(newname);
        s.setAge(newage);
        s.setAdress(newadress);

        for (int i=0;i< array.size();i++)
        {
            Student st=array.get(i);
            if (st.getSid().equals(sid))
            {
                array.set(i,s);
                System.out.println("学生信息修改成功!");
                return;
            }//if
        }//for
        System.out.println("没有找到你要修改的学生信息！");

    }//changeStudent

    //查看学生信息
    public static void showStudent(ArrayList<Student>array)
    {
        if (array.size()==0)
        {
            System.out.println("没有学生信息!");
            return;
        }//if
        System.out.println("学号\t\t\t\t姓名\t\t年龄\t\t居住地");
        for (int i=0;i<array.size();i++)
        {
            Student s=array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t\t"+s.getAdress());
        }//for
    }//showStudent
}//StudentManager


