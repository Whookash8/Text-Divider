package prazmo.lukasz;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)
    {
        String testString = "Litwo! Ojczyzno maja! Ty jesteś jak zdrowie, \n" +
                "Ile cię trzeba cenić, ten tylko się dowie, \n" +
                "Kto cię stracił. Dziś piękność twą w całej ozdobie \n" +
                "Widzę i opisuję, bo tęsknię po tobie \n" +
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
        divideText(testString , 35 , 500);
    }

    public static void divideText(String input , int columnWidth , int maximumLength)
    {
        if (!inputIsCorrect(input , columnWidth , maximumLength))
        {
            System.out.println("Given input has wrong format. Check if given numbers are positive integers and given String is correct.");
        }
        else
        {
            ArrayList<String> tokens = new ArrayList<>();
            splitIntoTokens(input , tokens , columnWidth);

            ArrayList<String> firstColumnLines = new ArrayList<>();
            ArrayList<String> secondColumnLines = new ArrayList<>();

            makeColumns(firstColumnLines , secondColumnLines , tokens , columnWidth , maximumLength);

            //System.out.println(tokens);
            //System.out.println(firstColumnLines);
            //System.out.println(secondColumnLines);
            showColumns(firstColumnLines , secondColumnLines , columnWidth);
        }
    }

    public static boolean inputIsCorrect(String input , int columnWidth , int maximumLength)
    {
        if (columnWidth <= 0) return false;
        else if(maximumLength <= 0) return false;
        else if(input.isEmpty()) return false;
        else return true;
    }

    public static void splitIntoTokens(String input , ArrayList<String> tokens , int maximumTokenSize)
    {
        StringTokenizer simpleTokenizer = new StringTokenizer(input);
        while(simpleTokenizer.hasMoreTokens())
        {
            String tempToken = simpleTokenizer.nextToken();
            if(tempToken.length() > maximumTokenSize)
            {
                ArrayList<String> strings = new ArrayList<>();
                int index = 0;
                while (index < tempToken.length())
                {
                    strings.add(tempToken.substring(index, Math.min(index + maximumTokenSize , tempToken.length())));
                    index += maximumTokenSize;
                }
                tokens.addAll(strings);
            }
            else
            {
                tokens.add(tempToken);
            }
        }
    }

    public static void makeColumns(ArrayList<String> firstColumn , ArrayList<String> secondColumn , ArrayList<String> tokens , int columnWidth , int maximumColumnSize)
    {
        String line = "";
        String currentWord;
        int charsInLine = 0;
        int charsInColumn = 0;
        int i = 0;
        currentWord = tokens.get(i);

        while(i < tokens.size())
        {
            while(isMoreSpaceInLine(currentWord , charsInLine , columnWidth) && i < tokens.size())
            {
                line += " " + currentWord;
                charsInColumn += currentWord.length() + 1;
                charsInLine += currentWord.length() + 1;
                i++;
                if(i < tokens.size())
                currentWord = tokens.get(i);
            }
            if (charsInColumn <= maximumColumnSize)
            {
                firstColumn.add(line.trim());
                charsInLine = 0;
                line = "";
            }
            else
            {
                secondColumn.add(line.trim());
                charsInLine = 0;
                line = "";
                break;
            }
        }

        charsInColumn = 0;

        while(i < tokens.size() && charsInColumn <= maximumColumnSize)
        {
            while(isMoreSpaceInLine(currentWord , charsInLine , columnWidth) && i < tokens.size())
            {
                line += " " + currentWord;
                charsInColumn += currentWord.length() + 1;
                charsInLine += currentWord.length() + 1;
                i++;
                if(i < tokens.size())
                currentWord = tokens.get(i);
            }
            if (charsInColumn <= maximumColumnSize)
            {
                secondColumn.add(line.trim());
                charsInLine = 0;
                line = "";
            }
        }
    }

    public static boolean isMoreSpaceInLine(String token , int currentSize , int maximumSize)
    {
        if(currentSize + token.length() <= maximumSize) return true;
        else return false;
    }

    public static void showColumns(ArrayList<String> firstColumn , ArrayList<String> secondColumn , int maximumWidth)
    {
        String format = "%-" + (maximumWidth+1) + "s";
        while(firstColumn.size() > 0)
        {
            System.out.printf(format , firstColumn.remove(0));
            if(secondColumn.size() > 0)
            {
                System.out.printf(format , secondColumn.remove(0));
                System.out.println();
            }
        }
    }
}
