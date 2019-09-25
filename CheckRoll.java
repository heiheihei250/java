import java.util.*;
import java.io.*;
class CheckRoll 
{
	public static void main(String[] args)throws Exception 
	{
		try
		{	
			int n;
			Scanner in =new Scanner(System.in);
			Person p=new Person();
			do
			{
				System.out.println("1-添加name");
				System.out.println("2-输出name");
				System.out.println("3-点名");
				System.out.println("退出点击任意键");
				System.out.println("请选择需要的操作：");
				n=in.nextInt();
				if (n==1)
				{
					p.addStudent();
				}
				else if (n==2)
				{
					p.speak();
				}
				else if (n==3)
				{
					p.random();
				}
				else break;

			}
			while (true);
		}
		catch (Exception e)
		{
			e.printStackTrace();//打印捕获得异常信息
		}finally{
			//in.close();
		}
	}
}
class Person
{
	private String name;
	private String t="name.txt";
	private ArrayList <String> arr= new ArrayList<String>();//可变储存长度的数组

	public Person()throws Exception{
		FileWriter fw=new FileWriter(t,true);//建立一个可添加的文件
		fw.close();
		FileReader reader=new FileReader(t);
		BufferedReader br = new BufferedReader (reader);
		while ((name=br.readLine())!=null)
		{
			arr.add(name);
		}
		br.close();
	}
	public void addStudent()throws Exception{
		System.out.println("请添加学生name，输入esc退出添加");
		Scanner in =new Scanner(System.in);
		FileWriter writer =new FileWriter (t,true);
		do
		{
			name=in.nextLine();
			if (name.equals("esc")) break;//注意保证name不能为空
			arr.add(name);
			writer.write(name);//写入文件
			writer.write("\n");

		}
		while (true);
		writer.close();//关闭写入流，释放资源
	}
	public void speak(){
		for (int i=0;i<arr.size() ;i++ )//arr.size()获取长度
		{
			System.out.println("学生"+(i+1)+"是："+arr.get(i));

		}
	}
	public void random(){
		Random r=new Random();
		System.out.println("请起立"+arr.get(r.nextInt(arr.size())));
	}
}

