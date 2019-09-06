package cn.hjmao.leetcode.a1010pairsofsongswithtotaldurationsdivisibleby60;

/**
 * Created by hjmao.
 *
 * URL:
 * =====
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Desc:
 * =====
 * In a list of songs, the i-th song has a duration of time[i] seconds. 
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 *
 * Example 2:
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 *
 * Note:
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 5000
 */

class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int[] mod = new int[60];
    for (int timex: time) {
      mod[timex % 60]++;
    }
    int pairs = mod[0] * (mod[0] - 1) / 2 + mod[30] * (mod[30] - 1) / 2;

    for (int i = 1; i < 30; i++) {
      pairs += mod[i] * mod[60 - i];
    }
    return pairs;
  }
}
