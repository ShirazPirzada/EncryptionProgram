

public class MorseCode extends Input {
    public  String convertMorseCode(String userInput) {
        //declared two Arrays of different Datatype one for the Characters/Alphabets and the Other of MorseCode(string type)
        var result1 = userInput;
        var newValue="";

        char[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f',
                          'g', 'h', 'i', 'j', 'k', 'l',
                          'm', 'n', 'o', 'p', 'q', 'r',
                          's', 't', 'u', 'v', 'w', 'x',
                          'y', 'z', '1', '2', '3', '4',
                          '5', '6', '7', '8', '9', '0' };
        // Morse code by indexing
        String[] morseCode
            = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----" };

            //Using Nested Loop to compare both arrays
        for(int i=0;i<result1.length();i++)
        {
            for(int j=0;j<alphabets.length;j++)
            {
                //taking each character from incoming text
                var character = result1.charAt(i);

                //comparaing character with the alphabets array.
                if(character == alphabets[j])
                {
                    //if value found then assign the morseCode for that character and append the one * star 
                    newValue += morseCode[j] + "*";
                }

                // if space is found between words 
                //append two * stars.
                //also increment i++ as we need to get the next word
                else if(character==' ')
                {
                    newValue += "**";
                    i++;
                }
            }
        }
        return newValue;
    }
}
