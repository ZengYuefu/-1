package structure;
import java.util.Random;
public class process {
	public static void main(String[] args)
	{
		short[] m=new short[50];
		short[] n=new short[50];
		short[] ov=new short[50];//��������
		Exercise(m,n,ov);
		Calculation(m,n,ov);//���ú���
	}
	
	public static void Exercise(short[] m,short[] n,short[] ov) {
		System.out.println("ϰ��:");
		char sign='+';
		Random random=new Random();//����random.nextInt����
		for(int i=0;i<50;i++) {
		    ov[i]=(short)random.nextInt(2);//ov�������0��1
			if((ov[i])==1) {
				while(true){//�жϺͲ��ܳ���һ��
					short m1=(short)random.nextInt(101);//m1�������0-100֮�����
					short n1=(short)random.nextInt(101);//n1�������0-100֮�����
					if(m1+n1<=100) {
						m[i]=m1;
						n[i]=n1;
						break;//�����С��100�����������ֵ��m[i]��n[i]
						}
					}
					sign='+';
				}
			else {
				while(true){//�жϲ��С����
					short m1=(short)random.nextInt(101);//m1�������0-100֮�����
					short n1=(short)random.nextInt(101);//n1�������0-100֮�����
					if(m1-n1>0) {
						m[i]=m1;
						n[i]=n1;
						break;//�����С��100�����������ֵ��m[i]��n[i]
						}	
					}
					sign='-';
				}
			for(int k=0;k<49;k++) {//�ж��ظ�
				for(int j=k+1;j<50;j++) {
					if(((m[k]==m[j])&&(n[k]==n[j])&&(ov[k]==ov[j]))||((ov[k]==1)&&(m[k]==n[j])&&(n[k]==m[j]))) {
						m[k]=(short)random.nextInt(101);//m[k]�������0-100֮�����
						n[k]=(short)random.nextInt(101);//n[k]�������0-100֮�����
						ov[k]=(short)random.nextInt(2);//ov[k]�������0��1
						k=0;
						break;
						}
					}	
				}
			System.out.print("("+(i+1)+")"+":\t"+m[i]+sign+n[i]+"=\t"+"\t");//������
			if((i+1)%5==0)
				System.out.println();//5������һ��
			}
		}
	
	public static void Calculation(short[] m,short[] n,short[] ov) {
		System.out.println(); 
		System.out.println("��:");
		for(int i=0;i<50;i++) {
			if(ov[i]==1) {
				int answer=m[i]+n[i];//������������
				System.out.print("("+(i+1)+")"+":\t"+answer+"\t");//������
				if((i+1)%5==0) {
					System.out.println();//5������һ��
					}		
				}
			else {
				int answer=m[i]-n[i];//�����������Ӽ�
				System.out.print("("+(i+1)+")"+":\t"+answer+"\t");//������
				if((i+1)%5==0) {
					System.out.println();//5������һ��
					}	
				}
			}
		}
}