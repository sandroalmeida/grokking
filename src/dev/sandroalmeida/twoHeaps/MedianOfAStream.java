package dev.sandroalmeida.twoHeaps;

import java.util.LinkedList;
import java.util.List;

public class MedianOfAStream {

    private List<Integer> numbers = new LinkedList<>();

    public void insertNum(int num){

        if(numbers.size() == 0)
            numbers.add(num);
        else{
            for(int i = 0; i < numbers.size(); i++){
                if(numbers.get(i) > num){
                    numbers.add(i, num);
                    break;
                }
                if(i == numbers.size() - 1){
                    numbers.add(i+1, num);
                    break;
                }
            }
        }
    }

    public double findMedian(){
        int i = numbers.size() / 2;
        if(numbers.size() % 2 != 0){
            return numbers.get(i);
        } else{
            return (numbers.get(i) + numbers.get(i-1)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
