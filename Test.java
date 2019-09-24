import java.io.*;
import java.util.*;

class CallTheRoll
{
	private String name;
	private String p = "name.txt";
	private ArrayList<String> s = new ArrayList<String>();

	public CallTheRoll() throws Exception{
		FileWriter w = new FileWriter(p,true);
		w.close();
		BufferedReader br = new BufferedReader(new FileReader(p));
		while((name = br.readLine() )!= null){
			s.add(name);
		}
		br.close();
	}

	public void addStudent() throws Exception{
		System.out.println("��������Ҫ��ӵ�ѧ��������������λexitʱ����������");
		Scanner in = new Scanner(System.in);
		FileWriter writer = new FileWriter(p,true);
		while(true){
			name = in.nextLine();
			if(name.equals("exit")) break;
			s.add(name);
			writer.write(name);
			writer.write("\n");
		}
		writer.close();
	}

	public void print(){
		for(int i=0;i<s.size();i++){
			System.out.print("��");
			if(i<9) System.out.print(0);
			System.out.println((i+1)+"λѧ����: "+s.get(i));
		}
	}

	public void random(){
		Random r = new Random();
		System.out.println(s.get(r.nextInt(s.size())));
	}
}

public class Test
{
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		try{
			CallTheRoll ctr = new CallTheRoll();
			boolean flag = true;
			int n;
			while(flag){
				System.out.println("1,���ѧ����Ϣ��2,����ѧ����Ϣ��3,���ѡ��ѧ��������,����");
				System.out.print("������: ");
				n = in.nextInt();
				if(n == 1) ctr.addStudent();
				else if(n == 2) ctr.print();
				else if(n == 3) ctr.random();
				else flag = false;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			in.close();
		}
	}
}