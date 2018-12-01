import java.util.Scanner;

class Task2d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] m=new double[3][2];
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = in.nextDouble();
            }
            System.out.println();
        }
        boolean[] bool = new boolean[4];
        //определяем в каких четвертях находятся вершины
        if ((m[0][0]>0 && m[0][1]>0)||(m[1][0]>0 && m[1][1]>0)||((m[2][0]>0 && m[2][1]>0)))
            bool[0]=true;
        if ((m[0][0]<0 && m[0][1]>0)||(m[1][0]<0 && m[1][1]>0)||((m[2][0]<0 && m[2][1]>0)))
            bool[1]=true;
        if ((m[0][0]<0 && m[0][1]<0)||(m[1][0]<0 && m[1][1]<0)||((m[2][0]<0 && m[2][1]<0)))
            bool[2]=true;
        if ((m[0][0]>0 && m[0][1]<0)||(m[1][0]>0 && m[1][1]<0)||((m[2][0]>0 && m[2][1]<0)))
            bool[3]=true;
        //ищим точки в диагональных четвертях
        for (int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if ((m[i][0]>=0 && m[j][0]<=0 && m[i][1]>=0 && m[j][1]<=0)||(m[i][0]<=0 && m[j][0]>=0 && m[i][1]<=0 && m[j][1]>=0)||(m[i][0]<=0 && m[j][0]>=0 && m[i][1]>=0 && m[j][1]<=0)||(m[i][0]>=0 && m[j][0]<=0 && m[i][1]<=0 && m[j][1]>=0)){
                    double b,k;
                    k=(m[i][1]-m[j][1])/(m[i][0]-m[j][0]);
                    b=m[i][1]-k*m[i][0];
                    if (b==0)
                        break;
                    else {
                        if (b>0){
                            if (k>0)
                                bool[1]=true;
                            if (k<0)
                                bool[0]=true;
                        }
                        else{
                            if (k>0)
                                bool[3]=true;
                            if (k<0)
                                bool[2]=true;
                        }
                    }
                }
            }

        }
        for (int a,i=0;i<4;i++){
            if (bool[i]) {
                a=i+1;
                System.out.print(a + " ");
            }
        }
    }
}