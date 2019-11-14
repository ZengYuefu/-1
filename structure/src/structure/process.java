package structure;
import java.util.Random;
public class process {
	public static void main(String[] args)
	{
		short[] m=new short[50];
		short[] n=new short[50];
		short[] ov=new short[50];//创建数组
		Exercise(m,n,ov);
		Calculation(m,n,ov);//调用函数
	}
	
	public static void Exercise(short[] m,short[] n,short[] ov) {
		System.out.println("习题:");
		char sign='+';
		Random random=new Random();//调用random.nextInt函数
		for(int i=0;i<50;i++) {
		    ov[i]=(short)random.nextInt(2);//ov随机生成0或1
			if((ov[i])==1) {
				while(true){//判断和不能超过一百
					short m1=(short)random.nextInt(101);//m1随机生成0-100之间的数
					short n1=(short)random.nextInt(101);//n1随机生成0-100之间的数
					if(m1+n1<=100) {
						m[i]=m1;
						n[i]=n1;
						break;//如果和小于100，把随机数赋值给m[i]和n[i]
						}
					}
					sign='+';
				}
			else {
				while(true){//判断差不能小于零
					short m1=(short)random.nextInt(101);//m1随机生成0-100之间的数
					short n1=(short)random.nextInt(101);//n1随机生成0-100之间的数
					if(m1-n1>0) {
						m[i]=m1;
						n[i]=n1;
						break;//如果和小于100，把随机数赋值给m[i]和n[i]
						}	
					}
					sign='-';
				}
			for(int k=0;k<49;k++) {//判断重复
				for(int j=k+1;j<50;j++) {
					if(((m[k]==m[j])&&(n[k]==n[j])&&(ov[k]==ov[j]))||((ov[k]==1)&&(m[k]==n[j])&&(n[k]==m[j]))) {
						m[k]=(short)random.nextInt(101);//m[k]随机生成0-100之间的数
						n[k]=(short)random.nextInt(101);//n[k]随机生成0-100之间的数
						ov[k]=(short)random.nextInt(2);//ov[k]随机生成0或1
						k=0;
						break;
						}
					}	
				}
			System.out.print("("+(i+1)+")"+":\t"+m[i]+sign+n[i]+"=\t"+"\t");//输出结果
			if((i+1)%5==0)
				System.out.println();//5个换行一次
			}
		}
	
	public static void Calculation(short[] m,short[] n,short[] ov) {
		System.out.println(); 
		System.out.println("答案:");
		for(int i=0;i<50;i++) {
			if(ov[i]==1) {
				int answer=m[i]+n[i];//两个随机数相加
				System.out.print("("+(i+1)+")"+":\t"+answer+"\t");//输出结果
				if((i+1)%5==0) {
					System.out.println();//5个换行一次
					}		
				}
			else {
				int answer=m[i]-n[i];//两个随机数相加减
				System.out.print("("+(i+1)+")"+":\t"+answer+"\t");//输出结果
				if((i+1)%5==0) {
					System.out.println();//5个换行一次
					}	
				}
			}
		}
}