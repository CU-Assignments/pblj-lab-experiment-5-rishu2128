import java.util.*; 
public class AutoboxingUnboxingExample 
{     
    public static int calculateSum(List<Integer> numbers) 
    {         
        int sum = 0;         
        for (Integer num : numbers) 
        {              
            sum += num; 
        }         
        return sum; 
    } 
    public static void main(String[] args) 
    {         
        List<Integer> numbers = new ArrayList<>();  
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter integers (type 'stop' to finish):");  
        while (scanner.hasNext()) 
        {             
            String input = scanner.next();             
            if (input.equalsIgnoreCase("stop")) break;             
            int value = Integer.parseInt(input);              
            numbers.add(value);  
        } 
        System.out.println("Sum: " + calculateSum(numbers));         
        scanner.close(); 
    } }

