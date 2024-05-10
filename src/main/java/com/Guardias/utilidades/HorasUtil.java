/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Fran
 */
public class HorasUtil {
    
    public static String DateToHorasMinutos(Date date){
        
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        
        return formatter.format(date);
        
    }
    
    public static Date horasMinutosToDate(String horasMinutos){
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        Date fechaDate = null;
        
        try{
            Date date = sdf.parse(horasMinutos);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            
            fechaDate = calendar.getTime();
            
        }catch(ParseException ex){
            
            System.out.println(ex.getMessage());
            
        }
        
        return fechaDate;
        
    }
    
}
