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
				System.out.println("1-���name");
				System.out.println("2-���name");
				System.out.println("3-����");
				System.out.println("�˳���������");
				System.out.println("��ѡ����Ҫ�Ĳ�����");
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
			e.printStackTrace();//��ӡ������쳣��Ϣ
		}finally{
			//in.close();
		}
	}
}
class Person
{
	private String name;
	private String t="name.txt";
	private ArrayList <String> arr= new ArrayList<String>();//�ɱ䴢�泤�ȵ�����

	public Person()throws Exception{
		FileWriter fw=new FileWriter(t,true);//����һ������ӵ��ļ�
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
		System.out.println("�����ѧ��name������esc�˳����");
		Scanner in =new Scanner(System.in);
		FileWriter writer =new FileWriter (t,true);
		do
		{
			name=in.nextLine();
			if (name.equals("esc")) break;//ע�Ᵽ֤name����Ϊ��
			arr.add(name);
			writer.write(name);//д���ļ�
			writer.write("\n");

		}
		while (true);
		writer.close();//�ر�д�������ͷ���Դ
	}
	public void speak(){
		for (int i=0;i<arr.size() ;i++ )//arr.size()��ȡ����
		{
			System.out.println("ѧ��"+(i+1)+"�ǣ�"+arr.get(i));

		}
	}
	public void random(){
		Random r=new Random();
		System.out.println("������"+arr.get(r.nextInt(arr.size())));
	}
}

