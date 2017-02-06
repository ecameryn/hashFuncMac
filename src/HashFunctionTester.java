
/**
 * Tests HashFunction Class.
 * 
 * @author Cameryn Holstick 
 */
public class HashFunctionTester
{
    static String getRandomWord(int length) 
    {
        String r = "";
        for(int i = 0; i < length; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }
    
    public static void main(String[] args)
    {
        HashFunction hashFunc = new HashFunction();
        
        String[] randWordsArr = new String[10000];
        
        //initilize the random words array
        for(int i = 0; i < randWordsArr.length; i++)
        {
            
            randWordsArr[i] = getRandomWord(15);
        }
        
        //hash the words in random words array
        int hashVal = 0;
        for (String randWord : randWordsArr) 
        {
            hashVal = hashFunc.hashMe(randWord);
        }
        
        //count collisions in each cell
        /*for(int i = 0; i < randWordsArr.length; i++)
        {
            System.out.println("Number of Collisions in Cell "+i+": "+hashFunc.getBucketCount(i));
        }*/
        
        System.out.println("Amount of collisions: "+hashFunc.getCollisionCount()+" out of "+hashFunc.getHashTicker()+" hashes.");
        double percentOfColl = (hashFunc.getCollisionCount()*100)/hashFunc.getHashTicker();
        System.out.println("collisions/hashes: "+percentOfColl+" %");
        
        int hashVal1, hashVal2, hashVal3, hashVal4, hashVal5;
        hashVal1 = hashFunc.hashMe("post");
        hashVal2 = hashFunc.hashMe("pots");
        hashVal3 = hashFunc.hashMe("stop");
        hashVal4 = hashFunc.hashMe("most");
        hashVal5 = hashFunc.hashMe("bost");
        
        
        System.out.println(hashFunc.printCollisionList(hashFunc.hashMe("ElectraCamerynHolstick")));
        System.out.println(hashFunc.printCollisionList(hashVal1));
        System.out.println(hashFunc.printCollisionList(hashVal2));
        System.out.println(hashFunc.printCollisionList(hashVal3));
        System.out.println(hashVal1+"/"+ hashVal2+"/"+ hashVal3+"/"+ hashVal4+"/"+ hashVal5);
        
   }
    
   
}


