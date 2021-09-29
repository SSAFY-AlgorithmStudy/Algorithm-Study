package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기2 {

    public static int sum = 0;
    public static int N;

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }//end of Input
        while(queue.size()>1) {
            int num = queue.poll() + queue.poll();
            sum += num;
            queue.add(num);
        }//end of for
        System.out.println(sum);
    }//end of main

}//end of class

/**
 * 입력 조건
 * 1. 첫째 줄에 N이 주어진다.
 * 2. 이어서 N개의 줄에 걸쳐 카드 묶음의 각각의 크기가 주어진다.
 * 3. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.
 * <p>
 * 출력 조건
 * 1. 첫째 줄에 최소 비교 횟수를 출력한다.
 * <p>
 * <p>
 * 1. 기본 조합 알고리즘을 작성한다.
 * 2. 여기서 합을 구해 최소를 찾는다.
 */