/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_analyzer;
import java.io.*;
import java.util.*;
/**
 * 
 * @author taylorjh
 */
public class Data_Analyzer{
    
    private ArrayList<Double> nums;
    private Double max;
    private Double min;
    private Double avg;
    
    public Data_Analyzer(){
        nums = new ArrayList<Double>();
    }
    public Data_Analyzer(Data_Getter d){
        nums = new ArrayList(d.give_nums());
        analyze_data();
    }
    
    public void add_num(Double d){
    try{
        nums.add(d);
        analyze_data();
    } catch(IllegalArgumentException e){
        System.out.println("Error: Tried to add not a number");
    }
    }
    
    public void print_nums(){
       
        for(Double element : nums){
            System.out.println(element);
        }
    }
    
    public int array_counter(){
        return nums.size();
    }
    
    private void analyze_data(){

   
        try{
            max = nums.get(0);
            min = nums.get(0);
            
            }
        catch(NoSuchElementException e){
            System.out.println("Array is empty");
            return;
            }
        
        Double sum = 0.0;
        
        for (Double number : nums){
            if(number > max){
                max = number;
            }
            if(number < min){
                min = number;
            }
            sum += number;
        }
            avg = sum / nums.size();
            
           
    
    }
    public Double max(){
      
        return max;
    }
    public Double min(){
        return min;
    }
    public Double avg(){
        return avg;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Data_Getter data_getter;
       try{
           data_getter = new Data_Getter(args[0]);
       } catch(IndexOutOfBoundsException e){
           data_getter = new Data_Getter();
       }
       Data_Analyzer data_analyzer = new Data_Analyzer(data_getter);
       
       System.out.println("The average of the numbers you entered is " + data_analyzer.avg());
       System.out.println("The max of the numbers you entered is " + data_analyzer.max());
       System.out.println("The min of the numbers you entered is " + data_analyzer.min());
    }
    
}
