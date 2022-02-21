package tsdv;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //N courses
    private int N;
    //M periods
    private int M;
    //C array has credits
    private int[] C;
    // matrix has the prerequisites constraints
    private int[][] A;

    private int[] sort;

    public ArrayList<Integer> prerequisites;

    private int resultOfBACP = 999;

    public void getData(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        C = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            C[i] = sc.nextInt();
        }
        A = new int[N + 1][N + 1];
        for (int row = 1; row <= N; row++){
            for (int col = 1; col <= N; col++) {
                A[row][col] = sc.nextInt();
            }
        }
        //save prerequisite information
        prerequisites = new ArrayList<>();
        for (int row = 1; row <= N; row++){
            for (int col = 1; col <= N; col++) {
                if (A[row][col] == 1){
                    prerequisites.add(row);
                    prerequisites.add(col);
                }
            }
        }
    }

    public void solve(){
        sort = new int[N+2];
        for (int j = 1; j <= N; j++) {
            sort[j] = 1;
        }
        arrange(1);
    }

//    public void arrange(int local){
//        for (int i = local; i <= N; i++) {
//            if (sort[local] < M){
//                sort[local] += 1;
//                calculateMax();
//            }else {
//                sort[local] = 1;
//                local++;
//                arrange(local);
//            }
//        }
//    }

    public void arrange(int local){
        for (int i = 1; i <= local; i++) {
//            if (sort[local] == M && local == N){
//                System.out.println("hehe");
//            }else
            if (i == local && sort[local] == M){
                if (local != N){
                    sort[local] = 1;
                    sort[local + 1] += 1;
                    calculateMax();
                    if (local < 6) arrange(local + 1);
                }else{
                    System.out.println("hehe");
                }

            }else if(i < local){
                if (sort[i] == M){
                    sort[i] = 1;
                }else{
                    sort[i] +=1;
                    calculateMax();
                    arrange(local);
                    break;
                }
            }else{
                sort[local] += 1;
                calculateMax();
                arrange(local);
            }
        }
    }

    public void calculateMax(){
        int tempMax = 0;
        if (check()){
            for (int i = 1; i <= M; i++){

                int countCredit = 0;
                for (int j = 1; j <= N; j++){
                    if (sort[j] == i) countCredit += C[j];
                }
                if (tempMax < countCredit) tempMax = countCredit;
            }
            if (resultOfBACP > tempMax) resultOfBACP = tempMax;
        }
    }

    public boolean check(){
        Boolean resultCheck = true;
        for (int i = 0; i <= prerequisites.size() - 2; i= i+2) {
            int before = prerequisites.get(i);
            int after = prerequisites.get(i + 1);
            if (sort[before] - sort[after] >= 0) {
                resultCheck = false;
                break;
            }
        }
        return resultCheck;
    }

    public static void main(String[] args) {
	// write your code here
        Main app = new Main();
        app.getData();
        app.solve();
        System.out.println(app.resultOfBACP);
    }
}
