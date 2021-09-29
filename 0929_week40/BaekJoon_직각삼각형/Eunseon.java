package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4153_직각삼각형 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue;
        while (true) {
            queue = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            queue.add(Integer.parseInt(st.nextToken()));
            queue.add(Integer.parseInt(st.nextToken()));
            queue.add(Integer.parseInt(st.nextToken()));

            //가장 큰 수의 제곱과 그 나머지의 제곱의 합이
            int one = queue.poll();
            int two = queue.poll();
            int three = queue.poll();

            if (one == 0 && two == 0 && three == 0) {
                break;
            }
            one = one * one;
            two = two * two;
            three = three * three;
            if (one + two == three) {
                sb.append("right");
                sb.append("\n");
            } else {
                sb.append("wrong");
                sb.append("\n");
            }
        }//end of while
        System.out.println(sb);
    }
}


/**
 * 과거 이집트 인들은 각 변들의 길이가 3,4,5인 삼각형이 직각 삼각형인것을 알아냈다.
 * 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하세요. :)
 *
 *
 * 입력 조건
 * 입력은 여러 개의 테케로 이루어진다.
 * 마지막 줄에는 0 0 0이 입력된다.
 * 각 테스트 케이스는 모두 30,000보다 작은 양의 정수로 주어진다.
 * 각 입력은 변을 의미한다.
 *
 * 출력 조건
 * 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
 */