package Tests;

import org.testng.annotations.Test;

public class StructuriRepetitive {
    // structuri repetitive = for, while, for each



    @Test
    public void metodaTest(){
    //afisamPrimele15Nr(5);
        afisamNrPare();
    }

    //afisam primele 15 numere
    public void afisamPrimele15Nr(Integer capat){
        for (Integer index = 0; index <= capat; index ++) {
            System.out.println(index);
        }
    }

    //aceeasi metoda cu while

    public void afisamPRimele15NRWhile(Integer capat){
        Integer index = 0;
        while (index <= capat){
            System.out.println(index);
            index++;
        }
    }

    //afisez nr pare de la 0 la 20

    public void afisamNrPare(){
        for (Integer i = 0; i <= 20; i++ ){
            if(i%2 == 0)
            System.out.println(i);
        }
    }
}
