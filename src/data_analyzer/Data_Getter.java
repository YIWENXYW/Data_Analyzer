/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_analyzer;

import java.util.Vector;
import java.io.*;

/**
 *
 * @author taylorjh
 */
public class Data_Getter {
    Vector<Double> nums = new Vector<Double>(0);
    
    public Data_Getter(){
        get_nums();
    }
    public Data_Getter(String file_name){
        System.out.println(file_name);
        try{
            String current_line;
            BufferedReader in = new BufferedReader(new FileReader(file_name));
            while((current_line = in.readLine()) != null){
                try{
                    nums.addElement(Double.parseDouble(current_line));
                } catch(NumberFormatException e){
                    System.out.println("Error: File contains non-number elements");
                }
            }
        } catch(IOException e){
            System.out.println("No such file");
        }
    }
    
    public void get_nums(){
        
        String n = new String("\n");
        boolean is_num = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(is_num){
        
            System.out.println("Please enter a number");
                try{
                 n = in.readLine();
                } catch(Exception e){
                    e.printStackTrace();
                }
                try{
                    Double new_num = Double.parseDouble(n);
                    nums.addElement(new_num);
                    
                } catch(NumberFormatException nfe){
                    System.out.println(n);
                    if (n.equals("")){
                        is_num = false;
                    }else{
                        System.out.println("Error: Please print a number!");
                    }
                }
        }
    }
    public Vector<Double> give_nums(){
        return nums;
    }
}
