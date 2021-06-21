package ex45;

public class word {
    static String targetWord;

    int isTarget(String input){
        if(input.equalsIgnoreCase(targetWord))
            return 1;
        else if(input.equalsIgnoreCase("\"" + targetWord + "\""))
            return 2;
        else
            return 0;
    }

    void determineTarget(String set){
        targetWord = set;
    }

    String replaceWord(String oldWord)
    {
        word temp = new word();
        String newWord = "use";

        switch (temp.isTarget(oldWord)) {
            case 1:
                return newWord;
            case 2:
                return "\""+newWord+"\"";
            default:
                return oldWord;
        }
    }
}
