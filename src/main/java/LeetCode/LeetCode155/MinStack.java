package LeetCode.LeetCode155;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MinStack {
    public MinStack() {
    }
    List<Integer> stack = new ArrayList<>();
    //建立最小栈，将时间复杂度由O(n)优化为O(1),来满足题目中要求的常数时间内获取最小值
    List<Integer> minStack = new ArrayList<>();

    public void push(int val) {
        this.stack.add(val);
        if (minStack.isEmpty() || val <= minStack.get(minStack.size() - 1)) {
            minStack.add(val);
        }
    }

    public void pop() {
        int topValue = this.stack.remove(this.stack.size() - 1);
        if (topValue == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
       return this.stack.get(this.stack.size()-1);
    }

    public int getMin() {
//        int min= this.stack.get(0);
//        for (Integer integer : this.stack) {
//            if (min > integer) {
//                min = integer;
//            }
//        }
//        return min;
        return minStack.get(minStack.size()-1);
    }
}
