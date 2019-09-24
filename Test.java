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
		System.out.println("请输入想要添加的学生姓名，当输入位exit时，结束输入");
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
			System.out.print("第");
			if(i<9) System.out.print(0);
			System.out.println((i+1)+"位学生是: "+s.get(i));
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
				System.out.println("1,添加学生信息；2,遍历学生信息；3,随机选出学生；其他,结束");
				System.out.print("请输入: ");
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