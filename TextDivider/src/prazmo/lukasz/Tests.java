package prazmo.lukasz;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2016-09-24.
 */
public class Tests
{
    String testString = "Litwo! Ojczyzno maja! Ty jesteś jak zdrowie, \n" +
            "Ile cię trzeba cenić, ten tylko się dowie, \n" +
            "Kto cię stracił. Dziś piękność twą w całej ozdobie \n" +
            "Widzę i opisuję, bo tęsknię po tobie\" \n" +
            "Panno święta, co Jasnej bronisz Częstochowy \n" +
            "I w Ostrej świecisz Bramie! Ty, co gród zamkowy \n" +
            "Nowogródzki ochraniasz z jego wiernym ludem! \n" +
            "Jak mnie dziecko do zdrowia powróciłaś cudem, \n" +
            "(Gdy od płaczącej matki pod Twoją opiekę \n" +
            "Ofiarowany, martwą podniosłem powiekę \n" +
            "I zaraz mogłem pieszo do Twych świątyń progu \n" +
            "Iść za wrócone życie podziękować Bogu), \n" +
            "Tak nas powrócisz cudem na Ojczyzny łono. \n" +
            "Tymczasem przenoś moją duszę utęsknioną \n" +
            "Do tych pagórków leśnych, do tych łąk zielonych, \n" +
            "Szeroko nad błękitnym Niemnem rozciągnionych; \n" +
            "Do tych pól malowanych zbożem rozmaitem, \n" +
            "Wyzłacanych pszenicą, posrebrzanych żytem; \n" +
            "Gdzie bursztynowy świerzop, gryka jak śnieg biała, \n" +
            "Gdzie panieńskim rumieńcem dzięcielina pała, \n" +
            "A wszystko przepasane jakby wstęgą, miedzą \n" +
            "Zieloną, na niej z rzadka ciche grusze siedzą.";
    int testWidth = 50;
    int testMaximumLength = 250;

    @Test
    public void testInputIsCorrect()
    {
        boolean value = Main.inputIsCorrect(testString , testWidth , testMaximumLength);

        assertEquals(true , value);
    }

    @Test
    public void testDivideText()
    {
        Main.divideText(testString , 100 , 500);
    }

    @Test
    public void testSplitIntoTokens()
    {
        ArrayList<String> test= new ArrayList<>();
        Main.splitIntoTokens(testString , test , testWidth);
    }
}
