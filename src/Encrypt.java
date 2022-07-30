import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) throws Exception {
          
        Scanner scan = new  Scanner(System.in);
        MainProgram();
      
        System.out.println("Do you want to try again: Press y or n: ");
        String ans = scan.nextLine();
        
        //This loop will be closed upon providing value : n
      while(ans.equals("y"))
      {
        MainProgram();
      
        System.out.println("Do you want to try again: Press y or n: ");
        ans = scan.nextLine();
        if(ans.equals("n"))
        break;
      }
       System.out.println("Thank You!");
        

       

    }

    public static void MainProgram(){
        //Calling the child Classes 


        Swap swap = new Swap();
        swap.userInput = swap.getUserInput();
        //Convert to lower
        //System.out.println("-------------LowerCase------------");
        var result1 = swap.userInput.toLowerCase();
        //System.out.println(result1);
        //System.out.println("-------------Swapped Value------------");
        var swapedValue = swap.getSwap(result1);
       // System.out.println(swapedValue);
        Inverse inverse = new Inverse();
        inverse.userInput = swapedValue;
         System.out.println("-------------Reversed Value------------");
        var inverseValue = inverse.getInverse(inverse.userInput);

        MorseCode morseCode=new MorseCode();
        morseCode.userInput = inverseValue;
        System.out.println("-------------Encrypted text:------------");

        var morseValue = morseCode.convertMorseCode(morseCode.userInput);
        System.out.println(morseValue);

        System.out.println("");
       
    }
}

 class Input {
    
  public String userInput;

  public String getUserInput()
  {
      Scanner Value = new Scanner(System.in);  // Create a Scanner object
    

      System.out.println("Enter Text: ");
      String result = Value.nextLine();

      return result;
  }
  
}

 class Swap extends Input {
    
  public String getSwap(String userInput){
      var result=userInput;
      char[] arr = result.toCharArray();

      //using loop to check every character
      for (int i = 0; i < arr.length; i++)
      {
          //intialize every character to a character type variable
          char character = arr[i];

          //Check every Character if its a vowel. 
          //if matches then replace with the value i.e provided
          if (character == 'a')
          {
              arr[i] = 'u';
          }
          else if (character == 'e')
          {
              arr[i] = 'a';
          }
          else if (character == 'i')
          {
              arr[i] = 'e';
          }
          else if (character == 'o')
          {
              arr[i] = 'i';
          }
          else if (character == 'u')
          {
              arr[i] = 'o';
          }
      }
       //Converting the arr into a string. 
        result = new String(arr);
       //System.out.println(result1);
      return result;
  }
}

 class Inverse extends Input {
  // public String inverseText;

  public String getInverse(String userInput)
  {
   var result = userInput;

   //Split the data based on space
   var data = result.split(" ",0);
   var newValue="";
   //get last word index and everytime add the last index value with space into the newValue using decrement. 
   for(int i=data.length-1;i>=0;i--){
       newValue = newValue + data[i] + " ";
   }
    System.out.println(newValue);
   return result;
  }
}


 class MorseCode extends Input {
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



