public class z {
    public static int result(){
        int dem=0;
        for (int ai = 3;ai<=7;ai++){
            for (int bi=1;bi<49;bi++){
                for (int ci=0;ci<=5;ci++){
                    for (int di=0;di<49;di++){
                        if (50-ai-bi-ci-di>-1) dem++;
                    }
                }
            }
        }
        return dem;
    }
    public static void main(String[] args) {
        System.out.println(result());
    }
}
